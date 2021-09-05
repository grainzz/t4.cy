package com.t4.cy.member;


public interface MemberMapper {

	int join(Member m);
	Member getMemberById(Member m);
	public int bye(Member m);
	public int update(Member m);
	public int idCheck(Member m);
//	public int idCheck(String memberid);
	

}
