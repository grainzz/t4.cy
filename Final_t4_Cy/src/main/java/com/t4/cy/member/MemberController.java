package com.t4.cy.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.t4.cy.PageInfoVO;
import com.t4.cy.pageInfo.PageInfoDAO;
import com.t4.cy.pay.PayDAO;
import com.t4.cy.port.portInfo;
import com.t4.cy.port.yjDAO;

@Controller
public class MemberController {

	@Autowired
	private MDAO mdao;
	
	@Autowired
	private PayDAO pdao;
	
	@Autowired
	private yjDAO yjdao;
	
	@Autowired
	private PageInfoDAO pjdao;
	

	@RequestMapping(value = "member.join.go", method = RequestMethod.GET)
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
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		return "index";
	}

	@RequestMapping(value = "member.join", method = RequestMethod.POST)
	public String join(Member m, HttpServletRequest request) {

		mdao.join(m, request);
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("contentPage", "login/joinSuccess.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("bannerPage", "banner.jsp");

		return "index";
	}
	
	 @RequestMapping(value = "member.IdChk", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	 public @ResponseBody int IdChk(Member m) {
	    int mm = mdao.idchk(m);
	    
	    return mm;
	      
	 }

	@RequestMapping(value = "member.login.go", method = RequestMethod.GET)
	public String loginGo(HttpServletRequest request) {
/*
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		*/
		
		request.getSession().setAttribute("pageInfo", null);
		
		request.setAttribute("theme", "default");//p_id 없을때 default
		
		request.setAttribute("contentPage", "login/login.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("bannerPage", "banner.jsp");

		return "index";
	}

	@RequestMapping(value = "member.login", method = RequestMethod.POST)
	public String login(portInfo i, Member m, HttpServletRequest request, HttpServletResponse res) {

		String c_id = m.getC_id();
		mdao.loginMember(m, request, res);
		
		Member mm = (Member) request.getSession().getAttribute("loginMember");
		if (mm != null) {
			//로그인 돼있으면
			pjdao.getInfoById(c_id, request);
			yjdao.getPortInfoByID(c_id, request);
			PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
			request.setAttribute("bgm", pp.getP_music());
			request.setAttribute("contentPage", "main.jsp");

		} else {
			//로그인 안돼있으면
			request.setAttribute("contentPage", "login/login.jsp");

		}
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("bannerPage", "banner.jsp");

		return "index";
	}

	@RequestMapping(value = "member.logout.go", method = RequestMethod.GET)
	public String logout(Member m, HttpServletRequest request, HttpServletResponse res) {
		//로그인상태에만 보이는거라 로그인체크안함
		mdao.logout(m, request, res);
		request.getSession().setAttribute("pageInfo", null);
		
		request.setAttribute("theme", "default");
		
		request.setAttribute("contentPage", "login/login.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("bannerPage", "banner.jsp");

		return "index";
	}

	@RequestMapping(value = "member.info.go", method = RequestMethod.GET)
	public String memebrInfoGo(Member m, HttpServletRequest request, HttpServletResponse res) {
		//로그인상태에만 보이는거라 로그인체크안함
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}		
		request.setAttribute("contentPage", "info.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("bannerPage", "banner.jsp");

		
		return "index";
	}
	
	
	@RequestMapping(value = "member.bye", method = RequestMethod.GET)
	public String memebrbye(Member m, HttpServletRequest request, HttpServletResponse res) {
		Member mm = (Member) request.getSession().getAttribute("loginMember");
		String id = mm.getC_id();
		
		pjdao.byeById(id);
		request.getSession().setAttribute("pageInfo", null);
		
		mdao.bye(request);
		mdao.logout(m, request, res);
		request.setAttribute("theme", "default");
		
		request.setAttribute("contentPage", "login/login.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		return "index";
	}
	
	@RequestMapping(value = "member.update", method = RequestMethod.POST)
	public String memberUpdate(portInfo i, Member m, HttpServletRequest request, HttpServletResponse res) {
		//로그인상태에만 보이는거라 로그인체크안했는데 form때문에 탈퇴눌렀을때도 여기로와서 수정함!!
		yjdao.getPortInfo(i, request);
		mdao.update(m, request);
		
		Member mm = (Member) request.getSession().getAttribute("loginMember");
		if (mm != null) {
			request.setAttribute("contentPage", "main.jsp");
		} else {
			//로그인 안돼있으면(탈퇴되면)
			request.setAttribute("contentPage", "login/login.jsp");

		}
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		return "index";
	
	}
	
	
	
	
	



}
