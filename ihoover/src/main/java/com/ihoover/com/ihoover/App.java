package com.ihoover.com.ihoover;

/**
 * 
 * CHRISTOPHE GRIVEL
 * 
 * IHOOVER EXPERIENCE
 * 
 */

import java.util.ArrayList;
import java.util.List;
import com.ihoover.com.ihoover.model.Hoover;
import com.ihoover.com.ihoover.model.Piece;
import com.ihoover.com.ihoover.controller.Controller;
import view.PanneauCommandeFrame;

public class App {
	public static void main(String[] args) {

		// Interface Utilisateur
		PanneauCommandeFrame iHooverInterface = new PanneauCommandeFrame();

		// La pièce à aspirer
		Piece piece = new Piece(0, 0);

		// l'aspirateur iHoover
		Hoover h1 = new Hoover(0, 0, "N", 1);

		// La liste des instructions
		List<String> instructions = new ArrayList<String>();

		// Déplacement du iHoover par le controller
		@SuppressWarnings("unused")
		Controller controller = new Controller(iHooverInterface, piece, h1, instructions);
	}
}