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

import Data.Ehdokas;
import Data.Kysymykset;
import Data.Vastaukset;
import key.CompositeKey;

@Path("/ehdokasservice")
public class EhdokasService {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone");
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;

	@POST
	@Path("/updateehdokas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateEhdokas(@FormParam("ehdokas_id") String id, @FormParam("vaalinro") String vaalinro, @FormParam("etunimi") String etunimi,
			@FormParam("sukunimi") String sukunimi, @FormParam("paikkakunta") String paikkakunta, @FormParam("puolue") String puolue, @FormParam("eduskunta") String eduskunta,
			@FormParam("edistaa") String edistaa, @FormParam("ehduser") String user, @FormParam("ehdpass") String pass) {
		

		Ehdokas ehd = new Ehdokas(id, sukunimi, etunimi, puolue, eduskunta, edistaa, paikkakunta, vaalinro, user, pass);
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		if (ehd != null) {
			em.merge(ehd);
		}
		em.getTransaction().commit();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/UpdateEhdokas.jsp");
		request.setAttribute("ehdokas", ehd);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@GET
	@Path("/readkysymys/{ehdokas_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void readKysymys(@PathParam("ehdokas_id") int ehdokas_id) {
		List<Kysymykset> list = readKysymykset();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/EhdokasKysymykset.jsp");
		request.setAttribute("kysymyslist", list);
		request.setAttribute("ehdokas_id", ehdokas_id);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@GET
	@Path("/savevastaus/{ehdokas_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void saveVastaus(@PathParam("ehdokas_id") int ehdokas_id) {
		List<Kysymykset> list = readKysymykset();
		EntityManager em = emf.createEntityManager();
		int y = 0;
		while (y < list.size()) {
			CompositeKey key = new CompositeKey(list.get(y).getKysymys_id(), ehdokas_id);
			em.getTransaction().begin();
			Vastaukset v = em.find(Vastaukset.class, key);
			if (v==null) {
				em.getTransaction().commit();
				break;
			}
			em.remove(v); 
			em.getTransaction().commit();
			y++;
		}
		
		for(int i = 0; i< list.size(); i++) {
			Vastaukset a = new Vastaukset(ehdokas_id, list.get(i).getKysymys_id(), Integer.parseInt(request.getParameter("vastaus"+list.get(i).getKysymys_id())));
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/candidateupdate");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List <Kysymykset> readKysymykset() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Kysymykset> list = em.createQuery("select a from Kysymykset a").getResultList();
		em.getTransaction().commit();
		return list;
	}
}
