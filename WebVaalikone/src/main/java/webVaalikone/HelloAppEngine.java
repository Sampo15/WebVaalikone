package webVaalikone;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello1"}
)
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {


	  
	  
	  
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");

    PrintWriter out = response.getWriter();
	  String cssTag="<link rel='stylesheet' type='text/css' href='main.css'>";
	    
	    out.println("<html>");
	    out.println("<head><title>Title Name</title>"+cssTag+"</head>");
	    out.println("<body>");
	           /*

	           Your  code 
	           */
	    out.println("</body></html>");

    
    try
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "sampo", "moppi123");
    	if (con != null) {
    		System.out.println("Connected");
    	}
    	
    	
    	PreparedStatement ps = con.prepareStatement("select * from kysymykset");
    	ResultSet rs = ps.executeQuery();
    	out.print("<form action=\"/vote\" method=\"POST\">");
    	out.print("<table class=\"table_center\" width=50% border=1>");
    	
    	
    	
    	
    	while(rs.next()){
    		
    		out.print("<tr><td>");
    		out.print(rs.getInt(1));
    		out.print("</td>");
    		out.print("<td>");
    		out.print(rs.getString(2)  + "<div class=\"form_middle\">\n" + 
    				
    				"\n" + 
    				"\n" + 
    				"\n" + 
    				"\n" + 
    				" <div  class=\"vastauscont\">\n" + 
    				"<input type=\"radio\" name=\"vastaus\" id=\"inlineRadio1\" value=\"T�ysineri\" >\n" + 
    				"<label  class=\"form-check-label\" for=\"inlineRadio1\">T�ysin eri mielt�</label>\n" + 
    				"\n" + 
    				"</div>\n" + 
    				"\n" + 
    				"<div class=\"vastauscont\">\n" + 
    				"<input  type=\"radio\" name=\"vastaus\" id=\"inlineRadio2\" value=\"V�h�neri\">\n" + 
    				"<label class=\"form-check-label\" for=\"inlineRadio1\">Jokseenkin eri mielt�</label>\n" + 
    				"\n" + 
    				"</div>\n" + 
    				"\n" + 
    				"<div class=\"vastauscont\">\n" + 
    				"\n" + 
    				"<input type=\"radio\" name=\"vastaus\" id=\"inlineRadio3\" value=\"Jokseenkinsama\">\n" + 
    				"<label class=\"form-check-label\" for=\"inlineRadio1\">Jokseenkin samaa mielt�</label>\n" + 
    				"</div>\n" + 
    				"\n" + 
    				"<div class=\"vastauscont\">\n" + 
    				"\n" + 
    				"<input type=\"radio\" name=\"vastaus\" id=\"inlineRadio4\" value=\"T�ysinsama\">\n" + 
    				"<label class=\"form-check-label\" for=\"inlineRadio1\">T�ysin samaa mielt�</label>\n" + 
    				"</div >\n" + 
    				"\n" + 
    				"\n" + 
    				"\n" + 
    				"\n" + 
    				 
    				"</div>");
    		out.print("</td>");
    		out.print("</tr>");
    		
    	}out.print("</table>");
    	out.print("<input class=\"vastausnappi\" type=\"submit\" value=\"L�het� vastaus\">");
    	out.print("</form>");
    
    }
    catch(Exception e2) {
    	e2.printStackTrace();
    	
    }
    
    finally {
    	
    	out.close();
    }
  }
}