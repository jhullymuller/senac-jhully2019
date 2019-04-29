package exercicio5.view;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exercicio4.model.dao.UsuarioDao;
import exercicio5.controller.UsuarioController;
import exercicio5.vo.CadastroPessoaVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JInternalFrame {
	private JTextField txtNomeCliente;
	private JTextField txtDataNascimento;
	private JTextField txtCep;
	private CadastroPessoaVO p = new CadastroPessoaVO();
	private UsuarioController usuarioController = new UsuarioController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setTitle("Cadastro de Cliente");
		setClosable(true);
		setBounds(0, 0, 594, 142);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel label = new JLabel("Nome:");
		getContentPane().add(label);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);
		getContentPane().add(txtNomeCliente);

		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		getContentPane().add(lblDataNascimento);

		txtDataNascimento = new JTextField();
		txtDataNascimento.setColumns(10);
		getContentPane().add(txtDataNascimento);

		JLabel lblCep = new JLabel("Cep:");
		getContentPane().add(lblCep);

		txtCep = new JTextField();
		getContentPane().add(txtCep);
		txtCep.setColumns(10);

		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensagem = usuarioController.cadastrar(txtNomeCliente.getText(), txtDataNascimento.getText(), txtCep.getText());
				if (mensagem != null) {
					JOptionPane.showMessageDialog(null, mensagem);
				} else {
					JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
				}
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		getContentPane().add(button);

	};

}
