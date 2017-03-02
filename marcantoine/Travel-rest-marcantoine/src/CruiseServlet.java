import java.io.BufferedReader;
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
	// Redéfinissant une méthode héritée
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/csv");
		Writer out = res.getWriter();
		// On regarde dans la liste pour afficher ses éléments :
		// Transforme l'url en chaîne de caractères :
		String url = req.getRequestURL().toString();
		// Test d'une fin de chaîne de caractères :
		if (url.endsWith("/cruise")) {
			// Parcourir une liste :
			for (String c : cruises) {
				out.write(c + "\n");
			}
		} else {
			// substring : crée une chaîne de caractères à partir d'un morceau
			// de la chaîne cible.
			String r = url.substring(url.lastIndexOf("/") + 1);
			// méthode get(int indexvalue) permet de donner l'élément de la
			// liste
			// d'index 'indexvalue.'
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
	public void doDelete(HttpServletRequest req, HttpServletResponse res) {
		int n = 0;
		// Pour supprimer un élément (définitif jusqu'à recréation servlet) :
		cruises.remove(n);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		On crée un buffered reader :
		BufferedReader in = req.getReader();
//		Le client peut ajouter quelque chose
//		readline : on lit une ligne du chargement avec read line
		cruises.add(in.readLine());
	}

	
	
	
}
