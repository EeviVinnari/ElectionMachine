package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

	@WebServlet(
		name = "logintesti",
		urlPatterns = {"/logintesti"}
		)

public class logintesti extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		if (SecurityUtils.isUserLogged(session)) {
			response.getWriter().println("Kirjautunut käyttäjä: "+ session.getAttribute("LoggedUser"));
		}else {
			response.getWriter().println("Käyttäjä ei ole kirjautunut");
		}
		response.getWriter().println("<br><a href=\"index.html\">back</a>");
		}
		}