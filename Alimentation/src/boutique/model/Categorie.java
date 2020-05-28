package boutique.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * The persistent class for the Categorie database table.
 * 
 */

@Entity
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nom;

	public Categorie() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}