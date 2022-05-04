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
//	@POST
//	@Path("/addquestion")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public List<Kysymykset> addFish(Kysymykset kysymykset) {
//		EntityManager em=emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(kysymykset);//The actual insertion line
//		em.getTransaction().commit();
//		//Calling the method readFish() of this service
//		List<Kysymykset> list=readKysymykset();		
//		return list;
//	}	
//	@PUT
//	@Path("/editquestion")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public List<Kysymykset> updateKysymykset(Kysymykset kysymykset) {
//		EntityManager em=emf.createEntityManager();
//		em.getTransaction().begin();
//		Kysymykset k=em.find(Kysymykset.class, kysymykset.getKysymys_id());
//		if (k!=null) {
//			em.merge(kysymykset);//The actual update line
//		}
//		em.getTransaction().commit();
//		//Calling the method readFish() of this service
//		List<Kysymykset> list=readKysymykset();		
//		return list;
//	}	
//	@DELETE
//	@Path("/deletequestion/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public List<Kysymykset> deleteFish(@PathParam("kysymys_id") int kysymys_id) {
//		EntityManager em=emf.createEntityManager();
//		em.getTransaction().begin();
//		Kysymykset k=em.find(Kysymykset.class, kysymys_id);
//		if (k!=null) {
//			em.remove(k);//The actual insertion line
//		}
//		em.getTransaction().commit();
//		//Calling the method readFish() of this service
//		List<Kysymykset> list=readKysymykset();		
//		return list;
//	}	
	@GET
	@Path("/readtoupdatequestion/{kysymys_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readToUpdateKysymykset(@PathParam("kysymys_id") int kysymys_id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Kysymykset k=em.find(Kysymykset.class, kysymys_id);
		em.getTransaction().commit();
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showupdatedquestions.jsp");
		request.setAttribute("updatedquestionlist", k);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}	
}
