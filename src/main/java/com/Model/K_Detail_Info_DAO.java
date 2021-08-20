package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class K_Detail_Info_DAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int rtn = 0;
	String name = null;
	K_Detail_Info_DTO dto = null;
	ArrayList<K_Detail_Info_DTO> k_list = null;
	K_Detail_Info_DTO info = null;

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

	public ArrayList<K_Detail_Info_DTO> All_K_Detail_info() {

		k_list = new ArrayList<K_Detail_Info_DTO>();
		conn();

		try {
			String sql = "select * from K_Detail_Info";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				int numbering = rs.getInt(1);
				int k_salinity = rs.getInt(2);
				int k_indoor_temp = rs.getInt(3);
				int k_indoor_humid = rs.getInt(4);
				int k_water_temp = rs.getInt(5);
				int k_wire_temp = rs.getInt(6);
				int k_water_high = rs.getInt(7);
				int k_daily_prod = rs.getInt(8);
				String k_harvest = rs.getString(9);
				int k_place_size = rs.getInt(10);
				int k_automode = rs.getInt(11);
				int node = rs.getInt(12);

				info = new K_Detail_Info_DTO(numbering, k_salinity, k_indoor_temp, k_water_temp, k_wire_temp, k_water_high, k_daily_prod, k_harvest, k_place_size, k_indoor_humid, k_automode, node);
				k_list.add(info);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return k_list;
	}

	public int delete_K_Detail_Info(K_Detail_Info_DTO dto) {

		conn();

		try {
			String sql = "delete from K_DETAIL_INFO where numbering = ?"; // where 조건 필요시 추가하기
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

	public int Update_Detail_Info(K_Detail_Info_DTO dto) {

		conn();

		String sql = "update K_DETAIL_INFO set numbering=?, k_salinity=?, k_indoor_temp=?, k_indoor_humid =?,"
				+ "k_water_temp =?,k_wire_temp =?,k_water_high =?,k_daily_prod =?,k_harvest =?,k_place_size =?,k_auto_mode =?,node = ? where numbering = ?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, dto.getNumbering());
			psmt.setInt(2, dto.getK_salinity());
			psmt.setInt(3, dto.getK_indoor_temp());
			psmt.setInt(4, dto.getK_indoor_humid());
			psmt.setInt(5, dto.getK_water_temp());
			psmt.setInt(6, dto.getK_wire_temp());
			psmt.setInt(7, dto.getK_water_high());
			psmt.setInt(8, dto.getK_daily_prod());
			psmt.setString(9, dto.getK_harvest());
			psmt.setInt(10, dto.getK_place_size());
			psmt.setInt(11, dto.getK_automode());
			psmt.setInt(12, dto.getNode());
			psmt.setInt(13, dto.getNumbering());

			rtn = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} finally {

			close();
		}
		return rtn;
	}

	public int insert_K_Detail_Info(K_Detail_Info_DTO dto) {

		conn();

		String sql = "insert into K_DETAIL_INFO values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, dto.getNumbering());
			psmt.setInt(2, dto.getK_salinity());
			psmt.setInt(3, dto.getK_indoor_temp());
			psmt.setInt(4, dto.getK_indoor_humid());
			psmt.setInt(5, dto.getK_water_temp());
			psmt.setInt(6, dto.getK_wire_temp());
			psmt.setInt(7, dto.getK_water_high());
			psmt.setInt(8, dto.getK_daily_prod());
			psmt.setString(9, dto.getK_harvest());
			psmt.setInt(10, dto.getK_place_size());
			psmt.setInt(11, dto.getK_automode());
			psmt.setInt(12, dto.getNode());

			rtn = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();

		}

		return rtn;

	}

}
