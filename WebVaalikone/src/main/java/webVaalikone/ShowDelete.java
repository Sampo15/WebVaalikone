package webVaalikone;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.Ehdokas;
import dao.Dao;
/**
 * Servlet implementation class ShowDelete
 */
@WebServlet("/ShowDelete")
public class ShowDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Dao dao;
       
    @Override
	public void init() {
    	dao =new  Dao();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Ehdokas> list=null;
		if (dao.getConnection()) {
			list=dao.lueEhdokkaat();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("ehdokkaatlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/EhdokkaatPoisto.jsp");
		rd.forward(request, response);
		
		
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
