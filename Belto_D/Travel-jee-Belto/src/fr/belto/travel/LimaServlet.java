package fr.belto.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LimaServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter(); 
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>Bienvenue à Cartagena (ville de Colombie)</title>");
		out.write("<link rel='stylesheet' href='css/bootstap.min.css'>");
		out.write("</head>");
		out.write("<body>");
		log("doGet"+ this);	
		out.write("<h1>"+getInitParameter("text")+"</h1>");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stu
		super.init(config);
		log("init");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		log("destroy");
	}

}
