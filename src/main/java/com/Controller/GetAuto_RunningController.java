package com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.Auto_Running_DAO;
import com.Model.Auto_Running_DTO;



public class GetAuto_RunningController implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		Auto_Running_DAO dao = new Auto_Running_DAO();
		Auto_Running_DTO dto = new Auto_Running_DTO(Integer.parseInt(request.getParameter("numbering")));
		Auto_Running_DTO resultdto = dao.Get_Auto_Running(dto);

		/* Domestic_AnimalsDTO[] domestic_animalsDTO[] = dto.get(dto.length); */

		if (resultdto != null) {
			HttpSession session = request.getSession();
			session.setAttribute("Auto_Running", dto);
		}
		
		response.sendRedirect("jsp");
	}

}
