package com.t4.cy.comment;

import org.springframework.stereotype.Service;

@Service
public class SiteOption {
	
	// sns 한 페이지당 몇 개씩 나오게 할 지
	private int CommentMsgPerPage;
	
	public SiteOption() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentMsgPerPage() {
		return CommentMsgPerPage;
	}

	public void setCommentMsgPerPage(int commentMsgPerPage) {
		CommentMsgPerPage = commentMsgPerPage;
	}

	public SiteOption(int CommentMsgPerPage) {
		super();
		this.CommentMsgPerPage = CommentMsgPerPage;
	}
	
	
}
