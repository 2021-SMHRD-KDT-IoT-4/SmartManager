package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.ControlDAO;
import com.Model.ControlDTO;

public class Stop_Linear_Controller implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int numbering = Integer.parseInt(request.getParameter("numbering"));
		
		
		ControlDTO dto = new ControlDTO(numbering);
		ControlDAO dao = new ControlDAO();
		int rtn = dao.LinearStop(dto);
		
		PrintWriter out = response.getWriter();
		out.print(rtn);
	}

}
