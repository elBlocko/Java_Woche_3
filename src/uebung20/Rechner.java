package uebung20;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Rechner extends JFrame {

	private JPanel contentPane;
	private JTextField tfOperandOne;
	private JTextField tfOperandTwo;
	private JTextField tfErg;
	private String CerrMessage = "Die Eingaben sind unvollständig";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rechner frame = new Rechner();
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
	public Rechner() {
		setTitle("Rechner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 187);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfOperandOne = new JTextField();
		tfOperandOne.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
			}
		});
		tfOperandOne.setToolTipText("");
		tfOperandOne.setColumns(10);
		tfOperandOne.setBounds(10, 47, 86, 20);
		contentPane.add(tfOperandOne);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (allesAusgefuellt()) {					
					calc("plus");
				} else {
					tfErg.setText(CerrMessage);
				}
			
			}
		});
		btnPlus.setBounds(100, 47, 48, 20);
		contentPane.add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (allesAusgefuellt()) {					
					calc("minus");
				} else {
					tfErg.setText(CerrMessage);
				}
			}
		});
		btnMinus.setBounds(158, 46, 48, 20);
		contentPane.add(btnMinus);
		
		JButton btnDurch = new JButton("/");
		btnDurch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (allesAusgefuellt()) {					
					calc("durch");
				} else {
					tfErg.setText(CerrMessage);
				}
			}
		});
		btnDurch.setBounds(158, 78, 48, 20);
		contentPane.add(btnDurch);
		
		JButton btnMal = new JButton("*");
		btnMal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (allesAusgefuellt()) {					
					calc("mal");
				} else {
					tfErg.setText(CerrMessage);
				}
			}
		});
		btnMal.setBounds(100, 79, 48, 20);
		contentPane.add(btnMal);
		
		tfOperandTwo = new JTextField();
		tfOperandTwo.setToolTipText("Operand 1");
		tfOperandTwo.setColumns(10);
		tfOperandTwo.setBounds(216, 47, 86, 20);
		contentPane.add(tfOperandTwo);
		
		tfErg = new JTextField();
		tfErg.setEditable(false);
		tfErg.setToolTipText("Operand 1");
		tfErg.setColumns(10);
		tfErg.setBounds(10, 117, 292, 20);
		contentPane.add(tfErg);
		
		JLabel lblNewLabel = new JLabel("Operand 1");
		lblNewLabel.setBounds(10, 25, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblOperand = new JLabel("Operand 2");
		lblOperand.setBounds(216, 25, 86, 14);
		contentPane.add(lblOperand);
		
		JLabel lblErgebnis = new JLabel("Ergebnis:");
		lblErgebnis.setBounds(10, 96, 86, 14);
		contentPane.add(lblErgebnis);

	}
	
	boolean allesAusgefuellt() {
		if (tfOperandOne.getText().equals("") || tfOperandTwo.getText().equals("")){
			return false;
		} else
			return true;
	}

	void calc(String send) {
		double operand1, operand2;
		operand1 = Double.parseDouble(tfOperandOne.getText().replace(",", "."));
		operand2 = Double.parseDouble(tfOperandTwo.getText().replace(",", "."));
		double erg = 0;
		
		if (send == "plus") {
			erg = operand1 + operand2; 
			
		}
		if (send == "minus") {
			erg = operand1 - operand2; 
			
		}
		if (send == "mal") {
			erg = operand1 * operand2; 
			
		}
		if (send == "durch" && operand2 != 0) {			
			erg = operand1 / operand2; 			
		} else  {
			tfErg.setText("Division durch Null ist nicht definiert");
		    return;
		}
		DecimalFormat f = new DecimalFormat("#0.00");
		tfErg.setText(f.format(erg));
		
		
		
		tfOperandOne.requestFocus(); // tf erhält Fokus
		tfOperandOne.selectAll(); // Markiert den Eintrag

	}
	
}
