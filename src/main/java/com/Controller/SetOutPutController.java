package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.OutPut_DAO;
import com.Model.OutPut_DTO;

public class SetOutPutController implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		OutPut_DAO dao = new OutPut_DAO();
		OutPut_DTO dto = new OutPut_DTO(Integer.parseInt(request.getParameter("numbering")),
				request.getParameter("date_search") ,
				Integer.parseInt(request.getParameter("prod")));

		int rtn = dao.Insert_OutPut(dto);
		HttpSession session = request.getSession();
		session.setAttribute("result", rtn);
		
		response.sendRedirect("domesticAnimals.jsp");
		
	}

}
