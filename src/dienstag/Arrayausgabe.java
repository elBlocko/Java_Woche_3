package dienstag;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.LinkedBlockingQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Arrayausgabe extends JFrame {

	private JPanel contentPane;
	private JTextField tfAnz;
	private JTextField tfZahl;
	private JLabel lblAusgabeRueck;
	private JLabel lblZahlen;
	private JLabel lblAusgabeVor;
	private JLabel lblQuestion;

	private JButton btnOkAnz;
	private JButton btnNeueEingabe;
	private JButton btnOkZahl;
	int i = 0;
	private int[] arr;
	private int arrSize;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arrayausgabe frame = new Arrayausgabe();
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
	public Arrayausgabe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 300);
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
		tfAnz.setBounds(282, 8, 86, 20);
		contentPane.add(tfAnz);
		// ******************************************************
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
		tfZahl.setBounds(20, 100, 86, 20);
		contentPane.add(tfZahl);

		// Label -----------------------------------------------

		lblQuestion = new JLabel("Wieviele Zahlen sollen eingegeben werden?");
		lblQuestion.setBounds(10, 11, 262, 14);
		contentPane.add(lblQuestion);
		// ***
		lblZahlen = new JLabel("Zahlen");
		lblZahlen.setVisible(false);
		lblZahlen.setBounds(10, 75, 73, 14);
		contentPane.add(lblZahlen);
		// ***
		lblAusgabeVor = new JLabel("...");
		lblAusgabeVor.setVisible(false);
		lblAusgabeVor.setBounds(10, 196, 222, 14);
		contentPane.add(lblAusgabeVor);
		// ***
		lblAusgabeRueck = new JLabel("...");
		lblAusgabeRueck.setVisible(false);
		lblAusgabeRueck.setBounds(10, 221, 222, 14);
		contentPane.add(lblAusgabeRueck);

		// BUTTON ----------------------------------------------
		// ***
		btnOkAnz = new JButton("Ok");
		btnOkAnz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOkExec();
			}

		});
		btnOkAnz.setBounds(375, 7, 86, 23);
		contentPane.add(btnOkAnz);
		// ***
		btnOkZahl = new JButton("Ok");
		btnOkZahl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOkZahlExec();
			}
		});
		btnOkZahl.setVisible(false);
		btnOkZahl.setBounds(116, 99, 86, 23);
		contentPane.add(btnOkZahl);
		// ***
		btnNeueEingabe = new JButton("Neue Eingabe");
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
		btnNeueEingabe.setBounds(282, 99, 179, 23);
		contentPane.add(btnNeueEingabe);
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
			lblAusgabeVor.setVisible(false);
			lblAusgabeRueck.setVisible(false);

		} else {
			lblAusgabeVor.setVisible(true);
			lblAusgabeRueck.setVisible(true);
		}
	}

	private void createArray() {
		arr = new int[arrSize];
	}

	private void btnOkZahlExec() {
		if (addNumberToArray()) {
			outputArray();
			btnNeueEingabe.requestFocus();
		}
	}

	private void btnOkExec() {
		arrSize = getArraySize();
		createArray();
		setFirstLineVisible(false);
		setSecondLineVisible(true);
		tfZahl.requestFocus();
		tfZahl.selectAll();
	}

	private boolean addNumberToArray() {
		if (i < arrSize) {
			try {
				arr[i] = Integer.parseInt(tfZahl.getText());
				i++;
				tfZahl.requestFocus();
				tfZahl.selectAll();
				if (arrSize == i) {					
					JOptionPane.showMessageDialog(null, "Array Ende erreicht, Ausgabe erfolgt");
					setSecondLineVisible(false);
					setThirdLineVisible(true);
					return true;
				
				} else {
				return false;
				}	
			} catch (Exception e) {
				// Fehler auslesen und ausgeben				
				JOptionPane.showMessageDialog(null,"Eingabe muss ganze Zahl sein!" + "\n" +e.getMessage()); 
				tfZahl.requestFocus();
				tfZahl.selectAll();
				return false;
			}
		} 
		else {			
			return true;
		}
	}

	private void outputArray() {
		lblAusgabeVor.setText("");
		lblAusgabeRueck.setText("");
		for (int tempNumber : arr) {
			lblAusgabeVor.setText(lblAusgabeVor.getText() + " " + tempNumber);
		}
		for (int k = arr.length - 1; k >= 0; k--) {
			lblAusgabeRueck.setText(lblAusgabeRueck.getText() + " " + arr[k]);
		}

	}

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
