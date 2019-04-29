package exercicio5.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exercicio5.vo.ProdutoVO;

public class ProdutoDAO {

	public ProdutoDAO() {
	}

	public int cadastrarProdutoDAO(ProdutoVO produtoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int r = 0;

		String query = "INSERT INTO produto(nomeproduto, valor, quantidade) VALUES ('" + produtoVO.getNomeProduto()
				+ "', '" + produtoVO.getQuantidade() + "', '" + produtoVO.getQuantidade() + "')";
		try {
			r = stmt.executeUpdate(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
		}
		return r;
	}

	public int atualizarProdutoDAO(ProdutoVO produtoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int r = 0;
		String query = "UPDATE produto SET nomeproduto = '"
				+ produtoVO.getNomeProduto() + "', valor = '" + produtoVO.getValor() + "', quantidade = '"
				+ produtoVO.getQuantidade() + "' where id = '" + produtoVO.getId() + "'";
		try {
			r = stmt.executeUpdate(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
		}
		return r;
	}

	public int excluirProdutoDAO(Integer id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int r = 0;
		String query = "DELETE FROM produto WHERE id = '" + id + "'";
		try {
			r = stmt.executeUpdate(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
		}
		return r;
	}

	public ArrayList<ProdutoVO> consultarTodosProdutosDAO(String nome) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet rs = null;
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		String query = "SELECT * FROM produto where UPPER(nomeproduto) LIKE UPPER('%"+ nome+"%')";
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				ProdutoVO produtoVO = new ProdutoVO();
				produtoVO.setId(Integer.parseInt(rs.getString(1)));
				produtoVO.setNomeProduto(rs.getString(2));
				produtoVO.setValor(Double.parseDouble(rs.getString(3)));
				produtoVO.setQuantidade(Integer.parseInt(rs.getString(4)));
				produtos.add(produtoVO);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
			Banco.closeResultSet(rs);
		}
		return produtos;
	}

	public ArrayList<ProdutoVO> consultarProdutoPorIdDAO(ProdutoVO produtoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet rs = null;
		ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		String query = "SELECT * FROM produto WHERE id = '" + produtoVO.getId() + "';";
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				ProdutoVO prodVO = new ProdutoVO();
				prodVO.setId(Integer.parseInt(rs.getString(1)));
				prodVO.setNomeProduto(rs.getString(2));
				prodVO.setValor(Double.parseDouble(rs.getString(3)));
				prodVO.setQuantidade(Integer.parseInt(rs.getString(4)));
				produtos.add(prodVO);
				System.out.println("RESULTADO BANCO: " + rs.getString(1) + " - " + rs.getString(2) + " - "
						+ rs.getString(3) + " - " + rs.getString(4));

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			Banco.closeConnection(conn);
			Banco.closeStatement(stmt);
			Banco.closeResultSet(rs);
		}
		return produtos;
	}

}
