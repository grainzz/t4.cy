package com.t4.cy.pay;

import java.util.List;

public interface PayMapper {

	void dotoriAutoFill(String c_id);

	int checkDotori(String c_id);

	void updateDotori(Pay pay);

	void setMusic(Music music);

	String getMusic(String c_id);
	
	void musicAutoFill(String c_id);

	void setTheme(Music music);

	void setMusicHistory(Music music);
	
	void setThemeHistory(Music music);

	int checkHistoryBgm(Music music);

	int checkHistoryTheme(Music music);

	List<B_HistoryVO> getB_history(String c_id);

	List<T_HistoryVO> getT_history(String c_id);

}
