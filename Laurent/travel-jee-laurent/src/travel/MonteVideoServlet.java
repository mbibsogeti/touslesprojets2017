package travel;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MonteVideoServlet")
public class MonteVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MonteVideoServlet() {
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setAttribute("promo", (1399*15)/100);

		req.setAttribute("now", LocalDateTime.now());
		
		String[] days= new String[]{"Arrivée","Plage","Randonnée","Kayak","Canyonning","Visite des villages voisins","Repos","Départ"};
		
		req.setAttribute("days", days);
		
		req.getRequestDispatcher("/montevideo.jsp").forward(req,res);
	}

}
