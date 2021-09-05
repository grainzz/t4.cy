package com.t4.cy;

public class PageInfoVO {
	
	private String p_id; // 해당 페이지의 아이디
	private String p_name; // 페이지 주인 이름
	private String p_birth;
	private String p_photo; //프로필사진
	private String p_music; // 프로필뮤직
	private String p_musicsec; // 브금 재생시간
	private String p_theme; // 설정 테마
	private String p_profile; // 프로필 메시지
	private String p_email; // 이메일 주소
	private String p_sns; // sns 주소
	private String p_state; //구직상태
	
	public PageInfoVO() {
		// TODO Auto-generated constructor stub
	}

	public PageInfoVO(String p_id, String p_name, String p_birth, String p_photo, String p_music, String p_musicsec,
			String p_theme, String p_profile, String p_email, String p_sns, String p_state) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_birth = p_birth;
		this.p_photo = p_photo;
		this.p_music = p_music;
		this.p_musicsec = p_musicsec;
		this.p_theme = p_theme;
		this.p_profile = p_profile;
		this.p_email = p_email;
		this.p_sns = p_sns;
		this.p_state = p_state;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_birth() {
		return p_birth;
	}

	public void setP_birth(String p_birth) {
		this.p_birth = p_birth;
	}

	public String getP_photo() {
		return p_photo;
	}

	public void setP_photo(String p_photo) {
		this.p_photo = p_photo;
	}

	public String getP_music() {
		return p_music;
	}

	public void setP_music(String p_music) {
		this.p_music = p_music;
	}

	public String getP_musicsec() {
		return p_musicsec;
	}

	public void setP_musicsec(String p_musicsec) {
		this.p_musicsec = p_musicsec;
	}

	public String getP_theme() {
		return p_theme;
	}

	public void setP_theme(String p_theme) {
		this.p_theme = p_theme;
	}

	public String getP_profile() {
		return p_profile;
	}

	public void setP_profile(String p_profile) {
		this.p_profile = p_profile;
	}

	public String getP_email() {
		return p_email;
	}

	public void setP_email(String p_email) {
		this.p_email = p_email;
	}

	public String getP_sns() {
		return p_sns;
	}

	public void setP_sns(String p_sns) {
		this.p_sns = p_sns;
	}

	public String getP_state() {
		return p_state;
	}

	public void setP_state(String p_state) {
		this.p_state = p_state;
	}

	
	
}
