package com.t4.cy.comment;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t4.cy.member.Member;






@Service
public class CommentDAO {
	
	private int allMsgCnt;
	
	
	@Autowired
	private SqlSession ss;
	
	@Autowired 
	private SiteOption so;
	
	public void getMsgs(Comment c, HttpServletRequest request) {
		request.setAttribute("msgs", ss.getMapper(CommentMapper.class).getAllmsg(c));
		request.setAttribute("msgs2", ss.getMapper(CommentMapper.class).getAllmsg2(c));
		/*
		 * CommentMapper mm = ss.getMapper(CommentMapper.class); Comment comm =
		 * mm.getAllmsg2(c); request.setAttribute("comm", comm);
		 */
	}
	
	
	 public void selectMsg(Comment c, HttpServletRequest request) { 
		 request.setAttribute("msg", ss.getMapper(CommentMapper.class).getMsgs(c));

	 }	 
	
	
	public void writeMsgs(Comment c, HttpServletRequest request) {
		String token = request.getParameter("token");
		System.out.println(token);

		String st = (String) request.getSession().getAttribute("successToken");
		System.out.println(st);

		if (st != null && token.equals(st)) {
			request.setAttribute("r", "댓글쓰기 실패(새로고침)");
			return;
		}
		


		Member m = (Member) request.getSession().getAttribute("loginMember");

		c.setC_writer(m.getC_id());

		if (ss.getMapper(CommentMapper.class).writeMsg(c) == 1) {
		//	request.setAttribute("r", "작성 성공");
			request.getSession().setAttribute("successToken", token);
			allMsgCnt++;
		} else {
			request.setAttribute("r", "작성 실패");

		}

	}
	
	public void delMsg(Comment c, HttpServletRequest request) {

		if (ss.getMapper(CommentMapper.class).deleteMsg(c) == 1) {
	//		request.setAttribute("r", "댓글 삭제 성공");
			allMsgCnt--;
		} else { 
			
			request.setAttribute("r", "댓글 삭제 실패");
		}
	}


	public void getMsgs(HttpServletRequest req) {
			// req.setAttribute("curPage", page);
			

			String search = (String) req.getSession().getAttribute("search"); // 검색어로 쓸꺼
			int msgCnt = 0;
			if (search == null) { // 전체조회 (검색어 없으면)
				msgCnt = allMsgCnt;
				search = "";
			} else { // 검색어가 있으면 검색인거.
				CommentSelector sSel2 = new CommentSelector(search);
				msgCnt = ss.getMapper(CommentMapper.class).getSearchMsgCnt(sSel2);
			}

			// allMsgCnt -> msgCnt
			int allPageCount = (int) Math.ceil((double) msgCnt / so.getCommentMsgPerPage());
			req.setAttribute("allPageCount", allPageCount);
			// 14 / 10 한걸 올림시킨거 = 2
		//	int start = (page - 1) * so.getCommentMsgPerPage() + 1;
			// 2페이지면 11 시작

	//		int end = (page == allPageCount) ? msgCnt : start + so.getCommentMsgPerPage() - 1;
			// 2 == 2 ? 2
			// 1 == 2 ? 아니고 : 1 + 9 = 10

			CommentSelector sSel = new CommentSelector(search);
			List<Comment> comments = ss.getMapper(CommentMapper.class).getMsg(sSel);

			for (Comment comment : comments) {
				// System.out.println(s.getC_no());
				// System.out.println(s.getC_comment());

				// 글 하나 하나에 해당하는 댓글
		
			/*	List<SNSReply> replys = ss.getMapper(SNSMapper.class).getReply(snsMsg);
				snsMsg.setReply(replys);

				System.out.println(snsMsg.getC_comment());
				if (replys != null) {
					for (SNSReply sr : replys) {
						System.out.println(sr.getCsr_c_comment());
				}
			
			
	}
					}*/
	}
			req.setAttribute("msgs", comments);
	}


	
	public void countAllMsg() {
		System.out.println(so.getCommentMsgPerPage());

		allMsgCnt = ss.getMapper(CommentMapper.class).getAllMsgCount();
		System.out.println(allMsgCnt);
	}

	public void searchMsg(HttpServletRequest req) {
			String search = req.getParameter("search");
			System.out.println(search);
			req.getSession().setAttribute("search", search);
				
			}

	
	public void searchClear(HttpServletRequest request) {
		request.getSession().setAttribute("search", null);
	}


	public void updateMsg(Comment c, HttpServletRequest request) {
		
			if (ss.getMapper(CommentMapper.class).updateMsg(c) == 1) {
		//		request.setAttribute("r", "수정 성공");
				allMsgCnt--;
			} else {
				
				request.setAttribute("r", "수정 실패");
			}
			
		
	}

	}
	
	
	


	


	
	
