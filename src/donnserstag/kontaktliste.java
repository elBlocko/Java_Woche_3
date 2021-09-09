package donnserstag;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mittwoch.TMyObject;
import mittwoch.TMyObjectList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ListSelectionModel;

public class kontaktliste extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfVorname;
	private JTextField tfTelNummer;
	private JTextField tfEmail;

	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnEnd;

	private JLabel lblName;
	private JLabel lblVorname;
	private JLabel lblEmail;
	private JLabel lblTelNummer;
	private JLabel lblKontaktlliste;

	private JScrollPane scrlpnPersonen;
	private JList<?> lbPersonen;

	private TPersonenModel personModel1;
	private int counter = 0;
	private JButton btnBearbeiten;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kontaktliste frame = new kontaktliste();
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
	public kontaktliste() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// TEXTFELDER *************************************************

		tfName = new JTextField();
		tfName.setBounds(10, 28, 86, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);

		tfVorname = new JTextField();
		tfVorname.setColumns(10);
		tfVorname.setBounds(106, 28, 86, 20);
		contentPane.add(tfVorname);

		tfTelNummer = new JTextField();
		tfTelNummer.setColumns(10);
		tfTelNummer.setBounds(202, 28, 203, 20);
		contentPane.add(tfTelNummer);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(10, 76, 182, 20);
		contentPane.add(tfEmail);

		// LABEL ****************************************************
		lblName = new JLabel("*Nachname");
		lblName.setBounds(10, 11, 86, 14);
		contentPane.add(lblName);

		lblEmail = new JLabel("*Email");
		lblEmail.setBounds(10, 59, 182, 14);
		contentPane.add(lblEmail);

		lblTelNummer = new JLabel("*Telefon");
		lblTelNummer.setBounds(202, 11, 203, 14);
		contentPane.add(lblTelNummer);

		lblVorname = new JLabel("*Vorname");
		lblVorname.setBounds(106, 11, 86, 14);
		contentPane.add(lblVorname);

		lblKontaktlliste = new JLabel("KontaktLliste");
		lblKontaktlliste.setBounds(10, 107, 182, 14);
		contentPane.add(lblKontaktlliste);
		// BUTTON *******************************************************
		btnSave = new JButton("\u00FCbernehmen >>");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setListContent();
			}
		});
		btnSave.setBounds(202, 75, 203, 23);
		contentPane.add(btnSave);
		// ----
		btnDelete = new JButton("l\u00F6schen");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteSelection();
			}
		});
		btnDelete.setBounds(10, 274, 241, 23);
		contentPane.add(btnDelete);
		// ----
		btnEnd = new JButton("Ende");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnd.setBounds(261, 274, 144, 23);
		contentPane.add(btnEnd);

		btnBearbeiten = new JButton("Bearbeiten");
		btnBearbeiten.setBounds(261, 240, 144, 23);
		contentPane.add(btnBearbeiten);

		// Liste *******************************************************
		scrlpnPersonen = new JScrollPane();
		scrlpnPersonen.setBounds(10, 132, 241, 131);
		contentPane.add(scrlpnPersonen);

		// Instanziierung wie im Form Create bei ObjPascal
		personModel1 = new TPersonenModel();
		lbPersonen = new JList<>(personModel1); // Konstruktorübergabe .setmodal cast error
		lbPersonen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrlpnPersonen.setViewportView(lbPersonen);

	} // eoc

	// METHODEN *********************************************************

	private void setListContent() {
		if (isRequiredFieldEmpty()) {
			JOptionPane.showMessageDialog(null,"Bitte mit *markierte Felder ausfüllen");
			return;
		}
		int tempID = counter;
		String tempName = tfName.getText();
		String tempVorname = tfVorname.getText();
		String tempTelNummer = tfTelNummer.getText();
		String tempEmail = tfEmail.getText();		
		personModel1.addElement(new TPerson(tempID, tempName, tempVorname, tempTelNummer, tempEmail));
		counter++;
	}
	
	private void deleteSelection() {
		 int tempIndex = lbPersonen.getSelectedIndex();
		 int YN = JOptionPane.showConfirmDialog(rootPane, "Wirklich löschen?", "Datei aus Bibliothek löschen",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	
		 if (YN == 0 && tempIndex > -1) {
			 personModel1.remove(tempIndex);
		 } else {
			 JOptionPane.showMessageDialog(rootPane, "Keine Datei ausgewählt", "Löschen nicht möglich",
						JOptionPane.WARNING_MESSAGE);			 
		 }		
		}		
	
	private boolean isRequiredFieldEmpty() {
		if (tfName.getText().equals("") && tfVorname.getText().equals("") && tfTelNummer.getText().equals("") &&
				tfEmail.getText().equals("")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/*
	 * private void loeschen() { //
	 * System.out.println(btnLoeschen.getActionCommand()); Konsole Wert ausgeben if
	 * (btnLoeschen.getActionCommand() == "markierten Eintrag löschen") { int delete
	 * = JOptionPane.showConfirmDialog(rootPane, "Wirklich löschen?",
	 * "Datei aus Bibliothek löschen", JOptionPane.YES_NO_OPTION,
	 * JOptionPane.QUESTION_MESSAGE);
	 * 
	 * if (delete == 0) { try { listenModel.remove(kontaktliste.getSelectedIndex());
	 * }
	 * 
	 * catch (ArrayIndexOutOfBoundsException e) {
	 * JOptionPane.showMessageDialog(rootPane, "Keine Datei ausgewählt",
	 * "Löschen nicht möglich", JOptionPane.WARNING_MESSAGE); } // int sel =
	 * kontaktliste.getSelectedIndex(); // System.out.println("getSelectedIndex " +
	 * sel);
	 * 
	 * } } } private void bearbeiten() { String daten =
	 * kontaktliste.getSelectedValue(); String[] werte = daten.split("; ");
	 * tfNachname.setText(werte[0]); tfVorname.setText(werte[1]);
	 * tfTelefon.setText(werte[2]); tfEmail.setText(werte[3]);
	 * listenModel.remove(kontaktliste.getSelectedIndex());
	 * 
	 * }
	 */
}
