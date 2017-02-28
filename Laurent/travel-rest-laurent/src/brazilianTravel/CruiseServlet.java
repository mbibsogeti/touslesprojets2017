package brazilianTravel;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CruiseServlet
 */
@WebServlet({"/cruise","/cruise/*"})
public class CruiseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> cruises;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CruiseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/csv"); //Permet d'indiquer que ce qu'on enverra sera du type choisis
		res.setCharacterEncoding("utf-8");
		Writer out= res.getWriter();
		String url=req.getRequestURL().toString();
		
		if(!url.split("/")[url.split("/").length-1].equals("cruise")){
			out.write(cruises.get(Integer.parseInt(url.split("/")[url.split("/").length-1]))+"\n");
		}else{
			for(String c : cruises){
				out.write(c+"\n");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		cruises.add(req.getReader().readLine());
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String url=req.getRequestURL().toString();
		int n=Integer.parseInt(url.split("/")[url.split("/").length-1]);
		cruises.remove(n);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		cruises = new ArrayList<String>();
		cruises.add("Manaus,9");
		cruises.add("Olinda,6");
		cruises.add("Belém,7");
		cruises.add("São Luis,10");
		cruises.add("Porto Alegre,11");
		cruises.add("Natal,8");
		cruises.add("Curitiba,7");
		cruises.add("Petropolis,8");
		cruises.add("João Pessoa,9");
		cruises.add("Rio Branco,6");
		cruises.add("Cuiaba,12");
	}

}
