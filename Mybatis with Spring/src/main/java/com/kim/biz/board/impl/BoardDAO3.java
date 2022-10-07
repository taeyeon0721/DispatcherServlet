package com.kim.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kim.biz.board.BoardVO;

@Repository("boardDAO")
public class BoardDAO3 {

	@Autowired
	private SqlSessionTemplate mybatis;
	
//	public BoardDAO3() {
//		mybatis=SqlSessionBean.getSqlSessionInstance();
//	}
	
	public void insertBoard(BoardVO vo) {
		System.out.println("vo들어왔니:?"+vo);
		mybatis.insert("BoardDAO.insertBoard",vo);
		//mybatis.commit();
	}
	void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard",vo);
	}
	void deleteBoard(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteBoard",vo);
	}
	BoardVO selectOneBoard(BoardVO vo) {
		return mybatis.selectOne("BoardDAO.selectOneBoard",vo);
	}
	public List<BoardVO> selectAllBoard(BoardVO vo) {
		return mybatis.selectList("BoardDAO.selectAllBoard",vo);
	}
}
