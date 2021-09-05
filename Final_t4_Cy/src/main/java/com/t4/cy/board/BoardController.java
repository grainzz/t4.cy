package com.t4.cy.board;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.t4.cy.PageInfoVO;

@Controller
public class BoardController {
	@Autowired
	private BDAO bdao;

	@RequestMapping(value = "board.showDetail", method = RequestMethod.GET)
	public String getDetail(Board b, HttpServletRequest request) {

		int b_no = Integer.parseInt(request.getParameter("b_no"));
		bdao.showDetail(b, b_no, request);
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "board/detail.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "board.reg.go", method = RequestMethod.GET)
	public String boardRegGo(HttpServletRequest request) {
		
		String b_writer = request.getParameter("b_writer");
		request.setAttribute("b_writer", b_writer);
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "board/insert.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		return "index";
	}
	
	
	@RequestMapping(value = "board.reg.do", method = RequestMethod.GET)
	public String boardRegDo(Board b, HttpServletRequest request) {
		
		bdao.regBoard(b, request);
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "board/insertSuccess.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");

		return "index";
	}
	
	
	@RequestMapping(value = "board.modify", method = RequestMethod.GET)
	public String boardModify(Board b, HttpServletRequest request) {
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		bdao.showDetail(b, b_no, request);
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "board/detailMod.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "board.modify.do", method = RequestMethod.GET)
	public String boardModifyDo(Board b, HttpServletRequest request) {
		bdao.boardModify(b, request);
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "board/insertSuccess.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		return "index";
	}

	
	@RequestMapping(value = {"/board.del.do"}, method = {RequestMethod.GET})
	public String boarddelDo(Board b, HttpServletRequest request) {
		bdao.delBoard(b, request);
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "board/insertSuccess.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		return "index";
	}
	
	//고쳐야됨!!!!!
	@RequestMapping(value = {"board.goGetAll"}, method = {RequestMethod.GET})
	public String boardGetAll(Board b, HttpServletRequest request) {
		
		bdao.getAllBoard(request);
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("contentPage", "menu/board.jsp");
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		return "index";
		
	}

}