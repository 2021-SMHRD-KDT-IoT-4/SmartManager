package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.K_Detail_Info_DAO;
import com.Model.K_Detail_Info_DTO;
import com.Model.MembersDAO;
import com.Model.MembersDTO;

public class LoginController implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		MembersDTO dto = new MembersDTO(id, pw);
		MembersDAO dao = new MembersDAO();
		MembersDTO info = dao.login(dto);
		int req = 0;
		try {
			req = Integer.parseInt(request.getParameter("req"));
		} catch (Exception e) {
			
		}
	
		
		if (req == 0) {

			if (info != null) {
				System.out.println("�α��� ����");

				HttpSession session = request.getSession();
				session.setAttribute("info", info);

				K_Detail_Info_DTO didto = new K_Detail_Info_DTO(info.getIdseq());
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("login.jsp");
			}
		} else {
			PrintWriter out = response.getWriter();
			if (info != null) {
				out.print("1");
			} else {
				out.print("0");
			}
		}

	}

}
