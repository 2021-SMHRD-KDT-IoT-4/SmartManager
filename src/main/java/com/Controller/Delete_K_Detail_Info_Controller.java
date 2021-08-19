package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.K_Detail_Info_DAO;
import com.Model.K_Detail_Info_DTO;
import com.Model.Z_Detail_info_DAO;
import com.Model.Z_Detail_info_DTO;

public class Delete_K_Detail_Info_Controller implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		
		int numbering = Integer.parseInt(request.getParameter("numbering"));
		int req = 0;
		try {
			req = Integer.parseInt(request.getParameter("req"));
		} catch (Exception e) { 
			
			
		}

		K_Detail_Info_DTO dto = new K_Detail_Info_DTO(numbering);
		K_Detail_Info_DAO dao = new K_Detail_Info_DAO();
	    int rtn = dao.delete_K_Detail_Info(dto);

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
