package jk.travel.amsud;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MontevideoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Réduction de 15% sur un voyage de 1399 €
		// Pour formater ici : String.format("%.2f", 1399 * 0.85). Mais on le fait d'une autre façon dans le fichier .jsp
		req.setAttribute("promo", 1399 * 0.85);
		// Date de validité de la promotion
		req.setAttribute("now", LocalDateTime.now());
		// Programme du séjour
		String[] sejour = new String[] { "Arrivée", "Visite globale de la ville", "Punta del Diablo", "Museo Dracula-Suárez",
				"Restau typique", "Piscine de maté", "Maldonado", "Retour" };
		req.setAttribute("planning", sejour);
		// Lien de la Servlet à la .jsp
		req.getRequestDispatcher("/montevideo.jsp").forward(req, res);
	} // end méthode doGet
}