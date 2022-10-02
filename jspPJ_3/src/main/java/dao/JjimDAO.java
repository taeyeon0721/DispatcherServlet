package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.JDBCUtil;
import vo.JjimVO;

public class JjimDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	final String sql_jInsert ="INSERT INTO JJIM(MID, EPK) VALUES(?, ?)";	//사용자가 찜하기 했을경우 데이터에 INSERT
	final String sql_jDelete ="DELETE FROM JJIM WHERE MID=? AND EPK=?";	//사용자가 찜하기 취소했을경우 데이터에서 DELETE
	final String sql_jSelectAll ="SELECT * FROM JJIM WHERE MID=?";	//사용자가 찜한 목록들 보여주기
	final String sql_selectOne = "SELECT * FROM JJIM WHERE MID=? AND EPK=?";	//현재 사용자가 찜을했는지 안했는지 확인할때 사용
	
	public ArrayList<Integer> selectAll(JjimVO vo1){
		conn = JDBCUtil.connect();
		ArrayList<Integer> datas=new ArrayList<Integer>();
		
		try {
			pstmt = conn.prepareStatement(sql_jSelectAll);
			pstmt.setString(1, vo1.getMid());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				datas.add(rs.getInt("EPK"));
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return datas;
	}
	public int jjimCheck(JjimVO vo) {	//현재 사용자가 보고있는 매물에 찜한상태를 확인하기위한 메서드
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setString(1, vo.getMid());
			pstmt.setInt(2, vo.getEpk());
			ResultSet rs =pstmt.executeQuery();
			if(rs.next()) {
				return 1;
			}
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	public boolean jjimDelete(JjimVO vo) {	//현재 사용자가 찜하기를 취소할때 실행되는 메서드
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_jDelete);
			pstmt.setString(1, vo.getMid());
			pstmt.setInt(2, vo.getEpk());
			int num=pstmt.executeUpdate();
			System.out.println("Jjimdelete에서 반환값="+num);
			if(num>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		return false;
	}
	
	public boolean jjimInsert(JjimVO vo) {	//현재 사용자가 찜하기를 할때 실행되는 메서드
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_jInsert);
			pstmt.setString(1, vo.getMid());
			pstmt.setInt(2, vo.getEpk());
			int num=pstmt.executeUpdate();
			System.out.println("Jjiminsert에서 반환값="+num);
			if(num>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		
		
		return false;
	}
	
	public int jjimAction(JjimVO vo) {	//ajax로 찜하기를 구현하기위한 메서드
		
		int num=jjimCheck(vo);		//check를 통해 사용자가 좋아요를 했는지 안했는지 판단
									//num=0이면 ->insert ,num>0 ->delete
		if(num==0) {
			if(jjimInsert(vo)) {
				return 1;		//서블릿에서 1 return값을 받아 보내줄 값 1이면 좋아요 하트
			}else {
				System.out.println("jjimInsert 오류");
				return -1;
			}
		}else {
			if(jjimDelete(vo)) {
				return 0;		//서블릿에서 0 return값을 받아 보내줄 값 0이면 좋아요 취소
			}else {
				System.out.println("jjimDelete 오류");
				return -1;
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
