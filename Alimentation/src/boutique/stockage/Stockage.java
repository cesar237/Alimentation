package boutique.stockage;


import javax.persistence.EntityTransaction;

import admin.model.Gestionnaire;
import boutique.model.Produit;
import boutique.model.QteException;
import boutique.stockage.model.GestionStock;
import core.Core;

public class Stockage {
	public static final int AJOUT_OP = 1;
	public static final int SUPPR_OP = -1;
	public static final int MODIF_OP = 0;
	
	
	private Gestionnaire gestionnaire;
	
	
	
	public Stockage(Gestionnaire g) {
		System.out.println("Ouverture du magazin...");
		
		gestionnaire = g;
	}

	
	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}
	
	
	public void creerProduit(Produit p) {
		Core.bd.add((Produit) p);
	}
	
	
	public void supprimmerProduit(Produit p) {
		Core.bd.remove((Produit) p);
	}
	
	
	public void ajouterQte(Produit p, double qte) {
		GestionStock g = new GestionStock(AJOUT_OP, qte, p, gestionnaire);
		Core.bd.add((GestionStock) g);
		p.setActif(true);
		
		EntityTransaction trans = Core.bd.getTransaction();
		trans.begin();
		p.setQte( qte + p.getQte() );
		Core.bd.getEm().flush();
		trans.commit();
	}
	
	public void reduireQte(Produit p, double qte) throws QteException{
		GestionStock g = new GestionStock(SUPPR_OP, qte, p, gestionnaire);
		double newQte = p.getQte() - qte;
		if (newQte < 0) {
			throw(new QteException());
		} else {
			Core.bd.add((GestionStock) g);
			Core.bd.getTransaction().begin();
			p.setQte(newQte);
			if (newQte == 0) {
				p.setActif(false);
			}
			Core.bd.getEm().flush();
			Core.bd.getTransaction().commit();
		}
	}
	
	
	public void modifierPrixVente(Produit p, double prix) {
		EntityTransaction trans = Core.bd.getTransaction();
		
		trans.begin();
		p.setPrixVente(prix);
		Core.bd.getEm().flush();
		trans.commit();
	}
	
	
	public void modifierPrixAchat(Produit p, double prix) {
		EntityTransaction trans = Core.bd.getTransaction();
		
		trans.begin();
		p.setPrixAchat(prix);
		Core.bd.getEm().flush();
		trans.commit();
	}
	
	
	public void modifierDescription(Produit p, String desc) {
		EntityTransaction trans = Core.bd.getTransaction();
		
		trans.begin();
		p.setDescription(desc);
		Core.bd.getEm().flush();
		trans.commit();
	}
	
}
