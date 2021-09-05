package com.t4.cy.pay;

import java.util.Date;

public class T_HistoryVO {
	
	private int th_no;
	private String th_id;
	private String th_theme;
	private Date th_date;
	
	public T_HistoryVO() {
		// TODO Auto-generated constructor stub
	}

	public T_HistoryVO(int th_no, String th_id, String th_theme, Date th_date) {
		super();
		this.th_no = th_no;
		this.th_id = th_id;
		this.th_theme = th_theme;
		this.th_date = th_date;
	}

	public int getTh_no() {
		return th_no;
	}

	public void setTh_no(int th_no) {
		this.th_no = th_no;
	}

	public String getTh_id() {
		return th_id;
	}

	public void setTh_id(String th_id) {
		this.th_id = th_id;
	}

	public String getTh_theme() {
		return th_theme;
	}

	public void setTh_theme(String th_theme) {
		this.th_theme = th_theme;
	}

	public Date getTh_date() {
		return th_date;
	}

	public void setTh_date(Date th_date) {
		this.th_date = th_date;
	}

	

	
	
	
	
	
}
