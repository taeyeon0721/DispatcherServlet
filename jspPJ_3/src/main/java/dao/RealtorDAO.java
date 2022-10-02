package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.JDBCUtil;
import vo.RealtorVO;

public class RealtorDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	final String sql_rLogin="SELECT * FROM REALTOR WHERE RID = ? AND RPW = ?";
	final String sql_rInsert ="INSERT INTO REALTOR VALUES(?,?,?,?,?,?,?,?,0,?)";
	final String sql_rDelete = "DELETE FROM REALTOR WHERE RID=?";
	final String sql_rSelectOne="SELECT * FROM REALTOR WHERE RID =?";
	final String sql_rSelectAll="SELECT * FROM REALTOR";
	final String sql_rSelectAll_C="SELECT * FROM REALTOR ORDER BY RCONSULTNUM DESC LIMIT 0,3";
	final String sql_rConsultNum ="UPDATE REALTOR SET RCONSULTNUM = RCONSULTNUM+1 WHERE RID = ?";
	final String sql_rUpdate ="UPDATE REALTOR SET RPW=?, RPOSTCODE=?, RADDRESS=?, RDETAILADDRESS=?, REXTRAADDRESS=?,  RMENT=? WHERE RID = ?";
	
	public RealtorVO rLogin(RealtorVO vo) {	//중개사 로그인
		conn = util.JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_rLogin);
			pstmt.setString(1, vo.getRid());
			pstmt.setString(2, vo.getRpw());
			ResultSet rs = pstmt.executeQuery();
			RealtorVO vo1 = new RealtorVO();
			if(rs.next()) {
				vo1.setRid(rs.getString("RID"));
				vo1.setRname(rs.getString("RNAME"));
				return vo1;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 중개사 로그인 실패");
		return null;
	}
	
	public boolean rInsert(RealtorVO vo) {	//중개사 회원가입
		conn = util.JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_rInsert);
			pstmt.setString(1, vo.getRid());
			pstmt.setString(2, vo.getRpw());
			pstmt.setString(3, vo.getRname());
			pstmt.setString(4, vo.getRphone());
			pstmt.setString(5, vo.getRpostcode());
			pstmt.setString(6, vo.getRaddress());
			pstmt.setString(7, vo.getRdetailaddress());
			pstmt.setString(8, vo.getRextraaddress());
			pstmt.setString(9, vo.getRment());
			int num = pstmt.executeUpdate(); 
			if (num <= 0) {
				System.out.println("로그 : 중개사 등록 실패");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 중개사 등록 성공");
		return true;
	}
	
	public boolean rDelete(RealtorVO vo) {	//중개사 탈퇴
		conn=util.JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_rDelete);
			pstmt.setString(1, vo.getRid());
			int num = pstmt.executeUpdate();
			if(num<=0) {
				System.out.println("로그 : 중개사 탈퇴 실패");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 중개사 탈퇴 성공");
		return true;
	}
	
	public RealtorVO rSelectOne(RealtorVO vo) { //중개사 마이페이지
		conn = util.JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_rSelectOne);
			pstmt.setString(1, vo.getRid());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				RealtorVO vo1 = new RealtorVO();
				vo1.setRid(rs.getString("RID"));
				vo1.setRpw(rs.getString("RPW"));
				vo1.setRname(rs.getString("RNAME"));
				vo1.setRphone(rs.getString("RPHONE"));
				vo1.setRpostcode(rs.getString("RPOSTCODE"));
				vo1.setRaddress(rs.getString("RADDRESS"));
				vo1.setRdetailaddress(rs.getString("RDETAILADDRESS"));
				vo1.setRextraaddress(rs.getString("REXTRAADDRESS"));
				vo1.setRconsultnum(rs.getInt("RCONSULTNUM"));
				vo1.setRment(rs.getString("RMENT"));
				return vo1;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 중개사 selectOne 실패");
		return null;
	}
	
	public ArrayList<RealtorVO> rSelectAll(RealtorVO vo) {	//추천 중개사(모든 중개사 출력)
		conn=util.JDBCUtil.connect();
		ArrayList<RealtorVO> datas = new ArrayList<RealtorVO>();
		try {
			if(vo.getRid() != null) {
				pstmt=conn.prepareStatement(sql_rSelectAll_C);
			}else {
				pstmt=conn.prepareStatement(sql_rSelectAll);				
			}
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				RealtorVO vo2 = new RealtorVO();
				vo2.setRid(rs.getString("RID"));
				vo2.setRpw(rs.getString("RPW"));
				vo2.setRname(rs.getString("RNAME"));
				vo2.setRphone(rs.getString("RPHONE"));
				vo2.setRpostcode(rs.getString("RPOSTCODE"));
				vo2.setRaddress(rs.getString("RADDRESS"));
				vo2.setRdetailaddress(rs.getString("RDETAILADDRESS"));
				vo2.setRextraaddress(rs.getString("REXTRAADDRESS"));
				vo2.setRconsultnum(rs.getInt("RCONSULTNUM"));
				vo2.setRment(rs.getString("RMENT"));
				datas.add(vo2);
			}
//			System.out.println("로그 : 중개사 selectAll 성공");
			return datas;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
//		System.out.println("로그 : selectAll 추천 중개사 실패");
		return null;
	}
	
	public boolean rConsultNum(RealtorVO vo) {	//중개사 상담 건수를 +1 해줌
		conn = util.JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_rConsultNum);
			pstmt.setString(1, vo.getRid());
			int num = pstmt.executeUpdate();
			if(num<=0) {
				System.out.println("로그 : 상담건수+1(업데이트) 실패");
				return false;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 상담건수+1(업데이트) 성공");
		return true;
	}
	
	
	public boolean rUpdate(RealtorVO vo) {	//중개사 정보 변경
											//비밀번호랑 주소, 멘트만 변경가능
		conn = util.JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_rUpdate);
			pstmt.setString(1, vo.getRpw());
			pstmt.setString(2, vo.getRpostcode());
			pstmt.setString(3, vo.getRaddress());
			pstmt.setString(4, vo.getRdetailaddress());
			pstmt.setString(5, vo.getRextraaddress());
			pstmt.setString(6, vo.getRment());
			pstmt.setString(7, vo.getRid());
			int num = pstmt.executeUpdate();
			if(num<=0) {
//				System.out.println("로그 : 중개사 정보 변경 실패");
				return false;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
//		System.out.println("로그 : 중개사 정보 변경 성공");
		return true;
	}
}
