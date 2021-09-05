package com.t4.cy.random;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t4.cy.PageInfoVO;
import com.t4.cy.member.Member;

@Service
public class RandomDAO {

	@Autowired
	private SqlSession ss;
	
	public String getRandom(HttpServletRequest request) {
		//본인 빼고 랜덤고르기 ->구현x

		String rId;
		
		//db에 있는 멤버들을 list로 가져오기
		List<Member> members = ss.getMapper(RandomMapper.class).getIdList();
		
		//db에 있는 멤버들 수 세기
		int cnt = members.size();
//		int cnt = ss.getMapper(RandomMapper.class).getIdCount();
		
		Random r = new Random();
		int rn = r.nextInt(cnt); //random number
		Member randomPick = members.get(rn);
		rId = randomPick.getC_id();
		
		//뽑은 id 넘겨주기
		
		return rId;
	}

	public boolean checkID(String sid, HttpServletRequest request) {
		if(ss.getMapper(RandomMapper.class).checkID(sid)==1) {
			//검색한 id 존재
			return true;
		}else {
			//검색한 id 없음
			return false;
		}
		
	}

}
