/**
 * Programm Einkauf
 * zur Berechnung eines Endpreises aus
 * Stückzahl, Einzelpreis und Rabattsatz.
 * Verwendung von try catch und throw Exception
 * @author A. Fletcher
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

public class Einkauf extends JFrame {

	private JPanel contentPane;
	private JTextField tfStueckzahl;
	private JTextField tfStueckpreis;
	private JTextField tfRabatt;
	private JLabel lblErgebnis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Einkauf frame = new Einkauf();
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
	public Einkauf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStueckzahl = new JLabel("St\u00FCckzahl");
		lblStueckzahl.setBounds(24, 28, 70, 14);
		contentPane.add(lblStueckzahl);
		
		tfStueckzahl = new JTextField();
		tfStueckzahl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfStueckpreis.requestFocus();
					tfStueckpreis.selectAll();
				}
			}
		});
		tfStueckzahl.setBounds(24, 48, 86, 20);
		contentPane.add(tfStueckzahl);
		tfStueckzahl.setColumns(10);
		
		tfStueckpreis = new JTextField();
		tfStueckpreis.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfRabatt.requestFocus();
					tfRabatt.selectAll();
				}
			}
		});
		tfStueckpreis.setColumns(10);
		tfStueckpreis.setBounds(140, 48, 86, 20);
		contentPane.add(tfStueckpreis);
		
		JLabel lblStueckpreis = new JLabel("St\u00FCckpreis");
		lblStueckpreis.setBounds(140, 28, 70, 14);
		contentPane.add(lblStueckpreis);
		
		tfRabatt = new JTextField();
		tfRabatt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					pruefe();
				}
			}
		});
		tfRabatt.setColumns(10);
		tfRabatt.setBounds(258, 48, 86, 20);
		contentPane.add(tfRabatt);
		
		JLabel lblRabatt = new JLabel("Rabatt (%)");
		lblRabatt.setBounds(258, 28, 70, 14);
		contentPane.add(lblRabatt);
		
		JButton btnBerechnen = new JButton("Berechnen");
		btnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pruefe();
			}

		});
		btnBerechnen.setBounds(394, 47, 118, 23);
		contentPane.add(btnBerechnen);
		
		lblErgebnis = new JLabel("");
		lblErgebnis.setBounds(24, 109, 320, 14);
		contentPane.add(lblErgebnis);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(394, 109, 118, 23);
		contentPane.add(btnEnde);
	}
	private void pruefe() {
		
		
			int stueckzahl;
			double stueckpreis, rabattsatz, bruttopreis, rabatt, einkaufspreis;
			
			try {
				if (tfStueckzahl.getText().equals("")) {
					throw new LeereEingabeException("Bitte geben Sie eine Stückzahl an!");
				}
				if (tfStueckpreis.getText().equals("")) {
					throw new LeereEingabeException("Bitte geben Sie einen Stückpreis an!");
				}
				if (tfRabatt.getText().equals("")) {
					throw new LeereEingabeException("Bitte geben Sie einen Rabattsatz an!");
				}
					
			stueckzahl = Integer.parseInt(tfStueckzahl.getText());
			stueckpreis = Double.parseDouble(tfStueckpreis.getText().replace(",", "."));
			rabattsatz = Double.parseDouble(tfRabatt.getText().replace(",", "."));
			
			bruttopreis = stueckzahl * stueckpreis;
			rabatt = bruttopreis * rabattsatz / 100;
			einkaufspreis = bruttopreis - rabatt;
			
			DecimalFormat f = new DecimalFormat("#0.00");
			
			lblErgebnis.setText("Der Einkaufspreis beträgt " + f.format(einkaufspreis) + " €");
			}
			catch (LeereEingabeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			catch (NumberFormatException e) {
				lblErgebnis.setText("Falsches Zahlenformat!" + e.getMessage());
			}
			catch (Exception e){
				lblErgebnis.setText("Fehler bei der Eingabe!");
		}
		tfStueckzahl.requestFocus();
		tfStueckzahl.selectAll();
	}
	
	private void berechne() {
		
		
		
	}

}
