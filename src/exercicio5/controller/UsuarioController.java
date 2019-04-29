package exercicio5.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import exercicio5.bo.CadastroPessoaBO;
import exercicio5.vo.CadastroPessoaVO;

public class UsuarioController {
	
	private CadastroPessoaBO cadastroPessoaBO = new CadastroPessoaBO();
	
	// Verificar se os campos são nulos ou vazios senao chamar BO
	public String cadastrar(String nomeCliente, String dataNascimento, String cep) {
		String mensagem = "";

		if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
			mensagem += "Erro por favor digite um nome, e sem espaço \n";
		}
		if (dataNascimento == null || nomeCliente.trim().isEmpty()) {
			mensagem += "Erro por favor digite uma data , e sem espaço \n";
		}
		if (cep == null || cep.trim().isEmpty()) {
			mensagem += "Erro por favor digite um cep, e sem espaço \n";
		}
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date data = null;
		try {
			data = df.parse(dataNascimento);
		} catch (ParseException e) {
			mensagem += "Erro por favor digite uma data no formato válido (dd/mm/aaaa) \n";
		}
		
		// validar o preenchimento dos campos - nao nulos e nao vazios
		if (mensagem.isEmpty()) {
			CadastroPessoaVO cadastro = new CadastroPessoaVO();
			cadastro.setNomeCliente(nomeCliente);
			cadastro.setDataNascimento(data);
			cadastro.setCep(cep);
			cadastroPessoaBO.salvar(cadastro);
			return null;
		}
		return mensagem;

	}
}