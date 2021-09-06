/**
 * Programm FahrenheitCelsius
 * zur Umrechnung einer Temperatur von Grad Fahrenheit
 * in Grad Celsius
 * Mit try-catch 
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
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FahrenheitCelsius extends JFrame {

	private JPanel contentPane;
	private JTextField tfFahrenheit;
	private JTextField tfCelsius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FahrenheitCelsius frame = new FahrenheitCelsius();
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
	public FahrenheitCelsius() {
		setTitle("Umrechnung Fahrenheit Celsius");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFarenheit = new JLabel("Grad Fahrenheit");
		lblFarenheit.setBounds(30, 25, 112, 14);
		contentPane.add(lblFarenheit);
		
		tfFahrenheit = new JTextField();
		tfFahrenheit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					umrechnen();
				}
			}
		});
		tfFahrenheit.setBounds(30, 47, 86, 20);
		contentPane.add(tfFahrenheit);
		tfFahrenheit.setColumns(10);
		
		JLabel lblCelsius = new JLabel("Grad Celsius");
		lblCelsius.setBounds(30, 114, 86, 14);
		contentPane.add(lblCelsius);
		
		tfCelsius = new JTextField();
		tfCelsius.setEditable(false);
		tfCelsius.setBounds(30, 139, 86, 20);
		contentPane.add(tfCelsius);
		tfCelsius.setColumns(10);
		
		JButton btnUmrechnen = new JButton("Umrechnen");
		btnUmrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				umrechnen();
			}

			
		});
		btnUmrechnen.setBounds(204, 46, 124, 23);
		contentPane.add(btnUmrechnen);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(204, 138, 124, 23);
		contentPane.add(btnEnde);
	}
	private void umrechnen() {
		try {
		double fahrenheit = Double.parseDouble
				(tfFahrenheit.getText().replace(",", "."));
		double celsius;
		celsius = (fahrenheit - 32) * 5/9;
		DecimalFormat f = new DecimalFormat("#0.00");
		tfCelsius.setText(f.format(celsius));
		tfFahrenheit.requestFocus(); //tfFahrenheit erhält den Fokus
		tfFahrenheit.selectAll(); //Markiert den Eintrag zum überschreiben
		}
		catch (NumberFormatException nFe) {
			tfCelsius.setText("Keine korrekte Fahrenheit-Temperatur");
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
