package services;

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

@Path("/electionservice")
public class electionService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone");
	@Context
	HttpServletRequest request;
	
	@Context
	HttpServletResponse response;
	
	
	@GET
	@Path("/readquestion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readKysymykset() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Kysymykset> list=em.createQuery("select xyx from Kysymykset xyx").getResultList();		
		em.getTransaction().commit();
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestions.jsp");
		request.setAttribute("questionlist", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	@POST
	@Path("/addquestion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public void addKysymykset(@FormParam("kysymys") String kysymys) {  
		Kysymykset k=new Kysymykset(kysymys);
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(k);//The actual insertion line
		em.getTransaction().commit();
		//Calling the method readKysymykset() of this service
		readKysymykset();		
	}	
	@POST
	@Path("/updatequestions")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public void updateKysymykset(@FormParam("kysymys") String kysymys, @FormParam("kysymys_id") int kysymys_id) {  
		Kysymykset k=new Kysymykset(kysymys);
		k.setKysymys_id(kysymys_id);
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(k);//The actual insertion line
		em.getTransaction().commit();
		//Calling the method readKysymykset() of this service
		readKysymykset();		
	}	
	@POST
	@Path("/editquestions")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateKysymykset(Kysymykset kysymykset) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Kysymykset k=em.find(Kysymykset.class, kysymykset.getKysymys_id());
		if (k!=null) {
			em.merge(kysymykset);//The actual update line
		}
		em.getTransaction().commit();
		//Calling the method readKysymykset() of this service
		readKysymykset();		
	}	

	@GET
    @Path("/delete/{kysymys_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAnswers(@PathParam("kysymys_id") int id) { 
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Kysymykset k=em.find(Kysymykset.class, id);
        if (k!=null) {
            em.remove(k);//The actual insertion line
        }
        em.getTransaction().commit();
        //Calling the method readAnswers() of this service
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
