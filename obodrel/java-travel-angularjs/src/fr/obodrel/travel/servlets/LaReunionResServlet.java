package fr.obodrel.travel.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LaReunionResServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter outFile = null;

		resp.setContentType("application/json;charset=UTF-8");
		
		log(req.getParameter("name")+" registered");
		
		outFile = resp.getWriter();
		
		outFile.write("\"OK\"");
	}
}
