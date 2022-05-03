package webVaalikone;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Data.Ehdokas;
import dao.Dao;

/**
 * Servlet implementation class ViewEhdokas
 */
@WebServlet("/ViewEhdokas")
public class ViewEhdokas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Dao dao;
	
	@Override
	public void init() {
		dao = new Dao();
	}
  
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ehdokas_id=request.getParameter("id");
		Ehdokas ehdokas=null;
		if (dao.getConnection()) {
			ehdokas=dao.lueEhdokas(ehdokas_id);
		}
		request.setAttribute("ehdokas", ehdokas);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/ViewEhdokas.jsp");
		rd.forward(request, response);
		
		
	}


}
