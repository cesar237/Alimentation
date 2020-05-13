package boutique.vente;

import admin.modele.Gestionnaire;
import boutique.vente.modele.Client;
import boutique.vente.modele.Facture;


public class Vente {
    

    private Facture facture;
    private Client client;
    private Gestionnaire caissier;

    public Vente(Facture facture, Client client, Gestionnaire caissier) {
        this.caissier = caissier;
        this.client = client;
        this.facture = facture;
    }

    public Vente(Facture facture, Gestionnaire caissier) {
        this(facture, null, caissier);
    }

    public void ajouterCommande() {

    }

    public void supprimmerCommande() {

    }

    public void finaliserVente() {

    }

    public void modifierCommande() {
        
    }

    /**
     * @return Facture return the facture
     */
    public Facture getFacture() {
        return facture;
    }

    /**
     * @return Client return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return Gestionnaire return the caissier
     */
    public Gestionnaire getCaissier() {
        return caissier;
    }

}