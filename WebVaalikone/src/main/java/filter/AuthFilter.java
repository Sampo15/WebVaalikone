package filter;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.Dao;
import Data.Ehdokas;

import org.apache.commons.codec.binary.Base64;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter(dispatcherTypes = {
		DispatcherType.REQUEST, 
		DispatcherType.FORWARD, 
		DispatcherType.INCLUDE, 
		DispatcherType.ERROR
}
, urlPatterns = {"/candidateupdate"})//Which URI's come through this filter
public class AuthFilter implements Filter {
	/*
	 * Attribute valiUsers, where the credentials of the valid users are added.
	 * This is used in this example, but a better way were to use database
	 */
	Hashtable<String, String> validUsers = new Hashtable<>();

	public AuthFilter() {
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		doFilter((HttpServletRequest)request, (HttpServletResponse)response, chain);
	}
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * Getting the Authorization string from the request header.
		 * It looks like: Basic aGtqaGtqaGtqOg==
		 * Starting with Basic and the crypted part is crypted version of 
		 * pattern someuser:somepassword
		 */
		String auth = request.getHeader("Authorization");
		Ehdokas ehdokas = allowUser(auth);
		// Check if the user is allowed?
		if (ehdokas == null) {
			// The client (browser) is not allowed, so report the situation to the browser
			response.setHeader("WWW-Authenticate", "BASIC realm=\"Pena's secret app\"");
			response.sendError(response.SC_UNAUTHORIZED);
		} else if (ehdokas != null) {
			// The client is allowed to forward the request to the URI "/sercretservlet"
			request.setAttribute("ehdokas", ehdokas);
			chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

	protected Ehdokas allowUser(String auth) throws IOException {

		if (auth == null) {
			return null;  
		}
		//If the authentication method is not BASIC
		if (!auth.toUpperCase().startsWith("BASIC ")) { 
			return null;
		}
		String userpassEncoded = auth.substring(6);
		Base64 base64 = new Base64();
		String userpassDecoded = new String(base64.decode(userpassEncoded.getBytes()));
		Ehdokas user = null;
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Ehdokas> list=em.createQuery("select a from ehdokkaat a").getResultList();
		em.getTransaction().commit();
		for (int i=0; i < list.size(); i++) {
			validUsers.put(list.get(i).getEhduser()+":" + list.get(i).getEhdpass(),"authorized");
			if ("authorized".equals(validUsers.get(userpassDecoded))) {
				
				user = list.get(i);
				return user;

			}

		}
		return user;

	}
}