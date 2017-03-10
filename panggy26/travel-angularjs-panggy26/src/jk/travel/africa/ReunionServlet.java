package jk.travel.africa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reunion")
public class ReunionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log(req.getParameter("name") + " enregistré");
		res.setContentType("application/json");
		// Pour tester cela, se rendre à l'adresse http://localhost:8080/travel-angularjs-panggy26/reunion
		// \" : échappement de "
		res.getWriter().write("\"ok\"" );
	} // end service method
} // end ReunionServlet class