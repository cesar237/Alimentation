package admin.controlleur;

import admin.modele.Gestionnaire;

public class Employe {
    public void ajouter(Gestionnaire gest) {

    }

    public void supprimmer(Gestionnaire gest) {

    }

    public void activer(Gestionnaire gest) {
        gest.setActif(true);
    }

    public void desactiver(Gestionnaire gest) {
        gest.setActif(false);
    }

    public Boolean etat(Gestionnaire gest) {
        return gest.isActif();
    }

    public void modifierNom(Gestionnaire gest, String nom) {
        gest.setNom(nom);
    }

    public void modifierLogin(Gestionnaire gest, String login) {
        gest.setLogin(login);
    }

    public void modifierPwd(Gestionnaire gest, String pwd) {
        gest.setPwd(pwd);
    }

    public void modifierType(Gestionnaire gest, int type) {
        gest.setType(type);
    }
}