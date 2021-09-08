package dienstag;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import java.awt.Color;

public class Messreihe extends JFrame {

	private JPanel contentPane;
	private JTextField tfAnz;
	private JTextField tfZahl;
	private JTextField tfStelle;
	private JTextField tfZahlNeu;
	private JLabel lblZahlen;
	private JLabel lblMaximalwert;
	private JLabel lblMinimalwert;
	private JLabel lblMittelwert;
	private JLabel lblMesswertEdit;
	private JLabel lblMesswertStelle;
	private JLabel lblMesswert;
	private JLabel lblQuestion;
	private JLabel lblAusgabe;

	private JButton btnEdit;
	private JButton btnOkAnz;
	private JButton btnOkZahl;
	private JButton btnAuswerten;
	private JButton btnSave;
	private JButton btnNeueEingabe;

	int i = 0;
	private double[] arr;
	private int arrSize;
	private int position;
	private double messwert;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Messreihe frame = new Messreihe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Messreihe() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Textfelder ------------------------------------------

		tfAnz = new JTextField();
		tfAnz.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnOkExec();
				}
			}
		});
		tfAnz.setColumns(10);
		tfAnz.setBounds(415, 10, 93, 20);
		contentPane.add(tfAnz);

		tfStelle = new JTextField();
		tfStelle.setVisible(false);
		tfStelle.setColumns(10);
		tfStelle.setBounds(336, 55, 69, 20);
		contentPane.add(tfStelle);

		tfZahl = new JTextField();
		tfZahl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnOkZahlExec();
				}
			}
		});
		tfZahl.setVisible(false);
		tfZahl.setColumns(10);
		tfZahl.setBounds(415, 35, 93, 20);
		contentPane.add(tfZahl);

		tfZahlNeu = new JTextField();
		tfZahlNeu.setVisible(false);
		tfZahlNeu.setColumns(10);
		tfZahlNeu.setBounds(336, 80, 69, 20);
		contentPane.add(tfZahlNeu);

		// Label -----------------------------------------------

		lblQuestion = new JLabel("Wieviele Messwerte sollen eingegeben werden?");
		lblQuestion.setBounds(10, 10, 395, 14);
		contentPane.add(lblQuestion);

		lblZahlen = new JLabel("Messwert: ");
		lblZahlen.setVisible(false);
		lblZahlen.setBounds(10, 35, 189, 14);
		contentPane.add(lblZahlen);

		lblMaximalwert = new JLabel("Maximalwert");
		lblMaximalwert.setVisible(false);
		lblMaximalwert.setBounds(10, 157, 498, 14);
		contentPane.add(lblMaximalwert);

		lblMinimalwert = new JLabel("Minimalwert");
		lblMinimalwert.setVisible(false);
		lblMinimalwert.setBounds(10, 182, 498, 14);
		contentPane.add(lblMinimalwert);

		lblMittelwert = new JLabel("Mittelwert");
		lblMittelwert.setVisible(false);
		lblMittelwert.setBounds(10, 207, 498, 14);
		contentPane.add(lblMittelwert);

		lblMesswertEdit = new JLabel("Messwerte: ");
		lblMesswertEdit.setVisible(false);
		lblMesswertEdit.setBounds(10, 61, 189, 14);
		contentPane.add(lblMesswertEdit);

		lblMesswertStelle = new JLabel(".Messwert");
		lblMesswertStelle.setVisible(false);
		lblMesswertStelle.setBounds(415, 58, 93, 14);
		contentPane.add(lblMesswertStelle);

		lblMesswert = new JLabel("Wert:");
		lblMesswert.setVisible(false);
		lblMesswert.setBounds(10, 86, 189, 14);
		contentPane.add(lblMesswert);

		// BUTTON ----------------------------------------------

		btnEdit = new JButton("Bearbeiten");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messwertBearbeiten();
			}
		});
		btnEdit.setVisible(false);
		btnEdit.setBounds(518, 58, 117, 23);
		contentPane.add(btnEdit);

		btnOkAnz = new JButton("Ok");
		btnOkAnz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOkExec();
			}
		});
		btnOkAnz.setBounds(518, 6, 117, 23);
		contentPane.add(btnOkAnz);

		btnOkZahl = new JButton("Ok");
		btnOkZahl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOkZahlExec();
			}
		});
		btnOkZahl.setVisible(false);
		btnOkZahl.setBounds(518, 32, 117, 23);
		contentPane.add(btnOkZahl);

		btnSave = new JButton("Speichern");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wertSpeichern();
			}
		});
		btnSave.setVisible(false);
		btnSave.setBounds(518, 83, 117, 23);
		contentPane.add(btnSave);

		btnAuswerten = new JButton("Messreihe Auswerten");
		btnAuswerten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				outputArray();
				btnNeueEingabe.requestFocus();
			}
		});
		btnAuswerten.setVisible(false);
		btnAuswerten.setBounds(10, 115, 625, 23);
		contentPane.add(btnAuswerten);

		btnNeueEingabe = new JButton("RESET");
		btnNeueEingabe.setBackground(Color.MAGENTA);
		btnNeueEingabe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					resetProc();
				}
			}
		});
		btnNeueEingabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetProc();
			}
		});
		btnNeueEingabe.setVisible(false);
		btnNeueEingabe.setBounds(504, 232, 131, 33);
		contentPane.add(btnNeueEingabe);

		table = new JTable();
		table.setBounds(10, 232, 1, 1);
		contentPane.add(table);

		lblAusgabe = new JLabel("Alle Werte:");
		lblAusgabe.setVisible(false);
		lblAusgabe.setBounds(10, 232, 395, 14);
		contentPane.add(lblAusgabe);

	}

	// METHODEN --------------------------------------------
	// METHODEN
	// --------------------------------------------------------------------------------------
	// Array
	private void createArray() {
		arr = new double[arrSize];
	}

	private int getArraySize() {
		int size = 0;
		if (tfAnz.getText().equals("")) {
			size = 0;
		} else {
			
			size = Integer.parseInt(tfAnz.getText());
			
			}
		return size;
	}

	// Sichtbarkeit steuern ----------------------
	private void setFirstLineVisible(boolean a) {
		if (a == false) {
			lblQuestion.setVisible(false);
			tfAnz.setVisible(false);
			btnOkAnz.setVisible(false);
			btnNeueEingabe.setVisible(true);
		} else {
			lblQuestion.setVisible(true);
			tfAnz.setVisible(true);
			btnOkAnz.setVisible(true);
		}
	}

	private void setSecondLineVisible(boolean a) {
		if (a == false) {
			lblZahlen.setVisible(false);
			tfZahl.setVisible(false);
			btnOkZahl.setVisible(false);
		} else {
			lblZahlen.setVisible(true);
			tfZahl.setVisible(true);
			btnOkZahl.setVisible(true);
		}
	}

	private void setThirdLineVisible(boolean a) {
		if (a == false) {
			lblMesswertEdit.setVisible(false);
			tfStelle.setVisible(false);
			lblMesswertStelle.setVisible(false);
			btnEdit.setVisible(false);
			lblMesswert.setVisible(false);
			tfZahlNeu.setVisible(false);
			btnSave.setVisible(false);
			btnAuswerten.setVisible(false);
			lblMaximalwert.setVisible(false);
			lblMinimalwert.setVisible(false);
			lblMittelwert.setVisible(false);
			lblAusgabe.setVisible(false);
		} else {
			lblMesswertEdit.setVisible(true);
			tfStelle.setVisible(true);
			lblMesswertStelle.setVisible(true);
			btnEdit.setVisible(true);
			lblMesswert.setVisible(true);
			tfZahlNeu.setVisible(true);
			btnSave.setVisible(true);
			btnAuswerten.setVisible(true);
			lblMaximalwert.setVisible(true);
			lblMinimalwert.setVisible(true);
			lblMittelwert.setVisible(true);
			lblAusgabe.setVisible(true);
		}
	}

	// Kern Methoden
	// --------------------------------------------------------------------
	// input
	private boolean addNumberToArray() {
		// alle Eingaben (i kann nicht > arrSize werden, trotzdem else return
		// erforderlich, da boolean Methode
		if (i < arrSize) {
			try {
				arr[i] = Double.parseDouble(tfZahl.getText().replace(",", "."));
				i++;
				tfZahl.requestFocus();
				tfZahl.selectAll();
				if (arrSize == i) { // vorletzte Eingabe
					JOptionPane.showMessageDialog(null, "Array Ende erreicht, Ausgabe erfolgt");
					setSecondLineVisible(false);
					setThirdLineVisible(true);
					return true;
				} else {
					return false; // bis vorletzte Eingabe
				}
			} catch (Exception e) {
				// Fehler auslesen und ausgeben
				JOptionPane.showMessageDialog(null, "Eingabe muss ganze Zahl sein!" + "\n" + e.getMessage());
				tfZahl.requestFocus();
				tfZahl.selectAll();
				return false;
			}
		} else {
			return true;
		}
	}

	// output
	private void outputArray() {
		lblAusgabe.setText("");
		lblMinimalwert.setText("Minimalwert: " + getMinimalwer());
		lblMittelwert.setText("Mittelwert: " + getMittelwert());
		lblMaximalwert.setText("Maximalwert: " + getMaximalwert());
		for (double tempNumber : arr) {
			lblAusgabe.setText(lblAusgabe.getText() + "  "+ tempNumber);
		}
	}

	private double getMaximalwert() {
		// Maximum bestimmen
		double max = arr[0];
		for (i = 0; i < arr.length; i++)
			if (max < arr[i])
				max = arr[i];
		return max;
	}

	private double getMittelwert() {
		double mittel = 0; // Summe bilden
		for (i = 0; i < arr.length; i++)
			mittel += arr[i];
		mittel /= arr.length;
		return mittel;
	}

	private double getMinimalwer() {
		// Minimum bestimmen
		double min = arr[0];
		for (i = 0; i < arr.length; i++)
			if (min > arr[i])
				min = arr[i];
		return min;
	}

	private void messwertBearbeiten() {
		try {
			position = Integer.parseInt(tfStelle.getText()) - 1;
			messwert = arr[position];
			tfZahlNeu.setText("" + messwert);
			tfZahlNeu.requestFocus();
			tfZahlNeu.selectAll();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ungültige Zahlenangabe!");
			tfStelle.requestFocus();
			tfStelle.selectAll();
		}

	}

	private void wertSpeichern() {
		try {
			arr[position] = Double.parseDouble(tfZahlNeu.getText().replace(",", "."));
			lblAusgabe.setText("Messwerte: ");
			for (double a : arr) {
				lblAusgabe.setText(lblAusgabe.getText() + " " + a);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ungültige Zahlenangabe!");
			tfZahlNeu.requestFocus();
			tfZahlNeu.selectAll();
		}

	}

	// Methodenaufruf in Ereignissen ----------------------------

	private void btnOkZahlExec() {
		if (addNumberToArray()) {
			outputArray();
			btnNeueEingabe.requestFocus();
		}
	}

	private void btnOkExec() {
		try {
		arrSize = getArraySize();
		createArray();
		setFirstLineVisible(false);
		setSecondLineVisible(true);
		tfZahl.requestFocus();
		tfZahl.selectAll(); 
		 } catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ganze Zahl eingeben \n" + e.getMessage());	
			resetProc();
		}
	}

	// ----------------------------------------------------------------------------

	private void resetProc() {
		setThirdLineVisible(false);
		setSecondLineVisible(false);
		setFirstLineVisible(true);
		btnNeueEingabe.setVisible(false);
		tfAnz.requestFocus();
		tfAnz.selectAll();
		arr = null;
		i = 0;
	}
}
