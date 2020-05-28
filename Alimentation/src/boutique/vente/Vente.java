package boutique.vente;

import java.util.ArrayList;
import java.util.Date;

import admin.model.Gestionnaire;
import boutique.model.Produit;
import boutique.model.QteException;
import boutique.vente.model.Client;
import boutique.vente.model.Facture;
import boutique.vente.model.LigneFacture;
import core.Core;

public class Vente {

	private Facture facture;
    private Client client;
    private Gestionnaire caissier;
    private ArrayList<LigneFacture> commandes;
    
    
	public Vente(Facture facture, Client client, Gestionnaire caissier) {
		super();
		this.facture = facture;
		this.client = client;
		this.caissier = caissier;
		this.commandes = new ArrayList<LigneFacture>();
	}
	
	public Vente(Client client, Gestionnaire caissier) {
		this.facture = new Facture();
		facture.setClientBean(client);
		facture.setGestionnaire(caissier);
		facture.setDateFacturation(new Date());
		this.commandes = new ArrayList<LigneFacture>();
	}


	public Facture getFacture() {
		return facture;
	}


	public void setFacture(Facture facture) {
		this.facture = facture;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Gestionnaire getCaissier() {
		return caissier;
	}


	public void setCaissier(Gestionnaire caissier) {
		this.caissier = caissier;
	}
	
	public void ajouterCommande(Produit p, double qte) throws QteException {
		double newQte = p.getQte() - qte;
		if (newQte < 0) {
			throw new QteException();
		}
		LigneFacture ligne = new LigneFacture();
		double montant = p.getPrixVente() * qte;
		ligne.setFactureBean(facture);
		ligne.setPrixAchat(montant);
		ligne.setPrixVente(p.getPrixVente());
		ligne.setQte(qte);;
		facture.setMontant(facture.getMontant() + montant);
		ligne.setProduitBean(p);
		
		commandes.add(ligne);
	}
	
	public void supprimmerCommande(Produit p) {
		for (LigneFacture l: commandes) {
			if (l.getProduitBean() == p) {
				facture.setMontant(facture.getMontant()-l.getPrixAchat());
				commandes.remove((LigneFacture) l);
			}
		}
	}
	
	public void modifierCommande(LigneFacture l, double qte) throws QteException{
		if (qte > l.getProduitBean().getQte()) {
			throw new QteException();
		}
		l.setQte(qte);
		facture.setMontant(facture.getMontant() - l.getPrixAchat());
		l.setPrixAchat(qte * l.getPrixVente());
		facture.setMontant(facture.getMontant() + l.getPrixAchat());
	}
	
	public void finaliserVente() throws QteException{
		Core.bd.add((Facture) facture);
		for (LigneFacture l: commandes) {
			Core.stock.reduireQte(l.getProduitBean(), l.getQte());
			Core.bd.add((LigneFacture) l);
		}
	}
    
    
}
