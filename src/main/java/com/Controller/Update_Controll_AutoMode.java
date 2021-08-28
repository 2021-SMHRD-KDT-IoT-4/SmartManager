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

public class Update_Controll_AutoMode implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numbering = Integer.parseInt(request.getParameter("numbering"));
		Saltern_DTO salternDTO = new Saltern_DTO(numbering);
		Saltern_DAO salternDAO = new Saltern_DAO();
		salternDTO = salternDAO.Get_Saltern(salternDTO);

		int rtn;
		if (salternDTO.getPart() == 0) {
			Z_Detail_info_DTO z_DTO = new Z_Detail_info_DTO(numbering);
			Z_Detail_info_DAO z_DAO = new Z_Detail_info_DAO();
			z_DTO = z_DAO.Get_Z_Detail_info(z_DTO);
			int autoMode = z_DTO.getZ_automode() == 1 ? 0 : 1;
			z_DTO.setZ_automode(autoMode);
			System.out.println(autoMode + "??");
			rtn = z_DAO.Update_Z_Detail_Info(z_DTO);
		} else {
			K_Detail_Info_DTO k_DTO = new K_Detail_Info_DTO(numbering);
			K_Detail_Info_DAO k_DAO = new K_Detail_Info_DAO();
			k_DTO = k_DAO.Get_K_Detail_info(k_DTO);
			int autoMode = k_DTO.getK_automode() == 1 ? 0 : 1;
			k_DTO.setK_automode(autoMode);
			rtn = k_DAO.Update_Detail_Info(k_DTO);
		}
		PrintWriter out = response.getWriter();
		out.print(rtn + "");

	}

}
