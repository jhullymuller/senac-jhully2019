package exercicio5.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import exercicio5.controller.ProdutoController;
import exercicio5.vo.ProdutoVO;

public class CadastroProdutos extends JInternalFrame {
	
	private JTextField txtNomeProduto;
	private JTextField txtValor;
	private JTable table;
	private JTextField txtPesquisa;
	private JTextField txtQuantidade;
	private Integer idProduto;
	private ProdutoController produtoController = new ProdutoController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProdutos frame = new CadastroProdutos();
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
	public CadastroProdutos() {
		setClosable(true);
		setTitle("Cadastro De Produtos");
		setBounds(0, 0, 671, 432);
		getContentPane().setLayout(null);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do Produto:");
		lblNomeDoProduto.setBounds(12, 58, 147, 18);
		getContentPane().add(lblNomeDoProduto);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setColumns(10);
		txtNomeProduto.setBounds(143, 58, 180, 20);
		getContentPane().add(txtNomeProduto);
		
		JLabel label_1 = new JLabel("Valor:");
		label_1.setBounds(330, 60, 46, 14);
		getContentPane().add(label_1);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(373, 58, 70, 20);
		getContentPane().add(txtValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idProduto != null) {
					produtoController.atualizar(idProduto,txtNomeProduto.getText(), txtValor.getText(), txtQuantidade.getText());
				} else {
					produtoController.cadastrar(txtNomeProduto.getText(), txtValor.getText(), txtQuantidade.getText());
				}
				limparCampos();
				ProdutoController control = new ProdutoController();
				atualizarTabela(control.consultarTodos(txtPesquisa.getText()));
			}
		});
		btnCadastrar.setBounds(117, 88, 116, 23);
		getContentPane().add(btnCadastrar);
		
		JButton button_1 = new JButton("Editar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = table.getSelectedRow();
				if(linha > -1 ) {
					idProduto = Integer.parseInt((String) table.getModel().getValueAt(linha, 0));
					txtNomeProduto.setText((String) table.getModel().getValueAt(linha, 1));
					txtValor.setText((String) table.getModel().getValueAt(linha, 2));
					txtQuantidade.setText((String) table.getModel().getValueAt(linha, 3));
				}
			}
		});
		button_1.setBounds(245, 90, 103, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Excluir");
		button_2.setBounds(360, 90, 98, 23);
		getContentPane().add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = table.getSelectedRow();
				if(linha > -1 ) {
					Integer id = Integer.parseInt((String) table.getModel().getValueAt(linha, 0));
					produtoController.excluir(id);
					atualizarTabela(produtoController.consultarTodos(txtPesquisa.getText()));
				}
			}
		});
		
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(45, 150, 87, 14);
		getContentPane().add(lblPesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 193, 618, 178);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Código", "Nome", "Valor","Quantidade"}));
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		
		txtPesquisa = new JTextField();
		txtPesquisa.setColumns(10);
		txtPesquisa.setBounds(131, 148, 284, 20);
		getContentPane().add(txtPesquisa);
		
		JLabel label_2 = new JLabel("Gerenciamento de produtos");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_2.setBounds(117, 0, 328, 27);
		getContentPane().add(label_2);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(447, 60, 101, 15);
		getContentPane().add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(547, 58, 55, 19);
		getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabela(produtoController.consultarTodos(txtPesquisa.getText()));
			}
		});
		btnBuscar.setBounds(427, 145, 117, 25);
		getContentPane().add(btnBuscar);

		atualizarTabela(produtoController.consultarTodos(txtPesquisa.getText()));
	}
	private void limparCampos() {
		this.idProduto = null;
		this.txtNomeProduto.setText("");
		this.txtValor.setText("");
		this.txtQuantidade.setText("");
	}
	
	private void limparTabela() {
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Código", "Nome", "Valor","Quantidade" }));
		
	}
	protected void atualizarTabela(ArrayList<ProdutoVO> produtos) {
		limparTabela();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		//Percorre as sobremesas para adicionar linha a linha na tabela (JTable)
		for(ProdutoVO produto: produtos) {
			String[] novaLinha = new String[4];
			novaLinha[0] = produto.getId() +"";
			novaLinha[1] = produto.getNomeProduto();
			novaLinha[2] = String.valueOf(produto.getValor());
			novaLinha[3] = String.valueOf(produto.getQuantidade());
			
			//Adiciona a nova linha na tabela
			model.addRow(novaLinha);
		}
	}
}
