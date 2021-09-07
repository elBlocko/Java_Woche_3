/*
 * Programm Notenbilanz
 * berechnet aus mehreren eingegebenen Noten 
 * den Notendurchschnitt und gibt zusätzlich die 
 * beste und die schlechteste Note aus.
 * @author A.Fletcher
 * @date 2021-09-06
 */
package uebung8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class Notenbilanz extends JFrame {

	private JPanel contentPane;
	private JTextField tfAnzahlNoten;
	private JTextField tfNote;
	private JLabel lblAnzahlNoten;
	private JButton btnAnzahlUebernehmen;
	private JLabel lblNote;
	private JButton btnNoteUebernehmen;
	private JLabel lblEingegebeneNoten;
	private JLabel lblNotenschnitt;
	private JLabel lblBesteNote;
	private JLabel lblSchlechtesteNote;
	private JButton btnEnde;
	private JButton btnNeueBerechnung;
	private int i, notenzahl;
	private double notenschnitt, besteNote, schlechtesteNote, summe;
	private DecimalFormat fzahl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notenbilanz frame = new Notenbilanz();
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
	public Notenbilanz() {
		setTitle("Notenbilanz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblAnzahlNoten = new JLabel("Anzahl Noten");
		lblAnzahlNoten.setBounds(10, 11, 80, 14);
		contentPane.add(lblAnzahlNoten);

		tfAnzahlNoten = new JTextField();
		tfAnzahlNoten.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					anzahlUebernehmen();
				}
			}
		});
		tfAnzahlNoten.setBounds(10, 28, 86, 20);
		contentPane.add(tfAnzahlNoten);
		tfAnzahlNoten.setColumns(10);

		btnAnzahlUebernehmen = new JButton("\u00DCbernehmen");
		btnAnzahlUebernehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anzahlUebernehmen();
			}
		});
		btnAnzahlUebernehmen.setBounds(119, 27, 116, 23);
		contentPane.add(btnAnzahlUebernehmen);

		lblNote = new JLabel("1. Note");
		lblNote.setVisible(false);
		lblNote.setBounds(10, 74, 86, 14);
		contentPane.add(lblNote);

		tfNote = new JTextField();
		tfNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noteUebernehmen();
			}
		});
		tfNote.setVisible(false);
		tfNote.setBounds(10, 91, 86, 20);
		contentPane.add(tfNote);
		tfNote.setColumns(10);

		btnNoteUebernehmen = new JButton("\u00DCbernehmen");
		btnNoteUebernehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noteUebernehmen();
			}
		});
		btnNoteUebernehmen.setVisible(false);
		btnNoteUebernehmen.setBounds(119, 90, 116, 23);
		contentPane.add(btnNoteUebernehmen);

		lblEingegebeneNoten = new JLabel("New label");
		lblEingegebeneNoten.setVisible(false);
		lblEingegebeneNoten.setBounds(10, 122, 225, 14);
		contentPane.add(lblEingegebeneNoten);

		lblNotenschnitt = new JLabel("New label");
		lblNotenschnitt.setVisible(false);
		lblNotenschnitt.setBounds(10, 146, 225, 14);
		contentPane.add(lblNotenschnitt);

		lblBesteNote = new JLabel("New label");
		lblBesteNote.setVisible(false);
		lblBesteNote.setBounds(10, 174, 225, 14);
		contentPane.add(lblBesteNote);

		lblSchlechtesteNote = new JLabel("New label");
		lblSchlechtesteNote.setVisible(false);
		lblSchlechtesteNote.setBounds(10, 199, 225, 14);
		contentPane.add(lblSchlechtesteNote);

		btnEnde = new JButton("Ende");
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(335, 227, 89, 23);
		contentPane.add(btnEnde);

		btnNeueBerechnung = new JButton("Neue Berechnung");
		btnNeueBerechnung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				neueBerechnung();
			}
		});
		btnNeueBerechnung.setVisible(false);
		btnNeueBerechnung.setBounds(264, 27, 160, 23);
		contentPane.add(btnNeueBerechnung);
	}

	private void anzahlUebernehmen() {
		if (!tfAnzahlNoten.getText().equals("")) {
			notenzahl = Integer.parseInt(tfAnzahlNoten.getText());
			i = 1;
			summe = 0;
			besteNote = 6;
			schlechtesteNote = 1;
			btnAnzahlUebernehmen.setVisible(false);
			tfAnzahlNoten.setEditable(false);
			lblNote.setVisible(true);
			tfNote.setVisible(true);
			btnNoteUebernehmen.setVisible(true);
			tfNote.requestFocus();
		} else {
			JOptionPane.showMessageDialog(null, "Anzahl der Noten eingeben!");
			tfAnzahlNoten.requestFocus();
		}
	}

	private void ergebnisseVisible() {
		lblEingegebeneNoten.setVisible(true);
		lblNotenschnitt.setVisible(true);
		lblSchlechtesteNote.setVisible(true);
		lblBesteNote.setVisible(true);
	}

	private void noteUebernehmen() {
		fzahl = new DecimalFormat("#0.00");
		if (!tfNote.getText().equals("") 
				&& Integer.parseInt(tfNote.getText()) >= 1
				&& Integer.parseInt(tfNote.getText()) <= 6) {
			
			summe = summe + Double.parseDouble(tfNote.getText());
			notenschnitt = summe / i;
			
			ergebnisseVisible();
			
			lblNotenschnitt.setText("Notenschnitt: " + fzahl.format(notenschnitt));
			lblEingegebeneNoten.setText("Anzahl eingegebene Noten: " 
					+ Integer.toString(i));

			if (Double.parseDouble(tfNote.getText()) > schlechtesteNote) {
				schlechtesteNote = Double.parseDouble(tfNote.getText());
				lblSchlechtesteNote.setText
					("schlechteste Note: " + Double.toString(schlechtesteNote));
			}
			
			if (Double.parseDouble(tfNote.getText()) < besteNote) {
				besteNote = Double.parseDouble(tfNote.getText());
				lblBesteNote.setText
					("beste Note: " + Double.toString(besteNote));
			}
			
			if (i == notenzahl) {
				notenschnitt = summe / i;
				btnNoteUebernehmen.setVisible(false);
				btnNeueBerechnung.setVisible(true);
			} else {
				i++;
				lblNote.setText(Integer.toString(i) + ". Note");
				tfNote.setText("");
				tfNote.requestFocus();
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "gültige Note eingeben!");
			tfNote.requestFocus();
		}
	}

	private void neueBerechnung() {
		i = 1;
		lblNote.setText(Integer.toString(i) + ".Note");
		summe = 0;
		besteNote = 6;
		schlechtesteNote = 0;
		btnAnzahlUebernehmen.setVisible(true);
		tfAnzahlNoten.setEditable(true);
		lblNote.setVisible(false);
		tfNote.setVisible(false);
		tfNote.setText("");
		btnNoteUebernehmen.setVisible(false);
		tfAnzahlNoten.setText("");
		tfAnzahlNoten.requestFocus();
		lblNotenschnitt.setText("");
		lblBesteNote.setText("");
		lblSchlechtesteNote.setText("");
		lblEingegebeneNoten.setText("");
		btnNeueBerechnung.setVisible(false);
	}

}
