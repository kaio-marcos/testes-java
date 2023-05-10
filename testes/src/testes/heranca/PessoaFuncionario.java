package testes.heranca;

public class PessoaFuncionario extends Pessoa {
	
	private String numeroRegistro;
	
	public PessoaFuncionario(String nome, String endereco, String cpf) {
		super(nome, endereco, cpf);
	}
	
	public final String getNumeroRegistro() {
		return numeroRegistro;
	}
	
	
}
