package webVaalikone;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import Calculator.answerCalc;
import Data.Ehdokkaat;

/**
 * Servlet implementation class ShowResults
 */
@WebServlet("/ShowResults")
public class ShowResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	private answerCalc calc;


	@Override
	public void init() {
		dao = new Dao();
		dao.getConnection();
		calc = new answerCalc();
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowResults() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i = 0;

		ArrayList <Integer> answerList = new ArrayList <>();
		while(request.getParameter("vastaus"+i)!= null) {
			answerList.add(Integer.parseInt(request.getParameter("vastaus"+i)));
			i++;
		}

		ArrayList<Ehdokkaat> ehdokasList = calc.matchCandidates(answerList);
		request.setAttribute("topThree", ehdokasList);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/ShowResults.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
