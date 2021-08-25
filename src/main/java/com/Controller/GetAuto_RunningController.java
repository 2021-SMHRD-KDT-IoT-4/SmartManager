package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

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
		PrintWriter out = response.getWriter();
		
		if (resultdto != null) {
			
			JSONObject data = new JSONObject();
			data.put("numbering", resultdto.getNumbering());
			data.put("fan_run", resultdto.getFan_run());
			data.put("pump_run", resultdto.getPump_run());
			data.put("wire_run", resultdto.getWire_run());
			data.put("light_run", resultdto.getLight_run());
			data.put("stalinity_run", resultdto.getStalinity_run());
			data.put("waterhigh_run", resultdto.getWaterhigh_run());
			
			out.print(data.toJSONString());
		
		}else {
			out.print("0");
		}
		
		
	}

}
