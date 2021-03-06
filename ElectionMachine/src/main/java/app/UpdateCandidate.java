/*package app;

import javax.servlet.http.HttpServlet;

public class UpdateCandidate extends HttpServlet {

}*/

package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import app.model.Vaalikone;

	@WebServlet(
	    name = "UpdateCandidate",
	    urlPatterns = {"/updatecandidate"}
		)

public class UpdateCandidate extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
		
		// if sessions does not exist, create new one
		HttpSession session = request.getSession();
		
		Dao dao = new Dao();
		ArrayList<Vaalikone> vaalikones = dao.readAllVaalikone();
		
		session.setAttribute("allvaalikones", vaalikones);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/html/UpdateCandidate.jsp");
		rd.forward(request, response);
	
		}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
		doGet(request, response);
		}
		}
