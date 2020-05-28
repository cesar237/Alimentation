package admin.info;

public class VentesCategorie extends Ventes{
	private String categorie;

	public VentesCategorie(double prixVente, String categorie) {
		super(prixVente);
		this.categorie = categorie;
	}
	

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
}
