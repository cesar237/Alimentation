package admin.info;


public class VentesProduit extends Ventes {
	private String produit;

	public VentesProduit(double prixVente, String produit) {
		super(prixVente);
		this.produit = produit;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}
}
