package com.Controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Z_Detail_info_DAO;
import com.Model.Z_Detail_info_DTO;

public class GetAll_Z_Detail_Info_Controller implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");


		int req = Integer.parseInt(request.getParameter("req"));

		Z_Detail_info_DAO dao = new Z_Detail_info_DAO();
		ArrayList<Z_Detail_info_DTO> resultDTO = dao.All_Z_Detail_info();

		if (req == 0) {
			if (resultDTO.size() > 0) {
				response.sendRedirect("");
			} else {
				response.sendRedirect("");
			}
		} else {
			PrintWriter out = response.getWriter();
			if (resultDTO.size() > 0) {

				JSONObject rtn = new JSONObject();
				JSONArray req_array = new JSONArray();
				
				for (int i = 0; i < resultDTO.size(); i++) {
					JSONObject data = new JSONObject();
					data.put("numbering", resultDTO.get(i).getNumbering());
					data.put("salinity", resultDTO.get(i).getNumbering());
					data.put("indoor_temp", resultDTO.get(i).getNumbering());
					data.put("indoor_humid", resultDTO.get(i).getNumbering());
					data.put("water_temp", resultDTO.get(i).getNumbering());
					data.put("wire_temp", resultDTO.get(i).getNumbering());
					data.put("water_high", resultDTO.get(i).getNumbering());
					data.put("place_size", resultDTO.get(i).getNumbering());
					data.put("pump_move", resultDTO.get(i).getNumbering());
					req_array.add(data);
				}
				
				
				
				rtn.put("data", req_array);
			
				out.print(rtn.toJSONString());
			} else {
				out.print("False");
			}
		}

	}

}
