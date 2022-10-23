package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.GmemberVO;


public class GmemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	final String sql_mSelectOne ="SELECT * FROM GMEMBER WHERE MID =?";
	final String sql_mSelectAll = "SELECT * FROM GMEMBER";
	final String sql_mLogin ="SELECT * FROM GMEMBER WHERE MID = ? AND MPW = ?";
	final String sql_mSignUp ="INSERT INTO GMEMBER VALUES (?,?,?,?,?,?,?,?,'member')";
	final String sql_mUpdate ="UPDATE GMEMBER SET MPW=?, MPOSTCODE=?, MADDRESS=?, MDETAILADDRESS=?, MEXTRAADDRESS=? WHERE MID = ?";
	final String sql_mDelete = "DELETE FROM GMEMBER WHERE MID=?";

	public GmemberVO mSelectOne(GmemberVO vo) {	//로그인 후 사용자의 정보를 전부 보여줄 SelectOne
		conn = util.JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_mSelectOne);
			pstmt.setString(1, vo.getMid());
			ResultSet rs = pstmt.executeQuery();
			GmemberVO vo1 = new GmemberVO();
			if(rs.next()) {
				vo1.setMid(rs.getString("MID"));
				vo1.setMpw(rs.getString("MPW"));
				vo1.setMname(rs.getString("MNAME"));
				vo1.setMphone(rs.getString("MPHONE"));
				vo1.setMpostcode(rs.getString("MPOSTCODE"));
				vo1.setMaddress(rs.getString("MADDRESS"));
				vo1.setMdetailaddress(rs.getString("MDETAILADDRESS"));
				vo1.setMextraaddress(rs.getString("MEXTRAADDRESS"));
				return vo1;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("로그 : 사용자의 정보 반환 실패");
			e.printStackTrace();
			return null;
		}finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		return null;
	}
	
	
	public ArrayList<GmemberVO> mSelectAll(GmemberVO vo) {	// 전체 사용자를 출력
		conn = util.JDBCUtil.connect();
		ArrayList<GmemberVO> datas = new ArrayList<GmemberVO>();
		try {
			pstmt = conn.prepareStatement(sql_mSelectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				GmemberVO vo1 = new GmemberVO();
				vo1.setMid(rs.getString("MID"));
				vo1.setMpw(rs.getString("MPW"));
				vo1.setMname(rs.getString("MNAME"));
				vo1.setMphone(rs.getString("MPHONE"));
				vo1.setMpostcode(rs.getString("MPOSTCODE"));
				vo1.setMaddress(rs.getString("MADDRESS"));
				vo1.setMdetailaddress(rs.getString("MDETAILADDRESS"));
				vo1.setMextraaddress(rs.getString("MEXTRAADDRESS"));
				datas.add(vo1);
			}			
			return datas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 사용자 로그인 실패");
		return null;
	}
	
	public GmemberVO mLogin(GmemberVO vo) {	//로그인
		conn = util.JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_mLogin);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			ResultSet rs = pstmt.executeQuery();
			GmemberVO vo1 = new GmemberVO();
			if(rs.next()) {
				vo1.setMid(rs.getString("MID"));
				vo1.setMname(rs.getString("MNAME"));
				return vo1;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 사용자 로그인 실패");
		return null;
	}

	
	public boolean mInsert(GmemberVO vo) {		//회원가입
		conn = util.JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_mSignUp);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getMname());
			pstmt.setString(4, vo.getMphone());
			pstmt.setString(5, vo.getMpostcode());
			pstmt.setString(6, vo.getMaddress());
			pstmt.setString(7, vo.getMdetailaddress());
			pstmt.setString(8, vo.getMextraaddress());
			int num = pstmt.executeUpdate();
			
			System.out.println("로그: mInsert num값: "+num);
			
			if(num<=0) {
				System.out.println("로그 : 회원가입 실패");
				return false;
			}
		} catch (SQLException e) {
			System.out.println("로그 : 회원가입 실패");
			e.printStackTrace();
			return false;
		}finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		
		System.out.println("로그 : 회원가입 성공");
		return true;
	}
	
	public boolean mUpdate(GmemberVO vo) {		//회원 정보 변경
												//비밀번호랑 주소관련 값만 바꿀수 있음
		conn = util.JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_mUpdate);
			pstmt.setString(1, vo.getMpw());
			pstmt.setString(2, vo.getMpostcode());
			pstmt.setString(3, vo.getMaddress());
			pstmt.setString(4, vo.getMdetailaddress());
			pstmt.setString(5, vo.getMextraaddress());
			pstmt.setString(6, vo.getMid());
			int num = pstmt.executeUpdate();
			if(num<=0) {
				System.out.println("로그 : 회원정보 수정 실패");
				return false;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 회원정보 수정 성공");
		return true;
	}
	
	
	public boolean mDelete(GmemberVO vo) {		//회원탈퇴
		conn=util.JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_mDelete);
			pstmt.setString(1, vo.getMid());
			int num = pstmt.executeUpdate();
			if(num<=0) {
				System.out.println("로그 :회원탈퇴 실패");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("로그 :회원탈퇴 실패");
			return false;
		}finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 회원탈퇴 성공");
		return true;
	}
	
}
