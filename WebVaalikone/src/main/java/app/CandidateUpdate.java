package app;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.Ehdokas;

@WebServlet("/candidateupdate")
public class CandidateUpdate extends HttpServlet {
	 @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException {
	    response.setContentType("text/plain;utf-8");
	    
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/UpdateEhdokas.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	}

