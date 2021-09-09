/*
 * Programm Kontaktliste4
 * wie Kontaktliste3
 * 
 * Die Eingaben werden in Kontakte.dat gespeichert
 * und beim Neustart des Programms in der Liste 
 * ausgegeben
 * 
 * @author A.Fletcher
 * @date 2021-09-09
 */

package donnserstag;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Kontaktliste4 extends JFrame {

	private JPanel contentPane;
	private JTextField tfNachname;
	private JTextField tfVorname;
	private JTextField tfTelefon;
	private JTextField tfEmail;
	private JList<String> listKontakte;
	
	private DefaultListModel<String> kontaktModel = new DefaultListModel<>();
	
	//1. Datei soll kontakte.dat heißen und im gleichen Ordner angelegt werden
	//2. File.separator liefert plattformabhängig das entsprechende Trennzeichen
	//für Pfadangaben
	private String dateiname = "." + File.separator + "kontakte.dat";

	//3. File-Objekt erstellen
	private File datei = new File(dateiname);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kontaktliste4 frame = new Kontaktliste4();
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
	public Kontaktliste4() {
		setTitle("Kontaktliste");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNachname = new JLabel("Nachname");
		lblNachname.setBounds(10, 11, 81, 14);
		contentPane.add(lblNachname);
		
		tfNachname = new JTextField();
		tfNachname.setBounds(10, 36, 86, 20);
		contentPane.add(tfNachname);
		tfNachname.setColumns(10);
		
		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setBounds(125, 11, 81, 14);
		contentPane.add(lblVorname);
		
		tfVorname = new JTextField();
		tfVorname.setColumns(10);
		tfVorname.setBounds(125, 36, 86, 20);
		contentPane.add(tfVorname);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(235, 11, 141, 14);
		contentPane.add(lblTelefon);
		
		tfTelefon = new JTextField();
		tfTelefon.setColumns(10);
		tfTelefon.setBounds(235, 36, 141, 20);
		contentPane.add(tfTelefon);
		
		JLabel lblEMail = new JLabel("E-Mail");
		lblEMail.setBounds(10, 75, 81, 14);
		contentPane.add(lblEMail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(10, 100, 201, 20);
		contentPane.add(tfEmail);
		
		JButton btnUebernehmen = new JButton("\u00DCbernehmen >>");
		btnUebernehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uebernehmen();
			}
		});
		btnUebernehmen.setBounds(235, 99, 141, 23);
		contentPane.add(btnUebernehmen);
		
		JLabel lblKontaktliste = new JLabel("Kontaktliste");
		lblKontaktliste.setBounds(10, 131, 86, 14);
		contentPane.add(lblKontaktliste);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 156, 564, 170);
		contentPane.add(scrollPane);
		
		listKontakte = new JList<>();
		listKontakte.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listKontakte);
		
		listKontakte.setModel(kontaktModel);
		
		JButton btnEintragLoeschen = new JButton("markierten Eintrag l\u00F6schen");
		btnEintragLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eintragLoeschen();
			}
		});
		btnEintragLoeschen.setBounds(10, 340, 196, 23);
		contentPane.add(btnEintragLoeschen);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//4. try-with-resources
				try(BufferedWriter out = new BufferedWriter
						(new FileWriter(datei))){
					//5. for-Schleife schreibt zeilenweise die Einträge mit der
					//write-Methode in die Datei
					for(var i = 0; i < kontaktModel.getSize(); i++) {
						out.write(kontaktModel.get(i).toString());
						//6. nach jedem Eintrag erfolgt ein Zeilenvorschub
						out.newLine();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnEnde.setBounds(488, 340, 86, 23);
		contentPane.add(btnEnde);
		
		JButton btnBearbeiten = new JButton("Bearbeiten");
		btnBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eintragBearbeiten();
			}
		});
		btnBearbeiten.setBounds(235, 340, 141, 23);
		contentPane.add(btnBearbeiten);
		
		//7. Daten aus einer Datei lesen
		//8. Prüfen ob Datei existiert
		if(!datei.exists()) {
			try {
				//9. Wenn Datei nicht existiert, erstellen
				datei.createNewFile();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else {
			//10. Wenn Datei existiert wird lokale String-Variable angelegt
			String adresszeile;
			//11. try-with-resources
			try(var in = new BufferedReader(new FileReader(datei))){
				//12. solange eine weitere Zeile existiert, wird diese in 
				// adresszeile gespeichert
				while ((adresszeile = in.readLine()) != null) {
					//13. adresszeile wird dem Kontaktemodel hinzugefügt
					kontaktModel.addElement(adresszeile);
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private void uebernehmen() {
		String datensatz = tfVorname.getText() + "; " + tfNachname.getText() 
			+ "; "  + tfTelefon.getText() + "; " + tfEmail.getText();
		kontaktModel.addElement(datensatz);
		tfNachname.setText("");
		tfVorname.setText("");
		tfTelefon.setText("");
		tfEmail.setText("");
		
	}
	
	private void eintragLoeschen() {
		int kontaktIndex = listKontakte.getSelectedIndex();
		kontaktModel.remove(kontaktIndex);
	}
	
	private void eintragBearbeiten() {
		String kontaktEintrag = listKontakte.getSelectedValue();
		String[] kontakt = kontaktEintrag.split("; ");
		tfNachname.setText(kontakt[0]);
		tfVorname.setText(kontakt[1]);
		tfTelefon.setText(kontakt[2]);
		tfEmail.setText(kontakt[3]);
		eintragLoeschen();
	}


}
