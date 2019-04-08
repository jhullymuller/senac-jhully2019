package exercicio4.view.entity;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exercicio4.controller.entity.UsuarioController;
import exercicio4.model.entity.Nivel;

public class Cadastrar extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField passwordField;
	private JButton btnCancelar;
	private JPasswordField txtConfirmacaoSenha;
	private JComboBox comboBoxNivel;
	private List<Nivel> niveis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastrar frame = new Cadastrar();
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
	public Cadastrar() {
		setTitle("Cadastro");
		setClosable(true);
		setBounds(100, 100, 338, 291);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(12, 30, 70, 15);
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(66, 28, 210, 19);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(12, 57, 46, 15);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(66, 57, 210, 19);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(66, 84, 210, 19);
		getContentPane().add(passwordField);

		JLabel lblNewLabel = new JLabel("Senha :");
		lblNewLabel.setBounds(12, 84, 58, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblNivel = new JLabel("Nivel :");
		lblNivel.setBounds(12, 171, 70, 15);
		getContentPane().add(lblNivel);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioController controller = new UsuarioController();
				String mensagem = controller.cadastrar(txtNome.getText(), txtEmail.getText(),
						String.valueOf(passwordField.getPassword()), (Nivel) comboBoxNivel.getSelectedItem(),String.valueOf(txtConfirmacaoSenha.getPassword()));

				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		btnSalvar.setForeground(new Color(0, 128, 0));
		btnSalvar.setBounds(31, 224, 117, 25);
		getContentPane().add(btnSalvar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}

			private void close() {
				Cadastrar.this.setVisible(false);
			}
		});
		btnCancelar.setForeground(Color.RED);
		btnCancelar.setBounds(191, 224, 117, 25);
		getContentPane().add(btnCancelar);

		JLabel lblConfirmaoDeSenha = new JLabel("Confirmação de Senha:");
		lblConfirmaoDeSenha.setBounds(12, 111, 177, 15);
		getContentPane().add(lblConfirmaoDeSenha);

		txtConfirmacaoSenha = new JPasswordField();
		txtConfirmacaoSenha.setBounds(191, 109, 117, 19);
		getContentPane().add(txtConfirmacaoSenha);
		txtConfirmacaoSenha.setColumns(10);

		comboBoxNivel = new JComboBox();
		comboBoxNivel.setModel(new DefaultComboBoxModel(new Nivel[] { new Nivel(1, "Admin"), new Nivel(2, "Normal") }));
		comboBoxNivel.setToolTipText("");
		comboBoxNivel.setBounds(66, 166, 250, 24);
		getContentPane().add(comboBoxNivel);

	}

	private void consultarNiveis() {
		// TODO trocar para uma chamada ao BO de Nivel
		niveis = new ArrayList<Nivel>();

		Nivel nivelAdm = new Nivel(1, "Administrador");
		Nivel nivelNormal = new Nivel(2, "Normal");

		niveis.add(nivelAdm);
		niveis.add(nivelNormal);
	}
}
