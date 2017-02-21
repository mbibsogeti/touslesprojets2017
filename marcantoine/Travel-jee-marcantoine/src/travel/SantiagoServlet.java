package travel;

import java.io.IOException;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SantiagoServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		Writer out = res.getWriter();

		String name = "";
		if (req.getParameter("name") != null) {
			name = req.getParameter("name");
		}
		String tel = "";
		if (req.getParameter("tel") != null) {
			tel = req.getParameter("tel");
		}
		String nb = "";
		if (req.getParameter("nb") != null) {
			nb = req.getParameter("nb");
		}
		
		

		// Session
		HttpSession s = req.getSession();

		out.write("<!DOCTYPE html><html><head><meta charset='UTF-8'>");
		out.write("<title>Santiago</title>");
		out.write("<link rel='stylesheet' href='../css/bootstrap.min.css'>");
		out.write("</head>");
		out.write("<body>");
		out.write("<div class='container'>");
		out.write("<h1>Santiago: a multiple offer for multiple clients</h1>");

		if ((Integer) s.getAttribute("v") == null) {
			out.write("<h2>Welcome, dear customer!</h2>");
			s.setAttribute("v", 1);
		} else {
			if ((Integer) s.getAttribute("v") >= 1
					&& (Integer) s.getAttribute("v") < 4) {
				out.write("<h2>Welcome again, dear faithful customer!</h2>");
				s.setAttribute("v", (Integer) s.getAttribute("v") + 1);
			}
		}

		out.write("<h2>What would you like?</h2>");
		out.write("<section class='row'><section class='col-xs-4'>");
		out.write("<form action='?' method='post'>");
		out.write("<section class='form-group'>");
		out.write("<p>Name: <input type='text' name='name' class='form-control' value='" + name + "'></p>");
		out.write("</section>");
		out.write("<section class='form-group'>");
		out.write("<p>Tel: <input type='tel' name='tel' class='form-control' value='" + tel + "'></p>");
		out.write("</section>");
		out.write("<section class='form-group'>");
		out.write("<p>Travellers: <input type='number' name='nb' class='form-control' value='" + nb + "'></p>");
		out.write("</section>");
		out.write("<section class='form-group'>");
		out.write("<p><input type='submit' value='send' class='btn btn-primary'></p>");
		out.write("</section>");
		out.write("</section></section>");
		out.write("</form></div></body></html>");

		out.write("</div></body><html>");
		
//		Ecriture d'un cookie :
		Cookie c=new Cookie ("last", URLEncoder.encode(new Date().toString(),"UTF-8"));
		c.setMaxAge(10);
		res.addCookie(c);
		
//		Lecture d'un cookie :
		Cookie[]cs=req.getCookies();
		if (cs!=null) {
			for (Cookie c2:cs) {
				if (c2.getName().equals("last")) {
					out.write(c2.getValue());
				}
			}
		}
	}

}
