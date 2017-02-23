import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Annotation qui remplace l'utilisation de web.xml. NB : on pourrait préciser l'extension du fichier
// Annotation avec paramètre. On ajoute une deuxième valuer d'url pour autoriser l'utilisateur
// à accéder au même contenu avec une url différente.
@WebServlet({ "/cruise", "/cruise/*" })
public class CruiseServlet extends HttpServlet {
	// Déclaration d'une liste à laquelle on va affecter des valeurs.
	private ArrayList<String> cruises;

	// Annotation permettant d'aider le développeur à ne pas faire d'erreur en
	// redéfinissant une méthode héritée
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/csv");
		Writer out = res.getWriter();
		// On regarde dans la liste pour afficher ses éléments :
		String url = req.getRequestURL().toString();
		if (url.endsWith("/cruise")) {
			for (String c : cruises) {
				out.write(c + "\n");
			}
		} else {
			String r = url.substring(url.lastIndexOf("/")+1);
			out.write(cruises.get(Integer.parseInt(r)));			
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		// Affectation de valeurs dans la liste. Init n'est utilisée qu'une
		// seule fois par session.
		cruises = new ArrayList<String>();
		cruises.add("Manaus,9");
		cruises.add("Belen,18");
		cruises.add("Porto Velho,5");
		cruises.add("Sartaren,12");
	}
	
	@Override
	public void doDelete () {
		int n = 0;
//		Pour supprimer un élément (définitif jusqu'à recréation servlet) :
		cruises.remove(n);
	}
}
