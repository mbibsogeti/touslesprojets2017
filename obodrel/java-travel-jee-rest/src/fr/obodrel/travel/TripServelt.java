package fr.obodrel.travel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TripServelt extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher currRequestDispatcher = null;
		
		log("Tototototo");
		
		currRequestDispatcher = req.getRequestDispatcher("/trip.jsp");
		currRequestDispatcher.forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		log("TripServelt init, this = "+this);
	}

}
