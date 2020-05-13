package boutique.modele;

import java.sql.Date;

import admin.modele.Fournisseur;

public class Produit {
    private int codePro;
    private String nom;
    private float prixVente;
    private float prixAchat;
    private float qte;
    private String description;
    private Fournisseur fournisseur;
    private Date dateInsert;
    private int actif;
    private Categorie categorie;

    public Produit(int codePro, String nom, float prixVente, 
                    float prixAchat, float qte, String description, 
                    Fournisseur fournisseur, Date dateInsert, int actif,
                     Categorie categorie) {
        this.codePro = codePro;
        this.nom = nom;
        this.actif = actif;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.qte = qte;
        this.description = description;
        this.fournisseur = fournisseur;
        this.dateInsert = dateInsert;
        this.categorie = categorie;
    }

    /**
     * @return int return the codePro
     */
    public int getCodePro() {
        return codePro;
    }

    /**
     * @param codePro the codePro to set
     */
    public void setCodePro(int codePro) {
        this.codePro = codePro;
    }

    /**
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return float return the prixVente
     */
    public float getPrixVente() {
        return prixVente;
    }

    /**
     * @param prixVente the prixVente to set
     */
    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }

    /**
     * @return float return the prixAchat
     */
    public float getPrixAchat() {
        return prixAchat;
    }

    /**
     * @param prixAchat the prixAchat to set
     */
    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }

    /**
     * @return float return the qte
     */
    public float getQte() {
        return qte;
    }

    /**
     * @param qte the qte to set
     */
    public void setQte(float qte) {
        this.qte = qte;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Fournisseur return the fournisseur
     */
    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    /**
     * @param fournisseur the fournisseur to set
     */
    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    /**
     * @return Date return the dateInsert
     */
    public Date getDateInsert() {
        return dateInsert;
    }

    /**
     * @param dateInsert the dateInsert to set
     */
    public void setDateInsert(Date dateInsert) {
        this.dateInsert = dateInsert;
    }

    /**
     * @return int return the actif
     */
    public int getActif() {
        return actif;
    }

    /**
     * @param actif the actif to set
     */
    public void setActif(int actif) {
        this.actif = actif;
    }

    /**
     * @return Categorie return the categorie
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

}