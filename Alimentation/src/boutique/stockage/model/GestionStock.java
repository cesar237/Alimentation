package boutique.stockage.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import admin.model.Gestionnaire;
import boutique.model.Produit;


/**
 * The persistent class for the GestionStock database table.
 * 
 */
@Entity
@NamedQuery(name="GestionStock.findAll", query="SELECT g FROM GestionStock g")
public class GestionStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateStock;

	private int operation;

	private double qte;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="codePro")
	private Produit produit;

	//bi-directional many-to-one association to Gestionnaire
	@ManyToOne
	@JoinColumn(name="gestionnaire")
	private Gestionnaire gestionnaireBean;

	public GestionStock() {
	}

	public GestionStock(int operation, double qte, Produit produit, Gestionnaire gestionnaireBean) {
		super();
		this.dateStock = new Date();
		this.operation = operation;
		this.qte = qte;
		this.produit = produit;
		this.gestionnaireBean = gestionnaireBean;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateStock() {
		return this.dateStock;
	}

	public void setDateStock(Date dateStock) {
		this.dateStock = dateStock;
	}

	public int getOperation() {
		return this.operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public double getQte() {
		return this.qte;
	}

	public void setQte(double qte) {
		this.qte = qte;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Gestionnaire getGestionnaireBean() {
		return this.gestionnaireBean;
	}

	public void setGestionnaireBean(Gestionnaire gestionnaireBean) {
		this.gestionnaireBean = gestionnaireBean;
	}

}