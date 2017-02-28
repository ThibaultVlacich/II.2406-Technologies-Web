package lab.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.mvc.model.Person;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String firstName = request.getParameter("firstname");
	  String lastName = request.getParameter("lastname");
	  String birthDate = request.getParameter("birthdate");
	  String sex = request.getParameter("sex");
	  
	  Person person = new Person(firstName, lastName, birthDate, sex);
	  
	  request.setAttribute("person", person);
	  
	  RequestDispatcher dispatcher;
	   
	  if (person.getBirthYear() < 90) {
	    dispatcher = getServletContext().getRequestDispatcher("/old.jsp");
	  } else {
	    dispatcher = getServletContext().getRequestDispatcher("/young.jsp");
	  }
	  
	  dispatcher.include(request, response);
	}

}
