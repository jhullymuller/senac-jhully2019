package exercicio3.model.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class MenuJOptionPane {

	private final static List<Usuario> usuarios = new ArrayList();
	private static final String Usuario = null;
	private static final String Normal = null;
	private static final String Admin = null;

	private static int idUsuario = 1;

	public static void main(String[] args) {
		menuPrincipal();
	}

	private static void listarUsuarios() {
		String usuariosString = "";
		for (Usuario usuario : usuarios) {
			usuariosString += usuario.toString()+"\n";
		}
		JOptionPane.showMessageDialog(null, usuariosString);
		menuPrincipal();
	}

	private static void excluirUsuario() {
		for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
			Usuario usuario = (Usuario) iterator.next();
			JOptionPane.showConfirmDialog(null, "Normal","Admin", idUsuario, idUsuario);
			try {
				if (Usuario == "Admin") {
					JOptionPane.showInputDialog(null,"Digite sua senha ");
					JOptionPane.showInputDialog(null, "Digite o Id do Usuario ");
				}
			} catch (Exception e) {
				if (Usuario == "Normal") {
					JOptionPane.showMessageDialog(null, "Somente Usu�rio Admin pode excluir");
				}
			}
			int id = 0;
			if(id  == usuario.getId()) {
				iterator.remove();
				JOptionPane.showMessageDialog(null, "Usuario removido com sucesso");
				menuPrincipal();
			}
		} 
		JOptionPane.showMessageDialog(null, "Usuario nao encontrado ");
		menuPrincipal();
		
	}

	private static void cadastrarUsuario() {
		String nomeInformad = JOptionPane.showInputDialog(null, "Digite o nome");
		String emailSalvo = JOptionPane.showInputDialog(null, "Digite o e-mail");
		String senhaSalva = JOptionPane.showInputDialog(null, "Digite a senha");
		String nivelSalvo = JOptionPane.showInputDialog(null, "Digite o Nivel:(Admin,Normal)");
		Usuario usuarioNovo = new Usuario();
		usuarioNovo.setId(idUsuario++);
		usuarioNovo.setNome(nomeInformad);
		usuarioNovo.setEmail(emailSalvo);
		usuarioNovo.setSenha(senhaSalva);
		usuarioNovo.setNivel(NivelEnum.valueOf(nivelSalvo));
		JOptionPane.showMessageDialog(null, "Usu�rio Cadastrado com Sucesso");
		usuarios.add(usuarioNovo);
		JOptionPane.showMessageDialog(null, usuarioNovo.toString());
		menuPrincipal();
	}

	private static void menuPrincipal() {
		try {
			int escolha = Integer.parseInt(
					JOptionPane.showInputDialog("Digite uma op��o:\n1) Cadastrar\n2) Excluir\n3) Listar Todos\n4)Sair"));
			if (escolha < 1 || escolha > 4) {
				JOptionPane.showMessageDialog(null, "Op�ao inv�lida");
				menuPrincipal();
			}
			switch (escolha) {
			case 1:
				cadastrarUsuario();
				break;
			case 2:
				excluirUsuario();
				break;
			case 3:
				listarUsuarios();
				break;
			case 4:
				System.exit(0);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Op�ao inv�lida");
			menuPrincipal();
		}
	}

}
