package app;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
	    name = "ShowCandidates",
	    urlPatterns = {"/showcandidates"}
	)

public class ShowCandidates extends HttpServlet {

}
