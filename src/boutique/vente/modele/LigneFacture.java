package boutique.vente.modele;

import boutique.modele.Produit;

public class LigneFacture {
    private int id;
    private Produit produit;
    private Facture facture;
    private float prixAchat;
    private float prixVente;
    private float qte;

    public LigneFacture(int id, Produit produit, float prixAchat, float prixVente, float qte, Facture facture) {
        this.id = id;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.qte = qte;
        this.produit = produit;
        this.facture = facture;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Produit return the produit
     */
    public Produit getProduit() {
        return produit;
    }

    /**
     * @param produit the produit to set
     */
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    /**
     * @return Facture return the facture
     */
    public Facture getFacture() {
        return facture;
    }

    /**
     * @param facture the facture to set
     */
    public void setFacture(Facture facture) {
        this.facture = facture;
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

}