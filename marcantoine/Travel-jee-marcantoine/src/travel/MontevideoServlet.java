package travel;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MontevideoServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		int red = 15;
		int price = 1399;
//		Onc rée l'objet promotion qui contient le prix actualisé en fonction de la promotion actuelle.
		req.setAttribute("promo", (100-red)*price/100);
//		On crée l'objet now contenant la date et l'heure exacte du jour actuel.
//		Cet objet pourra ensuite être appelé par la servlet.
		req.setAttribute("now", LocalDateTime.now());
//		Création d'un objet tableau
		String[]days=new String [] {
				"Arrival","Fishing","Clubbing","Leisure time","Hiking","Sleep","Gastronomy","Sleep","Departure"
		};
		req.setAttribute("days", days);
		
//		Redirection de la Servlet vers la JSP qui va afficher
		req.getRequestDispatcher("/montevideo.jsp").forward(req,res);
		
	}
}	
