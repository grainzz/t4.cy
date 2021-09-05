package com.t4.cy.member;

import java.io.File;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.t4.cy.PageInfoVO;
import com.t4.cy.pageInfo.PageInfoDAO;
import com.t4.cy.pageInfo.PageInfoMapper;
import com.t4.cy.pay.PayMapper;
import com.t4.cy.port.yjMapper;

@Service
public class MDAO {

	@Autowired
	private SqlSession ss;

	public void join(Member m, HttpServletRequest request) {

	      String path = request.getSession().getServletContext().getRealPath("resources/img");
	      MultipartRequest mr = null;
	      try {
	         mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
	         System.out.println(path);
	      } catch (IOException e) {
	         e.printStackTrace();
	         request.setAttribute("r", "가입실패(파일 용량 초과)");
	         return;
	      }

	      try {
	         String c_id = mr.getParameter("c_id");
	         String c_pw = mr.getParameter("c_pw");
	         String c_name = mr.getParameter("c_name");
	         String c_minimi = mr.getParameter("c_minimi");
	         String c_gender = mr.getParameter("c_gender");
	         String c_phone = mr.getParameter("c_phone");
	         String c_birth = mr.getParameter("c_birth");
	         String c_photo = mr.getFilesystemName("c_photo");
	         c_photo = URLEncoder.encode(c_photo, "utf-8");
	         c_photo = c_photo.replace("+", "");
	         System.out.println(c_id);
	         System.out.println(c_photo);

	         m.setC_id(c_id);
	         m.setC_pw(c_pw);
	         m.setC_name(c_name);
	         m.setC_minimi(c_minimi);
	         m.setC_gender(c_gender);
	         m.setC_phone(c_phone);
	         m.setC_birth(c_birth);
	         m.setC_photo(c_photo);
	         
	         if (ss.getMapper(MemberMapper.class).join(m) == 1) {
	        	ss.getMapper(PageInfoMapper.class).defaultAutoFill(m); //가입하면 자동으로 그 아이디의 profileInfo 세팅(id빼고 전부 null값이 기본)
	        	ss.getMapper(yjMapper.class).portAutoFill(c_id); // 포트폴리오도 null
	        	ss.getMapper(yjMapper.class).resAutoFill(c_id); // 자소서도 null
	        	
	       //     request.setAttribute("r", "가입 성공!");
	         } else {
	            request.setAttribute("r", "가입 실패!");
	         }
	         

	      } catch (Exception e) {
	         e.printStackTrace();
	         request.setAttribute("r", "가입실패(DB 서버문제)");
	         String c_photo = mr.getFilesystemName("c_photo");
	         File f = new File(path + "/" + c_photo);
	         f.delete();
	      }
	   }

	public void loginMember(Member m, HttpServletRequest req, HttpServletResponse res) {
//		System.out.println(m.getC_id());
//		System.out.println(m.getC_pw());

		Member dbM = ss.getMapper(MemberMapper.class).getMemberById(m);// 결과 : Member
		
		if(dbM == null) {
			req.setAttribute("r", "없는 아이디입니다.");
		}else {
			System.out.println("비밀번호: "+dbM.getC_pw());
			
			if (dbM != null) {
				if (dbM.getC_pw().equals(m.getC_pw())) {
				//	req.setAttribute("r", "로그인 성공");
					// dbM: 로그인 된 사람 전체 정보
					// 사이트에서 어딜 가든 지 저 정보가 살아 있어야.
					req.getSession().setAttribute("loginMember", dbM);
//					req.getSession().setMaxInactiveInterval(60*60*12); //시간수정
					
					if (req.getParameter("autologin") != null) {
						
						Cookie c = new Cookie("autoLoginID", dbM.getC_id());
						c.setMaxAge(86400);// 24시간 살리기. 1*60*60*24 = 86400
						res.addCookie(c);
					}
				} else {
					req.setAttribute("r", "잘못된 비밀번호입니다.");
				}
			}
		}
		
		
		
	}

	// 로그인 상태 검사할꺼
	// 로그인이 되어 있으면 true
	// 아니면 false
	// include 되는 페이지 기능까지 해결

	public boolean loginCheck(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");

		if (m != null) {
			request.setAttribute("contentPage", "main.jsp");
			return true;
		} else {
			request.setAttribute("contentPage", "login/login.jsp");

			return false;
		}
	}

	public void logout(Member m, HttpServletRequest request, HttpServletResponse res) {
		Cookie[] cookies = request.getCookies(); // 한 개가 아닐 테니 배열에 담았음
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("autoLoginID")) {
					c.setValue(null); // 쿠키 id값 삭제
					res.addCookie(c);
				}
			}
		}
		request.getSession().removeAttribute("loginMember");
	}
	
	
	public void autologin(HttpServletRequest request) {
		// 이 컴에 있는 모든 쿠키
		Cookie[] cookies = request.getCookies();

		// 만들어진 쿠키 있을 때
		// 우리가 만든 거
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("autoLoginID")) {
					String c_id = c.getValue();

					if (c_id != null) { // 로그아웃을 안 누르면 쿠키에 값이 있을 것
						Member m = new Member();
						m.setC_id(c_id);
						Member dbM = ss.getMapper(MemberMapper.class).getMemberById(m);
						if (dbM != null) {
							request.getSession().setAttribute("loginMember", dbM); // member(dbM)를 세션에 담은 거!
						//	request.getSession().setMaxInactiveInterval(1200);
						}
					}
				}
			}
		}
	}
	
	public void update(Member m, HttpServletRequest request ) {
		// 사진 파일은 최대 10MB
		// 수정시도 : 파일을 10MB넘게 -> 무조건 실패
		String path = request.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			request.setAttribute("r", "수정실패(파일용량초과)");
			return;
		}

		// 현재 로그인 된 회원 정보(수정되기 전)+페이지정보
		Member lm = (Member) request.getSession().getAttribute("loginMember");
		String c_id = lm.getC_id();
		PageInfoVO lp = ss.getMapper(PageInfoMapper.class).getPageInfoById(c_id);

		// 기존 사진 파일명
		String oldFile = lm.getC_photo(); // %2A.png

		// 새 파일명
		String newFile = mr.getFilesystemName("c_photo"); // ㅎ.png
		try {
			String dm_id = mr.getParameter("c_id");
			String dm_pw = mr.getParameter("c_pw");
			String dm_name = mr.getParameter("c_name");
			String dm_birth = mr.getParameter("c_birth");
			String dm_phone = mr.getParameter("c_phone");

			if (newFile == null) { // 사진은 수정 안하는
				newFile = oldFile;
			} else { // 사진 수정
				// newFile = URLEncoder.encode(newFile, "utf-8");
				// newFile = newFile.replace("+", " "); 한글파일일때해야함
			}

			m.setC_phone(dm_phone);
			m.setC_id(dm_id);
			m.setC_pw(dm_pw);
			m.setC_name(dm_name);
			m.setC_birth(dm_birth);
			m.setC_photo(newFile);
			
			lp.setP_id(dm_id);
			lp.setP_name(dm_name);
			lp.setP_birth(dm_birth);
			lp.setP_photo(newFile);
			// DB수정
			if (ss.getMapper(MemberMapper.class).update(m) == 1) {
		//		request.setAttribute("r", "수정성공");
				ss.getMapper(PageInfoMapper.class).update(lp); //해당 id의 pageInfo도 같이 수정
				// 사이트에 반영
				request.getSession().setAttribute("loginMember", m);
				request.getSession().setAttribute("pageInfo", lp);
//				loginCheck(request);

				// 프사 바꾸는 상황 : 옛날 프사 지우기
				if (!oldFile.equals(newFile)) {
					// oldFile = URLDecoder.decode(oldFile, "utf-8");
					new File(path + "/" + oldFile).delete();
				}
			} else {
	//			request.setAttribute("r", "수정실패");

				// 프사 바꾸는 상황 : 새 프사 지우기
				if (!oldFile.equals(newFile)) {
					// newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
	//		request.setAttribute("r", "수정실패");

			// 프사 바꾸는 상황 : 새 프사 지우기
			if (!oldFile.equals(newFile)) {
				// newFile = URLDecoder.decode(newFile, "utf-8");
				new File(path + "/" + newFile).delete();
			}
		}
		
	}
	
	public void bye(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		if (ss.getMapper(MemberMapper.class).bye(m) == 1) {
	//		request.setAttribute("r", "탈퇴 성공!");
		} else {
			request.setAttribute("r", "탈퇴 실패!");
		}
	}

	public int idchk(Member m) {
		
		int result = ss.getMapper(MemberMapper.class).idCheck(m);
		
		return result;
	}

}

