package admin.info;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

public class Statistiques {
	 private ArrayList<VentesProduit> tabVentesProduit;
	 private ArrayList<VentesCategorie> tabVentesCategorie;
	 private ArrayList<VentesDate> tabVentesDate;
	 
	 public Statistiques() {
		 tabVentesCategorie = new ArrayList<VentesCategorie>();
		 tabVentesDate = new ArrayList<VentesDate>();
		 tabVentesProduit = new ArrayList<VentesProduit>();
	 }
	 
	 @SuppressWarnings("unchecked")
	public void refreshTabVentesProduit() {
		String str = "SELECT SUM(L.prixAchat) AS prixVente, P.nom as produit FROM LIGNEFACTURE L INNER JOIN PRODUIT P ON L.produit = P.codePro "
				+ "GROUP BY P.codePro";
		Query query = core.Core.bd.getEm().createNativeQuery(str, admin.info.VentesDate.class);
		tabVentesProduit = (ArrayList<VentesProduit>) query.getResultList();
	 }
	 
	@SuppressWarnings("unchecked")
	public void refreshTabVentesCategorie() {
		String str = "SELECT SUM(L.prixAchat) AS prixVente, C.nom FROM "
				+ "LIGNEFACTURE AS L INNER JOIN PRODUIT AS P ON L.produit = P.codePro "
				+ "INNER JOIN CATEGORIE AS C ON C.id = P.categorie "
				+ "GROUP BY C.id;";
		Query query = core.Core.bd.getEm().createNativeQuery(str, admin.info.VentesCategorie.class);
		tabVentesCategorie = (ArrayList<VentesCategorie>) query.getResultList();
	}
	 
	 @SuppressWarnings("unchecked")
	public void refreshTabVentesDate() {
		String str = "SELECT SUM(montant) AS prixVente, dateFacturation as dateVente FROM FACTURE GROUP BY dateFacturation";
		Query query = core.Core.bd.getEm().createNativeQuery(str, admin.info.VentesDate.class);
		tabVentesDate = (ArrayList<VentesDate>) query.getResultList();
	 }
	 
	 public VentesCategorie bestCategorie() {
		 VentesCategorie best = tabVentesCategorie.get(0);
		 for (VentesCategorie v: tabVentesCategorie) {
			 if (best.getPrixVente() < v.getPrixVente()) {
				 best = v;
			 }
		 }
		 
		 return best;
	 }
	 
	 public VentesProduit bestPoduit() {
		 VentesProduit best = tabVentesProduit.get(0);
		 for (VentesProduit v: tabVentesProduit) {
			 if (best.getPrixVente() < v.getPrixVente()) {
				 best = v;
			 }
		 }
		 
		 return best;
	 }

	public List<VentesProduit> getTabVentesProduit() {
		return tabVentesProduit;
	}

	public List<VentesCategorie> getTabVentesCategorie() {
		return tabVentesCategorie;
	}

	public List<VentesDate> getTabVentesDate() {
		return tabVentesDate;
	}
	 
	 
}
