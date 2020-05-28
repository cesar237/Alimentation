package core;

import admin.model.Gestionnaire;
import boutique.Boutique;
import boutique.stockage.Stockage;
import database.JpaDatabase;

public class Core {
	public static JpaDatabase bd;
	public static Boutique boutique;
	public static Stockage stock;
	public static Gestionnaire user;
	public static final String project = "Alimentation";
	
	public static void init(Gestionnaire user) {
		Core.user = user;
		System.out.println("Alimentation core 0.01");
		System.out.println("Working with mysql5 : username = cesar, password = <contact the creator>;");
		System.out.println("Require the existence of a database namesd Alimentation, defined in 'ressources' folder...\n");
		
		bd = new JpaDatabase(project);
		boutique = new Boutique(Core.user);
		stock = new Stockage(Core.user);
	}
	
	/*
	public static void main(String[] args) {
		init(new Gestionnaire());
	}
	*/

}
