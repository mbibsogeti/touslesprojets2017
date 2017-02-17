package travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LimaServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		Writer out = res.getWriter();
		log("Youpla"+this);
//		Lire les options de servlet du web.xml
		
		
		out.write("<!DOCTYPE html><html><head><meta charset='UTF-8'>");
		out.write("<title>Maracaibo</title>");
		out.write("<link rel='stylesheet' href='../css/bootstrap.min.css'>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>Welcome in Lima man</h1>");
		out.write("<h2>"+getInitParameter("text")+"</h2>");
		out.write("</body><html>");		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		log("init used!");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		log("destroy used!");
	}
	
}
