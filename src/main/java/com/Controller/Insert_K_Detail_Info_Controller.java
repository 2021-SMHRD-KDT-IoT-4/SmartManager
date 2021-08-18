package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.K_Detail_Info_DAO;
import com.Model.K_Detail_Info_DTO;

public class Insert_K_Detail_Info_Controller implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		
		int numbering = Integer.parseInt(request.getParameter("numbering"));
		int k_salinity = Integer.parseInt(request.getParameter("k_salinity"));
		int k_indoor_temp = Integer.parseInt(request.getParameter("k_indoor_temp"));
		int k_indoor_humid = Integer.parseInt(request.getParameter("k_indoor_humid"));
		int k_water_temp = Integer.parseInt(request.getParameter("k_water_temp"));
		int k_wire_temp = Integer.parseInt(request.getParameter("k_wire_temp"));
		int k_water_high = Integer.parseInt(request.getParameter("k_water_high"));
		int k_daily_prod = Integer.parseInt(request.getParameter("k_daily_prod"));
		String k_harvest = request.getParameter("k_harvest");
		int k_place_size = Integer.parseInt(request.getParameter("k_place_size"));
		int k_automode = Integer.parseInt(request.getParameter("k_automode"));
		
		int req = 0;
		try {
			req = Integer.parseInt(request.getParameter("req"));
		} catch (Exception e) {
			
		}

		
		K_Detail_Info_DTO dto = new K_Detail_Info_DTO(numbering, k_salinity, k_indoor_temp, k_indoor_humid, k_water_temp, k_wire_temp, k_water_high, k_daily_prod, k_harvest, k_place_size, k_automode);
		K_Detail_Info_DAO dao = new K_Detail_Info_DAO();
		
		int cnt = dao.insert_K_Detail_Info(dto);
		
		if (req == 0) {
			if (cnt > 0 ) {
				response.sendRedirect("");
			} else {
				response.sendRedirect("");
			}
		} else {
			PrintWriter out = response.getWriter();
			if (cnt > 0 ) {
				out.print("1");
			} else {
				out.print("0");
			}
		}
		
		

	}

}
