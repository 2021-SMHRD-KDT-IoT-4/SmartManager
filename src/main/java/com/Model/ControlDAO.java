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
					psmt.setInt(2, dto.getFan());
					psmt.setInt(3, dto.getPump());
					psmt.setInt(4, dto.getWire());
					psmt.setInt(5, dto.getPusher());
					psmt.setInt(6, dto.getConveyer());
					psmt.setInt(7, dto.getLight());
					psmt.setInt(8, dto.getCamera());
					
					
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
					int fan = rs.getInt(2); 
					int pump = rs.getInt(3); 
					int wire = rs.getInt(4); 
					int pusher = rs.getInt(5);
					int conveyer = rs.getInt(6);
					int light = rs.getInt(7);
					int camera = rs.getInt(8);
					
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
