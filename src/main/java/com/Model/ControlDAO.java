package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControlDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	int rtn = 0 ;
	ControlDTO dto = null;
	ResultSet rs = null;
	ArrayList<ControlDTO> list = null;
	
	
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
				if(rs != null) {
					rs.close();
				}
				if(psmt != null) {
				psmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	public int update(ControlDTO dto) {
		conn();
		
				String sql = "update CONTROL set fan=?, pump=?, wire=?, pusher=?, conveyer=?, light=?, camera=? where numbering=?";
				
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setInt(1, dto.getNumbering());
					psmt.setString(2, dto.getFan());
					psmt.setString(3, dto.getPump());
					psmt.setString(4, dto.getWire());
					psmt.setString(5, dto.getPusher());
					psmt.setString(6, dto.getConveyer());
					psmt.setString(7, dto.getLight());
					psmt.setString(8, dto.getCamera());
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close();
				}
		
				return rtn;
	}
	
	public ControlDTO select(ControlDTO dto) {
		
		
		conn();
		
			String sql = "select * from CONTROL WHERE numbering= ?";
			
			try {
				psmt = conn.prepareStatement(sql);
				
				psmt.setInt(1,dto.getNumbering());
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					int numbering  = rs.getInt(1);
					String fan = rs.getString(2); 
					String pump = rs.getString(3); 
					String wire = rs.getString(4); 
					String pusher = rs.getString(5);
					String conveyer = rs.getString(6);
					String light = rs.getString(7);
					String camera = rs.getString(8);
					
					this.dto =  new ControlDTO(numbering, fan, pump, wire, pusher, conveyer,light,camera);									
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			return this.dto;
	}
	
	
	
}
