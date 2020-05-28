package admin.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the Gestionnaire database table.
 * 
 */
@Entity
@NamedQuery(name="Gestionnaire.findAll", query="SELECT g FROM Gestionnaire g")
public class Gestionnaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private boolean actif;

	private String login;

	private String nom;

	private String pwd;

	// if true, alors c'est le boss
	// if false, alors c'est un caissier
	private boolean type;
	
	public Gestionnaire() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean getType() {
		return this.type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

}