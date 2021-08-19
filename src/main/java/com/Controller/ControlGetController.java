package com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.ControlDAO;
import com.Model.ControlDTO;

public class ControlGetController implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		String numbering = request.getParameter("numbering");
		
		ControlDTO condto = new ControlDTO(Integer.parseInt(numbering));
		
		
		ControlDAO control = new ControlDAO();
		ControlDTO data = control.select(condto);  
		
		HttpSession session = request.getSession();
		session.setAttribute("control", data);
		
		response.sendRedirect("controlinfo.jsp");
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		

	}

}
