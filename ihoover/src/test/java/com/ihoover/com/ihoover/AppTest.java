package com.ihoover.com.ihoover;

/**
 * @author Christophe Grivel
 * TU Junit : TEST 1
 * 01/04/2022
 */
import org.junit.jupiter.api.Test;
import com.ihoover.com.ihoover.controller.MouvementController;
import com.ihoover.com.ihoover.exceptions.SortieDeLaPieceException;
import com.ihoover.com.ihoover.model.Hoover;
import com.ihoover.com.ihoover.model.Piece;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;

public class AppTest {

	MouvementController mouvementController = new MouvementController();

	// l'aspirateur iHoover de test
	Hoover iHoover1 = new Hoover(5, 5, "N", 1);

	// La pièce de test à aspirer
	Piece piece = new Piece(10, 10);

	// La liste des instructions pour ce test
	List<String> instructions = new ArrayList<String>();

	@Test
	@DisplayName("Test 1 de l'exercice")
	void testTest1() {
		// On charge les instructions
		instructions.add("D");
		instructions.add("A");
		instructions.add("D");
		instructions.add("A");
		instructions.add("D");
		instructions.add("A");
		instructions.add("D");
		instructions.add("A");
		instructions.add("A");

		try {
			iHoover1 = mouvementController.getDestinationHoover(piece, iHoover1, instructions);
		} catch (SortieDeLaPieceException e) {
			e.printStackTrace();
		}

		// Junit en action
		assertEquals(5, iHoover1.getX(), "ok");
		assertEquals(6, iHoover1.getY(), "ok");
		assertEquals("N", iHoover1.getOrientation(), "ok");
	}
}