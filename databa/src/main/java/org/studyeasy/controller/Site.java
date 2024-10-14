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
 * Servlet implementation class Site
 */
@WebServlet("/site")
public class Site extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page").toLowerCase();
		switch(page) { 

		case "listusers":
				listusers(request, response);
				break;
		case "adduser":
			adduser(request, response);
			break;
		case "updateuser":
			updateuser(request, response);
			break;
		case "deleteuser":
			deleteuser(request, response);
			break;
			
		default:
			request.setAttribute("title","Error Page");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
	}}

	private void deleteuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("deleteuser.jsp").forward(request, response);
	}

	private void updateuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("updateusers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String form= request.getParameter("form").toLowerCase();
		switch(form) {
		case "adduseroperation":
			User user = new User(request.getParameter("username"),request.getParameter("email"));
			new UsersModel().addUser(user);
			listusers(request, response);
			break;
		case "updateuseroperation":
			User update_user = new User(Integer.parseInt(request.getParameter("users_id")),request.getParameter("username"),request.getParameter("email"));
			new UsersModel().updateUser(update_user);
			listusers(request, response);
			break;
		case "deleteuseroperation":
			new UsersModel().deleteUser(Integer.parseInt(request.getParameter("users_id")));
			listusers(request, response);
			break;
		default:
			request.setAttribute("title","Error Page");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		}
	}
	
	protected void listusers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List <User> users=new ArrayList<>();
		users= new UsersModel().listuser();
		request.setAttribute("listusers",users);
		request.setAttribute("title","List users");
		request.getRequestDispatcher("listusers.jsp").forward(request, response);
	}
	
	protected void adduser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		request.setAttribute("title","Add users");
		request.getRequestDispatcher("adduser.jsp").forward(request, response);
		
	}

}
