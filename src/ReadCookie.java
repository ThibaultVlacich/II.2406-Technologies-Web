import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class ReadCookie
 */
@WebServlet("/ReadCookie")
public class ReadCookie extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Set content type
    response.setContentType("text/html");
    
    // Output result
    PrintWriter writer = response.getWriter();
    
    writer.println("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Insert title here</title></head><body>");
    
    // Get Stored cookies
    Cookie[] cookies = request.getCookies();
    
    if (cookies != null) {
      writer.println("<table>");
      
      for (Cookie cookie: cookies) {
        writer.println("<tr><td>"+cookie.getName()+"</td><td>"+cookie.getValue()+"</td></tr>");
      }
      
      writer.println("</table>");
    } else {
      writer.println("You don't have any cookie stored on your computer.");
    }
    
    writer.println("</body></html>");
    
    writer.close();
	}

}
