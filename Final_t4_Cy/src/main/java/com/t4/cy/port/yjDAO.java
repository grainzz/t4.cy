package com.t4.cy.port;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.t4.cy.PageInfoVO;
import com.t4.cy.member.Member;

@Service
public class yjDAO {

	@Autowired
	private SqlSession ss;
	
	public void portUpdate(portInfo i, HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String p_id = m.getC_id(); //로그인 중인 아이디 불러오기
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		
		try {
			mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
			System.out.println(path);
		} catch (IOException e) {
			e.printStackTrace();
			req.setAttribute("r", "가입실패(파일용량초과)");
			return;
		}	
		
		
		try {
			String p_textarea = mr.getParameter("p_textarea");
			String p_month1 = mr.getParameter("p_month1");
			String p_month2 = mr.getParameter("p_month2");
			String p_school = mr.getParameter("p_school");
			String p_major = mr.getParameter("p_major");
			String p_schoolInfo = mr.getParameter("p_schoolInfo");
			String p_selectBox1 = mr.getParameter("p_selectBox1");
			String p_selectBox2 = mr.getParameter("p_selectBox2");
			String p_licenDate = mr.getParameter("p_licenDate");
			String p_licenName = mr.getParameter("p_licenName");
			String p_skillname = mr.getParameter("p_skillname");
			String p_skillrange = mr.getParameter("p_skillrange");
			String p_hobby = mr.getParameter("p_hobby");

			
			if (p_selectBox1.equals("1")) {
				p_selectBox1 = "서비스업";
			} else if (p_selectBox1.equals("2")) {
				p_selectBox1 = "금융·은행업";
			} else if (p_selectBox1.equals("3")) {
				p_selectBox1 = "IT·정보통신업";
			} else if (p_selectBox1.equals("4")) {
				p_selectBox1 = "판매·유통업";
			} else if (p_selectBox1.equals("5")) {
				p_selectBox1 = "제조·생산·화학업";
			} else if (p_selectBox1.equals("6")) {
				p_selectBox1 = "교육업";
			} else if (p_selectBox1.equals("7")) {
				p_selectBox1 = "건설업";
			} else if (p_selectBox1.equals("8")) {
				p_selectBox1 = "의료·제약업";
			} else if (p_selectBox1.equals("9")) {
				p_selectBox1 = "미디어·광고업";
			} else if (p_selectBox1.equals("10")) {
				p_selectBox1 = "문화예술·디자인업";
			} else if (p_selectBox1.equals("11")) {
				p_selectBox1 = "기관·협회";
			}         
			
			System.out.println(p_selectBox1);
			
			i.setP_user(p_id);
			i.setP_textarea(p_textarea);
			i.setP_month1(p_month1);
			i.setP_month2(p_month2);
			i.setP_school(p_school);
			i.setP_major(p_major);
			i.setP_schoolInfo(p_schoolInfo);
			i.setP_selectBox1(p_selectBox1);
			i.setP_selectBox2(p_selectBox2);
			i.setP_licenDate(p_licenDate);
			i.setP_licenName(p_licenName);
			i.setP_skillname(p_skillname);
			i.setP_skillrange(p_skillrange);
			i.setP_hobby(p_hobby);
			
			if (ss.getMapper(yjMapper.class).portupdate(i)==1) {
				System.out.println("업데이트성공");
			} else {
				System.out.println("업데이트실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getPortInfo(portInfo i, HttpServletRequest req) {
		PageInfoVO p = (PageInfoVO) req.getSession().getAttribute("pageInfo");
		String p_id = p.getP_id(); //p_id값 받아오기
		i.setP_user(p_id);
		yjMapper mm = ss.getMapper(yjMapper.class);
		portInfo pt = mm.getinfo(i);
		req.setAttribute("pt", pt);
	}
	
	public void getPortInfoByID(String c_id, HttpServletRequest req) {
		yjMapper mm = ss.getMapper(yjMapper.class);
		portInfo pt = mm.getinfoByID(c_id);
		req.setAttribute("pt",pt);
	}
	

	public void resumeUpdate(resumeInfo r, HttpServletRequest req) {
		PageInfoVO p = (PageInfoVO) req.getSession().getAttribute("pageInfo");
		String p_id = p.getP_id(); //p_id값 받아오기
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		
		try {
			mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
			System.out.println(path);
		} catch (IOException e) {
			e.printStackTrace();
			req.setAttribute("r", "가입실패(파일용량초과)");
			return;
		}	
		
		try {
			String r_txt1 = mr.getParameter("r_txt1");
			String r_txt2 = mr.getParameter("r_txt2");
			String r_txt3 = mr.getParameter("r_txt3");
			String r_txt4 = mr.getParameter("r_txt4");
			String r_txt5 = mr.getParameter("r_txt5");

			r.setR_user(p_id);
			r.setR_txt1(r_txt1);
			r.setR_txt2(r_txt2);
			r.setR_txt3(r_txt3);
			r.setR_txt4(r_txt4);
			r.setR_txt5(r_txt5);
			
			if (ss.getMapper(yjMapper.class).resumeupdate(r)==1) {
				System.out.println("업데이트성공");
			} else {
				System.out.println("업데이트실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void getResumeInfo(resumeInfo r, HttpServletRequest req) {
		PageInfoVO p = (PageInfoVO) req.getSession().getAttribute("pageInfo");
		String p_id = p.getP_id(); //p_id값 받아오기
		r.setR_user(p_id);
		yjMapper mm = ss.getMapper(yjMapper.class);
		resumeInfo rm = mm.getresumeinfo(r);
		req.setAttribute("rm", rm);
	}


	
}
