package boutique.vente.modele;

public class Client {
    private int id;
    private String nom;
    private String adresse;
    private String tel;
    private float bonus;
    private Boolean actif;

    public Client(int id, String nom, String adresse, String tel, float bonus, Boolean actif) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.actif = actif;
        this.tel = tel;
        this.bonus = bonus;
    }    

    public Client(int id) {
        this(id, "", "", "", 0, false);
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

    /**
     * @return int return the bonus
     */
    public float getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    /**
     * @return Boolean return the actif
     */
    public Boolean isActif() {
        return actif;
    }

    /**
     * @param actif the actif to set
     */
    public void setActif(Boolean actif) {
        this.actif = actif;
    }

}