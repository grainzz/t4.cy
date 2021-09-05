package com.t4.cy.pageInfo;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t4.cy.PageInfoVO;


@Service
public class PageInfoDAO {

	@Autowired
	private SqlSession ss;
	
	public void getInfoById(String c_id, HttpServletRequest request) {
		PageInfoVO dbP = ss.getMapper(PageInfoMapper.class).getPageInfoById(c_id);
		request.getSession().setAttribute("pageInfo", dbP);
		System.out.println("pageInfo: "+dbP);
	}

	public void byeById(String id) {
		ss.getMapper(PageInfoMapper.class).byeById(id);
	}

	public void setProfile(PageInfoVO p, HttpServletRequest request) {
		PageInfoVO pp = (PageInfoVO) request.getSession().getAttribute("pageInfo");
		pp.setP_id(p.getP_id());
		pp.setP_profile(p.getP_profile());
		pp.setP_email(p.getP_email());
		pp.setP_sns(p.getP_sns());
		pp.setP_state(p.getP_state());
		ss.getMapper(PageInfoMapper.class).setProfile(pp);
		request.getSession().setAttribute("pageInfo", pp);
		
	}

}
