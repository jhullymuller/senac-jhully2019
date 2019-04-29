package exercicio5.bo;

import exercicio5.banco.CadastroPessoaDao;
import exercicio5.vo.CadastroPessoaVO;

public class CadastroPessoaBO {
private CadastroPessoaDao  cadastroPessoaDao = new CadastroPessoaDao();
	public void salvar(CadastroPessoaVO cadastro) {
		cadastroPessoaDao.salvar(cadastro);
		
	}

}
