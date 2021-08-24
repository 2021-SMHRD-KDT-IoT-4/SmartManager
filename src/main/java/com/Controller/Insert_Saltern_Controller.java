package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Auto_Running_DAO;
import com.Model.Auto_Running_DTO;
import com.Model.ControlDAO;
import com.Model.ControlDTO;
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
			
			ControlDAO controlDAO = new ControlDAO();
			ControlDTO zControlDTO = new ControlDTO(z_Detail_info_DTO.getNumbering(),0);
			ControlDTO kControlDTO = new ControlDTO(k_Detail_Info_DTO.getNumbering(),1);
			
			controlDAO.insert(zControlDTO);
			controlDAO.insert(kControlDTO);
			
			
			Auto_Running_DAO auto_Running_DAO = new Auto_Running_DAO();
			Auto_Running_DTO zAuto_Running_DTO = new Auto_Running_DTO(z_Detail_info_DTO.getNumbering());
			Auto_Running_DTO kAuto_Running_DTO = new Auto_Running_DTO(k_Detail_Info_DTO.getNumbering());
			auto_Running_DAO.Insert_Auto_Running(zAuto_Running_DTO);
			auto_Running_DAO.Insert_Auto_Running(kAuto_Running_DTO);
			
			
			
			rtn = 1;
			
		} catch (Exception e) {
			rtn = 0;
			
		}
		PrintWriter out = response.getWriter();
		out.print(rtn);
	}
}