package donnserstag;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BeispielJFileChooser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private JPanel contentPane;
	private JTextField tfVerzeichnis;
	//2. File deklarieren und importieren
	private File verzeichnis;
	
	//3. Listenmodelle deklarieren
	private DefaultListModel<String> verzeichnisseModel, dateienModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeispielJFileChooser frame = new BeispielJFileChooser();
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
	public BeispielJFileChooser() {
		setTitle("Verzeichnisse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//1. Komponenten anlegen
		JLabel lblVerzeichnis = new JLabel("Verzeichnis");
		lblVerzeichnis.setBounds(10, 11, 414, 14);
		contentPane.add(lblVerzeichnis);
		
		tfVerzeichnis = new JTextField();
		tfVerzeichnis.setBounds(10, 32, 414, 20);
		contentPane.add(tfVerzeichnis);
		tfVerzeichnis.setColumns(10);
		
		JButton btnInhaltAnzeigen = new JButton("Inhalt anzeigen");
		btnInhaltAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//13. Inhalte des Verzeichnisses anzeigen lassen
				//14. Inhalte aus den Listenmodellen l�schen
				verzeichnisseModel.clear();
				dateienModel.clear();
				
				//15. Pr�fen ob tfVerzeichnis leer ist --> dann Fehlermeldung
				if(tfVerzeichnis.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Verzeichnisname fehlt!");
				} else {
					//16. verzeichnis "erstellen" und Pfad �bergeben
					verzeichnis = new File(tfVerzeichnis.getText());
					
					//17. Pr�fen ob Verzeicnis existiert und ob es sich
					// um ein Verzeichnis handelt
					if(verzeichnis.exists() && verzeichnis.isDirectory()) {
						//18. alle Inhalte in String-Array speichern
						String[] inhalt = verzeichnis.list();
						
						//19. String-Array durchlaufen
						for(String eintrag : inhalt) {
							//20. Um zu �berpr�fen, ob der jeweilige Eintrag in die
							//Verzeichnis- oder in die Dateiliste eingetragen werden
							//muss, muss zu jedem Eintrag ein File-Objekt erstellt 
							//werden
							File f = new File(verzeichnis, eintrag);
							
							//21. Pr�fen ob es sich um ein Verzeichnis handelt
							if(f.isDirectory()) {
								verzeichnisseModel.addElement(eintrag);
							} else {
								dateienModel.addElement(eintrag);
							}
						}
					}
				}
			}
		});
		btnInhaltAnzeigen.setBounds(10, 63, 197, 23);
		contentPane.add(btnInhaltAnzeigen);
		
		JButton btnAusw�hlen = new JButton("Ausw\u00E4hlen ...");
		btnAusw�hlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//8. FileChooser anlegen
				JFileChooser fc = new JFileChooser();
				
				//9. Nur Verzeichnisse anzeigen
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				
				//10. status erlaubt R�ckschl�sse auf die Art und Weise
				// wie der Dialog geschlossen wurde
				int status = fc.showOpenDialog(null);
				
				//11. Der Button �ffnen wurde bet�tigt
				if(status == JFileChooser.APPROVE_OPTION) {
					File selFile = fc.getSelectedFile();
					//12. Der Pfad wird in das Textfeld geschrieben
					tfVerzeichnis.setText(selFile.getPath());
				}
			}
		});
		btnAusw�hlen.setBounds(217, 63, 207, 23);
		contentPane.add(btnAusw�hlen);
		
		JLabel lblVerzeichnisse = new JLabel("Verzeichnisse");
		lblVerzeichnisse.setBounds(10, 91, 197, 14);
		contentPane.add(lblVerzeichnisse);
		
		JLabel lblDateien = new JLabel("Dateien");
		lblDateien.setBounds(217, 91, 207, 14);
		contentPane.add(lblDateien);
		
		JScrollPane spVerzeichnisse = new JScrollPane();
		spVerzeichnisse.setBounds(10, 116, 197, 134);
		contentPane.add(spVerzeichnisse);
		
		//6. Datentyp String
		JList<String> listVerzeichnisse = new JList<>();
		spVerzeichnisse.setViewportView(listVerzeichnisse);
		//4. DefaultListModel anlegen und der Liste zuordnen
		verzeichnisseModel = new DefaultListModel<>();
		listVerzeichnisse.setModel(verzeichnisseModel);
		
		JScrollPane spDateien = new JScrollPane();
		spDateien.setBounds(217, 116, 207, 134);
		contentPane.add(spDateien);
		
		//7. Datentyp String
		JList<String> listDateien = new JList<>();
		spDateien.setViewportView(listDateien);
		//5. DefaultListModel anlegen und der Liste zuordnen
		dateienModel = new DefaultListModel<>();
		listDateien.setModel(dateienModel);
	}
}
