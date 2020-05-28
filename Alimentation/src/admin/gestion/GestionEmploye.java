package admin.gestion;

import java.util.List;

import javax.persistence.Query;

import admin.model.Gestionnaire;

public class GestionEmploye {
	private List<Gestionnaire> listeEmployes;
	
	public GestionEmploye(Gestionnaire g) {
		if (g.getType() == true) {
			loadListe();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void loadListe() {
		String str = "SELECT * FROM GESTIONNAIRE";
		
		Query query = core.Core.bd.getEm().createNativeQuery(str, admin.model.Gestionnaire.class);
		listeEmployes = (List<Gestionnaire>) query.getResultList();
	}

	public List<Gestionnaire> getListeEmployes() {
		return listeEmployes;
	}

	public void ajouter(Gestionnaire e) {
		core.Core.bd.add((Gestionnaire) e);
		listeEmployes.add(e);
	}
	
	public void supprimmer(Gestionnaire g) {
		core.Core.bd.remove((Gestionnaire) g);
	}
	
	public void activer(Gestionnaire g) {
		if (!g.getActif()) {
			core.Core.bd.getTransaction().begin();
			g.setActif(true);
			core.Core.bd.getEm().flush();
			core.Core.bd.getTransaction().commit();
		}
	}
	
	public void desactiver(Gestionnaire g) {
		if (g.getActif()) {
			core.Core.bd.getTransaction().begin();
			g.setActif(false);
			core.Core.bd.getEm().flush();
			core.Core.bd.getTransaction().commit();
		}
	}
	
	public boolean etat(Gestionnaire g) {
		return g.getActif();
	}
	
	public void modifierNom(Gestionnaire g, String name) {
		core.Core.bd.getTransaction().begin();
		g.setNom(name);
		core.Core.bd.getEm().flush();
		core.Core.bd.getTransaction().commit();
	}
	
	public void modifierLogin(Gestionnaire g, String login) {
		core.Core.bd.getTransaction().begin();
		g.setLogin(login);
		core.Core.bd.getEm().flush();
		core.Core.bd.getTransaction().commit();
	}
	
	public void modifierPasswd(Gestionnaire g, String passwd) {
		core.Core.bd.getTransaction().begin();
		g.setPwd(passwd);
		core.Core.bd.getEm().flush();
		core.Core.bd.getTransaction().commit();
	}
	
} 
