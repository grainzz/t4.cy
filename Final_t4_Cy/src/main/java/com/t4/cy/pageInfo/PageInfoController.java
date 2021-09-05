package com.t4.cy.pageInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.t4.cy.PageInfoVO;
import com.t4.cy.pay.PayDAO;
import com.t4.cy.port.portInfo;
import com.t4.cy.port.yjDAO;

@Controller
public class PageInfoController {

	@Autowired
	private PageInfoDAO pidao;

	@RequestMapping(value = "pageinfomod.go", method = RequestMethod.GET)
	public String joinGo(HttpServletRequest request) {
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("contentPage", "login/join.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("profilePage", "side.jsp");
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		return "index";
	}
	
	@RequestMapping(value = "profile.set", method = RequestMethod.GET)
	public String profileSet(PageInfoVO p, HttpServletRequest request) {
		
		pidao.setProfile(p, request);
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("contentPage", "menu/settingSuccess.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		return "index";
	}

	



}
