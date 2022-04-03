/*package app;

import javax.servlet.http.HttpServlet;

public class AddCandidate extends HttpServlet {

}*/

package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import app.model.Vaalikone;

/*
 * The name of the servlet is AddCandidate
 * and the servlet's URI (url-pattern) is 'addcandidate'
 */
@WebServlet(
		name = "AddCandidate",
		urlPatterns = {"/addcandidate"}
		)
public class AddCandidate extends HttpServlet {
	/*
	 * If the request type is POST, the request is transferred to the method doGet
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		doGet(request, response);
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		/*
		 * With a RequestDispatcher object is the htmlstart.html file included to this servlet
		 
		RequestDispatcher rd=request.getRequestDispatcher("staticpages/htmlstart.html");
		rd.include(request,  response);;*/
		
		// Read parameters to Model
		Vaalikone vaalikone=readVaalikone(request);
	
		// Create connection
		Dao dao=new Dao();
		
		// Save value and query total list
		dao.saveVaalikone(vaalikone);
		ArrayList<Vaalikone> list=dao.readAllVaalikone();
		
		// print output and close connection
		printVaalikoneList1(out, list);
		dao.close();
		

		out.println("<br><a href='./jsp/html/AdminPage.jsp'>Back to admin page</a>");

		/*
		 * With a RequestDispatcher object is the htmlend.html file included to this servlet
		 
		rd=request.getRequestDispatcher("staticpages/htmlend.html");
		rd.include(request,  response);;*/
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
	
	private void printVaalikoneList1(PrintWriter out, ArrayList<Vaalikone> list) {
		out.println("<ul>");
		for (Vaalikone g:list) {
			out.println("<li>"+g);
		}
		out.println("</ul>");
	}

}
