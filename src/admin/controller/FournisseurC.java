package admin.controlleur;

import admin.modele.Fournisseur;

public class FournisseurC {
    public void ajouter(Fournisseur frn) {

    }

    public void supprimmer(Fournisseur frn) {

    }

    public void modifierAdresse(Fournisseur frn, String adresse) {
        frn.setAdresse(adresse);
    }

    public void modifierTel(Fournisseur frn, String tel) {
        frn.setTel(tel);
    }

    public void modifierNom(Fournisseur frn, String nom) {
        frn.setNom(nom);
    }
}