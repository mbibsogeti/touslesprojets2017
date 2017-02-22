package fr.belto.travel;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MontevideoServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		float rédu=15;
		float billet=1399;
		req.setAttribute("promo", ((100-rédu)*billet)/100);// calcul qui sera appeler par le jsp//
		req.setAttribute("now", LocalDateTime.now());
		String[]days=new String[]{"Arrivée", "Journée libre", "Randonné à Velo", "Visite touristique en Bus", "Journée plage", "Activité libre","Visite de l'ile de Monté", "Ballade à cheval","Journée shopping"};
		req.setAttribute("days", days);
		req.getRequestDispatcher("/montevideo.jsp").forward(req,res);
}
}