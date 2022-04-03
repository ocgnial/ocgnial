package com.ihoover.com.ihoover.model;

import java.util.List;

/**
 * @author Christophe Grivel
 *
 */
public class Model {
	private Hoover iHoover;
	private Piece laPiece;
	private List<String> instructions;

	public Model() {
		super();
	}

	public Model(Hoover hoover, Piece piece, List<String> instructions) {
		this.iHoover = hoover;
		this.laPiece = piece;
		this.instructions = instructions;
	}

	/**
	 * Donne le Hoover
	 * 
	 * @return the iHoover
	 */
	public Hoover getiHoover() {
		return iHoover;
	}

	/**
	 * @param iHoover the iHoover to set
	 */
	public void setiHoover(Hoover iHoover) {
		this.iHoover = iHoover;
	}

	/**
	 * Donne les caracteristiques de la piece
	 * 
	 * @return the laPiece
	 */
	public Piece getLaPiece() {
		return laPiece;
	}

	/**
	 * @param laPiece the laPiece to set
	 */
	public void setLaPiece(Piece laPiece) {
		this.laPiece = laPiece;
	}

	/**
	 * Donne la liste des instructions.
	 * 
	 * @return the instructions
	 */
	public List<String> getInstructions() {
		return instructions;
	}

	/**
	 * @param instructions the instructions to set
	 */
	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		return "Model [iHoover=" + iHoover + ", laPiece=" + laPiece + "]";
	}
}