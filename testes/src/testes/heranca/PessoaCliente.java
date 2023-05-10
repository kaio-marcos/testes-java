package testes.heranca;

public class PessoaCliente extends Pessoa {
	
	private String cupom;
	private String bilhetePremiado;
	
	public PessoaCliente(String nome, String endereco, String cpf) {
		super(nome, endereco, cpf);
	}
	
	public String getCupom() {
		return cupom;
	}
	
	public String getBilhete() {
		return bilhetePremiado;
	}
	
	public String getNomeCompleto() {
		return nome + " " + sobrenome;
	}
	
}
