package com.t4.cy.comment;

import java.math.BigDecimal;
import java.util.Date;

public class Comment {

	private String c_id;

	private BigDecimal c_no;
	private String c_writer;
	private String c_guest_comment;
	private Date c_date;

	private String c_name;
	private String c_minimi;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(String c_id, BigDecimal c_no, String c_writer, String c_guest_comment, Date c_date, String c_name,
			String c_minimi) {
		super();
		this.c_id = c_id;
		this.c_no = c_no;
		this.c_writer = c_writer;
		this.c_guest_comment = c_guest_comment;
		this.c_date = c_date;
		this.c_name = c_name;
		this.c_minimi = c_minimi;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public BigDecimal getC_no() {
		return c_no;
	}

	public void setC_no(BigDecimal c_no) {
		this.c_no = c_no;
	}

	public String getC_writer() {
		return c_writer;
	}

	public void setC_writer(String c_writer) {
		this.c_writer = c_writer;
	}

	public String getC_guest_comment() {
		return c_guest_comment;
	}

	public void setC_guest_comment(String c_guest_comment) {
		this.c_guest_comment = c_guest_comment;
	}

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	public String getC_minimi() {
		return c_minimi;
	}

	public void setC_minimi(String c_minimi) {
		this.c_minimi = c_minimi;
	}

}
