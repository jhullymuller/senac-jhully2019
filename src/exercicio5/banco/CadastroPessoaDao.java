package exercicio5.banco;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import exercicio5.vo.CadastroPessoaVO;



public class CadastroPessoaDao {
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public boolean salvar(CadastroPessoaVO cadastro) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		String query = "insert into usuario(nome,datanascimento,cep) values ('" + cadastro.getNomeCliente() + "','"
				+ df.format(cadastro.getDataNascimento()) + "','" + cadastro.getCep() + "')";
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

	

	
}
