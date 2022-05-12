package rest;

import java.io.IOException;
import java.util.List;
import java.util.Random;

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

import Data.Ehdokas;
import Data.Kysymykset;
import Data.Vastaukset;
import key.CompositeKey;
/*
 * Path annotation for the rest service
 */
/**
 * @Date 12/05/2022
 * @author Sampo Lappalainen
 * @version 1
 *
 */
@Path("/kysymysservice")

public class KysymysService {
	/*
	 * Creation of EntityMangerFactory and Context annotation for Http request and response
	 */
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone");
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;

	
	/**
	 * Reads all the questions from the Kysymykset table in the database using @GET, creates a list from them and sends the list with request to the jsp.
	 */
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

	
	
	/**
	 * @param kysymys
	 *  Adds a question to the database from the Form Parameter input using @POST and persist to the Kysymykset database table and generates a random answer for all of the candidates to the Vastaukset database table and sends the added question with request to jsp.
	 */
	@POST
    @Path("/addkysymys")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addKysymys(@FormParam("kysymys") String kysymys) {

        Random rn = new Random();
        Kysymykset k = new Kysymykset(kysymys);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Ehdokas> list = em.createQuery("select a from ehdokkaat a").getResultList();
        em.getTransaction().commit();

        em.getTransaction().begin();

        em.persist(k);

        em.getTransaction().commit();

        em.getTransaction().begin();
        List<Kysymykset> list2 = em.createQuery("select a from Kysymykset a").getResultList();
        em.getTransaction().commit();

        for (int i = 0; i < list.size(); i++) {
            int ehdokas_id = list.get(i).getEhdokas_id();
            int vastaus = rn.nextInt(5) + 1;
            int kysymys_id = list2.get(list2.size() - 1).getKysymys_id();
            String kommentti = "ehdokkaan " + ehdokas_id + " vastaus kysymykseen " + kysymys_id;
            Vastaukset v = new Vastaukset(ehdokas_id, kysymys_id, vastaus, kommentti);

            em.getTransaction().begin();

            em.persist(v);

            em.getTransaction().commit();
        }
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/AdminPage.jsp");

        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
	
	

	/**
	 * @param kysymys_id
	 * @param kysymys
	 * Updates a question from the database table Kysymykset using Form parameter input with @POST and merge and sends a list with the updated question using the readKysymys method.
	 */
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
		readKysymys();
	}

	
	/**
	 * @param kysymys_id
	 * Reads a question from the Kysymykset database table by its question_id with @GET and request to jsp.
	 */
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

	
	
	/**
	 * @param kysymys_id
	 * Deletes a question by its question_id from the database table Kysymykset and Vastaukset with @GET and remove. Sends the updated list using the readKysymys method. 
	 */
	@GET
	@Path("/deletekysymys/{kysymys_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteKysymys(@PathParam("kysymys_id") int kysymys_id) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
        List<Ehdokas> eList = em.createQuery("select a from ehdokkaat a").getResultList();
        em.getTransaction().commit();
		
		for (int i = 0; i < eList.size(); i++) {
			em.getTransaction().begin();
			CompositeKey key = new CompositeKey(kysymys_id,eList.get(i).getEhdokas_id());
			Vastaukset v = em.find(Vastaukset.class, key);
			if (v != null) {
				em.remove(v);
			}
			em.getTransaction().commit();
		}
		em.getTransaction().begin();
		Kysymykset k = em.find(Kysymykset.class, kysymys_id);
		
		if (k != null) {
			em.remove(k);
		}
		em.getTransaction().commit();
		readKysymys();
	}

}
