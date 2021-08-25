package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.ControlDAO;
import com.Model.ControlDTO;

public class Update_All_Controll_Controller implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		int req = 0;
		try {
			req = Integer.parseInt(request.getParameter("req"));
		} catch (Exception e) {
			
		}
		
		ControlDAO dao = new ControlDAO();
		ControlDTO dto = new ControlDTO(Integer.parseInt(request.getParameter("numbering")),
										Integer.parseInt(request.getParameter("fan")),
										Integer.parseInt(request.getParameter("pump")),
										Integer.parseInt(request.getParameter("wire")),
										Integer.parseInt(request.getParameter("pusher")),
										Integer.parseInt(request.getParameter("conveyer")),
										Integer.parseInt(request.getParameter("light")),
										Integer.parseInt(request.getParameter("camera")),
										Integer.parseInt(request.getParameter("part")));
		
		int rtn = dao.update(dto);
		
		HttpSession session = request.getSession();
		session.setAttribute("result", rtn);
		
		PrintWriter out = response.getWriter();
		if (req == 0) {

			
		} else {
			
				out.print("1");
			
		}
	}
		
		

	}

