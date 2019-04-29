package exercicio5.vo;

public class ProdutoVO {
	
	private int id, quantidade;
	private String nomeProduto;
	private double valor;
	public ProdutoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProdutoVO(int id, int quantidade, String nomeProduto, double valor) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.nomeProduto = nomeProduto;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	}
	

