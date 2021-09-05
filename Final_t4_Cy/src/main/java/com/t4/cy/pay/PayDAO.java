package com.t4.cy.pay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t4.cy.member.Member;

@Service
public class PayDAO {

	@Autowired
	private SqlSession ss;
	
	public String getPay(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		String c_id = m.getC_id();
		int dotoriNum = Integer.parseInt(request.getParameter("dotoriNum"));
		String dotoriPrice = "5000";
		//3개: 300원, 10개: 800원, 30개: 2000원, 50: 3000원, 100: 5000원
		if(dotoriNum == 3) dotoriPrice = "300";
		else if(dotoriNum == 10) dotoriPrice = "800";
		else if(dotoriNum == 30) dotoriPrice = "2000";
		else if(dotoriNum == 50) dotoriPrice = "3000";
		//도토리 사려는 사람, 도토리 갯수, 도토리 가격 받음
		
		HttpsURLConnection huc = null;
		String successUrl = null;
		
		try {
			String url = "https://kapi.kakao.com/v1/payment/ready";
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			
			huc.setRequestMethod("POST"); //POST방식으로 요청해야함
			//setRequestProperty: URL에 요청할 때 보낼 헤더값
			huc.setRequestProperty("Authorization", "KakaoAK 5cf04376ccab1f7b8301a0292966d84f");
			huc.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			huc.setDoInput(true); //url 연결에 성공했을시 값을 받아올것인지? -> true
			huc.setDoOutput(true); //값을 넣을것인지? -> true
			
			//URL에 보낼 값들을 Map형태로 만든다
			Map<String, String> params = new HashMap<String, String>();
			
		    params.put("cid", "TC0ONETIME"); //가맹점코드: TC0ONETIME(테스트코드)
		    params.put("partner_order_id", "1001"); //주문번호(대충넣어둠)
		    params.put("partner_user_id", c_id); //회원id(세션에서 받아옴)
		    params.put("item_name", "도토리 "+dotoriNum+"개 지갑"); //상품명
		    params.put("quantity", "1"); //상품 수량: 한개씩만 살수있음
		    params.put("total_amount", dotoriPrice); //상품 가격
		    params.put("tax_free_amount", "100"); //비과세가격
		    //url localhost:8080 <- 요거 확인하기
		    params.put("approval_url", "http://localhost:8080/cy/pay.after?dotoriNum="+dotoriNum); //결제 성공시 redirect
		    params.put("cancel_url", "http://localhost:8080/cy/pay.after?dotoriNum="+"-1"); //결제 취소시 redirect
		    params.put("fail_url", "http://localhost:8080/cy/pay.after?dotoriNum="+"-1"); //결제 실패시 redirect
		    
		    String string_params = new String();
		    for(Map.Entry<String, String> elem: params.entrySet()) {
		    	string_params += (elem.getKey() + "=" + elem.getValue() + "&");
		    }
			
		    huc.getOutputStream().write(string_params.getBytes());
		    BufferedReader in = new BufferedReader(new InputStreamReader(huc.getInputStream()));
		    //카카오에서 응답해줌
		    
		    JSONParser jp = new JSONParser();
		    
		    JSONObject payData = (JSONObject) jp.parse(in);
//		    System.out.println(payData); //데이터 확인용
		    
		    successUrl = (String) payData.get("next_redirect_pc_url");
		    request.setAttribute("result", "결제 확인중..."); //확인용
		    request.setAttribute("dotoricheck", dotoriNum);
		    
		} catch (Exception e) {
			request.setAttribute("result", "결제에 실패했습니다"); //확인용
		}
		return successUrl;
		
	}

	//로그인했을때 현재 도토리 갯수 가져오기
	public void checkDotori(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		String c_id = m.getC_id(); //지금 로그인돼있는 세션에서 아이디가져오기
		int c_dotori = ss.getMapper(PayMapper.class).checkDotori(c_id); //그 아이디의 도토리 갯수 체크
		request.setAttribute("c_dotori", c_dotori);
	}
	
	//로그인화면에서 쓰는거
	public void checkDotoriById(String c_id, HttpServletRequest request) {
		int c_dotori = ss.getMapper(PayMapper.class).checkDotori(c_id); //그 아이디의 도토리 갯수 체크
		request.setAttribute("c_dotori", c_dotori);
		
	}
	
	//페이성공하고 도토리 갯수 업데이트하기
	public void updateData(HttpServletRequest request, Pay pay) {
		ss.getMapper(PayMapper.class).updateDotori(pay);
		checkDotori(request); //도토리 갯수 체크
	}

	//받아온 브금 db에 추가하기
	public void setMusic(Music music, HttpServletRequest request) {
		ss.getMapper(PayMapper.class).setMusic(music);
		
	}

	
	public void getMusic(HttpServletRequest request) {
		String p_id = (request.getSession().getAttribute("p_id")).toString(); //p_id값 받아오기
	//	System.out.println(p_id);
		String bgm = ss.getMapper(PayMapper.class).getMusic(p_id); //그 아이디에 설정되어있는 브금 찾기
		request.setAttribute("bgm", bgm);
	}

	public void setTheme(Music music, HttpServletRequest request) {
		ss.getMapper(PayMapper.class).setTheme(music);
	}

	public void setMusicHistory(Music music, HttpServletRequest request) {
		ss.getMapper(PayMapper.class).setMusicHistory(music);
	}

	public void setThemeHistory(Music music, HttpServletRequest request) {
		ss.getMapper(PayMapper.class).setThemeHistory(music);
	}
	
	public boolean checkHistoryBgm(Music music, HttpServletRequest request) {
		//구매이력에 있을때 true, 없을때 false return하기
		if(ss.getMapper(PayMapper.class).checkHistoryBgm(music) == 0) {
			//구매이력이 없을때
			return false;
		}else {
			//구매이력이 있을때
			return true;
		}
	}

	public boolean checkHistoryTheme(Music music, HttpServletRequest request) {
		//구매이력에 있을때 true, 없을때 false return하기
		if(ss.getMapper(PayMapper.class).checkHistoryTheme(music) == 0) {
			//구매이력이 없을때
			return false;
		}else {
			//구매이력이 있을때
			return true;
		}
	}

	public void getHistory(String c_id, HttpServletRequest request) {
		List<B_HistoryVO> B_history = ss.getMapper(PayMapper.class).getB_history(c_id);
		List<T_HistoryVO> T_history = ss.getMapper(PayMapper.class).getT_history(c_id);
		request.setAttribute("B_history", B_history);
		request.setAttribute("T_history", T_history);
	}



	
	
	
}
