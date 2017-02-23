package fr.ib.travel;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MontevideoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		double pourcentage = 15;
		int voyage = 1399;
		double reduction = voyage-((pourcentage*voyage)/100);
		req.setAttribute("promo", reduction);

		req.setAttribute("now", LocalDateTime.now());
		
		String []days=new String[]{"Arrivée","Visite1","Visite2","Plage","Temps Libre1","Visite3","Visite4","Temps Libre2","Départ"};
		req.setAttribute("days", days);
		
		
		req.getRequestDispatcher("/montevideo.jsp").forward(req, res);
	}
}
