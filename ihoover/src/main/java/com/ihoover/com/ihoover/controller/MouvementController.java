package com.ihoover.com.ihoover.controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ihoover.com.ihoover.exceptions.SortieDeLaPieceException;
import com.ihoover.com.ihoover.model.Boussole;
import com.ihoover.com.ihoover.model.Hoover;
import com.ihoover.com.ihoover.model.Piece;

/**
 * @author Christophe Grivel
 *
 */
public class MouvementController {
	private static final Logger logger = LogManager.getLogger(MouvementController.class);
	static Boussole boussole = new Boussole();

	public Hoover getDestinationHoover(Piece piece, Hoover hoover, List<String> instructions)
			throws SortieDeLaPieceException {
		for (String instruction : instructions) {
			switch (instruction) {
			case "A":
				switch (hoover.getOrientation()) {
				case "N":
					hoover.setY(hoover.getY() + hoover.getVitesse());
					break;
				case "E":
					hoover.setX(hoover.getX() + hoover.getVitesse());
					break;
				case "S":
					hoover.setY(hoover.getY() - hoover.getVitesse());
					break;
				case "W":
					hoover.setX(hoover.getX() - hoover.getVitesse());
					break;
				}
				// Vérifier que les coordonnées de l'aspirateur sont toujours dans la pièce
				verifieDestination(piece, hoover);
				break;
			case "G":
			case "D":
				changeOrientationHoover(instruction + hoover.getOrientation(), hoover);
				break;
			default:
				break;
			}
			logger.info("Votre iHoover est en colonne=" + hoover.getX() + " et en ligne =" + hoover.getY()
					+ " orienté vers =" + hoover.getOrientation());
		}
		return hoover;
	}

	/**
	 * changeOrientationHoover - Effectue un changement d'orientation de
	 * l'aspirateur.
	 * 
	 * @param instruction - Instruction courante
	 * @param hoover      - L'aspirateur en mouvement
	 */
	private static void changeOrientationHoover(String instruction, Hoover hoover) {
		hoover.setOrientation(boussole.getBoussole().get(instruction));
	}

	/**
	 * verifieDestination - Vérifie que l'aspirateur reste dans la pièce.
	 * 
	 * @param piece
	 * @param hoover
	 * @throws SortieDeLaPieceException
	 */
	private static void verifieDestination(Piece piece, Hoover hoover) throws SortieDeLaPieceException {
		if (hoover.getY() > piece.getNombreLigne() || hoover.getX() > piece.getNombreColonne() || hoover.getX() < 0
				|| hoover.getY() < 0) {
			JFrame jFrame = new JFrame();

			String direction = hoover.getOrientation();
			switch (direction) {
			case "N":
				direction = "le Nord";
				break;
			case "E":
				direction = "l'Est";
				break;
			case "S":
				direction = "le Sud";
				break;
			case "W":
				direction = "l'Ouest";
				break;
			}
			logger.info(" => Votre iHoover est arrivé ! iHoover est dans la colonne " + hoover.getX() + " ,la ligne "
					+ hoover.getY() + " et orienté vers " + direction + " !");
			JOptionPane.showMessageDialog(jFrame, " ! ATTENTION ! Votre iHoover est sorti de la pièce ! iHoover est dans la colonne "
					+ hoover.getX() + " ,la ligne " + hoover.getY() + " et orienté vers " + direction + " !");

			throw new SortieDeLaPieceException("Attention.L'aspirateur est sorti de la pièce.");
		}
	}
}