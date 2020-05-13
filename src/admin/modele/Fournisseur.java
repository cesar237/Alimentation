package admin.modele;

public class Fournisseur {
    // atributs
    private int id;
    private String nom;
    private String adresse;
    private String tel;

    public Fournisseur(int id, String nom, String adresse, String tel) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
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
     * @return String return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return String return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

}