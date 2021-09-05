package com.t4.cy.comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.t4.cy.PageInfoVO;
import com.t4.cy.member.MDAO;
import com.t4.cy.member.Member;
import com.t4.cy.pay.PayDAO;

@Controller
public class CommentController {
	
	@Autowired
	private CommentDAO cdao;
	
	
	@RequestMapping(value = "msgWrite", method = RequestMethod.GET)
	public String msgWrite(Comment c, Member m, HttpServletRequest request, HttpServletResponse res) {
		
		cdao.writeMsgs(c, request);
		cdao.getMsgs(c, request);
	//	cdao.getMsgs(1, request);
		TokenMaker.makeToken(request);
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "menu/message.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		return "index";
	}
	

	
	@RequestMapping(value = "msg.page.change", method = RequestMethod.GET)
	public String paging(HttpServletRequest req) {
			int p = Integer.parseInt(req.getParameter("p"));
			TokenMaker.makeToken(req);
			
			PageInfoVO pp = (PageInfoVO) req.getSession().getAttribute("pageInfo");
			if(pp!=null) {
				req.setAttribute("bgm", pp.getP_music());//브금세팅
				req.setAttribute("theme", pp.getP_theme());//테마세팅
			}else {
				req.setAttribute("theme", "default");//p_id 없을때 default
			}
			
			req.setAttribute("homePage", "home.jsp");
			req.setAttribute("titlePage", "title.jsp");
			req.setAttribute("contentPage", "menu/message.jsp");
			req.setAttribute("profilePage", "profilePage.jsp");
			req.setAttribute("bannerPage", "banner.jsp");
			return "index";
	}
	
	
	@RequestMapping(value = "msg.search", method = RequestMethod.GET)
	public String search(Comment c, HttpServletRequest req) {
		cdao.searchMsg(req);
	//	cdao.getMsgs(c, req);
		cdao.getMsgs(req);
		TokenMaker.makeToken(req);
		TokenMaker.makeToken(req);
		
		PageInfoVO pp = (PageInfoVO) req.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			req.setAttribute("bgm", pp.getP_music());//브금세팅
			req.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			req.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		req.setAttribute("contentPage", "menu/message.jsp");
		req.setAttribute("homePage", "home.jsp");
		req.setAttribute("titlePage", "title.jsp");
		req.setAttribute("profilePage", "profilePage.jsp");
		req.setAttribute("bannerPage", "banner.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "msg.del.go", method = RequestMethod.GET)
	public String msgDelGo(Comment c, HttpServletRequest request) {
		//로그인중에만 보여서 로그인체크할필요없음
		cdao.delMsg(c, request);
		cdao.getMsgs(c, request);
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
	
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "menu/message.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "msg.update.go", method = RequestMethod.GET)
	public String msgUpdateGo(Comment c, HttpServletRequest request) {
		//로그인중에만 보여서 로그인체크할필요없음
		cdao.getMsgs(c, request);
		cdao.selectMsg(c, request);
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
			
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "menu/messageUpdate.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
			
		
		return "index";
	}
	

	@RequestMapping(value = "msg.update.do", method = RequestMethod.GET)
	public String msgUpdateDo(Comment c, HttpServletRequest request) {
		//로그인중에만 수정버튼 보여서 로그인체크할필요없음
			cdao.updateMsg(c, request);
			cdao.getMsgs(c, request);
			
			PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
			if(pp!=null) {
				request.setAttribute("bgm", pp.getP_music());//브금세팅
				request.setAttribute("theme", pp.getP_theme());//테마세팅
			}else {
				request.setAttribute("theme", "default");//p_id 없을때 default
			}
			
			request.setAttribute("homePage", "home.jsp");
			request.setAttribute("titlePage", "title.jsp");
			request.setAttribute("contentPage", "menu/message.jsp");
			request.setAttribute("profilePage", "profilePage.jsp");
			request.setAttribute("bannerPage", "banner.jsp");
			
		
		
		return "index";
	}
	

	
	
	

}
