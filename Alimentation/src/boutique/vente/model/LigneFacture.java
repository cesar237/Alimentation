package boutique.vente.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import boutique.model.Produit;

/**
 * The persistent class for the LigneFacture database table.
 * 
 */
@Entity
@Table(name="LigneFacture")
@NamedQuery(name="LigneFacture.findAll", query="SELECT l FROM LigneFacture l")
public class LigneFacture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@OneToOne
	@JoinColumn(name="codePro")
	private Produit produitBean;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="facture")
	private Facture factureBean;

	private double prixAchat;

	private double prixVente;

	private double qte;

	public LigneFacture() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produit getProduitBean() {
		return produitBean;
	}

	public void setProduitBean(Produit produitBean) {
		this.produitBean = produitBean;
	}

	public Facture getFactureBean() {
		return this.factureBean;
	}

	public void setFactureBean(Facture facture) {
		this.factureBean = facture;
	}

	public double getPrixAchat() {
		return this.prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public double getPrixVente() {
		return this.prixVente;
	}

	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}

	public double getQte() {
		return this.qte;
	}

	public void setQte(double qte) {
		this.qte = qte;
	}

}