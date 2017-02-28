

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListItems
 */
@WebServlet("/ListItems")
public class ListItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession s = request.getSession(true);
    PrintWriter w = response.getWriter();
 
    ArrayList<String> items = (ArrayList<String>) s.getAttribute("items");
    
    w.println("Liste des items en session :");
    w.println("<ul>");
    
    for (String item: items) {
      w.println("<li>");
      w.print(item);
      w.print("</li>");
    }
    
    w.println("</ul>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession s = request.getSession(true);
    PrintWriter w = response.getWriter();
    
    ArrayList<String> items = (ArrayList<String>) s.getAttribute("items");
    
    if (items == null) {
      items = new ArrayList<String>();
    }
    
    String newItem = request.getParameter("newItem");
    
    if (newItem != null) {
      items.add(newItem);
    }
    
    s.setAttribute("items", items);
 
    doGet(request, response);
	}

}
