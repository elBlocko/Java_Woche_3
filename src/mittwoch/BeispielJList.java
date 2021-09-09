package mittwoch;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BeispielJList extends JFrame {

	private JPanel contentPane;
	private JLabel lblAktuellesObst;
	private JTextField tfHinzufuegen;
	private JButton btnHinzufuegen;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeispielJList frame = new BeispielJList();
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
	public BeispielJList() {
		setTitle("Beispiel JList");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Scroll Panel erstellen
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(132, 43, 152, 111);
		contentPane.add(scrollPane);

		//neue JList mit Typ String anlegen
		JList<String> listObst = new JList<>();
		
		//aktuelle Auswahl anzeigen
		listObst.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String auswahl = listObst.getSelectedValue();
				lblAktuellesObst.setText(auswahl);
			}
		});
		//nur einen Wert wählen lassen
		listObst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//Liste dem ScrollPanel hinzufügen
		scrollPane.setViewportView(listObst);

		//Neues Listenmodell erstellen (Bindeglied zwischen Array und JList)
		DefaultListModel<String> listenModel = new DefaultListModel<>();

		//Listenmodell der Liste hinzufügen
		listObst.setModel(listenModel);

		//Anfangsarray für die Liste erstellen
		String[] obst = { "Apfel", "Birne", "Banane", "Pflaume" };

		//Alle Werte des Array dem Listenmodell hinzufügen
		for (String frucht : obst) {
			listenModel.addElement(frucht);
		}

		//Label zum Anzeigen der aktuellen Auswahl
		lblAktuellesObst = new JLabel("...");
		lblAktuellesObst.setBounds(134, 181, 152, 14);
		contentPane.add(lblAktuellesObst);
		
		//Textfeld zum Eintrag eines neuen Elements
		tfHinzufuegen = new JTextField();
		tfHinzufuegen.setBounds(10, 42, 112, 20);
		contentPane.add(tfHinzufuegen);
		tfHinzufuegen.setColumns(10);
		
		//Button zum Hinzufügen eines neuen Elements
		//aus dem Textfeld zum Listenmodell
		btnHinzufuegen = new JButton("Hinzuf\u00FCgen");
		btnHinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String neuesObst = tfHinzufuegen.getText();
				listenModel.addElement(neuesObst);
			}
		});
		btnHinzufuegen.setBounds(10, 83, 112, 23);
		contentPane.add(btnHinzufuegen);

	}

}
