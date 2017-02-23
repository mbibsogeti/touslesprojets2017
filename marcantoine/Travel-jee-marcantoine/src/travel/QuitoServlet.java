package travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuitoServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html><html><head><meta charset='UTF-8'>");
		out.write("<title>Quito</title>");
		out.write("<link rel='stylesheet' href='../css/bootstrap.min.css'>");
		out.write("</head>");
		out.write("<body>");
		out.write("<jsp:include page='/header.jsp'>");
		out.write("<jsp:param name='year' value='2017'/>");
		out.write("</jsp:include>");
		out.write("<div class='container'>");
		out.write("<h1>Quito</h1>");
		out.write("<table class='table table-bordered table-striped table-hover'><thead><tr><th>Jours</th><th>Prix TTC ()</th></tr></thead>");
		out.write("<tbody>");
		for (int i = 5; i <= 25; i += 5) {
			out.write(
					"<tr><th>" + i + "</th><td>" + String.format("%.2f", (i - 1) * 32.80 + 1060) + " €</td></tr>");
		}
		out.write("</table>");
		out.write("</div></body></html>");
	}
}
