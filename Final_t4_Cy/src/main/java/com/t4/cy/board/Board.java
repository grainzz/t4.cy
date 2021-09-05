package com.t4.cy.board;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class Board {
	private int b_no;
	private String b_title;
	private String b_content;
	private String b_writer;
	private Date b_date;
	private int b_hit;
	private List<Board> board;

	public List<Board> getBoard() {
		return this.board;
	}

	public void setBoard(List<Board> board) {
		this.board = board;
	}

	public Board() {
	}

	public Board(int b_no, String b_title, String b_content, String b_writer, Date b_date, int b_hit) {
		this.b_no = b_no;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writer = b_writer;
		this.b_date = b_date;
		this.b_hit = b_hit;
	}

	public int getB_no() {
		return this.b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_title() {
		return this.b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return this.b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_writer() {
		return this.b_writer;
	}

	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	public Date getB_date() {
		return this.b_date;
	}

	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}

	public int getB_hit() {
		return this.b_hit;
	}

	public void setB_hit(int b_hit) {
		this.b_hit = b_hit;
	}
}