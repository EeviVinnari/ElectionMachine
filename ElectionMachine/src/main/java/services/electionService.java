package services; //package of this class

import java.io.IOException;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import app.model.Kysymykset;

@Path("/electionservice") //path to this service's Root Resource class 
public class electionService { //signature of the class
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone"); //create connection with database. persistence.xml file for settings
	@Context
	HttpServletRequest request;
	
	@Context
	HttpServletResponse response;
	
	
	@GET //the method accepts only GET-type requests
	@Path("/readquestion") //path to this method
	@Produces(MediaType.APPLICATION_JSON) //defines what media type method produces
	@Consumes(MediaType.APPLICATION_JSON) //defines what media type method accepts
	public void readKysymykset() {
		EntityManager em=emf.createEntityManager(); //creates EntityManager which manages entities given in persistence.xml
		em.getTransaction().begin(); //starts the transaction (every transaction must begin and end)
		List<Kysymykset> list=em.createQuery("select xyx from Kysymykset xyx").getResultList();	//reads all the data from a database table kysymykset and returns a list of objects. the 'xyx's could be anything but they need to be exactly the same	
		em.getTransaction().commit(); //closes the transaction
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestions.jsp"); //creates a requestDispatcher rd, and shows where it should be forwarded. requestDispatcher allows forwarding a request/response to a resource, for example JSP.
		request.setAttribute("questionlist", list); //adds attribute to request to take to showquestions.jsp
		try { //tries to forward the request with the attribute and catches an exception if it doesn't go through
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@POST //the method accepts only POST-type requests
	@Path("/addquestion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public void addKysymykset(@FormParam("kysymys") String kysymys) {  //we are using FormParam because we get the parameters from an HTML form
		Kysymykset k=new Kysymykset(kysymys); //creating a new Kysymykset object
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(k); //Inserting kysymykset object into database
		em.getTransaction().commit();
		//Calling the method readKysymykset() of this service
		readKysymykset(); //reads the method readKysymykset which shows the questions as a list, so in this case after adding the new question, it is shown in the question list
	}
	
	@POST
	@Path("/updatequestions")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public void updateKysymykset(@FormParam("kysymys") String kysymys, @FormParam("kysymys_id") int kysymys_id) {  
		Kysymykset k=new Kysymykset(kysymys);
		k.setKysymys_id(kysymys_id); //object kysymykset gets kysymys_id as parameter
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(k); //Updates kysymykset in database
		em.getTransaction().commit();
		//Calling the method readKysymykset() of this service
		readKysymykset();		
	}	

	@GET
    @Path("/delete/{kysymys_id}") //setting kysymys_id as a parameter into URL
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAnswers(@PathParam("kysymys_id") int id) { // when using PathParam we get the parameters from URL (kysymys_id)
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Kysymykset k=em.find(Kysymykset.class, id); //searches object id (kysymys_id) from database
        if (k!=null) { //if k (kysymykset) is not null, meaning that there is information, the chosen line is being deleted
            em.remove(k);//The actual insertion line
        }
        em.getTransaction().commit();
        //Calling the method readKysymykset() of this service
        readKysymykset();
    }
	
	@GET
	@Path("/readtoupdatequestion/{tadaa}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readToUpdateKysymykset(@PathParam("tadaa") int kysymys_id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Kysymykset k=em.find(Kysymykset.class, kysymys_id);
		em.getTransaction().commit();
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showupdatedquestions.jsp");
		request.setAttribute("updatedquestion", k);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}	
}