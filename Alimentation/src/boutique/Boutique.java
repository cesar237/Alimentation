package boutique;

import java.util.List;

import javax.persistence.Query;

import admin.model.Gestionnaire;
import boutique.model.Produit;
import core.Core;

public class Boutique {
	private List<Produit> listeProduits;
	private List<Produit> listeProduitsDisponibles;
	private Gestionnaire gestionnaire;

	
	public Boutique(Gestionnaire g) {
		System.out.println("Ouverture de la boutique...");
		
		loadProduits();
		loadProduitsDispo();
		gestionnaire = g;
	}

	@SuppressWarnings("unchecked")
	public void loadProduits() {
		// Chargement de la liste des produits
		String str = "SELECT * FROM PRODUIT";
		Query query = Core.bd.getEm().createNativeQuery(str, boutique.model.Produit.class);
		listeProduits = (List<Produit>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public void loadProduitsDispo() {
		// Chargement de la liste des produits
		String str = "SELECT * FROM PRODUIT WHERE ACTIF = TRUE";
		Query query = Core.bd.getEm().createNativeQuery(str, boutique.model.Produit.class);
		listeProduitsDisponibles = (List<Produit>) query.getResultList();
	}

	public List<Produit> getListeProduits() {
		return listeProduits;
	}


	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}


	public List<Produit> getListeProduitsDisponibles() {
		return listeProduitsDisponibles;
	}


	public void setListeProduitsDisponibles(List<Produit> listeProduitsDisponibles) {
		this.listeProduitsDisponibles = listeProduitsDisponibles;
	}


	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}


	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}
	
	
}
