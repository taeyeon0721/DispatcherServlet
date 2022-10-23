package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.JDBCUtil;
import vo.EstateVO;


public class EstateDAO {
	Connection conn;
	PreparedStatement pstmt;

	final String sql_eInsert = "INSERT INTO ESTATE(ENAME, PRICE, CATEGORY, EADDRESS, EINFO, EPAY, SUBWAY ,RID, EIMGSRC) VALUES(?,?,?,?,?,?,?,?,?)";
	final String sql_eUpdate = "UPDATE ESTATE SET ENAME=?, PRICE=?, CATEGORY=?, EADDRESS=?, EINFO=?, EPAY=?, SUBWAY=?, EIMGSRC=? WHERE EPK=?";
	final String sql_eDelete = "DELETE FROM ESTATE WHERE EPK=?";
	final String sql_eSelectOne = "SELECT * FROM ESTATE WHERE EPK=?";

	final String sql_eSelectAll ="SELECT * FROM ESTATE WHERE EADDRESS LIKE CONCAT('%',?,'%') AND SUBWAY LIKE CONCAT('%',?,'%') ORDER BY EPK DESC LIMIT 0,?";
	final String sql_eSelectAll_R ="SELECT * FROM ESTATE WHERE RID=?";

	final String sql_eSelectAll_Size = "SELECT COUNT(*) AS CNT FROM ESTATE";
	final String sql_eSelectAll_Size_S = "SELECT COUNT(*) AS CNT FROM ESTATE WHERE EADDRESS LIKE CONCAT('%',?,'%') AND SUBWAY LIKE CONCAT('%',?,'%')";


	public boolean eInsert(EstateVO vo) { // 매물 추가
		conn = util.JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_eInsert);
			pstmt.setString(1, vo.getEname());
			pstmt.setString(2, vo.getPrice());
			pstmt.setString(3, vo.getCategory());
			pstmt.setString(4, vo.getEaddress());
			pstmt.setString(5, vo.getEinfo());
			pstmt.setString(6, vo.getEpay());
			pstmt.setString(7, vo.getSubway());
			pstmt.setString(8, vo.getRid());
			pstmt.setString(9, vo.getEimgsrc());
			int num = pstmt.executeUpdate();
			if (num <= 0) {
				System.out.println("로그 : 매물 저장 실패");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 매물 저장 성공");
		return true;
	}

	public boolean eUpdate(EstateVO vo) { // 매물 정보 변경
		conn = util.JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_eUpdate);
			pstmt.setString(1, vo.getEname());
			pstmt.setString(2, vo.getPrice());
			pstmt.setString(3, vo.getCategory());
			pstmt.setString(4, vo.getEaddress());
			pstmt.setString(5, vo.getEinfo());
			pstmt.setString(6, vo.getEpay());
			pstmt.setString(7, vo.getSubway());
			pstmt.setString(8, vo.getEimgsrc());
			pstmt.setInt(9, vo.getEpk());
			int num = pstmt.executeUpdate();
			if (num <= 0) {
				System.out.println("로그 : 매물정보 수정 실패");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 매물정보 수정 성공");
		return true;
	}

	public boolean eDelete(EstateVO vo) { // 매물 삭제
		conn = util.JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_eDelete);
			pstmt.setInt(1, vo.getEpk());
			int num = pstmt.executeUpdate();
			if (num <= 0) {
				System.out.println("로그 : 매물 삭제 실패");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 매물 삭제 성공");
		return true;
	}


	public EstateVO eSelectOne(EstateVO vo) { // 매물 상세 보기
		conn = util.JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_eSelectOne);
			pstmt.setInt(1, vo.getEpk());
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				EstateVO vo4 = new EstateVO();
				vo4.setEpk(rs.getInt("EPK"));
				vo4.setEname(rs.getString("ENAME"));
				vo4.setPrice(rs.getString("PRICE"));
				vo4.setCategory(rs.getString("CATEGORY"));
				vo4.setEaddress(rs.getString("EADDRESS"));
				vo4.setEinfo(rs.getString("EINFO"));
				vo4.setEpay(rs.getString("EPAY"));
				vo4.setSubway(rs.getString("SUBWAY"));
				vo4.setEimgsrc(rs.getString("EIMGSRC"));
				vo4.setRid(rs.getString("RID"));
				return vo4;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : 매물 상세 보기 실패");
		return null;
	}

	public ArrayList<EstateVO> eSelectAll(EstateVO vo) { 
		conn = util.JDBCUtil.connect();
		ArrayList<EstateVO> datas = new ArrayList<EstateVO>();
		try {

			if(vo.getRid() != null) {
				System.out.println("중개사가 자신의 매물을 보려함");
				pstmt = conn.prepareStatement(sql_eSelectAll_R);
				pstmt.setString(1, vo.getRid());
			}else {
				pstmt = conn.prepareStatement(sql_eSelectAll);
				pstmt.setString(1, vo.getEaddress());
				pstmt.setString(2, vo.getSubway());
				pstmt.setInt(3, vo.getCnt());
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EstateVO vo5 = new EstateVO();
				vo5.setEpk(rs.getInt("EPK"));
				vo5.setEname(rs.getString("ENAME"));
				vo5.setPrice(rs.getString("PRICE"));
				vo5.setCategory(rs.getString("CATEGORY"));
				vo5.setEaddress(rs.getString("EADDRESS"));
				vo5.setEinfo(rs.getString("EINFO"));
				vo5.setEpay(rs.getString("EPAY"));
				vo5.setSubway(rs.getString("SUBWAY"));
				vo5.setEimgsrc(rs.getString("EIMGSRC"));
				datas.add(vo5);
			}
			System.out.println("로그 : eSelectAll 성공");
			return datas;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			util.JDBCUtil.disconnect(pstmt, conn);
		}
		System.out.println("로그 : eSelectAll 실패");
		return null;
	}

	public int eSelectAll_Size(EstateVO vo) { 
		conn=JDBCUtil.connect();
		try {
			if(vo.getEaddress().equals("") && vo.getSubway().equals("")) {

				pstmt = conn.prepareStatement(sql_eSelectAll_Size);
			}
			else {

				pstmt = conn.prepareStatement(sql_eSelectAll_Size_S);
				pstmt.setString(1, vo.getEaddress());
				pstmt.setString(2, vo.getSubway());
			}

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int size = rs.getInt("CNT");
			return size;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
}
