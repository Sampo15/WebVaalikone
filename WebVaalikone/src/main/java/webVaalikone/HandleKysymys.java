//package webVaalikone;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.client.Invocation.Builder;
//import javax.ws.rs.core.GenericType;
//import javax.ws.rs.core.MediaType;
//
//import Data.Kysymykset;
//
//import rest.KysymysService;
//
//@WebServlet(urlPatterns = {"/addkysymys", "/deletekysymys", "updatekysymys", "readkysymys", "readtoupdatekysymys" })
//public class HandleKysymys extends HttpServlet {
//	
//
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		doGet(request, response);
//	}
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String action = request.getServletPath();
//		List<Kysymykset>list =null;
//		switch (action) {
//		  case "/addkysymys":
//			  list=addKysymys(request);break;
//		  case "/deletekysymys":
//			  String id=request.getParameter("kysymys_id");
//			  list=deleteKysymys(request);break;
//		  case "/updatekysyms":
//			  list=updateKysymys(request);break;
//		  case "/readkysymys":
//			  list=readKysymys(request);break;
//		  case "/readtoupdatekysymys":
//			  Kysymykset k=readtoUpdateKysymys(request);
//			  request.setAttribute("kysymys", k);
//			  RequestDispatcher rd=request.getRequestDispatcher("./jsp/EditKysymystoupdate.jsp");
//			  rd.forward(request, response);
//			  return;
//		
//	}
//		request.setAttribute("kysymysentlist", list);
//		  RequestDispatcher rd=request.getRequestDispatcher("./jsp/EditKysymykset.jsp");
//		  rd.forward(request, response);	
//
//}
//	private List<Kysymykset> readKysymys(HttpServletRequest request) {
//		String id=request.getParameter("kysymys_id");
//		String uri = "http://127.0.0.1:8080/rest/kysymysservice/readkysymys";
//		Client c=ClientBuilder.newClient();
//		WebTarget wt=c.target(uri);
//		Builder b=wt.request();
//		//Create a GenericType to be able to get List of objects
//		//This will be the second parameter of post method
//		GenericType<List<Kysymykset>> genericList = new GenericType<List<Kysymykset>>() {};
//		
//		List<Kysymykset> returnedList=b.get(genericList);
//		return returnedList;
//		
//		
//	}
//	private List<Kysymykset> addKysymys(HttpServletRequest request) {
//		//A Fish object to send to our web-service 
//		Kysymykset k=new Kysymykset(request.getParameter("kysymys"));
//		System.out.println(k);
//		String uri = "http://127.0.0.1:8080/rest/kysymysservice/addkysymys";
//		Client c=ClientBuilder.newClient();
//		WebTarget wt=c.target(uri);
//		Builder b=wt.request();
//		//Here we create an Entity of a Fish object as JSON string format
//		Entity<Kysymykset> e=Entity.entity(k,MediaType.APPLICATION_JSON);
//		//Create a GenericType to be able to get List of objects
//		//This will be the second parameter of post method
//		GenericType<List<Kysymykset>> genericList = new GenericType<List<Kysymykset>>() {};
//		
//		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
//		List<Kysymykset> returnedList=b.post(e, genericList);
//		return returnedList;
//	}
//	
//	private List<Kysymykset> updateKysymys(HttpServletRequest request) {
//		//A Fish object to send to our web-service 
//		Kysymykset k=new Kysymykset(request.getParameter("kysymys_id"),request.getParameter("kysymys"));
//		System.out.println(k);
//		String uri = "http://127.0.0.1:8080/rest/kysymysservice/updatekysymys";
//		Client c=ClientBuilder.newClient();
//		WebTarget wt=c.target(uri);
//		Builder b=wt.request();
//		//Here we create an Entity of a Fish object as JSON string format
//		Entity<Kysymykset> e=Entity.entity(k,MediaType.APPLICATION_JSON);
//		//Create a GenericType to be able to get List of objects
//		//This will be the second parameter of post method
//		GenericType<List<Kysymykset>> genericList = new GenericType<List<Kysymykset>>() {};
//		
//		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
//		List<Kysymykset> returnedList=b.put(e, genericList);
//		return returnedList;
//	}
//	
//	
//	private Kysymykset readtoUpdateKysymys(HttpServletRequest request) {
//		String id=request.getParameter("kysymys_id");
//		String uri = "http://127.0.0.1:8080/rest/kysymysservice/readtoupdatekysymys/"+id;
//		Client c=ClientBuilder.newClient();
//		WebTarget wt=c.target(uri);
//		Builder b=wt.request();
//		Kysymykset k=b.get(Kysymykset.class);
//		return k;
//	}
//	
//	private List<Kysymykset> deleteKysymys(HttpServletRequest request) {
//		String id=request.getParameter("kysymys_id");
//		String uri = "http://127.0.0.1:8080/rest/kysymysservice/deletekysymys/"+id;
//		Client c=ClientBuilder.newClient();
//		WebTarget wt=c.target(uri);
//		Builder b=wt.request();
//		//Create a GenericType to be able to get List of objects
//		//This will be the second parameter of post method
//		GenericType<List<Kysymykset>> genericList = new GenericType<List<Kysymykset>>() {};
//		
//		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
//		List<Kysymykset> returnedList=b.delete(genericList);
//		return returnedList;
//	}
//	
//}
