

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowSession
 */
@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(true);
		PrintWriter w = response.getWriter();
		
		if (s.isNew()) {
		  w.println("Welcome on my site");
		  s.setAttribute("numberOfVisits", 1);
		} else {
	    int numberOfVisits = (int) s.getAttribute("numberOfVisits");
	    numberOfVisits++;
	    
	    s.setAttribute("numberOfVisits", numberOfVisits);
	    
		  w.println("Welcome back!");
		  w.println("Its the " + numberOfVisits + " times you've come on my site!");
		}
	}

}
