package fr.ib.travel;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MontevideoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    double taux = 0.15;
		int PrixDép = 1399;
		double PrixRéduit = PrixDép-(PrixDép*taux);

		req.setAttribute("promo", PrixRéduit);
		req.setAttribute("now", LocalDateTime.now());
		
		String[]days = new String[]{
			"Arrivée","Repos", "Plage", "Balade en bateau","Sortie pêche","Parcours Jungle ","Avion"
		};
		
		req.setAttribute("days", days);
		
		
		
		
		
		
	    req.getRequestDispatcher("/montevideo.jsp").forward(req, res);	
		
		
		
		
		
	}
    
}
