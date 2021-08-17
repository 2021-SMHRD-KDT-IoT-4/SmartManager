package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.K_Detail_Info_DAO;
import com.Model.K_Detail_Info_DTO;
import com.Model.Z_Detail_info_DAO;
import com.Model.Z_Detail_info_DTO;

public class GetAll_Z_Detail_Info_Controller implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");

		int numbering = Integer.parseInt(request.getParameter("numbering"));
		int req = Integer.parseInt("req");

		Z_Detail_info_DTO dto = new Z_Detail_info_DTO(numbering);
		Z_Detail_info_DAO dao = new Z_Detail_info_DAO();
		ArrayList<Z_Detail_info_DTO> resultDTO = dao.All_Z_Detail_info();

		if (req == 0) {
			if (resultDTO.size() > 0 ) {
				response.sendRedirect("");
			} else {
				response.sendRedirect("");
			}
		} else {
			PrintWriter out = response.getWriter();
			if (resultDTO.size() > 0 ) {
				out.print("1");
			} else {
				out.print("0");
			}
		}

	}

}
