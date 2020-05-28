package boutique.model;

public class QteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QteException() {
		super("Opération impossible : pas assez en stock !");
	}
}
