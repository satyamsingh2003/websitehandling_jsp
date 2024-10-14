package org.studyeasy.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.studyeasy.entity.User;
import org.studyeasy.model.UsersModel;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			String page=request.getParameter("page").toLowerCase();
			switch(page) { 
			case "home":
				request.setAttribute("title","Homepage");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			default:
				request.setAttribute("title","Error Page");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				break;
				
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
