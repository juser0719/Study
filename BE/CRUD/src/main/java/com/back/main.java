package com.back;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("action=["+action+"]");
		
		switch(action) {
		case "reigster":
			register(request, response);
			break;
		case "cancel":
			cancel(request, response);
			break;
		}
	}

	private void cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("productName");
		System.out.println(id);
		request.setAttribute("pid",id);
		RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
		rd.forward(request, response);
		
	}

}
