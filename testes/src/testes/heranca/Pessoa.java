package testes.heranca;

public class Pessoa {
	
	public String nome;
	public String sobrenome;
	public String endereco;
	public String cpf;
	public ContaCorrente contaCorrente;
	
	public Pessoa(String nome, String endereco, String cpf) {
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.contaCorrente = new ContaCorrente();
	}
	
	public String getNomeCompleto() {
		return nome + " " + sobrenome;
	}
}
