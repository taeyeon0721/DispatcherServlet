package com.kim.biz.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kim.biz.board.BoardVO;
import com.kim.biz.common.JDBCUtil;
import com.kim.biz.member.MemberVO;

@Repository("memberDAO") //메모리에 이 객체 만들어달라는 뜻, 이게 있어야 service 코드 돌아감
public class MemberDAO2 { 

	@Autowired
	//멤버변수로 사용되니까 의존성주입
	private JdbcTemplate jdbcTemplate;

	final String sql_selectOne="SELECT * FROM MEMBER WHERE MID=? AND MPW=?";
	final String sql_selectAll="SELECT * FROM MEMBER ORDER BY MID DESC";
	final String sql_insert="INSERT INTO MEMBER(MID,MPW,NAME,ROLE) VALUES(?,?,?,?)";
	final String sql_update="UPDATE MEMBER SET MPW=? WHERE MID=?";
	final String sql_delete="DELETE MEMBER WHERE MID=? AND MPW=?";

	void insertMember(MemberVO vo) {
		jdbcTemplate.update(sql_insert,vo.getMid(),vo.getMpw(),vo.getName(),vo.getRole());
	}
	void updateMember(MemberVO vo) {
		jdbcTemplate.update(sql_update,vo.getMpw(),vo.getMid());	
	}
	void deleteMember(MemberVO vo) {
		jdbcTemplate.update(sql_delete,vo.getMid(),vo.getMpw());
	}
	public MemberVO selectOneMember(MemberVO vo) {
		Object[] args= {vo.getMid(),vo.getMpw()};
		return jdbcTemplate.queryForObject(sql_selectOne,args,new MemberRowMapper());
		//queryForObject는 output이 없으면 예외뜨도록 되어있음
	}
	List<MemberVO> selectAllMember(MemberVO vo) {
		return jdbcTemplate.query(sql_selectAll,new MemberRowMapper());
	}
	
	class MemberRowMapper implements RowMapper<MemberVO>{

		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {//rowNum == 데이터개수
			MemberVO data=new MemberVO();
			data.setMid(rs.getString("MID"));
			data.setMpw(rs.getString("MPW"));
			data.setName(rs.getString("NAME"));
			data.setRole(rs.getString("ROLE"));
			return data;
		}

	}
}