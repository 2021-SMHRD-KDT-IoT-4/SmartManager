package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.K_Detail_Info_DAO;
import com.Model.K_Detail_Info_DTO;

public class DetailGetController implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		
		int numbering = Integer.parseInt(request.getParameter("numbering")) ;
		
		
		K_Detail_Info_DTO dto = new K_Detail_Info_DTO(numbering);
		K_Detail_Info_DAO dao = new K_Detail_Info_DAO();
		K_Detail_Info_DTO resultDTO = dao.Get_Detail_Info(dto);
		
		if (resultDTO!= null) {
			response.sendRedirect("");
		}else {
			response.sendRedirect("");
		}
		
		
		
		

	}

}
