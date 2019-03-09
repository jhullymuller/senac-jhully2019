package exercicio2.model.entity;

public class PessoaJuridica extends Cliente{
	private String cnpj;

	public String getcnpj() {
		return cnpj;
	}

	public void setcnpj(String cnpj) {
		cnpj = cnpj;
	}
	public Double getSaldo() {
		return super.getSaldo();
	}	
	

}
