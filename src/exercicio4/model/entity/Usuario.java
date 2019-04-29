package exercicio4.model.entity;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String confirmacaoSenha;
	private Nivel nivel;
	public Usuario() {
		super();
	}
	public Usuario(int id, String nome, String email, String senha,String confirmacaoSenha, Nivel nivel) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.nivel = nivel;
		this.confirmacaoSenha = confirmacaoSenha;
	}
	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}
	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", confirmacaoSenha="
				+ confirmacaoSenha + ", nivel=" + nivel + "]";
	}

}

