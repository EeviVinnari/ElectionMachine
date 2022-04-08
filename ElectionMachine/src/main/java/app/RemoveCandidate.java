package app;

import java.sql.SQLException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.model.Vaalikone;
import dao.Dao;


@WebServlet(
    name = "RemoveCandidate",
    urlPatterns = {"/removecandidate"}
	)

public class RemoveCandidate extends HttpServlet {
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException {
	
	// if sessions does not exist, create new one
		HttpSession session = request.getSession();

		String idValue = request.getParameter("id");

		if ( idValue != null ) {
			try {
				int ehdokas_id = Integer.parseInt(idValue);

				Dao dao = new Dao();
				Vaalikone vaalikone = dao.getVaalikoneInfo(ehdokas_id);

				session.setAttribute("vaalikone", vaalikone);

				RequestDispatcher rd = request.getRequestDispatcher("jsp/html/removecandidate.jsp");
				rd.forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}
				} else {
				// Back to list
				response.sendRedirect("/jsp/html/AdminPage.jsp");

				}
				
	// Create connection
	Dao dao=new Dao();
			
			try {
        
				dao.deleteCandidate(Integer.parseInt(request.getParameter("ehdokas_id")));
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	dao.close();

	// Back to list after actions
	RequestDispatcher rd = request.getRequestDispatcher("/jsp/html/AdminPage.jsp");
	rd.forward(request, response);
	response.sendRedirect("/jsp/html/AdminPage.jsp");
	}		
	}