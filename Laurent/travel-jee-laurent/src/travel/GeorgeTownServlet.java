package travel;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class GeorgeTownServlet extends HttpServlet {

	public GeorgeTownServlet() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try{
			//Initialisation de la DB
			DataSource ds=(DataSource) new InitialContext().lookup("java:comp/env/jdbc/travelDS"); 
			ds.getConnection().close();
			
			
		}catch(Exception ex){
			req.setAttribute("erreur", "Erreur !!!"+ex);
		}
		
		
		req.getRequestDispatcher("/georgetown.jsp").forward(req,res);
	}
}
