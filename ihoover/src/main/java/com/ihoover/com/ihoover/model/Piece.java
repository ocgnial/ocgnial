package com.ihoover.com.ihoover.model;

import java.util.Objects;

/**
 * @author Christophe Grivel
 *
 * Pièce : Une pièce à nettoyer par l'aspirateur iHoover V1.0
 * 
 * 01/04/2022
 */
public class Piece {
	private int nombreColonne; // Nombre de colonne dans la pièce
	private int nombreLigne;   // Nombre de ligne dans la pièce
	
	/**
	 * @param nombreColonne
	 * @param nombreLigne
	 */
	public Piece(int nombreColonne, int nombreLigne) {
		super();
		this.nombreColonne = nombreColonne;
		this.nombreLigne = nombreLigne;
	}

	/**
	 * Donne la taille en nombre de colonne de la pièce.
	 * @return the nombreColonne
	 */
	public int getNombreColonne() {
		return nombreColonne;
	}

	/**
	 * Renseigne la taille de la pièce en nombre de colonnes.
	 * @param nombreColonne the nombreColonne to set
	 */
	public void setNombreColonne(int nombreColonne) {
		this.nombreColonne = nombreColonne;
	}

	/**
	 * Donne la taille en nombre de ligne de la pièce.
	 * @return the nombreLigne
	 */
	public int getNombreLigne() {
		return nombreLigne;
	}

	/**
	 * Renseigne la taille de la pièce en nombre de lignes.
	 * @param nombreLigne the nombreLigne to set
	 */
	public void setNombreLigne(int nombreLigne) {
		this.nombreLigne = nombreLigne;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombreColonne, nombreLigne);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		return nombreColonne == other.nombreColonne && nombreLigne == other.nombreLigne;
	}

	@Override
	public String toString() {
		return "Piece [nombreColonne=" + nombreColonne + ", nombreLigne=" + nombreLigne + "]";
	}
}