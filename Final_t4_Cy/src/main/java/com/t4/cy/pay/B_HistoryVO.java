package com.t4.cy.pay;

import java.util.Date;

public class B_HistoryVO {
	
	private int bh_no;
	private String bh_id;
	private String bh_music;
	private Date bh_date;
	
	public B_HistoryVO() {
		// TODO Auto-generated constructor stub
	}

	public B_HistoryVO(int bh_no, String bh_id, String bh_music, Date bh_date) {
		super();
		this.bh_no = bh_no;
		this.bh_id = bh_id;
		this.bh_music = bh_music;
		this.bh_date = bh_date;
	}

	public int getBh_no() {
		return bh_no;
	}

	public void setBh_no(int bh_no) {
		this.bh_no = bh_no;
	}

	public String getBh_id() {
		return bh_id;
	}

	public void setBh_id(String bh_id) {
		this.bh_id = bh_id;
	}

	public String getBh_music() {
		return bh_music;
	}

	public void setBh_music(String bh_music) {
		this.bh_music = bh_music;
	}

	public Date getBh_date() {
		return bh_date;
	}

	public void setBh_date(Date bh_date) {
		this.bh_date = bh_date;
	}
	
	
	
	
	
	
	
}
