package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Z_Detail_info_DAO {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int rtn = 0;
	Z_Detail_info_DTO dto = null;
	ArrayList<Z_Detail_info_DTO> z_list = null;
	Z_Detail_info_DTO info = null;
	
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
	
	public ArrayList<Z_Detail_info_DTO> All_Z_Detail_info() {

		z_list = new ArrayList<Z_Detail_info_DTO>();
		conn();

		try {
			String sql = "select * from z_detail_info";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				int numbering = rs.getInt(1);
				int z_salinity = rs.getInt(2);
				int z_indoor_temp = rs.getInt(3);
				int z_indoor_humid = rs.getInt(4);
				int z_water_temp = rs.getInt(5);
				int z_wire_temp = rs.getInt(6);
				int z_water_high = rs.getInt(7);
				int z_place_size = rs.getInt(8);
				int z_pump_move = rs.getInt(9);
				
				info = new Z_Detail_info_DTO(numbering, z_salinity, z_indoor_temp, z_indoor_humid, z_water_temp, z_wire_temp, z_water_high, z_place_size, z_pump_move);
				z_list.add(info);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return z_list;
	}
	
	public int delete_Z_Detail_Info(Z_Detail_info_DTO dto) {
		
		conn();

		try {
			String sql = "delete from Z_DETAIL_INFO where numbering = ?"; // where 조건 필요시 추가하기
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getNumbering());
			rtn = psmt.executeUpdate();
			
		} catch (SQLException e) {

			System.out.println(e.toString());
		} finally {
			close();
		}
		
		return rtn;
	}
	
	public int Update_Z_Detail_Info(Z_Detail_info_DTO dto) {
		
		conn();

		String sql = "update Z_DETAIL_INFO set numbering=?, z_salinity=?, z_indoor_temp=?, z_indoor_humid =?,"
				+ "z_water_temp =?,z_wire_temp =?,z_water_high =?,z_place_size =?,z_pump_move =? WHERE numbering = ?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, dto.getNumbering());
			psmt.setInt(2, dto.getZ_salinity());
			psmt.setInt(3, dto.getZ_indoor_temp());
			psmt.setInt(4, dto.getZ_indoor_humid());
			psmt.setInt(5, dto.getZ_water_temp());
			psmt.setInt(6, dto.getZ_wire_temp());
			psmt.setInt(7, dto.getZ_water_high());
			psmt.setInt(9, dto.getZ_place_size());
			psmt.setInt(11, dto.getZ_pump_move());
			psmt.setInt(12, dto.getNumbering());

			rtn = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} finally {

			close();
		}
		return rtn;
	}
	
	public int insert_Z_Detail_Info(Z_Detail_info_DTO dto) {
		
		conn();
		
		String sql = "insert into Z_DETAIL_INFO values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, dto.getNumbering());
			psmt.setInt(2, dto.getZ_salinity());
			psmt.setInt(3, dto.getZ_indoor_temp());
			psmt.setInt(4, dto.getZ_indoor_humid());
			psmt.setInt(5, dto.getZ_water_temp());
			psmt.setInt(6, dto.getZ_wire_temp());
			psmt.setInt(6, dto.getZ_water_high());
			psmt.setInt(6, dto.getZ_place_size());
			psmt.setInt(6, dto.getZ_pump_move());

			rtn = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
			
		}
		
		return rtn;
		
		
	}
	
	
	
	

}
