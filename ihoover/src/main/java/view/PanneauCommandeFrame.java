package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;

/**
 * @author Christophe Grivel
 * 
 *         INTERFACE UTILISATEUR IHOOVER
 *
 */
public class PanneauCommandeFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	JPanel panneauDeCommande = new JPanel();
	GridBagLayout layout = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();

	MaskFormatter formatter = null;

	JTextField hauteurPiece = new JTextField();
	JTextField largeurPiece = new JFormattedTextField(formatter);
	JTextField ligneDepart = new JTextField();
	JTextField colonneDepart = new JTextField();

	JTextArea lesInstructions = new JTextArea();

	JButton depart = new JButton("Go iHoover");

	GridLayout panneauDeCommandeGrid = new GridLayout(10, 1);
	GridLayout dimensionGrid = new GridLayout(2, 4);
	GridLayout departGrid = new GridLayout(2, 4);
	GridLayout orientationGrid = new GridLayout(3, 3);
	GridLayout instructionGrid = new GridLayout(1, 2);

	// Création des boutons radio pour l'orientation
	ButtonGroup group = new ButtonGroup();
	JRadioButton radio1 = new JRadioButton("N", true);
	JRadioButton radio2 = new JRadioButton("E", false);
	JRadioButton radio3 = new JRadioButton("S", false);
	JRadioButton radio4 = new JRadioButton("W", false);

	// Les panels de l'IHM
	JPanel dimensionPiecePanel = new JPanel();
	JPanel departPanel = new JPanel();
	JPanel orientationPanel = new JPanel();
	JPanel instructionPanel = new JPanel();
	JPanel boutonPanel = new JPanel();

	// Les labels
	JLabel pieceLabel = new JLabel("Quel sont les dimensions de la pièces ?");
	JLabel largeurPieceLabel = new JLabel("Largeur de la pièce :");
	JLabel hauteurPieceLabel = new JLabel("Hauteur de la pièce :");

	JLabel pointDeDepartLabel = new JLabel("Quel est le point de départ de votre iHoover ?");
	JLabel ligneDepartLabel = new JLabel("Numéro de la ligne de départ :");
	JLabel colonneDepartLabel = new JLabel("Numéro de la colonne de départ :");

	JLabel orientationLabel = new JLabel("Orientation de départ :");

	JLabel instructionsLabel = new JLabel("Instructions de déplacement (A=Avance, G=Gauchee ,D=Droite) ?");

	public PanneauCommandeFrame() {
		depart.setEnabled(false);
		this.panneauDeCommande.setLayout(layout);
		largeurPiece.setText("0");
		hauteurPiece.setText("0");
		ligneDepart.setText("0");
		colonneDepart.setText("0");
		dimensionPiecePanel.setLayout(dimensionGrid);
		departPanel.setLayout(departGrid);
		orientationPanel.setLayout(layout);
		instructionPanel.setLayout(instructionGrid);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 500, 700);
		this.setTitle("IHoover Interface");

		try {
			formatter = new MaskFormatter("##########");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Dimension de la Frame
		Dimension dim = new Dimension(10, 20);
		largeurPiece.setMaximumSize(dim);
		
		// CONTROLE DES ENTREES
	
		largeurPiece.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			public void insertUpdate(DocumentEvent e) {
				changed();
			}

			public void changed() {
				if (largeurPiece.getText().isEmpty() || hauteurPiece.getText().isEmpty()
						|| ligneDepart.getText().isEmpty() || colonneDepart.getText().isEmpty()
						|| lesInstructions.getText().isEmpty()
						|| Integer.parseInt(colonneDepart.getText()) > Integer.parseInt(largeurPiece.getText())
						|| Integer.parseInt(ligneDepart.getText()) > Integer.parseInt(hauteurPiece.getText())) {
					depart.setEnabled(false);
				} else {
					depart.setEnabled(true);
				}

			}
		});
		largeurPiece.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		hauteurPiece.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			public void insertUpdate(DocumentEvent e) {
				changed();
			}

			public void changed() {
				if (largeurPiece.getText().isEmpty() || hauteurPiece.getText().isEmpty()
						|| ligneDepart.getText().isEmpty() || colonneDepart.getText().isEmpty()
						|| lesInstructions.getText().isEmpty()
						|| Integer.parseInt(colonneDepart.getText()) > Integer.parseInt(largeurPiece.getText())
						|| Integer.parseInt(ligneDepart.getText()) > Integer.parseInt(hauteurPiece.getText())) {
					depart.setEnabled(false);
				} else {
					depart.setEnabled(true);
				}

			}
		});
		hauteurPiece.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});

		ligneDepart.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		ligneDepart.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			public void insertUpdate(DocumentEvent e) {
				changed();
			}

			public void changed() {
				if (largeurPiece.getText().isEmpty() || hauteurPiece.getText().isEmpty()
						|| ligneDepart.getText().isEmpty() || colonneDepart.getText().isEmpty()
						|| lesInstructions.getText().isEmpty()
						|| Integer.parseInt(colonneDepart.getText()) > Integer.parseInt(largeurPiece.getText())
						|| Integer.parseInt(ligneDepart.getText()) > Integer.parseInt(hauteurPiece.getText())) {
					depart.setEnabled(false);
				} else {
					depart.setEnabled(true);
				}

			}
		});
		colonneDepart.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			public void insertUpdate(DocumentEvent e) {
				changed();
			}

			public void changed() {
				if (largeurPiece.getText().isEmpty() || hauteurPiece.getText().isEmpty()
						|| ligneDepart.getText().isEmpty() || colonneDepart.getText().isEmpty()
						|| lesInstructions.getText().isEmpty()
						|| Integer.parseInt(colonneDepart.getText()) > Integer.parseInt(largeurPiece.getText())
						|| Integer.parseInt(ligneDepart.getText()) > Integer.parseInt(hauteurPiece.getText())) {
					depart.setEnabled(false);
				} else {
					depart.setEnabled(true);
				}

			}
		});
		lesInstructions.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			public void insertUpdate(DocumentEvent e) {
				changed();
			}

			public void changed() {
				if (largeurPiece.getText().isEmpty() || hauteurPiece.getText().isEmpty()
						|| ligneDepart.getText().isEmpty() || colonneDepart.getText().isEmpty()
						|| lesInstructions.getText().isEmpty()
						|| Integer.parseInt(colonneDepart.getText()) > Integer.parseInt(largeurPiece.getText())
						|| Integer.parseInt(ligneDepart.getText()) > Integer.parseInt(hauteurPiece.getText())) {
					depart.setEnabled(false);
				} else {
					depart.setEnabled(true);
				}

			}
		});
		colonneDepart.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		lesInstructions.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c != 'A') && (c != 'a') && (c != 'D') && (c != 'd') & (c != 'G') & (c != 'g')
						|| (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		// Définir les boutons
		boutonPanel.add(depart);

		// Ajouter les boutons au frame
		dimensionPiecePanel.add(largeurPieceLabel);
		dimensionPiecePanel.add(largeurPiece);
		dimensionPiecePanel.add(hauteurPieceLabel);
		dimensionPiecePanel.add(hauteurPiece);

		departPanel.add(colonneDepartLabel);
		departPanel.add(colonneDepart);
		departPanel.add(ligneDepartLabel);
		departPanel.add(ligneDepart);

		group.add(radio1);
		group.add(radio2);
		group.add(radio3);
		group.add(radio4);

		// Ajouter les boutons au frame
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weighty = 3;

		gbc.gridx = 2;
		gbc.gridy = 0;
		orientationPanel.add(radio1, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		orientationPanel.add(radio4, gbc);

		gbc.gridx = 3;
		gbc.gridy = 1;
		orientationPanel.add(radio2, gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 2;

		orientationPanel.add(radio3, gbc);

		DocumentFilter f = new UppercaseJTextField();
		AbstractDocument doc = (AbstractDocument) lesInstructions.getDocument();
		doc.setDocumentFilter(f);

		instructionPanel.add(lesInstructions);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.panneauDeCommande.add(pieceLabel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;

		panneauDeCommande.add(dimensionPiecePanel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;

		panneauDeCommande.add(pointDeDepartLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panneauDeCommande.add(departPanel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;

		panneauDeCommande.add(orientationLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 6;

		panneauDeCommande.add(orientationPanel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		panneauDeCommande.add(instructionsLabel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 8;

		panneauDeCommande.add(instructionPanel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 9;

		panneauDeCommande.add(depart, gbc);
		this.add(panneauDeCommande);
		this.setVisible(true);
	}

	/**
	 * Recupere le nombre de ligne de la pièce
	 * @return
	 */
	public int getNombreLigne() {
		return (hauteurPiece.getText().isEmpty() ? 0 : Integer.parseInt(hauteurPiece.getText()));
	}

	/**
	 * Recupere le nombre de colonnne de la pièce
	 * @return
	 */
	public int getNombreColonne() {
		return (largeurPiece.getText().isEmpty() ? 0 : Integer.parseInt(largeurPiece.getText()));
	}

	/**
	 *
 	 * Recupere la colonne de départ de l'aspirateur
	 * @return
	 */
	public int getPlaceXHoover() {
		return (colonneDepart.getText().isEmpty() ? 0 : Integer.parseInt(colonneDepart.getText()));
	}

	/**
	 * Recupere la ligne de départ de l'aspirateur
	 * @return
	 */
	public int getPlaceYHoover() {
		return (ligneDepart.getText().isEmpty() ? 0 : Integer.parseInt(ligneDepart.getText()));
	}

	/**
	 * Recupere les instructions de l'utilisateur
	 * @return
	 */
	public List<String> getLesInstructions() {
		List<String> listeDesInstructions = new ArrayList<String>();
		int curseur = 0;
		while (curseur < (lesInstructions.getText().length())) {
			listeDesInstructions.add(lesInstructions.getText().substring(curseur, curseur + 1));
			curseur++;

		}
		return listeDesInstructions;
	}

	/**
	 * Permet de récuperer l'orientation choisie
	 * @return
	 */
	public String getOrientationHoover() {
		String orientation = "";
		if (radio1.isSelected())
			orientation = "N";
		if (radio2.isSelected())
			orientation = "E";
		if (radio3.isSelected())
			orientation = "S";
		if (radio4.isSelected())
			orientation = "W";
		return orientation;
	}

	/**
	 * Donne le controle sur le bouton de Go
	 * @return
	 */
	public JButton getDepartButton() {
		return depart;
	}
}