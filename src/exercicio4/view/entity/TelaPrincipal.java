package exercicio4.view.entity;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends  JFrame {

	private JPanel contentPane;
	private Cadastrar cadastrar;
	private JDesktopPane desktopPane;
	private TelaListagem telaListagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 491);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.select"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 448, 21);
		contentPane.add(menuBar);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent  e) {
				if (cadastrar == null) {
					cadastrar = new Cadastrar();
					desktopPane.add(cadastrar);
					cadastrar.show();
				} else if (cadastrar != null) {
					cadastrar.setVisible(true);
				}
			}
		});
		menuBar.add(mntmCadastrar);
		
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (telaListagem == null) {
					telaListagem = new TelaListagem();
					desktopPane.add(telaListagem);
					telaListagem.show();
				} else if (telaListagem != null) {
					telaListagem.setVisible(true);
				}
			}
		});
		menuBar.add(mntmListar);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mntmExcluir);
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(UIManager.getColor("ComboBox.disabledForeground"));
		desktopPane.setBounds(10, 33, 650, 419);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);
	}
	

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
