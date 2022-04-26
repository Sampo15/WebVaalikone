package webVaalikone;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import java.util.*;
import Data.Ehdokkaat;
/**
 * Servlet implementation class UpdateEhdokkaat
 */
@WebServlet("/UpdateEhdokkaat")
public class UpdateEhdokkaat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
       
  
	@Override
	public void init() {
		dao = new Dao();
	
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ehdokas_id = request.getParameter("ehdokas_id");
		String sukunimi=request.getParameter("sukunimi");
		String etunimi=request.getParameter("etunimi");
		String puolue=request.getParameter("puolue");
		String eduskunta=request.getParameter("eduskunta");
		String edistaa=request.getParameter("edistaa");
		String paikkakunta = request.getParameter("paikkakunta");
		String vaalinro = request.getParameter("vaalinro");
		Ehdokkaat ed = new Ehdokkaat(ehdokas_id, sukunimi, etunimi, puolue, eduskunta, edistaa, paikkakunta, vaalinro);
		
		ArrayList<Ehdokkaat> list=null;
		if(dao.getConnection()) {
			list = dao.Muokkaehdokas(ed);
		}
		request.setAttribute("ehdokkaatlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/EditEhdokkaat.jsp");
		rd.forward(request, response);
		
	}

}
