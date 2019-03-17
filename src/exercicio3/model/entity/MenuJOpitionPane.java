package exercicio3.model.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class MenuJOpitionPane {

	private final static List<Usuario> usuarios = new ArrayList<>();
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
		int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Id do Usuario "));
		for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
			Usuario usuario = (Usuario) iterator.next();
			if(id == usuario.getId()) {
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
		usuarios.add(usuarioNovo);
		JOptionPane.showMessageDialog(null, usuarioNovo.toString());
		menuPrincipal();
	}

	private static void menuPrincipal() {
		try {
			int escolha = Integer.parseInt(
					JOptionPane.showInputDialog("Digite uma opção:\n1) Cadastrar\n2) Excluir\n3) Listar Todos\n4)Sair"));
			if (escolha < 1 || escolha > 4) {
				JOptionPane.showMessageDialog(null, "Opçao inválida");
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
			JOptionPane.showMessageDialog(null, "Opçao inválida");
			menuPrincipal();
		}
	}

}
