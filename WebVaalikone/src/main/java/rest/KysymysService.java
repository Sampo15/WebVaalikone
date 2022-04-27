package rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Data.Kysymykset;

@Path("/kysymysservice")
public class KysymysService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone");

	@GET
	@Path("/readkysymys")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Kysymykset> readKysymys() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Kysymykset> list = em.createQuery("select a from Kysymykset a").getResultList();
		em.getTransaction().commit();
		return list;
	}

	@POST
	@Path("/addkysymys")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Kysymykset> addKysymys(Kysymykset kysymys) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(kysymys);
		em.getTransaction().commit();
		List<Kysymykset> list = readKysymys();
		return list;
	}

	@PUT
	@Path("/updatekysymys")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Kysymykset> updateKysymys(Kysymykset kysymys) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Kysymykset k = em.find(Kysymykset.class, kysymys.getKysymys_id());
		if (k != null) {
			em.merge(kysymys);
		}
		em.getTransaction().commit();
		List<Kysymykset> list = readKysymys();
		return list;
	}

	@GET
	@Path("/readtoupdatekysymys/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Kysymykset readtoUpdateKysymys(@PathParam("kysymys_id") int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Kysymykset k = em.find(Kysymykset.class, id);
		em.getTransaction().commit();
		return k;
	}

	@DELETE
	@Path("/deletekysymys/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Kysymykset deleteKysymys(@PathParam("kysymys_id") int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Kysymykset k = em.find(Kysymykset.class, id);
		if (k != null) {
			em.remove(k);

		}
		em.getTransaction().commit();
		List<Kysymykset> list = readKysymys();
		return k;
	}

}
