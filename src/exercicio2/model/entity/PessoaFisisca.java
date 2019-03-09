package exercicio2.model.entity;

public class PessoaFisisca extends Cliente {
	
	private String cpf;
	private String sexo;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Double getSaldo() {
		return super.getSaldo();
	}	
	
	
}