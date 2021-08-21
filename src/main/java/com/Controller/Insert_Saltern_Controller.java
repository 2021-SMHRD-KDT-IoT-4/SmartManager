package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.K_Detail_Info_DAO;
import com.Model.K_Detail_Info_DTO;
import com.Model.Saltern_DAO;
import com.Model.Saltern_DTO;
import com.Model.Z_Detail_info_DAO;
import com.Model.Z_Detail_info_DTO;

public class Insert_Saltern_Controller implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		int z_place_size = Integer.parseInt(request.getParameter("z_place_size"));
		int k_place_size = Integer.parseInt(request.getParameter("k_place_size"));
		int node = -1;

		int rtn = 0;
		
		Saltern_DAO saltern_DAO = new Saltern_DAO();
		Saltern_DTO z_Saltern = new Saltern_DTO(id, 0);
		Saltern_DTO k_Saltern = new Saltern_DTO(id, 1);
		
		try {
			saltern_DAO.Insert_Saltern(z_Saltern);
			z_Saltern = saltern_DAO.Get_Last_Saltern();
			
			
			saltern_DAO.Insert_Saltern(k_Saltern);
			k_Saltern = saltern_DAO.Get_Last_Saltern();
			
			
			Z_Detail_info_DTO z_Detail_info_DTO = new Z_Detail_info_DTO(z_Saltern.getNumbering(),z_place_size);
			
			Z_Detail_info_DAO z_Detail_info_DAO = new Z_Detail_info_DAO();
			z_Detail_info_DAO.insert_Z_Detail_Info(z_Detail_info_DTO);
			
			K_Detail_Info_DTO k_Detail_Info_DTO = new K_Detail_Info_DTO(k_Saltern.getNumbering(),k_place_size, z_Saltern.getNumbering());
			
			K_Detail_Info_DAO k_Detail_Info_DAO = new K_Detail_Info_DAO();
			k_Detail_Info_DAO.insert_K_Detail_Info(k_Detail_Info_DTO);
			rtn = 1;
			
		} catch (Exception e) {
			rtn = 0;
			
		}
		PrintWriter out = response.getWriter();
		out.print(rtn);
	}
}