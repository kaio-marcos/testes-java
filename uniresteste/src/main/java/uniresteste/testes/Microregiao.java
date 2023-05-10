package uniresteste.testes;

public class Microregiao {
	
	private Long id;
	private String nome;
	
	private Mesoregiao mesoregiao;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Mesoregiao getMesoregiao() {
		return mesoregiao;
	}
	public void setMesoregiao(Mesoregiao mesoregiao) {
		this.mesoregiao = mesoregiao;
	}
}
