package com.t4.cy.random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.t4.cy.PageInfoVO;
import com.t4.cy.member.MDAO;
import com.t4.cy.member.Member;
import com.t4.cy.pageInfo.PageInfoDAO;
import com.t4.cy.pay.PayDAO;
import com.t4.cy.port.portInfo;
import com.t4.cy.port.yjDAO;

@Controller
public class RandomController {
	
	@Autowired
	private RandomDAO rdao;
	
	@Autowired
	private yjDAO yjdao;
	
	@Autowired
	private PageInfoDAO pjdao;
	
	@RequestMapping(value = "random.go", method = RequestMethod.GET)
	public String randomGo(portInfo i, HttpServletRequest request) {
		
		String rId = rdao.getRandom(request);
		pjdao.getInfoById(rId, request);
		yjdao.getPortInfo(i, request);

		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "main.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");

	
	return "index";
}
	
	@RequestMapping(value = "myHome.go", method = RequestMethod.GET)
	public String myHomeGo(portInfo i, HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		PageInfoVO p = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		String c_id = m.getC_id(); //지금 로그인돼있는 세션에서 아이디가져오기
		pjdao.getInfoById(c_id, request);
		yjdao.getPortInfo(i, request);
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "main.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
			
		return "index";
	}

	

	@RequestMapping(value = "search.go", method = RequestMethod.GET)
	public String SearchGo(portInfo i, HttpServletRequest request) {
		//검색어 받아오기
		String sid = request.getParameter("keyword");
		
		if(rdao.checkID(sid, request)) {
			//검색한 아이디 존재하면
			pjdao.getInfoById(sid, request);
			request.getSession().getAttribute("pageInfo");
			yjdao.getPortInfo(i, request);
			
			request.setAttribute("homePage", "home.jsp");
			request.setAttribute("titlePage", "title.jsp");
			request.setAttribute("contentPage", "main.jsp");
			request.setAttribute("profilePage", "profilePage.jsp");
			request.setAttribute("bannerPage", "banner.jsp");
		
			PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
			if(pp!=null) {
				request.setAttribute("bgm", pp.getP_music());//브금세팅
				request.setAttribute("theme", pp.getP_theme());//테마세팅
			}else {
				request.setAttribute("theme", "default");//p_id 없을때 default
			}
		}else {
			//검색한 아이디 없는거면
			request.setAttribute("keyword", sid);
			request.setAttribute("theme", "default");
			yjdao.getPortInfo(i, request);
			
			request.setAttribute("homePage", "home.jsp");
			request.setAttribute("titlePage", "title.jsp");
			request.setAttribute("contentPage", "searchFailed.jsp");
			request.setAttribute("profilePage", "profilePage.jsp");
			request.setAttribute("bannerPage", "banner.jsp");
		}
		
	
		return "index";
	}
	
	//최종추가
	@RequestMapping(value = "HomeGoWithpId", method = RequestMethod.GET)
	public String HomeGoWithpId(portInfo i, HttpServletRequest request) {
	
		//p_id 받아오기
		PageInfoVO p = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		pjdao.getInfoById(p.getP_id(), request);
		
		yjdao.getPortInfo(i, request);

		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "main.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		
		return "index";
	}
}
