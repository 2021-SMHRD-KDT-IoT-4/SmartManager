package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Auto_Running_DAO;
import com.Model.Auto_Running_DTO;
import com.Model.ControlDAO;
import com.Model.ControlDTO;
import com.Model.Z_Detail_info_DAO;
import com.Model.Z_Detail_info_DTO;

public class Update_Z_Detail_Info_Controller implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int numbering = Integer.parseInt(request.getParameter("numbering"));
		int z_salinity = Integer.parseInt(request.getParameter("z_salinity"));
		int z_indoor_temp = Integer.parseInt(request.getParameter("z_indoor_temp"));
		int z_indoor_humid = Integer.parseInt(request.getParameter("z_indoor_humid"));
		int z_water_temp = Integer.parseInt(request.getParameter("z_water_temp"));
		int z_wire_temp = Integer.parseInt(request.getParameter("z_wire_temp"));
		int z_water_high = Integer.parseInt(request.getParameter("z_water_high"));
		int z_place_size = Integer.parseInt(request.getParameter("z_place_size"));
		int z_pump_move = Integer.parseInt(request.getParameter("z_pump_move"));

		int req = 0;
		try {
			req = Integer.parseInt(request.getParameter("req"));
		} catch (Exception e) {

		}

		Z_Detail_info_DTO dto = new Z_Detail_info_DTO(numbering, z_salinity, z_indoor_temp, z_indoor_humid,
				z_water_temp, z_wire_temp, z_water_high, z_place_size, z_pump_move);
		Z_Detail_info_DAO dao = new Z_Detail_info_DAO();

		int cnt = dao.Update_Z_Detail_Info(dto);
		
		Auto_Running_DTO autodto = new Auto_Running_DTO(numbering);
		Auto_Running_DAO autodao = new Auto_Running_DAO();
		autodto = autodao.Get_Auto_Running(autodto);
		
		ControlDTO cdto = new ControlDTO(numbering);
		ControlDAO cdao = new ControlDAO();
		cdto = cdao.select(cdto);
		
		int fan_run = 0, wire_run=0;
		
		if(dto.getZ_water_temp() <= autodto.getWire_run()) {
			wire_run = 1;
		}
		
		if(dto.getZ_indoor_humid() >= autodto.getFan_run()) {
			fan_run = 1;
		}
		
		if(dto.getZ_water_high() == 0 && cdto.getPump() == 0) {
			cdto.setPump(1); 
		}
		if(cdto.getPump() == 1 && dto.getZ_water_high() >= autodto.getPump_run()) {   // 물 공급시 펌프 정지 물 높이 
			cdto.setPump(0);
		}

		
		cdto.setFan(fan_run);
		cdto.setWire(wire_run);

		cdao.update(cdto);
		
		PrintWriter out = response.getWriter();
		if (cnt > 0) {
			out.print("1");
		} else {
			out.print("0");
		}

	}

}
