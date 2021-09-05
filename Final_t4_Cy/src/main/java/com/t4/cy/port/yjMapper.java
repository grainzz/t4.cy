package com.t4.cy.port;

public interface yjMapper {

	public int portupdate(portInfo i);
	public portInfo getinfo(portInfo i);
	
	public int resumeupdate(resumeInfo r);
	public resumeInfo getresumeinfo(resumeInfo r);
	public portInfo getinfoByID(String c_id);
	public void portAutoFill(String c_id);
	public void resAutoFill(String c_id);

}
