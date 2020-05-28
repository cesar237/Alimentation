package boutique.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import admin.model.Fournisseur;


/**
 * The persistent class for the Produit database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codePro;

	private boolean actif;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateInsert;

	private String description;

	private String nom;

	private double prixAchat;

	private double prixVente;

	private double qte;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="categorie")
	private Categorie categorieBean;

	//bi-directional many-to-one association to Fournisseur
	@ManyToOne
	@JoinColumn(name="fourn")
	private Fournisseur fournisseur;

	
	public Produit() {
		this("", "", 0, 0, 0, null, null);
	}
	

	public Produit(String description, String nom, double prixAchat, double prixVente, double qte,
			Categorie categorieBean, Fournisseur fournisseur) {
		super();
		this.actif = false;
		this.dateInsert = new Date();
		this.description = description;
		this.nom = nom;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.qte = qte;
		this.categorieBean = categorieBean;
		this.fournisseur = fournisseur;
	}

	public int getCodePro() {
		return this.codePro;
	}

	public void setCodePro(int codePro) {
		this.codePro = codePro;
	}

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Date getDateInsert() {
		return this.dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public Categorie getCategorieBean() {
		return this.categorieBean;
	}

	public void setCategorieBean(Categorie categorieBean) {
		this.categorieBean = categorieBean;
	}

	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

}