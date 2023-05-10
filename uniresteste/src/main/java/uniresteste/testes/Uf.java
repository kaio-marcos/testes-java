package uniresteste.testes;

public class Uf {
	
	private Long id;
	private String sigla;
	private String nome;
	private Regiao regiao;
	
	public Long getId() {
		return id;
	}
	public String getSigla() {
		return sigla;
	}
	public String getNome() {
		return nome;
	}
	public Regiao getRegiao() {
		return regiao;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	
}
