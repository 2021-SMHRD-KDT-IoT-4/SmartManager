package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Detail_Info_DAO {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int rtn = 0;
	String name = null;
	Detail_Info_DTO dto=null;
	
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
	
		public Detail_Info_DTO Get_Detail_Info(Detail_Info_DTO dto) {
		
		conn();

		try {
			String sql = "select * from DETAIL_INFO where numbering = ?"; // where 조건 필요시 추가하기
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getNumbering());
			rs = psmt.executeQuery();
		
			if (rs.next()) {
				System.out.println(rs.getInt("numbering") + "sdfdsdfsdf");
				
				int numbering = rs.getInt("numbering");
				int salinity = rs.getInt("salinity");
				int indoor_temp = rs.getInt("indoor_temp");
				int indoor_humid = rs.getInt("indoor_humid");
				int water_temp = rs.getInt("water_temp");
				int wire_temp = rs.getInt("wire_temp");
				int water_high = rs.getInt("water_high");
				int daily_prod = rs.getInt("daily_prod");
				String harvest = rs.getString("harvest");
				int place_size = rs.getInt("place_size");
				String automode = rs.getString("automode");
				String supplyinfo = rs.getString("supplyinfo");
				
				this.dto = new Detail_Info_DTO(numbering, salinity, indoor_temp, indoor_humid, water_temp, wire_temp, water_high, daily_prod, harvest, place_size, automode, supplyinfo);
				System.out.println(dto.toString());
			}

		} catch (SQLException e) {

			System.out.println(e.toString());
		} finally {
			close();
		}
		
		return this.dto;
	}
		
		public int Update_Detail_Info(Detail_Info_DTO dto) {
			
			conn();

			String sql = "update detail_info set numbering=?, salinity=?, indoor_temp=?, water_temp =?,"
					+ "wire_temp =?,water_high =?,daily_prod =?,harvest =?,place_size =?,automode =? where numbering = ?";

			try {
				psmt = conn.prepareStatement(sql);

				psmt.setInt(1, dto.getNumbering());
				psmt.setInt(2, dto.getSalinity());
				psmt.setInt(3, dto.getIndoor_temp());
				psmt.setInt(4, dto.getWater_temp());
				psmt.setInt(5, dto.getWire_temp());
				psmt.setInt(6, dto.getWater_high());
				psmt.setInt(7, dto.getDaily_prod());
				psmt.setString(8, dto.getHarvest());
				psmt.setInt(9, dto.getPlace_size());
				psmt.setString(10, dto.getAutomode());
				psmt.setInt(11, dto.getNumbering());

				rtn = psmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.toString());
			} finally {

				close();
			}
			return rtn;
		}
	
	
	

}
