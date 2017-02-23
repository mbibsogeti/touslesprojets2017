package fr.ib.hugo.travel;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MontevideoServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int precioBruto = 1399;
		double reduccion = 0.15;
		double precioFinal = precioBruto * (1 - reduccion);
		String[] dias = new String[] { "Llegada", "Playa", "Mate", "Pastorales", "Ecoturismo", "Deportes de aventura",
				"Partida" };

		req.setAttribute("precioFinal", precioFinal);
		req.setAttribute("finPromo", LocalDateTime.now());
		req.setAttribute("programaDias", dias);

		req.getRequestDispatcher("/montevideo.jsp").forward(req, res);
	}

	private static final long serialVersionUID = 1L;

}
