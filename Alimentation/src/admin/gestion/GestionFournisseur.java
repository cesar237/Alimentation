package admin.gestion;

import java.util.List;

import javax.persistence.Query;

import admin.model.Fournisseur;


public class GestionFournisseur {
	private List<Fournisseur> listeFournisseur;
	
	@SuppressWarnings("unchecked")
	public GestionFournisseur() {
		String str = "SELECT * FROM FOUNRISSEUR";
		
		Query query = core.Core.bd.getEm().createNativeQuery(str, admin.model.Fournisseur.class);
		listeFournisseur = (List<Fournisseur>) query.getResultList();
	}

	public List<Fournisseur> getListeFournisseur() {
		return listeFournisseur;
	}
	
	public void ajouter(Fournisseur e) {
		core.Core.bd.add((Fournisseur) e);
		listeFournisseur.add(e);
	}
	
	public void supprimmer(Fournisseur g) {
		core.Core.bd.remove((Fournisseur) g);
	}
	
	public void modifierNom(Fournisseur g, String name) {
		core.Core.bd.getTransaction().begin();
		g.setNom(name);
		core.Core.bd.getEm().flush();
		core.Core.bd.getTransaction().commit();
	}
	
	public void modifierAdresse(Fournisseur g, String adresse) {
		core.Core.bd.getTransaction().begin();
		g.setAdresse(adresse);
		core.Core.bd.getEm().flush();
		core.Core.bd.getTransaction().commit();
	}
	
	public void modifierTel(Fournisseur g, String tel) {
		core.Core.bd.getTransaction().begin();
		g.setTel(tel);
		core.Core.bd.getEm().flush();
		core.Core.bd.getTransaction().commit();
	}
}
