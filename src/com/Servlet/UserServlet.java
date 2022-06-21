package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;

@WebServlet("/UserServlet")

public class UserServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String name=request.getParameter("fname");
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");
		
		UserDetails us=new UserDetails();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
		
		UserDAO dao=new UserDAO(DBConnect.getConn());
		boolean f=dao.addUser(us);
		HttpSession session;
		
		if(f)
		{
			session=request.getSession();
			session.setAttribute("req-sucess", "Registration SuccessFully...");
			response.sendRedirect("register.jsp");
		}
		else {
			session=request.getSession();
			session.setAttribute("Failed-msg", "Something went wrong on server...");
			response.sendRedirect("register.jsp");
		}
		
		
	}

}
