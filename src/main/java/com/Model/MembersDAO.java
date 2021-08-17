package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MembersDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	int rtn = 0;
	MembersDTO dto = null;
	ResultSet rs = null;
	ArrayList<MembersDTO> list = null;

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

	public int join(MembersDTO dto) {

		conn();

		String sql = "insert into members values(idSeq.nextval,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			
			System.out.println(dto.getId() + "   " + dto.getPw() );
			System.out.println(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());

			rtn = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rtn;

	}

	public MembersDTO login(MembersDTO dto) {
		
		conn();

		String sql = "select * from MEMBERS where member_id=? and member_pw=?";

		try {

			System.out.println("¿Ô´Ï2");
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());

			rs = psmt.executeQuery();

			if (rs.next()) {

				int idSeq = Integer.parseInt(rs.getString(1));
				String id = rs.getString(2);
				String pw = rs.getString(3);

				this.dto = new MembersDTO(id, pw,idSeq);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return this.dto;
	}
	
}
