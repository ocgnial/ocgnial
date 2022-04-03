package com.ihoover.com.ihoover.controller;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ihoover.com.ihoover.exceptions.SortieDeLaPieceException;
import com.ihoover.com.ihoover.model.Hoover;
import com.ihoover.com.ihoover.model.Model;
import com.ihoover.com.ihoover.model.Piece;
import view.PanneauCommandeFrame;

/**
 * @author Christophe Grivel
 * 
 *         Controlleur de l'application iHoover
 */
public class Controller {
	private static final Logger logger = LogManager.getLogger(Controller.class);

	private PanneauCommandeFrame view;
	private Model monModel;
	private MouvementController mouvementController = new MouvementController();

	public Controller(PanneauCommandeFrame view, Piece model, Hoover hoover, List<String> instructions) {
		this.view = view;
		this.monModel = new Model(hoover, model, instructions);
		setUpViewEvents();
	}

	private void setUpViewEvents() {
		view.getDepartButton().addActionListener(e -> mouvementIHoover());
		view.setVisible(true);
	}

	private Object mouvementIHoover() {
		Hoover hooverEnMouvement = new Hoover();
		try {
			// Mapping des datas de la vue.
			this.monModel.getLaPiece().setNombreLigne(view.getNombreLigne());
			this.monModel.getLaPiece().setNombreColonne(view.getNombreColonne());
			this.monModel.getiHoover().setX(view.getPlaceXHoover());
			this.monModel.getiHoover().setY(view.getPlaceYHoover());
			this.monModel.getiHoover().setVitesse(1);
			this.monModel.getiHoover().setOrientation(view.getOrientationHoover());
			this.monModel.setInstructions(view.getLesInstructions());

			hooverEnMouvement = mouvementController.getDestinationHoover(monModel.getLaPiece(), monModel.getiHoover(),
					monModel.getInstructions());

		} catch (SortieDeLaPieceException e) {
			logger.error("Erreur lors du déplacement de l'aspirateur iHoover." + e);
		}
		
		if (hooverEnMouvement.getOrientation() != null) {
			JFrame jFrame = new JFrame();
			String direction = hooverEnMouvement.getOrientation();
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
			logger.log(Level.INFO,"Votre iHoover est arrivé ! iHoover est dans la colonne " + hooverEnMouvement.getX()
					+ " ,la ligne " + hooverEnMouvement.getY() + " et orienté vers " + direction + " !");
			JOptionPane.showMessageDialog(jFrame,
					"Votre iHoover est arrivé ! iHoover est dans la colonne " + hooverEnMouvement.getX() + " ,la ligne "
							+ hooverEnMouvement.getY() + " et orienté vers " + direction + " !");
		}
		return hooverEnMouvement;
	}
}