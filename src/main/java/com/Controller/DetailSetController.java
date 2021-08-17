package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Detail_Info_DAO;
import com.Model.Detail_Info_DTO;

public class DetailSetController implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");

		int numbering = Integer.parseInt(request.getParameter("numbering"));
		int salinity = Integer.parseInt(request.getParameter("salinity"));
		int indoor_temp = Integer.parseInt(request.getParameter("indoor_temp"));
		int indoor_humid = Integer.parseInt(request.getParameter("indoor_humid"));
		int water_temp = Integer.parseInt(request.getParameter("water_temp"));
		int wire_temp = Integer.parseInt(request.getParameter("wire_temp"));
		int water_high = Integer.parseInt(request.getParameter("water_high"));
		int daily_prod = Integer.parseInt(request.getParameter("daily_prod"));
		String harvest = request.getParameter("harvest");
		int place_size = Integer.parseInt(request.getParameter("place_size"));
		String automode = request.getParameter("automode");
		String supplyinfo = request.getParameter("supplyinfo");

		Detail_Info_DTO dto = new Detail_Info_DTO(numbering, salinity, indoor_temp, indoor_humid, water_temp, wire_temp, water_high, daily_prod, harvest, place_size, automode, supplyinfo);
		Detail_Info_DAO dao = new Detail_Info_DAO();

		int cnt = dao.Update_Detail_Info(dto);
		
		PrintWriter out = response.getWriter();
		if (cnt > 0) {
			out.print("1");
		} else {
			out.print("0");
		}
		
	}

}
