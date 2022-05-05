package rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;


import Data.Ehdokas;

@Path("/ehdokasservice")
public class EhdokasService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone");
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;
	
	@POST
	@Path("/lisaakuva/{ehdokas_id}")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public String uploadFile( @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition fileMetaData, @Context ServletContext sc) 
            		throws Exception
	{
		EntityManager em = emf.createEntityManager();
	    int i = 0;
		em.getTransaction().begin();
	    List<Ehdokas> list = em.createQuery("select a from ehdokkaat a").getResultList();
	    em.getTransaction().commit();
	    int ehdokas_id = list.get(i).getEhdokas_id();
	    
	    String fileName = ehdokas_id + ".png";

	    String UPLOAD_PATH = (System.getProperty("user.dir")) + "\\img\\";

	    try{
	        int read = 0;
	        byte[] bytes = new byte[1024];
	 
	        //OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + "/"+fileMetaData.getFileName()));
	        OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + fileName));
		    
	        while ((read = fileInputStream.read(bytes)) != -1) 
	        {
	            out.write(bytes, 0, read);
	        }
	        out.flush();
	        out.close();
	        
	    } 
	    catch (IOException e){
	        throw new WebApplicationException("Virhe ladattaessa tiedostoa.");
	    }
		RequestDispatcher rd=request.getRequestDispatcher("/index.html");
		rd.forward(request, response);
	    return null;
	}
}