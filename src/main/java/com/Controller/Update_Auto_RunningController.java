package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.Auto_Running_DAO;
import com.Model.Auto_Running_DTO;
import com.Model.K_Detail_Info_DTO;


public class Update_Auto_RunningController implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		int req = 0;
		try {
			req = Integer.parseInt(request.getParameter("req"));
		} catch (Exception e) {
			
		}
		
		Auto_Running_DAO dao = new Auto_Running_DAO();
		Auto_Running_DTO dto = new Auto_Running_DTO(Integer.parseInt(request.getParameter("numbering")),
				Integer.parseInt(request.getParameter("fan_run")),
				Integer.parseInt(request.getParameter("pump_run")),
				Integer.parseInt(request.getParameter("wire_run")),
				0,
				Integer.parseInt(request.getParameter("stalinity_run")),
				0);
		int rtn = dao.Update_Auto_Running(dto);
		
		HttpSession session = request.getSession();
		session.setAttribute("result", rtn);
		
		PrintWriter out = response.getWriter();
		if (req == 0) {

			
		} else {
			
				out.print("1");
			
		}
		
	}

}
