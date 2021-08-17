package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.Auto_Running_DAO;
import com.Model.Auto_Running_DTO;


public class Update_Auto_RunningController implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		Auto_Running_DAO dao = new Auto_Running_DAO();
		Auto_Running_DTO dto = new Auto_Running_DTO(Integer.parseInt(request.getParameter("numbering")),
				Integer.parseInt(request.getParameter("fan_run")),
				Integer.parseInt(request.getParameter("pump_run")),
				Integer.parseInt(request.getParameter("wire_run")),
				Integer.parseInt(request.getParameter("light_run")));
		int rtn = dao.Update_Auto_Running(dto);
		
		HttpSession session = request.getSession();
		session.setAttribute("result", rtn);
		
		response.sendRedirect("domesticAnimals.jsp");
	}

}
