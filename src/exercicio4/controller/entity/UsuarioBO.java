package exercicio4.controller.entity;

import java.util.ArrayList;

import exercicio4.model.dao.UsuarioDao;
import exercicio4.model.entity.Usuario;

public class UsuarioBO {

	public String cadastrar(Usuario novo) {

		String mensagem = validarCampos(novo);

		if (mensagem.isEmpty()) {
			UsuarioDao dao = new UsuarioDao();
			dao.cadastrar(novo);
			mensagem = "Cadastrado com Sucesso";
		}
		return mensagem;

	}

	private String validarCampos(Usuario novo) {
		String mensagem = "";
		if (novo.getNome() == null || novo.getNome().trim().length() < 3) {
			mensagem += "- Nome deve possuir pelo menos 3 caracteres \n";
		}

		if (novo.getSenha() == null || novo.getSenha().trim().length() < 6) {
			mensagem += "Senha deve conter no minimo 6 caracteres \n";
		}

		/**
		 * verifica se tem arroba e se tem mais de 1 arroba
		 */
		int numArrobas = 0;
		for (char c : novo.getEmail().toCharArray()) {
			if (c == '@') {
				numArrobas++;
			}
		}
		if (numArrobas != 1) {
			mensagem += "Email inválido \n";
		} 

		return mensagem;
	}
	public ArrayList<Usuario> consultarTodos(String nome,Integer nivel) {
		UsuarioDao dao = new UsuarioDao();
		return dao.consultarTodos(nome,nivel);
	}

	public boolean remover(Integer id) {
		UsuarioDao dao = new UsuarioDao();
		return dao.remover(id);
	}

}
