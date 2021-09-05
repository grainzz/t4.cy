package com.t4.cy.port;

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
public class PortController {
   
   @Autowired
   private yjDAO yjdao;
   
   @Autowired
   private MDAO mdao;
   
   @Autowired
   private PayDAO pdao;
   
   @RequestMapping(value = "/port.Detail.go", method = RequestMethod.GET)
   public String PortDetailGo(HttpServletRequest request, portInfo i) {
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
      request.setAttribute("contentPage", "portfolio/portDetail.jsp");
      request.setAttribute("profilePage", "profilePage.jsp");
      request.setAttribute("bannerPage", "banner.jsp");
      
      return "index";
   }
   
   @RequestMapping(value = "/port.show", method = RequestMethod.GET)
   public String PortShow(HttpServletRequest request, portInfo i) {
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
   
   @RequestMapping(value = "/correct.OK", method = RequestMethod.POST)
   public String correctOK(HttpServletRequest request, portInfo i) {
      yjdao.portUpdate(i, request);
      
      PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
      request.setAttribute("homePage", "home.jsp");
      request.setAttribute("titlePage", "title.jsp");
      request.setAttribute("contentPage", "portfolio/portSuccess.jsp");
      request.setAttribute("profilePage", "profilePage.jsp");
      request.setAttribute("bannerPage", "banner.jsp");

      return "index";

   }


   @RequestMapping(value = "/resume.Detail.go", method = RequestMethod.GET)
   public String resumeDetailgo(resumeInfo r, HttpServletRequest request, portInfo i) {
     
      yjdao.getResumeInfo(r, request);
      
      PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
      request.setAttribute("homePage", "home.jsp");
      request.setAttribute("titlePage", "title.jsp");
      request.setAttribute("contentPage", "portfolio/resumeDetail.jsp");
      request.setAttribute("profilePage", "profilePage.jsp");
      request.setAttribute("bannerPage", "banner.jsp");

      return "index";
   }
   
   @RequestMapping(value = "/resume.show", method = RequestMethod.GET)
   public String resumeShow(resumeInfo r, HttpServletRequest request, portInfo i) {
	   
	   yjdao.getResumeInfo(r, request);
	   
	   PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
	   
	   request.setAttribute("homePage", "home.jsp");
	   request.setAttribute("titlePage", "title.jsp");
	   request.setAttribute("contentPage", "portfolio/resumeView.jsp");
	   request.setAttribute("profilePage", "profilePage.jsp");
	   request.setAttribute("bannerPage", "banner.jsp");
	   
	   return "index";
   }
   
   @RequestMapping(value = "/resume.correct.OK", method = RequestMethod.POST)
   public String resumeCorrectOK(resumeInfo r, HttpServletRequest request, portInfo i) {

      yjdao.resumeUpdate(r, request);      
      yjdao.getResumeInfo(r, request);
      
      PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
      request.setAttribute("homePage", "home.jsp");
      request.setAttribute("titlePage", "title.jsp");
      request.setAttribute("contentPage", "portfolio/resumeView.jsp");
      request.setAttribute("profilePage", "profilePage.jsp");
      request.setAttribute("bannerPage", "banner.jsp");
      
      return "index";
   }

}