package jk.travel.bresil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Cette ligne d'annotation remplace le fichier web.xml
// La servlet est accessible depuis les adresses suivantes
@WebServlet({"/cruise", "/cruise/*"})
// équivalent : @WebServlet(value=)
// équivalent : @WebServlet(urlPatterns=)
public class CruiseServlet extends HttpServlet {

	// ATTRIBUTS //
	private ArrayList<String> cruises;

	// MÉTHODES //
	@Override
	public void init() throws ServletException {
		// Prépare la liste des croisières
		cruises = new ArrayList<String>();
		cruises.add("Manaus,9");
		cruises.add("Belém,5");
		cruises.add("Porto Velho,8");
		cruises.add("Santarém,7");
		cruises.add("Santa-Catarina,4");
	} // end init method
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Voir client du package jk.travel.bresil.clientClient = navigateur. Pour une doGet(), le client peut aussi être le navigateur.
		// Fixer le type de sortie (norme MIME)
		res.setContentType("text/csv");
		// Fixer l'encodage de Tomcat
		res.setCharacterEncoding("UTF-8");
		// Obtenir la main sur un flux de sortie déjà préparé
		Writer out = res.getWriter();
		// Récupère l'URL demandée par le client
		String url = req.getRequestURL().toString();
		if(url.endsWith("/cruise")) {
		// Condition que j'avais trouvée : if(url.equals("http://localhost:8080/travel-rest-panggy26/cruise")) {
			// Affichage des croisières
			for (String i : cruises) {
				out.write(i + "\n");
			} // end for
		} // end if
		else {
			// Récupération de ce qu'il y a après le dernier /
			String num = url.substring(url.lastIndexOf("/") + 1);
			int ind = Integer.parseInt(num);
			out.write(cruises.get(ind));
		} // end if
	} // end doGet method

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Client = navigateur
		// La donnée est dans le chargement (corps de la requête). Il n'y a pas de contrôle : si le client envoie n'importe quoi,
		// cela écrit n'importe quoi. On lit une ligne du chargement. S'il y en a davantage, il ignore les autres.
		BufferedReader in = req.getReader();
		cruises.add(in.readLine());
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Voir client du package jk.travel.bresil.client
		int n = 0;
		cruises.remove(n);
	}
} // end CruiseServlet class