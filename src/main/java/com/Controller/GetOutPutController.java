package com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.OutPut_DAO;
import com.Model.OutPut_DTO;

public class GetOutPutController implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		OutPut_DAO dao = new OutPut_DAO();
		OutPut_DTO dto = new OutPut_DTO(Integer.parseInt(request.getParameter("numbering")));
		ArrayList<OutPut_DTO> dtos = dao.Get_All_OutPut(dto);

		/* Domestic_AnimalsDTO[] domestic_animalsDTO[] = dto.get(dto.length); */
		
		
		if (dtos.size() > 1) {
			HttpSession session = request.getSession();
			session.setAttribute("OutPut_Info", dto);
		}
		
		response.sendRedirect("Output.jsp");
	}

}
