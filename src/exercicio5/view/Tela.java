package exercicio5.view;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {
	private static final Window frame = null;
	private Ajuda ajuda;
	private JDesktopPane desktopPane;
	private CadastroProdutos cadastroProdutos;
	private Cadastro cadastro;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 398);
		getContentPane().setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		JMenu mnNewMenu = new JMenu("Clientes");
		mnNewMenu.setIcon(new ImageIcon(Tela.class.getResource("../icones/icons8-grupo-de-usu\u00E1rio-homem-mulher-64.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.setIcon(new ImageIcon(Tela.class.getResource("../icones/icons8-adicionar-grupo-de-usu\u00E1rios-mulher-homem-16.png")));
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cadastro ==null) {
					cadastro = new Cadastro();
					desktopPane.add(cadastro);
					cadastro.show();
				}else if(cadastro!= null) {
					cadastro.setVisible(true);
				}
				
			}
		});
		mnNewMenu.add(mntmCadastrar);
		
		JMenu mnNewMenu_1 = new JMenu("Produtos");
		mnNewMenu_1.setIcon(new ImageIcon(Tela.class.getResource("../icones/icons8-adicionar-o-carrinho-de-compras-64.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnCadastrarProduto = new JMenu("Cadastrar Produto");
		mnCadastrarProduto.setIcon(new ImageIcon(Tela.class.getResource("../icones/icons8-adicionar-a-lista-64.png")));
		mnCadastrarProduto.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				if(cadastroProdutos == null) {
					cadastroProdutos = new CadastroProdutos();
					desktopPane.add(cadastroProdutos);
					cadastroProdutos.show();
				} else if(cadastroProdutos != null) {
					cadastroProdutos.setVisible(true);
				}
			}
		});
		mnNewMenu_1.add(mnCadastrarProduto);
		
		JMenu mnNewMenu_2 = new JMenu("Funcionarios");
		mnNewMenu_2.setIcon(new ImageIcon(Tela.class.getResource("../icones/icons8-trabalhador-64.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnAjuda_1 = new JMenu("Ajuda");
		mnAjuda_1.setIcon(new ImageIcon(Tela.class.getResource("../icones/icons8-ajuda-64.png")));
		menuBar.add(mnAjuda_1);
		
		JMenuItem mntmTireAsSuas = new JMenuItem("Tire as suas Duvidas");
		mntmTireAsSuas.setIcon(new ImageIcon(Tela.class.getResource("../icones/icons8-por-que-n\u00F3s-feminino-40.png")));
		mntmTireAsSuas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ajuda == null) {
					ajuda = new Ajuda();
					desktopPane.add(ajuda);
					ajuda.show();
				} else if (ajuda != null) {
					ajuda.setVisible(true);
					ajuda.show();
				}
			}
		});
		mnAjuda_1.add(mntmTireAsSuas);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(UIManager.getColor("ComboBox.disabledForeground"));
		desktopPane.setBounds(0, 0, 10000, 1000);
		getContentPane().add(desktopPane);
		desktopPane.setLayout(null);
	
	}
}
