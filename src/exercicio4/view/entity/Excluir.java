package exercicio4.view.entity;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Excluir extends JInternalFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Excluir frame = new Excluir();
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
	public Excluir() {
		setTitle("Excluir");
		setClosable(true);
		setBounds(100, 100, 324, 195);
		getContentPane().setLayout(null);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(45, 23, 70, 15);
		getContentPane().add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(133, 21, 114, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 58, 114, 19);
		getContentPane().add(passwordField);
		
		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setBounds(45, 50, 56, 15);
		getContentPane().add(lblSenha);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		btnNewButton.setBounds(133, 99, 127, 25);
		getContentPane().add(btnNewButton);

	}
}
