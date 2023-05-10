package testes.heranca;

public class ContaCorrente {
	
	private Double saldo;
	
	public final Double getSaldo() {
		return saldo;
	}
	
	public final void setSaldo(Double saldo) {
		this.saldo += saldo;
	}
	
}
