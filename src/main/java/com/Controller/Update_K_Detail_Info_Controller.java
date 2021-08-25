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
import com.Model.K_Detail_Info_DAO;
import com.Model.K_Detail_Info_DTO;
import com.Model.Z_Detail_info_DAO;
import com.Model.Z_Detail_info_DTO;

public class Update_K_Detail_Info_Controller implements Command {

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
		int node = Integer.parseInt(request.getParameter("node"));

		int req = 0;
		try {
			req = Integer.parseInt(request.getParameter("req"));
		} catch (Exception e) {

		}

		K_Detail_Info_DTO dto = new K_Detail_Info_DTO(numbering, k_salinity, k_indoor_temp, k_water_temp,
				k_wire_temp, k_water_high, k_daily_prod, k_harvest, k_place_size, k_indoor_humid, k_automode, node);
		K_Detail_Info_DAO dao = new K_Detail_Info_DAO();

		int cnt = dao.Update_Detail_Info(dto);

		Auto_Running_DTO autodto = new Auto_Running_DTO(dto.getNumbering());
		Auto_Running_DAO autodao = new Auto_Running_DAO();
		autodto = autodao.Get_Auto_Running(autodto);

		Z_Detail_info_DAO zdao = new Z_Detail_info_DAO();
		Z_Detail_info_DTO zdto = new Z_Detail_info_DTO(numbering);
		zdto = zdao.Get_Z_Detail_info(zdto);

		ControlDTO cdto = new ControlDTO(numbering);
		ControlDAO cdao = new ControlDAO();
		cdto = cdao.select(cdto);

		int fan_run = 0, wire_run = 0;

		if (dto.getK_indoor_humid() > autodto.getFan_run()) {
			fan_run = 1;
		}

		if (dto.getK_water_temp() <= autodto.getWire_run()) {
			wire_run = 1;
		}

		if (dto.getK_water_high() == 0 && zdto.getZ_water_high() <= autodto.getWaterhigh_run() // 물 공급시 증발지 염도
				&& cdto.getPump() == 0) {
			cdto.setPump(1);
		}

		if (cdto.getPump() == 1 && zdto.getZ_water_high() == 0) {
			cdto.setPump(0);
		}

		cdto.setFan(fan_run);
		cdto.setWire(wire_run);

		cdao.update(cdto);

		// this.dto = new
		// Auto_Running_DTO(numbering,fan_run,pump_run,wire_run,light_run);

		PrintWriter out = response.getWriter();
		if (cnt > 0) {
			out.print("1");
		} else {
			out.print("0");
		}

	}

}
