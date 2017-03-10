package fr.obodrel.travel.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LaReunionServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher currRequestDispatcher = null;
		
		currRequestDispatcher = req.getRequestDispatcher("/lareunion.jsp");
		currRequestDispatcher.forward(req, resp);
	}
}
