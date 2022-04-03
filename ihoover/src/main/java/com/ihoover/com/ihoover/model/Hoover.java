package com.ihoover.com.ihoover.model;

import java.util.Objects;

/**
 * @author Christophe Grivel
 *
 * Hoover : Un aspirateur iHoover V1.0
 * 01/04/2022
 * 
 */
public class Hoover {
	private int x; 				// Position en colonne dans la piece
	private int y; 				// Position en ligne dans la piece
	private String orientation; // Direction prise par l'aspirateur
	private int vitesse; 	    // Capacité de déplacement
	
	/**
	 * @param x - La colonne occupée par l'aspirateur.
	 * @param y - La ligne occupée par l'aspirateur.
	 * @param orientation - L'orientation de l'aspirateur.
	 * @param vitesse - La vitesse de déplacement de l'aspirateur.
	 */
	public Hoover(int x, int y, String orientation, int vitesse) {
		super();
		this.x = x;
		this.y = y;
		this.orientation = orientation;
		this.vitesse = vitesse;
	}
	
	
	/**
	 * 
	 */
	public Hoover() {
		super();
	}


	/**
	 * Donne la colonne occupée par l'aspirateur.
	 * @return x 
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Renseigne la colonne occupée par l'aspirateur.
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Donne la ligne occupée par l'aspirateur.
	 * @return
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Renseigne la ligne occupée par l'aspirateur.
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Donne l'orientation de l'aspirateur.
	 * @return 
	 */
	public String getOrientation() {
		return this.orientation;
	}
	
	/**
	 * Renseigne l'orientation de l'aspirateur.
	 * @param orientation
	 */
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	/**
	 * Donne la vitesse de déplacement de l'aspirateur.
	 * @return
	 */
	public int getVitesse() {
		return this.vitesse;
	}
	
	/**
	 * Renseigne la vitesse de déplacement de l'aspirateur.
	 * @param vitesse
	 */
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(orientation, vitesse, x, y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hoover other = (Hoover) obj;
		return Objects.equals(orientation, other.orientation) && vitesse == other.vitesse && x == other.x
				&& y == other.y;
	}

	@Override
	public String toString() {
		return "Hoover [x=" + x + ", y=" + y + ", Orientation=" + orientation + ", vitesse=" + vitesse + "]";
	}
}