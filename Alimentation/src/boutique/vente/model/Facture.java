package boutique.vente.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import admin.model.Gestionnaire;


/**
 * The persistent class for the Facture database table.
 * 
 */
@Entity
@NamedQuery(name="Facture.findAll", query="SELECT f FROM Facture f")
public class Facture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String codePayement;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFacturation;

	private int modePaiement;

	private double montant;

	private double remise;

	//bi-directional many-to-one association to Gestionnaire
	@ManyToOne
	@JoinColumn(name="caissiere")
	private Gestionnaire gestionnaire;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client")
	private Client clientBean;

	//bi-directional many-to-one association to LigneFacture
	@OneToMany(mappedBy="factureBean")
	private List<LigneFacture> ligneFactures;

	public Facture() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodePayement() {
		return this.codePayement;
	}

	public void setCodePayement(String codePayement) {
		this.codePayement = codePayement;
	}

	public Date getDateFacturation() {
		return this.dateFacturation;
	}

	public void setDateFacturation(Date dateFacturation) {
		this.dateFacturation = dateFacturation;
	}

	public int getModePaiement() {
		return this.modePaiement;
	}

	public void setModePaiement(int modePaiement) {
		this.modePaiement = modePaiement;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public double getRemise() {
		return this.remise;
	}

	public void setRemise(double remise) {
		this.remise = remise;
	}

	public Gestionnaire getGestionnaire() {
		return this.gestionnaire;
	}

	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public Client getClientBean() {
		return this.clientBean;
	}

	public void setClientBean(Client clientBean) {
		this.clientBean = clientBean;
	}

	public List<LigneFacture> getLigneFactures() {
		return this.ligneFactures;
	}

	public void setLigneFactures(List<LigneFacture> ligneFactures) {
		this.ligneFactures = ligneFactures;
	}

	public LigneFacture addLigneFacture(LigneFacture ligneFacture) {
		getLigneFactures().add(ligneFacture);
		ligneFacture.setFactureBean(this);

		return ligneFacture;
	}

	public LigneFacture removeLigneFacture(LigneFacture ligneFacture) {
		getLigneFactures().remove(ligneFacture);
		ligneFacture.setFactureBean(null);

		return ligneFacture;
	}

}