package dienstag;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Rectangle;

public class Messreihe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		setBounds(100, 100, 537, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuestion = new JLabel("Wieviele Messwerte sollen eingegeben werden?");
		lblQuestion.setBounds(10, 15, 262, 14);
		contentPane.add(lblQuestion);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(288, 7, 93, 20);
		contentPane.add(textField);
		
		JButton btnOkAnz = new JButton("Ok");
		btnOkAnz.setBounds(391, 6, 117, 23);
		contentPane.add(btnOkAnz);
		
		JLabel lblMesswert = new JLabel("Messwert: ");
		lblMesswert.setBounds(10, 40, 189, 14);
		contentPane.add(lblMesswert);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(288, 32, 93, 20);
		contentPane.add(textField_1);
		
		JButton btnOkAnz_1 = new JButton("Ok");
		btnOkAnz_1.setBounds(391, 31, 117, 23);
		contentPane.add(btnOkAnz_1);
		
		JLabel lblMesswertEdit = new JLabel("Messwerte: ");
		lblMesswertEdit.setBounds(10, 66, 189, 14);
		contentPane.add(lblMesswertEdit);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(209, 58, 69, 20);
		contentPane.add(textField_2);
		
		JButton btnEdit = new JButton("Bearbeiten");
		btnEdit.setBounds(391, 57, 117, 23);
		contentPane.add(btnEdit);
		
		JLabel lblMesswertStelle = new JLabel(".Messwert");
		lblMesswertStelle.setBounds(288, 61, 93, 14);
		contentPane.add(lblMesswertStelle);
		
		JLabel lblMesswertEdit_1 = new JLabel("Wert:");
		lblMesswertEdit_1.setBounds(10, 91, 189, 14);
		contentPane.add(lblMesswertEdit_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(209, 83, 69, 20);
		contentPane.add(textField_3);
		
		JButton btnSave = new JButton("Speichern");
		btnSave.setBounds(391, 82, 117, 23);
		contentPane.add(btnSave);
		
		JButton btnAuswerten = new JButton("Messreihe Auswerten");
		btnAuswerten.setBounds(10, 115, 498, 23);
		contentPane.add(btnAuswerten);
		
		JLabel lblNewLabel = new JLabel("Maximalwert");
		lblNewLabel.setBounds(10, 157, 498, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMinimalwert = new JLabel("Minimalwert");
		lblMinimalwert.setBounds(10, 182, 498, 14);
		contentPane.add(lblMinimalwert);
		
		JLabel lblMittelwert = new JLabel("Mittelwert");
		lblMittelwert.setBounds(10, 207, 498, 14);
		contentPane.add(lblMittelwert);
	}
}
