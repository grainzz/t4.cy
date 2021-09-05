package com.t4.cy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.t4.cy.board.BDAO;
import com.t4.cy.comment.Comment;
import com.t4.cy.comment.CommentDAO;
import com.t4.cy.comment.TokenMaker;
import com.t4.cy.member.MDAO;
import com.t4.cy.member.Member;
import com.t4.cy.pageInfo.PageInfoDAO;
import com.t4.cy.pay.PayDAO;
import com.t4.cy.port.portInfo;
import com.t4.cy.port.yjDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MDAO mdao;
	
	@Autowired
	private WeatherDAO wdao;
	
	@Autowired
	private yjDAO yjdao;
	
	@Autowired
	private BDAO bdao;
	
	@Autowired
	private CommentDAO cdao;
	
	@Autowired
	private PageInfoDAO pidao;
	

	private boolean isFirstReq;
	
	public HomeController() {
		isFirstReq = true;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(portInfo i, HttpServletRequest request) {
		//맨처음화면-> 처음 실행 말고는 들어올일없음
		wdao.getWeatherDefault(request); //맨처음 들어올때 시드니 날씨정보 받아와서 아이콘 설정
		
		//세션 준비: 로그인(멤버정보+도토리), 페이지(페이지프로필,테마,브금), 날씨
		request.getSession().setMaxInactiveInterval(60*60*12); //세션 12시간 유지
		
		
		if(request.getSession().getAttribute("loginMember")==null) {
			//로그인 유지 안돼있는상태
			request.getSession().setAttribute("loginMember", null); //로그인 기본 세션 준비
			request.getSession().setAttribute("pageInfo", null); //페이지 기본 세션 준비
			request.setAttribute("contentPage", "login/login.jsp");
		}else {
			//로그인 유지 돼있는상태
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String c_id = m.getC_id(); //지금 로그인돼있는 세션에서 아이디가져오기
			
			//로그인돼있는 세션의 pageInfo 가져오고, 세션에 세팅
			pidao.getInfoById(c_id, request);
			
			mdao.autologin(request);
			request.setAttribute("contentPage", "main.jsp");
		}
		
		request.setAttribute("theme", "default");
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		

		return "index";
	}
	
	@RequestMapping(value = "location.go", method = RequestMethod.GET)
	public String locationGo(HttpServletRequest request) {
		wdao.getWeatherByLocation(request);
		request.setAttribute("theme", "default");
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "login/login.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		return "index";
	}
	

	@RequestMapping(value = "menu.home.go", method = RequestMethod.GET)
	public String homeGo(portInfo i, Member m, HttpServletRequest request, HttpServletResponse res) {
		//p_id가 있으면 그 p_id 홈으로 보내주고, 없으면 로그인 상태 확인
		PageInfoVO p = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		
		//p_id 확인
		if(p != null) {
			//p_id가 있을때 -> p_id랑 같은 페이지 가져와서 세팅
			pidao.getInfoById(p.getP_id(), request);
			yjdao.getPortInfo(i, request);
			request.setAttribute("bgm", p.getP_music());//브금세팅
			request.setAttribute("theme", p.getP_theme());//테마세팅
			
			request.setAttribute("contentPage", "main.jsp");
			
		}else {
			//p_id가 없을때
			request.setAttribute("contentPage", "login/login.jsp");
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");

		
		return "index";
	}

	@RequestMapping(value = "menu.board.go", method = RequestMethod.GET)
	public String board(Member m, HttpServletRequest request, HttpServletResponse res) {
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");

		if(pp!= null) {
			//p_id값이 있을때
			bdao.getBoard(request);
			request.setAttribute("contentPage", "menu/board.jsp");
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			//p_id값이 없을때
			request.setAttribute("contentPage", "login/login.jsp");
			request.setAttribute("theme", "default");
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		return "index";
	}

	@RequestMapping(value = "menu.setting.go", method = RequestMethod.GET)
	public String setting(Member m, HttpServletRequest request, HttpServletResponse res) {
		//로그인했을때만 보여서 로그인체크 안해도됨
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "menu/setting.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");

		return "index";
	}
	

	@RequestMapping(value = "menu.message.go", method = RequestMethod.GET)
	public String message(Comment c, Member m, HttpServletRequest request, HttpServletResponse res) {
		
		if (isFirstReq) {
			cdao.countAllMsg();
			isFirstReq = false;
		}
		
		if (request.getSession().getAttribute("loginMember") != null) {
		cdao.getMsgs(c, request);
		TokenMaker.makeToken(request);
		request.setAttribute("contentPage", "menu/message.jsp");

		} else {
		request.setAttribute("contentPage", "login/login.jsp");
		}
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		return "index";
	}
	
	
}
