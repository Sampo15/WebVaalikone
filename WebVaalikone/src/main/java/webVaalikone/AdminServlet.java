package webVaalikone;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.Admin;
import dao.Dao;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private Dao dao;
	private static final long serialVersionUID = 1L;
  
	 @Override
	public void init() {
	    	dao = new Dao();
	    	dao.getConnection();
	    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String username = request.getParameter("username");
			String passwrd = request.getParameter("password");
			
			Admin admin = dao.AdminLogin(username, passwrd);
			
			
			
			if(admin!=null) {
				response.sendRedirect("/jsp/AdminPage.jsp");
				
			}else {
				response.getWriter().print("V��r�t tunnukset");
			}
			
			
	}

}
