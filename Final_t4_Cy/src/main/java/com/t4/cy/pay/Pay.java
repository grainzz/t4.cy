package com.t4.cy.pay;

public class Pay {
	private String c_id;
	private int c_dotori;
	
	public Pay() {
		// TODO Auto-generated constructor stub
	}

	public Pay(String c_id, int c_dotori) {
		super();
		this.c_id = c_id;
		this.c_dotori = c_dotori;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public int getC_dotori() {
		return c_dotori;
	}

	public void setC_dotori(int c_dotori) {
		this.c_dotori = c_dotori;
	}

	
	
}
