package fr.obodrel.travel;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MontevideoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher currRequestDispatcher = null;
		double promotionPercent = -15;
		int planePrice = 1399;
		String [] scheduleOptions = new String [] {"Arrival","Visit","Hiking","Scuba-diving","Road Trip","Bike Ride","Party","Departure"};
		
		req.setAttribute("promotionPercent", Math.abs(promotionPercent));
		req.setAttribute("planePrice", (1.0+(promotionPercent/100f))*planePrice);
		req.setAttribute("currDate", LocalDateTime.now());
		req.setAttribute("scheduleOptions", scheduleOptions);
		
		currRequestDispatcher = req.getRequestDispatcher("/montevideo.jsp");
		currRequestDispatcher.forward(req, resp);
	}
}
