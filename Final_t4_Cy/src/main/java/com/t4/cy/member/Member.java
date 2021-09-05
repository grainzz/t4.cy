package com.t4.cy.member;

public class Member {
	private String c_id;
	private String c_pw;
	private String c_name;
	private String c_minimi;
	private String c_gender;
	private String c_phone;
	private String c_birth;
	private String c_photo;
	private int c_dotori;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_pw() {
		return c_pw;
	}

	public void setC_pw(String c_pw) {
		this.c_pw = c_pw;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_minimi() {
		return c_minimi;
	}

	public void setC_minimi(String c_minimi) {
		this.c_minimi = c_minimi;
	}

	public String getC_gender() {
		return c_gender;
	}

	public void setC_gender(String c_gender) {
		this.c_gender = c_gender;
	}

	public String getC_phone() {
		return c_phone;
	}

	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}

	public String getC_birth() {
		return c_birth;
	}

	public void setC_birth(String c_birth) {
		this.c_birth = c_birth;
	}

	public String getC_photo() {
		return c_photo;
	}

	public void setC_photo(String c_photo) {
		this.c_photo = c_photo;
	}

	public int getC_dotori() {
		return c_dotori;
	}

	public void setC_dotori(int c_dotori) {
		this.c_dotori = c_dotori;
	}

	public Member(String c_id, String c_pw, String c_name, String c_minimi, String c_gender, String c_phone,
			String c_birth, String c_photo, int c_dotori) {
		super();
		this.c_id = c_id;
		this.c_pw = c_pw;
		this.c_name = c_name;
		this.c_minimi = c_minimi;
		this.c_gender = c_gender;
		this.c_phone = c_phone;
		this.c_birth = c_birth;
		this.c_photo = c_photo;
		this.c_dotori = c_dotori;
	}


}
