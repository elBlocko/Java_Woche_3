/*
 * Programm Arrayausgabe
 * liest die Länge des Arrays und die Werte 
 * in eine ArrayList ein
 * gibt die Werte vorwärts und rückwärts aus
 * 
 * @author A.Fletcher
 * @date 2021-09-08
 */

package mittwoch;

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
import java.util.ArrayList;

public class Arrayausgabe2 extends JFrame {

	//Panel
	private JPanel contentPane;
	
	//Textfelder
	private JTextField tfAnzahlZahlen;
	private JTextField tfZahl;
	
	//Buttons
	private JButton btnOKAnzahl;
	private JButton btnOKZahl;
	private JButton btnNeueEingabe;
	private JButton btnEnde;
	
	//Label
	private JLabel lblAnzahlZahlen;
	private JLabel lblZahl;
	private JLabel lblAusgabeVorwaerts;
	private JLabel lblAusgabeRueckwaerts;
	
	//Variable
	private int anzahl;
	private int n = 0;
	private ArrayList<Integer> zahlen; //ArrayList deklarieren

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arrayausgabe2 frame = new Arrayausgabe2();
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
	public Arrayausgabe2() {
		setTitle("Arrayausgabe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAnzahlZahlen = new JLabel("Wie viele Zahlen sollen eingegeben werden?");
		lblAnzahlZahlen.setBounds(10, 11, 281, 14);
		contentPane.add(lblAnzahlZahlen);
		
		tfAnzahlZahlen = new JTextField();
		tfAnzahlZahlen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					anzahlUebernehmen();
				}
			}
		});
		tfAnzahlZahlen.setBounds(294, 8, 86, 20);
		contentPane.add(tfAnzahlZahlen);
		tfAnzahlZahlen.setColumns(10);
		
		btnOKAnzahl = new JButton("OK");
		btnOKAnzahl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anzahlUebernehmen();
			}
		});
		btnOKAnzahl.setBounds(417, 7, 89, 23);
		contentPane.add(btnOKAnzahl);
		
		lblZahl = new JLabel("Zahl");
		lblZahl.setVisible(false);
		lblZahl.setBounds(10, 74, 46, 14);
		contentPane.add(lblZahl);
		
		tfZahl = new JTextField();
		tfZahl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					zahlUebernehmen();
				}
			}
		});
		tfZahl.setVisible(false);
		tfZahl.setBounds(10, 88, 86, 20);
		contentPane.add(tfZahl);
		tfZahl.setColumns(10);
		
		btnOKZahl = new JButton("OK");
		btnOKZahl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zahlUebernehmen();
			}
		});
		btnOKZahl.setVisible(false);
		btnOKZahl.setBounds(123, 87, 89, 23);
		contentPane.add(btnOKZahl);
		
		btnNeueEingabe = new JButton("Neue Eingabe");
		btnNeueEingabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAusgabeVorwaerts.setVisible(false);
				lblAusgabeRueckwaerts.setVisible(false);
				btnNeueEingabe.setVisible(false);
				lblAnzahlZahlen.setVisible(true);
				tfAnzahlZahlen.setVisible(true);
				btnOKAnzahl.setVisible(true);
				n = 0;
				tfAnzahlZahlen.requestFocus();
				tfAnzahlZahlen.selectAll();
			}
		});
		btnNeueEingabe.setVisible(false);
		btnNeueEingabe.setBounds(294, 87, 126, 23);
		contentPane.add(btnNeueEingabe);
		
		lblAusgabeVorwaerts = new JLabel("Ausgabe vorw\u00E4rts");
		lblAusgabeVorwaerts.setVisible(false);
		lblAusgabeVorwaerts.setBounds(10, 192, 410, 14);
		contentPane.add(lblAusgabeVorwaerts);
		
		lblAusgabeRueckwaerts = new JLabel("Ausgabe r\u00FCckw\u00E4rts");
		lblAusgabeRueckwaerts.setVisible(false);
		lblAusgabeRueckwaerts.setBounds(10, 217, 410, 14);
		contentPane.add(lblAusgabeRueckwaerts);
		
		btnEnde = new JButton("Ende");
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(511, 213, 89, 23);
		contentPane.add(btnEnde);
	}
	private void anzahlUebernehmen() {
		try {
		    anzahl = Integer.parseInt(tfAnzahlZahlen.getText());
		    lblAnzahlZahlen.setVisible(false);
		    tfAnzahlZahlen.setVisible(false);
		    btnOKAnzahl.setVisible(false);
		    n++;
		    lblZahl.setText(n + ". Zahl:");
		    zahlen = new ArrayList<Integer>(); //ArrayList "erstellen" 
		    lblZahl.setVisible(true);
		    tfZahl.setVisible(true);
		    btnOKZahl.setVisible(true);
		    tfZahl.requestFocus();
		    tfZahl.selectAll();
		} catch (Exception ex) {
		    JOptionPane.showMessageDialog(null, "Falsches Zahlenformat!");
		    tfAnzahlZahlen.requestFocus();
		    tfAnzahlZahlen.selectAll();
		}
	}
	
	private void zahlUebernehmen() {
		if (n <= anzahl) {
		    try {
			zahlen.add(Integer.parseInt(tfZahl.getText()));//Änderung ArrayList
			n++;
			lblZahl.setText(n + ". Zahl:");
			tfZahl.setText("");
			tfZahl.requestFocus();
		    } 
		    catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Ungültige Zahlenangabe!");
			tfZahl.requestFocus();
			tfZahl.selectAll();
		    }
		}
		if (n > anzahl) {
		    lblAusgabeVorwaerts.setText("");
		    lblAusgabeRueckwaerts.setText("");
		    for (int a : zahlen) {
			lblAusgabeVorwaerts.setText(lblAusgabeVorwaerts.getText() + a
				+ " ");
		    }
		    for (var x = n - 2; x >= 0; x--) {
		    	//-2, weil n noch einmal hochgezählt wird wenn n = anzahl
			lblAusgabeRueckwaerts.setText(lblAusgabeRueckwaerts.getText()
				+ zahlen.get(x) + " "); //Änderung ArrayList
		    }
		    lblAusgabeVorwaerts.setVisible(true);
		    lblAusgabeRueckwaerts.setVisible(true);
		    lblZahl.setVisible(false);
		    tfZahl.setVisible(false);
		    btnOKZahl.setVisible(false);
		    btnNeueEingabe.setVisible(true);
		}
	}
}
