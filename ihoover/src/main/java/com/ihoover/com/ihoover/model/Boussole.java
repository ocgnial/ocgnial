package com.ihoover.com.ihoover.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Christophe Grivel
 *
 * La boussole qui trouve l'orientation
 */
public class Boussole {
	// Mab Boussole pour connaitre la prochaine orientation de l'aspirateur :
	Map<String, String> boussole = new HashMap<>();

	/**
	 * Une boussole
	 */
	public Boussole() {
		super();
		// Prédiction de la nouvelle orientations
		boussole.put("DN", "E");
		boussole.put("GN", "W");

		boussole.put("DE", "S");
		boussole.put("GE", "N");

		boussole.put("DS", "W");
		boussole.put("GS", "E");

		boussole.put("DW", "N");
		boussole.put("GW", "S");
	}

	/**
	 * Donne la nouvelle orientation.
	 * 
	 * @return the boussole
	 */
	public Map<String, String> getBoussole() {
		return boussole;
	}
}