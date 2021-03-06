package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Saltern_DAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int rtn = 0;

	public void conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "jjin";
			String db_pw = "1234";

			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Saltern_DTO Get_Saltern(Saltern_DTO dto) {

		conn();

		try {
			String sql = "select * from SALTERN where numbering = ?"; 
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getNumbering());
			rs = psmt.executeQuery();

			if (rs.next()) {
				
				int numbering = rs.getInt(1);
				String number_id = rs.getString(2);
				int part = rs.getInt(3);

				dto = new Saltern_DTO(numbering, number_id, part);
			}

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			close();
		}

		return dto;
	}
	
	public Saltern_DTO Get_Last_Saltern() {
		
		conn();
		Saltern_DTO dto = null;
		try {
			String sql = "SELECT * FROM(SELECT * FROM SALTERN ORDER BY NUMBERING DESC) WHERE ROWNUM = 1"; // where 조건 필요시 추가하기
			
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				int numbering = rs.getInt(1);
				String number_id = rs.getString(2);
				int part = rs.getInt(3);
				
				dto = new Saltern_DTO(numbering, number_id, part);
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.toString());
		} finally {
			close();
		}
		
		return dto;
	}

	public int Insert_Saltern(Saltern_DTO dto) {

		conn();
		String sql = "insert into SALTERN values(NUMBERSEQ.nextval, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getMember_id());
			psmt.setInt(2, dto.getPart());

			rtn = psmt.executeUpdate();

		} catch (SQLException e) {

			System.out.println(e.toString());
		} finally {
			close();
		}

		return rtn;
	}
	
	
}
