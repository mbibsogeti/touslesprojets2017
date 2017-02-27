package fr.ib.travel.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/excursions")
public class Excursions {
	private List<Excursion> l;

	public Excursions() {
		l = new ArrayList<>();
		l.add(new Excursion("Ciuaba", 6));
		l.add(new Excursion("Uberlandia", 5));
		l.add(new Excursion("Curitiba", 7));
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String gettInfos() {
		return "Ceci est l'API des excursions au Brésil\n" + "Adresses: \n" + "Visite du Barrage d’Itaipu\n"
				+ "Le matin, départ de l’hôtel pour une visite en groupe du site d’Itaipu.Ce gigantesque barrage, véritable fierté brésilienne, fournit assez d’énergie électrique pour le Paraguay et le Sud du Brésil. Service groupe avec guide anglophone (francophone en option). La visite comprend le transport, la projection d’un film informatif, puis le tour en bus vers les panoramas les plus intéressants. Retour à Iguaçu en milieu de journée. Repas non compris. Nuit à l’hôtel.\n"
				+ "Rafting 2 heures \n"
				+ "Durant la visite des chutes, vous ferez une halte au Campo de Desafios (le terrain des défis) pour une descente du RIo Iguaçu en rafting. La descente fait environ 4 kms : 1 km de rapides puis 3 kms en eaux plus calmes, où il sera possible de se baigner. Le début de la descente est tout proche des chutes vous offrons une superbe vue.L’excursion a une durée d’environ 2 heures : ce sont 20 minutes de marche, puis votre moniteur vous transmettra les instructions, 35 minutes de descente et enfin 30 minutes pour rejoindre la fin de l’excursion. Note 1 : Les rapides sont considérés de niveau moyen (classe III+), accessible à partir de 14 ans. Pour les mineurs de 14 à 17 ans, il est obligatoire de présenter une autorisation d’un responsable (parents ou responsable legal).Note 2 : Prévoir des vêtements légers qui seront mouillés.IMPORTANT : la faisabilité de l’excursion est sujet au niveau de la rivière Rio Iguaçu. En cas de manque d’eau, l’excursion sera annulée.";
	}

	@GET
	@Path("/list")
	/*
	 * public String getList() { return "(vide)"; }
	 */
	@Produces(MediaType.APPLICATION_JSON)
	public List<Excursion> getList() {
		return l;

	}

	@GET
	@Path("/bestvalue")
	@Produces(MediaType.APPLICATION_JSON)
	public Excursion getBestValue() {
		return new Excursion("Ciuaba", 6);
	}

	// pour afficher juste une excursion
	@GET
	@Path("/bynumber/{no}")
	@Produces(MediaType.APPLICATION_JSON)
	public Excursion getByNumber(@PathParam("no") int n) {

		return l.get(n);
	}
	//supprimer une donnée quelconque dans notre liste excursions
	//ne marche pas sur le navigateur (elle ne s'excute pas) 
	@DELETE
	@Path("/bynumber/{no}")
	public void deleteByNumber(@PathParam("no") int n) {
		l.remove(n);
	}
}
