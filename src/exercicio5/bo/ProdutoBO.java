package exercicio5.bo;

import exercicio5.banco.ProdutoDAO;
import exercicio5.vo.ProdutoVO;

public class ProdutoBO {
	private ProdutoDAO produtoDao = new ProdutoDAO();

	public int cadastrar(ProdutoVO produto) {
		return produtoDao.cadastrarProdutoDAO(produto);
	}
	
	public int atualizar(ProdutoVO produto) {
		return produtoDao.atualizarProdutoDAO(produto);
	}
}
