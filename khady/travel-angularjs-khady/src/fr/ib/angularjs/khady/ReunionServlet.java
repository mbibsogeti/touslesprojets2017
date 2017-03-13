package fr.ib.angularjs.khady;

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

		res.setContentType("application/json");
		res.setCharacterEncoding("utf-8");
		
		log(req.getParameter("name")+ " enregistré");
		res.getWriter().write("\"OK\"");
		
		
		
	}

}
