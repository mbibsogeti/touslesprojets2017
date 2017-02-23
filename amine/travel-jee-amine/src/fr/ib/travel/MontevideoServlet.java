/**
 * 
 */
package fr.ib.travel;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ib
 *
 */
public class MontevideoServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//enregistrer une promotion voyage sur la requête
		req.setAttribute("promo", 1399-1399*0.15);
		//afficher la validité de la promotion
		req.setAttribute("now", LocalDateTime.now());
		//tableau programme du voyage à Montevideo
		String []days=new String[]{
				"Arrivée","visite","plage","découverte","restaurant","repos","départ"
		};
		req.setAttribute("days", days);
		//une servlet qui va vers un JSP
		req.getRequestDispatcher("/montevideo.jsp").forward(req, res);

	}

}
