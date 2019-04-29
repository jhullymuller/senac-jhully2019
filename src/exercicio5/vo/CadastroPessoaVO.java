package exercicio5.vo;

import java.util.Date;

public class CadastroPessoaVO {
private String nomeCliente;
private Date dataNascimento;
private String cep;
public CadastroPessoaVO() {
	super();
}
public CadastroPessoaVO(String nomeCliente, Date dataNascimento, String cep) {
	super();
	this.nomeCliente = nomeCliente;
	this.dataNascimento = dataNascimento;
	this.cep = cep;
}
public String getNomeCliente() {
	return nomeCliente;
}
public void setNomeCliente(String nomeCliente) {
	this.nomeCliente = nomeCliente;
}
public Date getDataNascimento() {
	return dataNascimento;
}
public void setDataNascimento(Date dataNascimento) {
	this.dataNascimento = dataNascimento;
}
public String getCep() {
	return cep;
}
public void setCep(String cep) {
	this.cep = cep;
}



}
