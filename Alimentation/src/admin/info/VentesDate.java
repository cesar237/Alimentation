package admin.info;

import java.util.Date;


public class VentesDate extends Ventes{
	private Date dateVente;
	
	public VentesDate(double prixVente, Date dateVente) {
		super(prixVente);
		this.dateVente = dateVente;
	}

	public Date getDateVente() {
		return dateVente;
	}

	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}
}
