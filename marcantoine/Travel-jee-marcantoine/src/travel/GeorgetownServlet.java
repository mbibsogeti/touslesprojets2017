package travel;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class GeorgetownServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//		
		try {
			DataSource ds=(DataSource) new InitialContext().lookup("java:comp/env/jdbc/travelDS");
			ds.getConnection().close();
		} catch (Exception ex) {
			log ("Erreur!", ex);
		}
	}
}
