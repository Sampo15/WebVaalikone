package webVaalikone;


import java.io.IOException;
//import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Data.Ehdokkaat;
import dao.Dao;

/**
 * Servlet implementation class EhdokkaatPoisto
 */
@WebServlet("/EhdokkaatPoisto")
public class EhdokkaatPoisto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Dao dao;
	
	@Override
	public void init() {
		dao = new Dao();
	}
  
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String ehdokas_id=request.getParameter("id");
			Ehdokkaat ehdokas=null;
			if (dao.getConnection()) {
				ehdokas=dao.poistaEhdokas(ehdokas_id);
			} 
			RequestDispatcher rd=request.getRequestDispatcher("/ShowDelete");
			rd.forward(request, response);
		}

	
}


