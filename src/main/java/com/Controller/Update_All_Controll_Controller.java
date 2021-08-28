package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.ControlDAO;
import com.Model.ControlDTO;
import com.Model.K_Detail_Info_DAO;
import com.Model.K_Detail_Info_DTO;
import com.Model.Saltern_DAO;
import com.Model.Saltern_DTO;
import com.Model.Z_Detail_info_DAO;
import com.Model.Z_Detail_info_DTO;

public class Update_All_Controll_Controller implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");

		int req = 0;
		try {
			req = Integer.parseInt(request.getParameter("req"));
		} catch (Exception e) {

		}

		System.out.println(Integer.parseInt(request.getParameter("numbering") + ""));
		ControlDAO dao = new ControlDAO();
		ControlDTO dto = new ControlDTO(Integer.parseInt(request.getParameter("numbering")),
				Integer.parseInt(request.getParameter("fan")), Integer.parseInt(request.getParameter("pump")),
				Integer.parseInt(request.getParameter("wire")), Integer.parseInt(request.getParameter("pusher")),
				Integer.parseInt(request.getParameter("conveyer")), Integer.parseInt(request.getParameter("light")),
				Integer.parseInt(request.getParameter("camera")));

		int rtn = dao.update(dto);
		
		Saltern_DTO salternDTO = new Saltern_DTO(dto.getNumbering());
		
		Saltern_DAO salternDAO = new Saltern_DAO();
		salternDTO = salternDAO.Get_Saltern(salternDTO);
		
		if(salternDTO.getPart() == 0) {
			Z_Detail_info_DTO z_DTO = new Z_Detail_info_DTO(dto.getNumbering());
			Z_Detail_info_DAO z_DAO = new Z_Detail_info_DAO();
			z_DTO = z_DAO.Get_Z_Detail_info(z_DTO);
			z_DTO.setZ_automode(1);
			z_DAO.Update_Z_Detail_Info(z_DTO);
		}else {
			K_Detail_Info_DTO k_DTO = new K_Detail_Info_DTO(dto.getNumbering());
			K_Detail_Info_DAO k_DAO = new K_Detail_Info_DAO();
			k_DTO = k_DAO.Get_K_Detail_info(k_DTO);
			k_DTO.setK_automode(1);
			k_DAO.Update_Detail_Info(k_DTO);
		}
		
		PrintWriter out = response.getWriter();
		if (req == 0) {

		} else {
			out.print("1");
		}
	}

}
