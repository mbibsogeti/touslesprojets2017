package fr.ib.travel;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MontevideoServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("promo", 0.85*1399);
		req.setAttribute("now", LocalDateTime.now());
		String[] days = new String[] {"Arrivée","xxx","Depart"};
		req.setAttribute("day", days);
		req.getRequestDispatcher("/montevideo.jsp").forward(req, res);
	}

}
