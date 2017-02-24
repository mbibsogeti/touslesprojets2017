package fr.obodrel.travel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(value={"/cruiseCSV","/cruiseCSV/*"}, loadOnStartup=1)
public class CruiseServlet extends HttpServlet {
	private ArrayList<String> cruisesAvailable;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter outHtmlFile = null;
		String outHtmlStr = "";
		String currURL = "";
		String cruiseNumber = "";
		int lastURLToken = 0;
		int lastSlash = -1;
		log("CruiseServlet, doGet, start");
		
		currURL = req.getRequestURI();

		lastURLToken = currURL.lastIndexOf("/cruiseCSV");
		
		if(lastURLToken+"/cruiseCSV/".length() < currURL.length()) {
			cruiseNumber = currURL.substring(lastURLToken+"/cruiseCSV/".length());
			lastSlash = cruiseNumber.lastIndexOf("/");
			if( lastSlash != -1) {
				cruiseNumber = cruiseNumber.split("/")[0];
				log("CruiseServlet, doGet, cruisenumber = "+cruiseNumber);
			}	
			try {
				outHtmlStr += cruisesAvailable.get(Integer.parseInt(cruiseNumber)-1);
			} catch(NumberFormatException ex) {
				log("CruiseServlet, doGet, number not entered!"+cruiseNumber);
			}
		} else {
			for(String cruise:cruisesAvailable) {
				outHtmlStr += cruise + "\n";
			}
		}
		

		resp.setContentType("text/csv;;charset=UTF-8");
		
		outHtmlFile = resp.getWriter();
		
		outHtmlFile.print(outHtmlStr);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		cruisesAvailable = new ArrayList<String>();

		cruisesAvailable.add("Manaus;9");
		cruisesAvailable.add("Belem;12");
		cruisesAvailable.add("Porto Velho;14");
		cruisesAvailable.add("Santaren;21");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String currURL = "";
		String cruiseNumber = "";
		int lastURLToken = 0;
		int lastSlash = -1;
		
		currURL = req.getRequestURI();

		lastURLToken = currURL.lastIndexOf("/cruiseCSV");
		
		if(lastURLToken+"/cruiseCSV/".length() < currURL.length()) {
			cruiseNumber = currURL.substring(lastURLToken+"/cruiseCSV/".length());
			lastSlash = cruiseNumber.lastIndexOf("/");
			if( lastSlash != -1) {
				cruiseNumber = cruiseNumber.split("/")[0];
				log("CruiseServlet, doGet, cruisenumber = "+cruiseNumber);
			}	
			try {
				cruisesAvailable.remove(Integer.parseInt(cruiseNumber)-1);
				log("CruiseServlet, doDelete, deleted goen through");
			} catch(NumberFormatException ex) {
				log("CruiseServlet, doDelete, nothing deleted since there is a false information provided");
			}
		} else {
			log("CruiseServlet, doDelete, nothing deleted since there is no number provided");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader readerReq = req.getReader();
		
		cruisesAvailable.add(readerReq.readLine());
	}

}
