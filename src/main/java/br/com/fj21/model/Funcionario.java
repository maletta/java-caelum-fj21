package br.com.fj21.model;

public class Funcionario {

	
	private long cpf;
	private String nome;
	private String sobrenome;
	private long rg;
	
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public long getRg() {
		return rg;
	}
	public void setRg(long rg) {
		this.rg = rg;
	}
	
	@Override
	public String toString() {
		return "Funcionario [cpf=" + cpf + ", nome=" + nome + ", sobrenome=" + sobrenome + ", rg=" + rg + "]";
	}

}
