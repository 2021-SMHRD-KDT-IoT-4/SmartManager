package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.Model.K_Detail_Info_DAO;
import com.Model.K_Detail_Info_DTO;

public class GetAll_K_Detail_Info_Controller implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("EUC-KR");
		
		
		
		int req = 0;
		try {
			req = Integer.parseInt(request.getParameter("req"));
		} catch (Exception e) {
			
		}

		K_Detail_Info_DAO dao = new K_Detail_Info_DAO();
		ArrayList<K_Detail_Info_DTO> resultDTO = dao.All_K_Detail_info();
		
		if (req == 0) {
			if (resultDTO.size() > 0 ) {
				response.sendRedirect("");
			} else {
				response.sendRedirect("");
			}
		} else {
			PrintWriter out = response.getWriter();
			if (resultDTO.size() > 0 ) {
				
				JSONObject rtn = new JSONObject();
				JSONArray req_array = new JSONArray();
				
				for(int i = 0; i < resultDTO.size(); i++) {
					JSONObject data = new JSONObject();
					data.put("numbering", resultDTO.get(i).getNumbering());
					data.put("k_salinity", resultDTO.get(i).getK_salinity());
					data.put("k_indoor_temp", resultDTO.get(i).getK_indoor_temp());
					data.put("k_water_temp", resultDTO.get(i).getK_water_temp());
					data.put("k_wire_temp", resultDTO.get(i).getK_wire_temp());
					data.put("k_water_high", resultDTO.get(i).getK_water_high());
					data.put("k_daily_prod", resultDTO.get(i).getK_daily_prod());
					data.put("k_harvest", resultDTO.get(i).getK_harvest());
					data.put("k_place_size", resultDTO.get(i).getK_place_size());
					data.put("k_indoor_humid", resultDTO.get(i).getK_indoor_humid());
					data.put("k_automode", resultDTO.get(i).getK_automode());
					data.put("node", resultDTO.get(i).getNode());
					
					req_array.add(data);
					
					
				}
				
				rtn.put("data", req_array);
				
				out.print(rtn.toJSONString());
				
				
			} else {
				out.print("0");
			}
		}

	}

}
