package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OutPut_DAO {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private OutPut_DTO dto = null;
	ArrayList<OutPut_DTO> dtos=null;
	private int rtn=0;
	
	public void conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String path = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			conn = DriverManager.getConnection(path, "jjin", "1234");

		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
			System.out.println(e.toString());
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println(e.toString());
		}
	}
	
	private void close() {
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
	
	public ArrayList<OutPut_DTO> Get_All_OutPut(OutPut_DTO dto) {
		 dtos= new ArrayList<OutPut_DTO>();
		try {
			conn();
			String sql = "SELECT * FROM OUTPUT WHERE =?";
			psmt.setInt(1, dto.getNumbering());
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				
				int numbering = rs.getInt("numbering");
				String date_search = rs.getString("date_search");
				int prod = rs.getInt("prod");

				dtos.add(new OutPut_DTO(numbering, date_search, prod));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dtos;
	}
	
	public int Insert_OutPut(OutPut_DTO dto) {

		try {
			conn();

			String sql = "insert into Members values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getNumbering());
			psmt.setString(2, dto.getDate_search());
			psmt.setInt(3, dto.getProd());
			rtn = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rtn;
	}
	
	
}
