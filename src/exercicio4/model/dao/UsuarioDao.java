package exercicio4.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exercicio4.model.dao.Banco.Banco;
import exercicio4.model.entity.Nivel;
import exercicio4.model.entity.Usuario;

public class UsuarioDao {

	public boolean cadastrar(Usuario usuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		String query = "insert into usuario(nome,email,senha,nivel) values ('" + usuario.getNome() + "','"
				+ usuario.getEmail() + "','" + usuario.getSenha() + "','" + usuario.getNivel().getId() + "')";
		try {
			return stmt.executeUpdate(query) > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro do Usuario.Erro: " + e.getMessage());

		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return false;
	}

	public boolean remover(Integer id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		String query = "delete from usuario where id = " + id;
		try {
			return stmt.executeUpdate(query) > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de remover do Usuario.Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return false;
	}

	public ArrayList<Usuario> consultarTodos(String nome,Integer nivel) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		String query = "SELECT usuario.id, usuario.nome, usuario.email, nivel.id, nivel.descricao FROM usuario LEFT JOIN nivel on usuario.nivel = nivel.id where UPPER(nome) LIKE UPPER('%"+ nome+"%')";
		if(nivel!=null) {
			query += " and nivel.id = "+ nivel;
		}
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(Integer.parseInt(resultado.getString(1)));
				usuario.setNome(resultado.getString(2));
				usuario.setEmail((resultado.getString(3)));
				usuario.setNivel(new Nivel(resultado.getInt(4), resultado.getString(5)));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Usuários.");
			e.printStackTrace();
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuarios;
	}
}
