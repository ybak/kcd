package com.controller.icbc.util;
import java.io.IOException; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import cn.jpush.*;
/** * Servlet implementation class tuisong */ 
public class tuisong extends HttpServlet { 
	private static final long serialVersionUID = 1L; 
	private static final String appKey ="7e21faf06524b22f0ee1414c"; 
	private static final String masterSecret = "c87361ae4d7d91067b3ea01a";
	public tuisong() { 
		super(); 
	// TODO Auto-generated constructor stub 
		} 
	/** * @see HttpServlet#doGet(HttpServletRequest request,
	 *  HttpServletResponse response) 
	 *  
	 */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		//Jdpush.testSendPush(appKey,masterSecret); 
		System.out.println("sucess");
		} 
	/** * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		} 
	
	}
	
