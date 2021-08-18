package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Z_Detail_info_DAO;
import com.Model.Z_Detail_info_DTO;

public class Delete_Z_Detail_Info_Controller implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");

		int numbering = Integer.parseInt(request.getParameter("numbering"));
		int req = Integer.parseInt(request.getParameter("req"));

		Z_Detail_info_DTO dto = new Z_Detail_info_DTO(numbering);
		Z_Detail_info_DAO dao = new Z_Detail_info_DAO();
	    int rtn = dao.delete_Z_Detail_Info(dto);

		if (req == 0) {
			if (rtn > 0 ) {
				response.sendRedirect("");
			} else {
				response.sendRedirect("");
			}
		} else {
			PrintWriter out = response.getWriter();
			if (rtn > 0 ) {
				out.print("1");
			} else {
				out.print("0");
			}
		}


	}

}
