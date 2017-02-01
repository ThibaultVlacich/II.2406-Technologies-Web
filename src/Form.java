import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class Form
 */
@WebServlet({"/FormServlet", "/Form_Servlet"})
public class Form extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // Get sent datas
	  String firstName = request.getParameter("firstname");
	  String lastName = request.getParameter("lastname");
	  String birthDate = request.getParameter("birthdate");
	  String sex = request.getParameter("sex");
	  
	  // Set content type
	  response.setContentType("text/html");
	  
	  // Output result
	  PrintWriter writer = response.getWriter();
	  
	  writer.println("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Insert title here</title></head><body>");
	  writer.println("<table>");
	  writer.println("<tr><td>First name</td><td>"+firstName+"</td></tr>");
	  writer.println("<tr><td>Last name</td><td>"+lastName+"</td></tr>");
	  writer.println("<tr><td>Birth date</td><td>"+birthDate+"</td></tr>");
	  writer.println("<tr><td>Sex</td><td>"+sex+"</td></tr>");
	  writer.println("</table>");
	  writer.println("</body></html>");
	  
	  writer.close();
	}

}
