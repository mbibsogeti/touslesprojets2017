/**
 * 
 */
package fr.ib.travel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ib
 *
 */
public class MontevideoServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/montevideo.jsp").forward(req, res);//une servlet qui va vers un JSP
		
	}
	

}
