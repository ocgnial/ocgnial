package com.ihoover.com.ihoover.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Christophe Grivel
 *
 */
public class SortieDeLaPieceException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(SortieDeLaPieceException.class);

	public SortieDeLaPieceException(String message) {
		super(message);
		logger.fatal(message);
	}
}