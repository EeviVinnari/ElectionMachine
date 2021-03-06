package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

@WebServlet(
	    name = "AddUserServlet",
	    urlPatterns = {"/add"}
	    )

public class AddUserServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		response.sendRedirect("loginform.html");
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		
		Dao dao = new Dao();
		
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		
		String salt = SecurityUtils.getSalt();
		String hashpw = SecurityUtils.getPasswordHashed(password, salt);
		
		dao.addUser(uname, hashpw, salt);
		
		dao.close();
		response.sendRedirect("loginform.html");
		
		}
		}
