package com.t4.cy.pageInfo;

import com.t4.cy.PageInfoVO;
import com.t4.cy.member.Member;

public interface PageInfoMapper {

	int defaultAutoFill(Member m);

	PageInfoVO getPageInfoById(String c_id);

	void update(PageInfoVO lp);

	void byeById(String id);

	void setProfile(PageInfoVO pp);

}
