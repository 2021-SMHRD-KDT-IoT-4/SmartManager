package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Auto_Running_DAO {

	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private Auto_Running_DTO dto = null;
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
	
	public Auto_Running_DTO Get_Auto_Running(Auto_Running_DTO dto) {

		try {
			conn();
			String sql = "SELECT * FROM AUTO_RUNNING WHERE = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getNumbering());
			rs = psmt.executeQuery();

			if (rs.next()) {
				
				int numbering = rs.getInt("numbering");
				int fan_run = rs.getInt("fan_run");
				int pump_run = rs.getInt("pump_run");
				int wire_run = rs.getInt("wire_run");
				int light_run = rs.getInt("light_run");
			

				this.dto = new Auto_Running_DTO(numbering,fan_run,pump_run,wire_run,light_run);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	public int Update_Auto_Running(Auto_Running_DTO dto) {

		rtn = 0;

		try {
			conn();

			String sql = "UPDATE AUTO_RUNNING SET numbering = ?, fan_run = ?, pump_run = ?, "
					+ "wire_run = ?, light_run = ? WHERE = ? ";

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, dto.getNumbering());
			psmt.setInt(2, dto.getFan_run());
			psmt.setInt(3, dto.getPump_run());
			psmt.setInt(4, dto.getWire_run());
			psmt.setInt(5, dto.getLight_run());
			psmt.setInt(6, dto.getNumbering());

			rtn = psmt.executeUpdate();

		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println(e.toString());
		} finally {
			close();
		}
		return rtn;
	}
}