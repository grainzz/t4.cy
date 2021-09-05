package com.t4.cy.random;

import java.util.List;

import com.t4.cy.member.Member;

public interface RandomMapper {

	List<Member> getIdList();

	int getIdCount();

	int checkID(String sid);

}
