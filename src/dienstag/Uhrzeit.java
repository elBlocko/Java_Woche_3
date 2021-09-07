/**
 * Programm Uhrzeit
 * mit try catch
 * @author A. Fletcher
 * @date 2021-09-06
 */
package dienstag;

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

public class Uhrzeit extends JFrame {

	private JPanel contentPane;
	private JTextField tfStunden;
	private JTextField tfMinuten;
	private JLabel lblAusgabe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Uhrzeit frame = new Uhrzeit();
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
	public Uhrzeit() {
		setTitle("Uhrzeit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStunden = new JLabel("Stunden");
		lblStunden.setBounds(21, 24, 73, 14);
		contentPane.add(lblStunden);
		
		tfStunden = new JTextField();
		tfStunden.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfMinuten.requestFocus();
				}
			}
		});
		tfStunden.setBounds(21, 49, 86, 20);
		contentPane.add(tfStunden);
		tfStunden.setColumns(10);
		
		JLabel lblMinuten = new JLabel("Minuten");
		lblMinuten.setBounds(158, 24, 73, 14);
		contentPane.add(lblMinuten);
		
		tfMinuten = new JTextField();
		tfMinuten.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					uebernehmen();
				}
			}

		});
		tfMinuten.setColumns(10);
		tfMinuten.setBounds(158, 49, 86, 20);
		contentPane.add(tfMinuten);
		
		JButton btnUebernehmen = new JButton("\u00DCbernehmen");
		btnUebernehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uebernehmen();
			}
		});
		btnUebernehmen.setBounds(278, 48, 130, 23);
		contentPane.add(btnUebernehmen);
		
		lblAusgabe = new JLabel("...");
		lblAusgabe.setBounds(22, 105, 222, 14);
		contentPane.add(lblAusgabe);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(319, 179, 89, 23);
		contentPane.add(btnEnde);
	}
	
	private void uebernehmen() {
		try{
			int std = Integer.parseInt(tfStunden.getText());
			int min = Integer.parseInt(tfMinuten.getText());
			lblAusgabe.setText("Ihre Uhrzeit ist "
			    + std + ":" + min + " Uhr.");
		}
		catch (NumberFormatException nfe) {
			lblAusgabe.setText("Ungültige Uhrzeit!");
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		tfStunden.requestFocus();
		tfStunden.selectAll();
		
	}

}
