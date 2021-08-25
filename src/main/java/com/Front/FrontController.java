package com.Front;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Controller.Command;
import com.Controller.ControlSetController;
import com.Controller.Delete_K_Detail_Info_Controller;
import com.Controller.Delete_Z_Detail_Info_Controller;
import com.Controller.GetAll_K_Detail_Info_Controller;
import com.Controller.GetAll_Z_Detail_Info_Controller;
import com.Controller.GetAuto_RunningController;
import com.Controller.GetOutPutController;
import com.Controller.Get_All_Controll_Controller;
import com.Controller.Insert_Saltern_Controller;
import com.Controller.JoinController;
import com.Controller.LoginController;
import com.Controller.LogoutController;
import com.Controller.SetOutPutController;
import com.Controller.Update_Auto_RunningController;
import com.Controller.Update_K_Detail_Info_Controller;
import com.Controller.Update_Z_Detail_Info_Controller;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String request_URI = request.getRequestURI();
		String context_Path = request.getContextPath();
		String result_URI = request_URI.substring(context_Path.length() + 1);

		Command _interface = null;
		
		if (result_URI.equals("login.do")) {
			_interface = new LoginController();
		}else if (result_URI.equals("Join.do")) {
			_interface = new JoinController();
		}else if(result_URI.equals("Logout.do")) {
			_interface = new LogoutController();
		}else if(result_URI.equals("GetAllControl.do")) {
			_interface = new Get_All_Controll_Controller();
		}else if(result_URI.equals("SetControl.do")) {
			_interface = new ControlSetController();
		}else if(result_URI.equals("Delete_K_Detail_Info.do")) {
			_interface = new Delete_K_Detail_Info_Controller();
		}else if(result_URI.equals("Delete_Z_Detail_Info.do")) {
			_interface = new Delete_Z_Detail_Info_Controller();
		}else if(result_URI.equals("GetAll_K_Detail_Info.do")) {
			_interface = new GetAll_K_Detail_Info_Controller();
		}else if(result_URI.equals("GetAll_Z_Detail_Info.do")) {
			_interface = new GetAll_Z_Detail_Info_Controller();
		}else if(result_URI.equals("GetAuto_Running.do")) {
			_interface = new GetAuto_RunningController();
		}else if(result_URI.equals("GetOutPut.do")) {
			_interface = new GetOutPutController();
		}else if(result_URI.equals("InsertSaltern.do")) {
			_interface = new Insert_Saltern_Controller();
		}else if(result_URI.equals("SetOutPut.do")) {
			_interface = new SetOutPutController();
		}else if(result_URI.equals("Update_Auto_Running.do")) {
			_interface = new Update_Auto_RunningController();
		}else if(result_URI.equals("Update_K_Detail_Info.do")) {
			_interface = new Update_K_Detail_Info_Controller();
		}else if(result_URI.equals("Update_Z_Detail_Info.do")) {
			_interface = new Update_Z_Detail_Info_Controller();
		}
		
		_interface.command(request, response);
	
	}

}
