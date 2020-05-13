package boutique.vente.modele;

import java.sql.Date;
import java.util.ArrayList;
import admin.modele.Gestionnaire;

public class Facture {

    private int id;
    private Date dateFacturation;
    private int codePaiement;
    private float remise;
    private float montant;
    private int modePaiement;
    private Gestionnaire caissier;
    private Client client;
    private ArrayList<LigneFacture> lignesFacture;

    public Facture(int id, Date dateFacturation, int codePaiement, float remise, 
                    float montant, int modePaiement, Gestionnaire caissier, Client client) {
        this.id = id;
        this.dateFacturation = dateFacturation;
        this.codePaiement = codePaiement;
        this.remise = remise;
        this.modePaiement = modePaiement;
        this.montant = montant;
        this.caissier = caissier;
        this.client = client;
        this.lignesFacture = new ArrayList<LigneFacture>();
    }

    public void imprimer() {
        
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
     * @return Date return the dateFacturation
     */
    public Date getDateFacturation() {
        return dateFacturation;
    }

    /**
     * @param dateFacturation the dateFacturation to set
     */
    public void setDateFacturation(Date dateFacturation) {
        this.dateFacturation = dateFacturation;
    }

    /**
     * @return int return the codePaiement
     */
    public int getCodePaiement() {
        return codePaiement;
    }

    /**
     * @param codePaiement the codePaiement to set
     */
    public void setCodePaiement(int codePaiement) {
        this.codePaiement = codePaiement;
    }

    /**
     * @return float return the remise
     */
    public float getRemise() {
        return remise;
    }

    /**
     * @param remise the remise to set
     */
    public void setRemise(float remise) {
        this.remise = remise;
    }

    /**
     * @return float return the montant
     */
    public float getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(float montant) {
        this.montant = montant;
    }

    /**
     * @return int return the modePaiement
     */
    public int getModePaiement() {
        return modePaiement;
    }

    /**
     * @param modePaiement the modePaiement to set
     */
    public void setModePaiement(int modePaiement) {
        this.modePaiement = modePaiement;
    }

    /**
     * @return Gestionnaire return the caissier
     */
    public Gestionnaire getCaissier() {
        return caissier;
    }

    /**
     * @param caissier the caissier to set
     */
    public void setCaissier(Gestionnaire caissier) {
        this.caissier = caissier;
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
     * @return ArrayList<LigneFacture> return the lignesFacture
     */
    public ArrayList<LigneFacture> getLignesFacture() {
        return lignesFacture;
    }

    /**
     * @param lignesFacture the lignesFacture to set
     */
    public void setLignesFacture(ArrayList<LigneFacture> lignesFacture) {
        this.lignesFacture = lignesFacture;
    }

    public void addLigneFacture(LigneFacture ligne) {
        lignesFacture.add(ligne);
    }

}