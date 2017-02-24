package fr.ib.travelBresil;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/cruise", "/cruise/*" })
public class CruiseServlet extends HttpServlet {

	private ArrayList<String> cruises;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/csv");
		Writer out = resp.getWriter();

		String url = req.getRequestURL().toString();
		log(url);

		Boolean f = true;

		for (int i = 1; i < cruises.size(); i++) {
			String fin = url.substring(url.length() - 1);
			try {
				if (Integer.parseInt(fin) == i) {
					out.write(cruises.get(i - 1));
					f = false;
				}
			} catch (Exception ex) {
			}
		}

		if (f) {
			for (String c : cruises) {
				out.write(c + "\n");
			}
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		cruises = new ArrayList<>();
		cruises.add("Manaus, 9");
		cruises.add("Belen, 4");
		cruises.add("Porto Vetho, 5");
		cruises.add("Santaren, 3");
	}

}
