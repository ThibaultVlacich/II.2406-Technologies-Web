

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		  w.println("Welcome on my site. Please tell us a bit more about you :");
		  
		  w.println("<form method=\"POST\" action=\"\">");
		  w.println("<label for=\"name\">Full name:</label>");
		  w.println("<input type=\"text\" id=\"name\" name=\"name\">");
	    
		  w.println("<br>");
	    
		  w.println("<label for=\"birthdate\">Birth date (format dd/MM/yyyy):</label>");
		  w.println("<input type=\"date\" id=\"birthdate\" name=\"birthdate\">");
	    
		  w.println("<br>");

		  w.println("<input type=\"submit\" value=\"Submit\">");
		  w.println("</form>");
		  
		  s.setAttribute("numberOfVisits", 1);
		} else {
	    int numberOfVisits = (int) s.getAttribute("numberOfVisits");
	    numberOfVisits++;
	    
	    String name = (String) s.getAttribute("name");
	    String birthdate = (String) s.getAttribute("birthdate");
	    
	    s.setAttribute("numberOfVisits", numberOfVisits);
		  
		  if (name != null) {
		    w.println("Hi " + name + "!");
		  } else {  
	      w.println("Welcome back!");
		  }
		  
		  if (birthdate != null) {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    
		    try {
		      Date today = new Date();
          Date date = formatter.parse(birthdate);
          
          int currentDays = absoluteDay(today.getMonth(), today.getDay());
          int birthDayDays1 = absoluteDay(date.getMonth(), date.getDay());
          
          int numberOfDays = (birthDayDays1 - currentDays >= 0) ? (birthDayDays1 - currentDays) : (365 - (currentDays - birthDayDays1));
          
          w.println("There are " + numberOfDays + " days to your birthday.");
        } catch (ParseException e) {
            e.printStackTrace();
        }
		  }
		  
		  w.println("Its the " + numberOfVisits + " times you've come on my site!");
		}
	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession s = request.getSession(true);
	    PrintWriter w = response.getWriter();
	 
	    String name = request.getParameter("name");
	    String birthDate = request.getParameter("birthdate");

	    s.setAttribute("name", name);
	    s.setAttribute("birthdate", birthDate);
	    
	    w.println("<a href=\"\">< Retour</a>");
	 }
	 
   private static int absoluteDay(int month, int day){
     int[] days = {0, 0, 31, 60, 91, 121, 91, 121, 152, 182, 213, 244, 274, 305, 335};
     
     return days[month] + day;
 }
}
