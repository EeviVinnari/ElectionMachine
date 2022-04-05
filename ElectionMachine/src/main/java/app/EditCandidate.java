/*package app;

import javax.servlet.http.HttpServlet;

public class EditCandidate extends HttpServlet {

}*/

package app;

import java.io.IOException;
import java.io.PrintWriter;
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
		name = "EditCandidate",
		urlPatterns = {"/editcandidate"}
		)
public class EditCandidate extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		
		// if sessions does not exist, create new one
		HttpSession session = request.getSession();
		
		String ehdokas_idValue = request.getParameter("ehdokas_id");
		
		if ( ehdokas_idValue != null ) {
			try {
				int ehdokas_id = Integer.parseInt(ehdokas_idValue);
				
				Dao dao = new Dao();
				Vaalikone vaalikone = dao.getVaalikoneInfo(ehdokas_id);
				
				session.setAttribute("vaalikone", vaalikone);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/html/editcandidate.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			} else {
			// Back to list
			response.sendRedirect("/updatecandidate");
			
		}
	
		}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
	
		
		// Create connection
		Dao dao=new Dao();
		Vaalikone vaalikone = readVaalikone(request);
		
		dao.updateVaalikone(vaalikone);
		
		dao.close();
		
		// Back to list after actions
		//RequestDispatcher rd = request.getRequestDispatcher("/updatecandidate");
		//rd.forward(request, response);
		response.sendRedirect("/showdata");
		}
	
	private Vaalikone readVaalikone(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Vaalikone vaalikone=new Vaalikone();
		vaalikone.setSukunimi(request.getParameter("sukunimi"));
		vaalikone.setEtunimi(request.getParameter("etunimi"));
		vaalikone.setEhdokas_Id(Integer.parseInt(request.getParameter("ehdokas_id")));
		vaalikone.setPuolue(request.getParameter("puolue"));
		vaalikone.setKotipaikkakunta(request.getParameter("kotipaikkakunta"));
		vaalikone.setIka(Integer.parseInt(request.getParameter("ika")));
		vaalikone.setMiksi_eduskuntaan(request.getParameter("miksi_eduskuntaan"));
		vaalikone.setMita_asioita_haluat_edistaa(request.getParameter("mita_asioita_haluat_edistaa"));
		vaalikone.setAmmatti(request.getParameter("ammatti"));
		return vaalikone;
		}
		}

