package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.Model.ControlDAO;
import com.Model.ControlDTO;

public class Get_All_Controll_Controller implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ControlDAO controlDAO = new ControlDAO();

		ArrayList<ControlDTO> dtos = controlDAO.getAllControlls();
		PrintWriter out = response.getWriter();
		if (dtos.size() > 0) {

			JSONObject rtn = new JSONObject();
			JSONArray req_array = new JSONArray();

			for (int i = 0; i < dtos.size(); i++) {
				JSONObject data = new JSONObject();
				data.put("numbering", dtos.get(i).getNumbering());
				data.put("fan", dtos.get(i).getNumbering());
				data.put("pump", dtos.get(i).getNumbering());
				data.put("wire", dtos.get(i).getNumbering());
				data.put("pusher", dtos.get(i).getNumbering());
				data.put("conveyer", dtos.get(i).getNumbering());
				data.put("light", dtos.get(i).getNumbering());
				data.put("camera", dtos.get(i).getNumbering());
				data.put("part", dtos.get(i).getNumbering());
				
				req_array.add(data);
			}

			rtn.put("data", req_array);

			out.print(rtn.toJSONString());
		} else {
			out.print("0");
		}

	}

}
