package travel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MonteVideoServlet")
public class MonteVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MonteVideoServlet() {
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.getRequestDispatcher("/montevideo.jsp").forward(req,res);
	}

}
