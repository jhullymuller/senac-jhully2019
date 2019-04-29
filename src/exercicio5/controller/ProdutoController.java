package exercicio5.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import exercicio5.banco.ProdutoDAO;
import exercicio5.bo.ProdutoBO;
import exercicio5.vo.ProdutoVO;

public class ProdutoController {
	private ProdutoBO produtoBO = new ProdutoBO();

	public void cadastrar(String nomeProduto, String valor, String quantidade) {
		ProdutoVO produtoVO = new ProdutoVO();
		produtoVO.setNomeProduto(nomeProduto);
		try {
			produtoVO.setValor(Double.parseDouble(valor));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Por favor digite com .");
			return;
		}
		try {
			produtoVO.setQuantidade(Integer.parseInt(quantidade));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Por Favor digite um número válido");
			return;
		}
		int r = produtoBO.cadastrar(produtoVO);
		if (r == 1) {
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "NÃo foi possivel cadastrar");
		}

	}

	public void atualizar(Integer id, String nomeProduto, String valor, String quantidade) {
		ProdutoVO produtoVO = new ProdutoVO();
		produtoVO.setId(id);
		produtoVO.setNomeProduto(nomeProduto);
		try {
			produtoVO.setValor(Double.parseDouble(valor));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Por favor digite com .");
			return;
		}
		try {
			produtoVO.setQuantidade(Integer.parseInt(quantidade));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Por Favor digite um número válido");
			return;
		}
		int r = produtoBO.atualizar(produtoVO);
		if (r == 1) {
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "NÃ£o foi possivel atualizar");
		}

	}

	public void excluir(Integer id) {
		ProdutoDAO pdao = new ProdutoDAO();
		int r = pdao.excluirProdutoDAO(id);
		if (r == 1) {
			JOptionPane.showMessageDialog(null, "Excluido com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "NÃ£o foi possivel excluir");
		}

	}

	public ArrayList<ProdutoVO> consultarTodos(String nome) {
		ProdutoDAO pdao = new ProdutoDAO();
		ArrayList<ProdutoVO> pvo = pdao.consultarTodosProdutosDAO( nome);
		if (pvo.isEmpty()) {
			JOptionPane.showMessageDialog(null, "NÃ£o existem vendas no banco");
		}
		return pvo;
	}

	public ArrayList<ProdutoVO> consultarProdutoPorId(ProdutoVO produtoVO) {
		ProdutoDAO pdao = new ProdutoDAO();
		ArrayList<ProdutoVO> pvo = pdao.consultarProdutoPorIdDAO(produtoVO);
		if (pvo == null) {
			JOptionPane.showMessageDialog(null, "NÃ£o existe vendas com esse id");
		}
		return pvo;
	}

}
