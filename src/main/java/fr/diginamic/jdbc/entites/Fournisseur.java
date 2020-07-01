/**
 * 
 */
package fr.diginamic.jdbc.entites;

/**
 * Classe représentant un fournisseur avec ses attributs id et nom.
 * 
 * @author souleymaneTHIAM
 *
 */
public class Fournisseur {
	/** id du fournisseur */
	private int id;
	/** nom du fournisseur */
	private String nom;

	/**
	 * 
	 */
	public Fournisseur() {
	}

	/**
	 * @param id
	 * @param nom
	 */
	public Fournisseur(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
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

	@Override
	public String toString() {
		return "Fournisseur id = " + getId() + ", Nom = " + getNom();
	}

}
