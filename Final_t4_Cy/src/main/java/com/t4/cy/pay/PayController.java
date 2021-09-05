package com.t4.cy.pay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.t4.cy.PageInfoVO;
import com.t4.cy.member.MDAO;
import com.t4.cy.member.Member;
import com.t4.cy.pageInfo.PageInfoDAO;

@Controller
public class PayController {

	@Autowired
	private MDAO mdao;

	@Autowired
	private PayDAO pdao;
	
	@Autowired
	private PageInfoDAO pjdao;
	
	@RequestMapping(value = "pay.go", method = RequestMethod.GET)
	public String payGo(HttpServletRequest request) {
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "pay/payPop.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		return "index";
}
	
	@RequestMapping(value = "pay.call", method = RequestMethod.POST)
	public String payOpen(HttpServletRequest request, HttpServletResponse response) {
		String url = pdao.getPay(request);
		if(url != null) {
			request.setAttribute("successUrl", url);
			request.setAttribute("contentPage", "pay/payPop2.jsp");
		}else {
			request.setAttribute("contentPage", "pay/paySuccess.jsp");
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
	
	
	@RequestMapping(value = "pay.after", method = RequestMethod.GET)
	public String payAfter(HttpServletRequest request) {

		int addDotori = Integer.parseInt(request.getParameter("dotoriNum"));
		Member m = (Member) request.getSession().getAttribute("loginMember");
		String c_id = m.getC_id(); //로그인중인 id값 불러오기
		Pay pay = new Pay(c_id, addDotori);
		int olddotori = m.getC_dotori();
		m.setC_dotori(olddotori+addDotori);
		request.getSession().setAttribute("loginMember", m);
		
		if(addDotori != -1) {
			pdao.updateData(request, pay); 
		}
		return "pay/paySuccess";
	}
	
	@RequestMapping(value = "shop.go", method = RequestMethod.GET)
	public String shopGo(HttpServletRequest request) {
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "pay/shopList.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "shop.bgm.go", method = RequestMethod.GET)
	public String shopBgmGo(HttpServletRequest request) {
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "pay/shopBgm.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "shop.theme.go", method = RequestMethod.GET)
	public String shopThemeGo(HttpServletRequest request) {
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "pay/shopTheme.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "shop.buy", method = RequestMethod.GET)
	public String shopBuy(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		String c_id = m.getC_id();
		pjdao.getInfoById(c_id, request);
		PageInfoVO p = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		int checkdotori = m.getC_dotori();
		
		if(checkdotori < 3) {
			//잔액부족할때
			request.setAttribute("shopResult", "도토리가 부족합니다!");
			request.setAttribute("c_dotori", checkdotori);
			
		}else {
			//잔액 충분할때
			String bgm = request.getParameter("bgm");
			Music music = new Music(c_id, bgm); //c_id랑 bgm 한꺼번에 넘기는 용 객체
			
			if(pdao.checkHistoryBgm(music, request)) {
				//이미 산 적이 있을때
				request.setAttribute("shopResult", "이미 구입한 브금입니다!");
				request.setAttribute("c_dotori", checkdotori);
			}else {
				//산 적 없는 브금일때 구매 진행
				Pay pay = new Pay(c_id, -3);
				pdao.updateData(request, pay);
				m.setC_dotori(checkdotori-3);
				request.setAttribute("shopResult", "브금 구입 완료");
				
				//산 브금 세팅
				p.setP_music(bgm); //세션에 세팅하기
				pdao.setMusic(music, request); //pageInfo db에 세팅하기
				pdao.setMusicHistory(music, request); //history db에 세팅하기
				
				request.setAttribute("c_dotori", checkdotori-3);
				request.getSession().setAttribute("loginMember", m);
				request.getSession().setAttribute("pageInfo", p);
			}
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "pay/shopSuccess.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		return "index";
	}
	
	
	@RequestMapping(value = "shop.buyTheme", method = RequestMethod.GET)
	public String shopBuyTheme(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		String c_id = m.getC_id();
		
		pjdao.getInfoById(c_id, request);
		PageInfoVO p = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		
		int checkdotori = m.getC_dotori();
		
		if(checkdotori < 2) {
			//잔액부족할때
			request.setAttribute("shopResult", "도토리가 부족합니다!");
			request.setAttribute("c_dotori", checkdotori);
			
		}else {
			//잔액 충분할때
			String theme = request.getParameter("theme");
			//브금세팅이랑 똑같으니까 기능그대로씀
			Music music = new Music(c_id, theme);//c_id랑 bgm 한꺼번에 넘기는 용 객체
			
			if(pdao.checkHistoryTheme(music, request)) {
				//이미 산 적이 있을때
				request.setAttribute("shopResult", "이미 구입한 테마입니다!");
				request.setAttribute("c_dotori", checkdotori);
			}else {
				//산 적 없는 테마일때 구매 진행
				Pay pay = new Pay(c_id, -2);
				pdao.updateData(request, pay);
				m.setC_dotori(checkdotori-2);
				request.setAttribute("shopResult", "테마 구입 완료");
				
				//테마에 테마 세팅
				p.setP_theme(theme); //세션에 세팅하기
				pdao.setTheme(music, request); //pageInfo db에 세팅하기
				pdao.setThemeHistory(music, request); //history db에 세팅하기
				
				request.setAttribute("c_dotori", checkdotori-2);
				request.getSession().setAttribute("loginMember", m);
				request.getSession().setAttribute("pageInfo", p);
			}
			
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "pay/shopSuccess.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");
		}
		
		return "index";
	}

	
	@RequestMapping(value = "shop.history.go", method = RequestMethod.GET)
	public String shopHistoryGo(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		String c_id = m.getC_id();
		
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		
		
		//구입내역 table 값 list로 받아서 request로 세팅 (B_history, T_history)
		pdao.getHistory(c_id, request);
		
	
		if(pp!=null) {
			request.setAttribute("bgm", pp.getP_music());//브금세팅
			request.setAttribute("theme", pp.getP_theme());//테마세팅
		}else {
			request.setAttribute("theme", "default");//p_id 없을때 default
		}
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "pay/showHistory.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		return "index";
}
	
	@RequestMapping(value = "history.setMusic", method = RequestMethod.GET)
	public String HistorySetMusic(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		
		//넘겨줄 Music 객체 만들기
		String c_id = m.getC_id();
		String bgm = request.getParameter("bgm");
		Music music = new Music(c_id, bgm);
		
		pdao.setMusic(music, request); //받아온 브금 db에 추가
		PageInfoVO p = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		p.setP_music(bgm); //받아온 브금 세션에 추가
		
		request.getSession().setAttribute("pageInfo", p);
		
		request.setAttribute("bgm", bgm);//브금세팅
		request.setAttribute("theme", p.getP_theme());//테마세팅
		
		request.setAttribute("shopResult", "브금 적용 완료!");
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "pay/settingSuccess.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		
		return "index";
	}
	
	@RequestMapping(value = "history.setTheme", method = RequestMethod.GET)
	public String HistorySetTheme(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		
		//넘겨줄 Music 객체 만들기
		String c_id = m.getC_id();
		String theme = request.getParameter("theme");
		Music music = new Music(c_id, theme);
		
		pdao.setTheme(music, request); //받아온 테마 db에 추가
		PageInfoVO p = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		p.setP_theme(theme); //받아온 테마세션에 추가
		
		request.getSession().setAttribute("pageInfo", p);
		
		request.setAttribute("bgm", p.getP_music());//브금세팅
		request.setAttribute("theme", theme);//테마세팅
		
		request.setAttribute("shopResult", "테마 적용 완료!");
		
		request.setAttribute("homePage", "home.jsp");
		request.setAttribute("titlePage", "title.jsp");
		request.setAttribute("contentPage", "pay/settingSuccess.jsp");
		request.setAttribute("profilePage", "profilePage.jsp");
		request.setAttribute("bannerPage", "banner.jsp");
		
		
		return "index";
	}
	
	

}
