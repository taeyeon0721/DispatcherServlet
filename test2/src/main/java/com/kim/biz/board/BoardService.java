package com.kim.biz.board;

import java.util.List;

public interface BoardService {
	//인터페이스에서 부모클래스는 메서드 바디가 필요없음
	void insertBoard(BoardVO vo);
	void updateBoard(BoardVO vo);
	void deleteBoard(BoardVO vo);
	BoardVO selectOneBoard(BoardVO vo);
	List<BoardVO> selectAllBoard(BoardVO vo);
}
