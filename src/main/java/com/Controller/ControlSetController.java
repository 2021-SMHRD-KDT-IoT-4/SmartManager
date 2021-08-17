package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.ControlDAO;
import com.Model.ControlDTO;

public class ControlSetController implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		
		String numbering = request.getParameter("numbering");
		String fan = request.getParameter("fan");
		String pump = request.getParameter("pump");
		String wire = request.getParameter("wire");
		String pusher = request.getParameter("pusher");
		String conveyer = request.getParameter("conveyer");
		String light = request.getParameter("light");
		String camera = request.getParameter("camera");
		
		ControlDTO cntdto = new ControlDTO(Integer.parseInt(numbering), fan, pump, wire, pusher, conveyer, light, camera);
		
		ControlDAO control = new ControlDAO();
		int rtn = control.update(cntdto);
		
		HttpSession session = request.getSession();
		session.setAttribute("control", rtn);
		
		response.sendRedirect("controlinfo.jsp");
		
		
		
		
		
		
	}

}
