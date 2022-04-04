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
		
		String idValue = request.getParameter("ehdokas_id");
		

        if ( idValue != null ) {
            try {
                int ehdokas_id = Integer.parseInt(idValue);
                
                Dao dao = new Dao();
                Vaalikone vaalikone = dao.readVaalikone(ehdokas_id);
                
                session.setAttribute("Vaalikone", vaalikone);
                
                RequestDispatcher rd = request.getRequestDispatcher("jsp/html/removecandidate.jsp");
                rd.forward(request, response);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Back to list
            response.sendRedirect("/showAll");
            
        }
    
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
    
        
        // Create connection
        Dao dao=new Dao();
        Vaalikone vaalikone = readAllVaalikone(request);
        
        dao.removeVaalikone(vaalikone);
        
        dao.close();
        
        // Back to list after actions
        //RequestDispatcher rd = request.getRequestDispatcher("/showdata");
        //rd.forward(request, response);
        response.sendRedirect("/showAll");
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



