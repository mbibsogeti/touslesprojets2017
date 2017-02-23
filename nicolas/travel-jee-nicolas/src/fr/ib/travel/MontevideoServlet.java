package fr.ib.travel;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MontevideoServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException {
		HashMap<String,String>descs=new HashMap<>();
		
		
		res.setContentType("text/html"); 
		res.setCharacterEncoding("utf-8");
		req.setAttribute("promo", 1399-1399*0.15);	
		req.setAttribute("now", LocalDateTime.now());
		req.setAttribute("now2", new Date());
		String[]days= new String[]{"Arrivée","plage","montagne","mer","repos","dodo","manger" };
		req.setAttribute("days",days);
		req.getRequestDispatcher("/montevideo.jsp").forward(req,res);
	
	}
}