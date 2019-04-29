package exercicio5.view;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ajuda extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajuda frame = new Ajuda();
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
	public Ajuda() {
		setClosable(true);
		setTitle("Ajuda");
		setBounds(0, 0, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Tire as suas Duvidas");
		label.setBounds(44, 12, 189, 19);
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		getContentPane().add(label);
		
		JLabel lblDigiteAquiSua = new JLabel("Digite aqui sua Duvida :");
		lblDigiteAquiSua.setBounds(44, 45, 189, 19);
		lblDigiteAquiSua.setFont(new Font("Dialog", Font.BOLD, 13));
		getContentPane().add(lblDigiteAquiSua, "2, 6, 2, 1, left, top");
		
		textField = new JTextField();
		textField.setBounds(44, 76, 189, 19);
		getContentPane().add(textField, "2, 8, 2, 1, fill, default");
		textField.setColumns(10);
		
		JButton button = new JButton("Pesquisar");
		button.setBounds(44, 100, 189, 19);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					URI uri = new URI("https://www.google.com/search?q=" + URLEncoder.encode(textField.getText(), "UTF-8"));
					Desktop.getDesktop().browse(uri);
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		});
		getContentPane().add(button, "2, 10");
		
		JButton button_1 = new JButton("www.google.com");
		button_1.setBounds(44, 175, 189, 19);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					URI uri = new URI("https://www.google.com");
					Desktop.getDesktop().browse(uri);
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		});
		getContentPane().add(button_1, "2, 14");

	}

}
