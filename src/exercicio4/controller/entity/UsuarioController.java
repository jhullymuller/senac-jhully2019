package exercicio4.controller.entity;

import java.util.ArrayList;

import exercicio4.model.dao.UsuarioDao;
import exercicio4.model.entity.Nivel;
import exercicio4.model.entity.Usuario;

public class UsuarioController {

	// Verificar se os campos s�o nulos ou vazios senao chamar BO
	public String cadastrar(String nome, String email, String senha, Nivel nivel,String confirmacaoSenha) {
		String mensagem = "";
		if (nome == null || nome.trim().isEmpty()) {
			mensagem += "Erro por favor digite um nome, e sem espa�o \n";
		}
		if (email == null || email.trim().isEmpty()) {
			mensagem += "Erro por favor digite um email, e sem espa�o \n";
		}
		if (senha == null || senha.trim().isEmpty()) {
			mensagem += "Erro por favor digite uma senha, e sem espa�o \n";
		}
		if (nivel == null ){
			mensagem += "Erro por favor digite um nivel, e sem espa�o \n";
		}
		if (!senha.equals(confirmacaoSenha)) {
			mensagem += "Senhas n�o compativ�is";
		}
		// validar o preenchimento dos campos - nao nulos e nao vazios
		if (mensagem.isEmpty()) {
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setNivel(nivel);

			UsuarioBO bo = new UsuarioBO();

			mensagem = bo.cadastrar(usuario);

			return mensagem;
		}
		return mensagem;
	}
	public ArrayList<Usuario> consultarTodos() {
		UsuarioBO bo = new UsuarioBO();
		return bo.consultarTodos();
	}
	
	public boolean remover(Integer id) {
		UsuarioBO bo = new UsuarioBO();
		return bo.remover(id);
	}
}
