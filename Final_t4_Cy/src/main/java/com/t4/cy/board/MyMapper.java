package com.t4.cy.board;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface MyMapper {
	List<Board> showBoard(String p_id);

	int regBoard(Board var1);

	int delBoard(Board var1);

	int updateHit(Board b);

	Board showDetail(Board var1);

	int modBoard(Board b);

	List<Board> showAllBoard();
}