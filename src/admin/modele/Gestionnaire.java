package admin.modele;

public class Gestionnaire {
    private int id;
    private String nom;
    private int type;
    private String login;
    private String pwd;
    private Boolean actif;

    private static int counter;

    public Gestionnaire(int id, String nom, int type, String login, String pwd, Boolean actif) {
        this.nom = nom;
        this.type = type;
        this.login = login;
        this.pwd = pwd;
        this.actif = actif;
        this.id = id;
    }

    public Gestionnaire(String nom, int type, String login, String pwd) {
        this(counter, nom, type, login, pwd, false);
        counter += 1;
    }

    public static void initialize(int counter) {
        Gestionnaire.counter = counter;
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
     * @return int return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return String return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return String return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
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