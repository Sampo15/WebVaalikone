package webVaalikone;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.Ehdokkaat;
import dao.Dao;

/**
 * Servlet implementation class AddVastaukset
 */
@WebServlet("/AddEhdokas")
public class AddEhdokas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	private Connection conn;

	@Override
	public void init() {
		dao = new Dao();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		dao.lisaaEhdokas(ed);
		
		
	}
	request.setAttribute("ehdokkaatlist", list);
	RequestDispatcher rd=request.getRequestDispatcher("/jsp/AddEhdokas.jsp");
	rd.forward(request, response);

}
	
}

