package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/reunion")
public class ReunionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log(req.getParameter("name") + " saved in the database.");
		// notre requête renvoie du JSON, on doit donc l'écrire en conséquences : "\"ok\"".
		res.setContentType("application/json");
		res.getWriter().write("\"ok\"");
	}
}
