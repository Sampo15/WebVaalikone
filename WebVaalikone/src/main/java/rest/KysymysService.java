package rest;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import Data.Kysymykset;

@Path("/kysymysservice")
public class KysymysService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone");
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;

	@GET
	@Path("/readkysymys")
	@Produces(MediaType.APPLICATION_JSON)
	public void readKysymys() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Kysymykset> list = em.createQuery("select a from Kysymykset a").getResultList();
		em.getTransaction().commit();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/EditKysymykset.jsp");
		request.setAttribute("kysymysentlist", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@POST
	@Path("/addkysymys")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void addKysymys(@FormParam("kysymys") String kysymys) {

		Kysymykset k = new Kysymykset(kysymys);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(k);
		em.getTransaction().commit();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/AddKysymys.jsp");
		request.setAttribute("kysymysentlist", k);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@POST
	@Path("/updatekysymys")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateKysymys(@FormParam("kysymys_id") int kysymys_id, @FormParam("kysymys") String kysymys) {

		Kysymykset k = new Kysymykset(kysymys_id, kysymys);
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		if (k != null) {
			em.merge(k);
		}
		em.getTransaction().commit();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/EditKysymykset.jsp");
		request.setAttribute("kysymysentlist", k);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@GET
	@Path("/readtoupdatekysymys/{kysymys_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void readtoUpdateKysymys(@PathParam("kysymys_id") int kysymys_id) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Kysymykset k = em.find(Kysymykset.class, kysymys_id);
		em.getTransaction().commit();
		request.setAttribute("kysymys", k);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/EditKysymystoupdate.jsp");

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@DELETE
	@Path("/deletekysymys/{kysymys_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public void deleteKysymys(@PathParam("kysymys_id") int kysymys_id) {

		EntityManager em = emf.createEntityManager();
		Kysymykset k = em.find(Kysymykset.class, kysymys_id);
		if (k != null) {
			em.remove(k);
		}
		em.getTransaction().commit();
		request.setAttribute("kysymysentlit", k);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/EditKysymykset.jsp");

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
