import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

@WebServlet("/reunion")

public class ReunionServlet extends HttpServlet{

@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	res.setContentType("text/html"); // respecte la norme mime
	res.setCharacterEncoding("utf-8");
	log(req.getParameter("name")+"enregistrer");
	res.setContentType("application/json");
	res.getWriter().write("\"ok\"");

}

}
