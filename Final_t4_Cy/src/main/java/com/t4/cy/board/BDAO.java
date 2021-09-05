package com.t4.cy.board;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t4.cy.PageInfoVO;

@Service
public class BDAO {

	@Autowired
	private SqlSession ss;

	public void getBoard(HttpServletRequest req) {
		PageInfoVO p = (PageInfoVO) req.getSession().getAttribute("pageInfo");
		String p_id = p.getP_id(); //p_id값 받아오기
		List<Board> board = ss.getMapper(MyMapper.class).showBoard(p_id);
		req.setAttribute("board", board);
	}
	
	public void getAllBoard(HttpServletRequest request) {
		List<Board> board = ss.getMapper(MyMapper.class).showAllBoard();
		request.setAttribute("board", board);
		
	}
	

	public void showDetail(Board b, int b_no, HttpServletRequest req) {
		ss.getMapper(MyMapper.class).updateHit(b);
		Board bb = ss.getMapper(MyMapper.class).showDetail(b);
		req.setAttribute("bb", bb);
	}

	public void regBoard(Board b, HttpServletRequest req) {
		if (ss.getMapper(MyMapper.class).regBoard(b) == 1) {
			req.setAttribute("result", "게시물 작성이 완료되었습니다");
		} else {
			req.setAttribute("result", "게시물 작성 실패");
		}
	}

	public void delBoard(Board b, HttpServletRequest req) {
		if ((ss.getMapper(MyMapper.class)).delBoard(b) == 1) {
			req.setAttribute("result", "게시물 삭제가 완료되었습니다");
		} else {
			req.setAttribute("result", "게시물 삭제 실패");
		}
	}

	public void updateHit(Board b, HttpServletRequest req) {
		ss.getMapper(MyMapper.class).updateHit(b);
	}

	public void boardModify(Board b, HttpServletRequest req) {
		if (ss.getMapper(MyMapper.class).modBoard(b) == 1) {
			req.setAttribute("result", "게시물 수정이 완료되었습니다");
		}else {
			req.setAttribute("result", "게시물 수정 실패");
		}
	}


}