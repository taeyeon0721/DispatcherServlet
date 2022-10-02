package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.JDBCUtil;
import vo.ConsultVO;

public class ConsultDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	final String sql_cSelectAll = "SELECT * FROM CONSULT";
	final String sql_cSelectAll_M ="SELECT * FROM CONSULT WHERE MID =?"; //상담내역 전체 보기
	final String sql_cSelectOne ="SELECT * FROM CONSULT WHERE CID =?"; //상담 내역 하나 확인
	final String sql_cInsert ="INSERT INTO CONSULT (MID, RID, EPK, CDATE, TITLE, CONTENT) VALUES (?,?,?,?,?,?)"; //상담신청
	final String sql_cUpdate ="UPDATE CONSULT SET CONTENT=? WHERE CID =?"; //내용만 수정할 수 있게
	final String sql_cDelete ="DELETE FROM CONSULT WHERE CID=?";
	
	public boolean cInsert(ConsultVO vo) { //상담 신청
		conn = util.JDBCUtil.connect();
		try {
			System.out.println("dao로그: "+vo.getContent());
			
			pstmt = conn.prepareStatement(sql_cInsert);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getRid());
			pstmt.setInt(3, vo.getEpk());
			pstmt.setString(4, vo.getCdate());
			pstmt.setString(5, vo.getTitle());
			pstmt.setString(6, vo.getContent());
			
			
			int num = pstmt.executeUpdate(); 
			if (num <= 0) {
				System.out.println("로그 : 상담 신청 실패");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 상담 신청 성공");
		return true;
	}
	
	public ArrayList<ConsultVO> cSelectAll(ConsultVO vo) { //개인 사용자의 상담내역 전체 보기
		conn=util.JDBCUtil.connect();
		ArrayList<ConsultVO> datas = new ArrayList<ConsultVO>();
		
		System.out.println("로그: 전체상담내역 트라이 전"+vo.getMid());
		try {
			if(vo.getMid() == null) {
				pstmt=conn.prepareStatement(sql_cSelectAll);
			}
			else {
				pstmt=conn.prepareStatement(sql_cSelectAll_M);
				pstmt.setString(1, vo.getMid());
			}
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ConsultVO vo1 = new ConsultVO();
				vo1.setCid(rs.getInt("CID"));
				vo1.setTitle(rs.getString("TITLE"));
				vo1.setContent(rs.getString("CONTENT"));
				vo1.setCdate(rs.getString("CDATE"));
				vo1.setEpk(rs.getInt("EPK"));
				vo1.setMid(rs.getString("MID"));
				vo1.setRid(rs.getString("RID"));
				vo1.setWriteday(rs.getString("WRITEDAY"));
				datas.add(vo1);
			}
			
			System.out.println("로그 : selectAll상담내역 전체 출력 성공");
			return datas;
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		
		System.out.println("로그 : selectAll상담내역 전체 출력 실패");
		return null;
	}
	
	public ConsultVO cSelectOne(ConsultVO vo) { //개인 사용자의 상담 내역 한개 확인
		conn=util.JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_cSelectOne);
			pstmt.setInt(1, vo.getCid());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				ConsultVO vo2 = new ConsultVO();
				vo2.setCid(rs.getInt("CID"));
				vo2.setTitle(rs.getString("TITLE"));
				vo2.setContent(rs.getString("CONTENT"));
				vo2.setCdate(rs.getString("CDATE"));
				vo2.setEpk(rs.getInt("EPK"));
				vo2.setMid(rs.getString("MID"));
				vo2.setRid(rs.getString("RID"));
				vo2.setWriteday(rs.getString("WRITEDAY"));
				return vo2;
			}
			System.out.println("로그 : 상담 내역 하나  출력 성공");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 상담 내역 하나 출력 실패");
		return null;
	}
	
	public boolean cUpdate(ConsultVO vo) { // 상담 내용 변경
		conn = util.JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_cUpdate);
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getCid());
			int num = pstmt.executeUpdate(); 
			if (num <= 0) {
				System.out.println("로그 : 상담 내용 변경 실패");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 상담 내용 변경 성공");
		return true;
	}
	
	public boolean cDelete(ConsultVO vo) { //상담 취소
		conn = util.JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_cDelete);
			pstmt.setInt(1, vo.getCid());
			int num = pstmt.executeUpdate(); 
			if (num <= 0) {
				System.out.println("로그 : 상담 취소 실패");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 상담 취소 성공");
		return true;
	}	
}
