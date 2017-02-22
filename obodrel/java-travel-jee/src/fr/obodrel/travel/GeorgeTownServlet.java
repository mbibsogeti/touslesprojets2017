package fr.obodrel.travel;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@SuppressWarnings("serial")
public class GeorgeTownServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher currRequestDispatcher = null;
		
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/travelDS");
			ds.getConnection().close();
		} catch(Exception ex) {
			log("GeorgeTwonServlet, service, Error! "+ex);
		}
		
		currRequestDispatcher = req.getRequestDispatcher("/georgetown.jsp");
		currRequestDispatcher.forward(req, resp);
	}
}
