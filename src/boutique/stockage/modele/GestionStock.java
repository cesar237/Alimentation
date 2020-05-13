package boutique.stockage.modele;

import java.sql.Date;

import admin.modele.Gestionnaire;
import boutique.modele.Produit;

public class GestionStock {
    private int id;
    private float qte;
    private Produit produit;
    private Gestionnaire gestionnaire;
    private Date dateStockage;
    private int operation;

    public GestionStock(int id, float qte, Produit produit,
                        Gestionnaire gestionnaire, Date dateStockage, int operation) {
        
        this.id = id;
        this.qte = qte;
        this.produit = produit;
        this.gestionnaire = gestionnaire;
        this.dateStockage = dateStockage;
        this.operation = operation;
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
     * @return Gestionnaire return the gestionnaire
     */
    public Gestionnaire getGestionnaire() {
        return gestionnaire;
    }

    /**
     * @param gestionnaire the gestionnaire to set
     */
    public void setGestionnaire(Gestionnaire gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    /**
     * @return Date return the dateStockage
     */
    public Date getDateStockage() {
        return dateStockage;
    }

    /**
     * @param dateStockage the dateStockage to set
     */
    public void setDateStockage(Date dateStockage) {
        this.dateStockage = dateStockage;
    }

    /**
     * @return int return the operation
     */
    public int getOperation() {
        return operation;
    }

    /**
     * @param operation the operation to set
     */
    public void setOperation(int operation) {
        this.operation = operation;
    }

}