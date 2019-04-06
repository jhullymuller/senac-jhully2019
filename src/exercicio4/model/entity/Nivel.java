package exercicio4.model.entity;

public class Nivel {
	private int id;
	private String descricao;
	public Nivel(int id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "Nivel [id=" + id + ", descricao=" + descricao + "]";
	}
	
}
