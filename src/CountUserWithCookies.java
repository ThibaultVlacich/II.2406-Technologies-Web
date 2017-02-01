import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class CountUserWithCookies
 */
@WebServlet("/CountUserWithCookies")
public class CountUserWithCookies extends HttpServlet {

  private static int userCount = 0;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  Cookie[] cookies = request.getCookies();
	  
	  if (cookies != null && cookies.length > 0) {
	    userCount++;
	  }
	 
	  response.getWriter().println("User using cookies: "+userCount);
	}

}
