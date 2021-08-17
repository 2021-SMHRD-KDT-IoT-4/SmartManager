package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.MembersDAO;
import com.Model.MembersDTO;

public class JoinController implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		MembersDAO dao = new MembersDAO();
		MembersDTO dto = new MembersDTO(id, pw);

		int cnt = dao.join(dto);

		if (cnt > 0) {
			System.out.println("회원가입 성공");
			response.sendRedirect("Login.jsp");

		} else {

			System.out.println("회원가입 실패");
			response.sendRedirect("Join.jsp");
		}

	}

}
