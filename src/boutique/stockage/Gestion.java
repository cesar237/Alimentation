package boutique.stockage;


import admin.modele.Gestionnaire;
import boutique.modele.Produit;


public class Gestion {
    
    private Gestionnaire gestionnaire;
    private int operation;

    public Gestion(Gestionnaire gestionnaire, int operation) {
        this.gestionnaire = gestionnaire;
        this.operation = operation;
    }

    public int getOperation() {
        return operation;
    }

    /**
     * @return Gestionnaire return the gestionnaire
     */
    public Gestionnaire getGestionnaire() {
        return gestionnaire;
    }

    public void ajouterProduit(Produit prd) {
        
    }

    public void supprimmerProduit(Produit prd) {

    }

    public void modifierQte(Produit prd, float qte) {
        prd.setQte(qte);
    }

    public void activer(Produit prd) {
        prd.setActif(1);
    }

    public void desactiver(Produit prd) {
        prd.setActif(0);
    }

    public void modifierPrixVente(Produit prd, float prixVente) {
        prd.setPrixVente(prixVente);
    }

    public void modifierPrixAchat(Produit prd, float prixAchat) {
        prd.setPrixAchat(prixAchat);
    }

    public void modifierDescription(Produit prd, String desc) {
        prd.setDescription(desc);
    }

    public void finaliserOperation() {
        
    }
}