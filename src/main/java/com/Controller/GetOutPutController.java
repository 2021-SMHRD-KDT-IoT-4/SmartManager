package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.Model.OutPut_DAO;
import com.Model.OutPut_DTO;

public class GetOutPutController implements Command {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		OutPut_DAO dao = new OutPut_DAO();
		ArrayList<OutPut_DTO> dtos = dao.Get_All_OutPut();

		PrintWriter out = response.getWriter();
		if (dtos.size() > 0 ) {
			
			JSONObject rtn = new JSONObject();
			JSONArray req_array = new JSONArray();		
			for(int i = 0; i < dtos.size(); i++) {
				JSONObject data = new JSONObject();
				data.put("date_search", dtos.get(i).getDate_search());
				data.put("prod", dtos.get(i).getProd());
				req_array.add(data);
			}
			
			rtn.put("data", req_array);
			
			out.print(rtn.toJSONString());
			
			
		} else {
			out.print("0");
		}
		
	}

}
