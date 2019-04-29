package exercicio4.view.entity;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import exercicio4.controller.entity.UsuarioController;
import exercicio4.model.entity.Nivel;
import exercicio4.model.entity.Usuario;

public class TelaListagem extends JInternalFrame {
	private JTable table;
	private JTextField txtBuscar;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagem frame = new TelaListagem();
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
	public TelaListagem() {
		setClosable(true);
		setTitle("Lista de Usuario");
		setBounds(100, 100, 604, 397);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 158, 582, 207);
		getContentPane().add(scrollPane);
		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID","Nome", "Email", "Nivel" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(167);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		scrollPane.setViewportView(table);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(12, 43, 49, 15);
		getContentPane().add(lblNome);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(79, 41, 180, 19);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new Nivel[] { new Nivel(1, "Admin"), new Nivel(2, "Normal") }));
		comboBox.setToolTipText("");
		comboBox.setBounds(79, 72, 180, 24);
		getContentPane().add(comboBox);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioController control = new UsuarioController();
				Nivel nivel = (Nivel) comboBox.getSelectedItem();
				Integer idNivel = null;
				if (nivel != null) {
					idNivel = nivel.getId();
				}
				atualizarTabela(control.consultarTodos(txtBuscar.getText(), idNivel));
			}
		});
		btnBuscar.setBounds(285, 38, 117, 25);
		getContentPane().add(btnBuscar);


		JLabel lblNivel = new JLabel("Nivel :");
		lblNivel.setBounds(22, 77, 49, 15);
		getContentPane().add(lblNivel);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setToolTipText("");
		btnExcluir.setBounds(453, 108, 117, 25);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int linha = table.getSelectedRow();

				if(linha > -1 ) {

					Integer id = Integer.parseInt((String) table.getModel().getValueAt(linha, 0));
					UsuarioController controller = new UsuarioController();
					controller.remover(id);
					Nivel nivel = (Nivel) comboBox.getSelectedItem();
					Integer idNivel = null;
					if (nivel != null) {
						idNivel = nivel.getId();
					}
					atualizarTabela(controller.consultarTodos(txtBuscar.getText(), idNivel));
				}
			}
		});
		getContentPane().add(btnExcluir);

		JButton btnLimparTabela = new JButton("Limpar Tabela");
		btnLimparTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTabela();
			}
		});
		btnLimparTabela.setBounds(79, 108, 153, 25);
		getContentPane().add(btnLimparTabela);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(269, 108, 70, 15);
		getContentPane().add(lblEmail);

		textField = new JTextField();
		textField.setBounds(326, 108, 114, 19);
		getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(326, 124, 114, 19);
		getContentPane().add(passwordField);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(269, 131, 59, 15);
		getContentPane().add(lblSenha);

	}

	private void limparTabela() {
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID","Nome", "Email", "Nivel" }));

	}
	protected void atualizarTabela(ArrayList<Usuario> usuarios) {
		limparTabela();

		DefaultTableModel model = (DefaultTableModel) table.getModel();


		//Percorre as sobremesas para adicionar linha a linha na tabela (JTable)
		for(Usuario usuario: usuarios) {
			String[] novaLinha = new String[4];
			novaLinha[0] = usuario.getId() +"";
			novaLinha[1] = usuario.getNome();
			novaLinha[2] = usuario.getEmail();
			novaLinha[3] = usuario.getNivel().getDescricao();

			//Adiciona a nova linha na tabela
			model.addRow(novaLinha);
		}
	}
}
