package com.t4.cy.comment;

import java.util.List;

import com.t4.cy.member.Member;


public interface CommentMapper {

	public List<Member> getAllmsg(Comment c);
	public List<Comment> getAllmsg2(Comment c);

	public int writeMsg(Comment c);


	public int getAllMsgCount();

	public int deleteMsg(Comment c);

	public List<Comment> getMsg(CommentSelector s);
	public int getSearchMsgCnt(CommentSelector sSel2);

	public int updateMsg(Comment c);

	public Comment getMsgs(Comment c);

	
	public List<Comment> selectMsg(Comment c);


}
