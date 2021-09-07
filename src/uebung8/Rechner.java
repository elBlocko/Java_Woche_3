/*
 * Programm Rechner
 * als Mini-Taschenrechner für die vier Grundrechenarten.
 * @author A.Fletcher
 * @date 2021-09-06
 */
package uebung8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Rechner extends JFrame {

	private JPanel contentPane;
	private JTextField tfOperand1;
	private JTextField tfOperand2;
	private JTextField tfErgebnis;
	private double x, y, ergebnis;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOperand1 = new JLabel("Operand1");
		lblOperand1.setBounds(10, 11, 77, 14);
		contentPane.add(lblOperand1);
		
		JLabel lblOperand2 = new JLabel("Operand2");
		lblOperand2.setBounds(279, 11, 77, 14);
		contentPane.add(lblOperand2);
		
		tfOperand1 = new JTextField();
		tfOperand1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfOperand2.requestFocus();
				}
			}
		});
		tfOperand1.setBounds(10, 36, 86, 20);
		contentPane.add(tfOperand1);
		tfOperand1.setColumns(10);
		
		tfOperand2 = new JTextField();
		tfOperand2.setColumns(10);
		tfOperand2.setBounds(279, 36, 86, 20);
		contentPane.add(tfOperand2);
		
		JButton btnAddition = new JButton("+");
		btnAddition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x = Double.parseDouble(tfOperand1.getText());
				y = Double.parseDouble(tfOperand2.getText());
				ergebnis = x + y;
				tfErgebnis.setText(x + " + " + y + " = " + ergebnis);
			}
		});
		btnAddition.setBounds(131, 35, 41, 41);
		contentPane.add(btnAddition);
		
		JButton btnSubtraktion = new JButton("-");
		btnSubtraktion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x = Double.parseDouble(tfOperand1.getText());
				y = Double.parseDouble(tfOperand2.getText());
				ergebnis = x - y;
				tfErgebnis.setText(x + " - " + y + " = " + ergebnis);
			}
		});
		btnSubtraktion.setBounds(201, 35, 41, 41);
		contentPane.add(btnSubtraktion);
		
		JButton btnMultiplikation = new JButton("*");
		btnMultiplikation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x = Double.parseDouble(tfOperand1.getText());
				y = Double.parseDouble(tfOperand2.getText());
				ergebnis = x * y;
				tfErgebnis.setText(x + " * " + y + " = " + ergebnis);
			}
		});
		btnMultiplikation.setBounds(131, 106, 41, 41);
		contentPane.add(btnMultiplikation);
		
		JButton btnDivision = new JButton("/");
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x = Double.parseDouble(tfOperand1.getText());
				y = Double.parseDouble(tfOperand2.getText());
				ergebnis = x / y;
				tfErgebnis.setText(x + " / " + y + " = " + ergebnis);
				
			}
		});
		btnDivision.setBounds(201, 106, 41, 41);
		contentPane.add(btnDivision);
		
		tfErgebnis = new JTextField();
		tfErgebnis.setEditable(false);
		tfErgebnis.setBounds(10, 184, 355, 20);
		contentPane.add(tfErgebnis);
		tfErgebnis.setColumns(10);
		
		JLabel lblErgebnis = new JLabel("Ergebnis");
		lblErgebnis.setBounds(10, 159, 86, 14);
		contentPane.add(lblErgebnis);
	}
}
