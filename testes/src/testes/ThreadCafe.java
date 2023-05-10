package testes;

public class ThreadCafe implements Runnable {
	
	private String pedido;
	
	public ThreadCafe(String pedido) {
		this.pedido = pedido;
	}
	
	@Override
    public void run() {

        System.out.println("O atendente " + Thread.currentThread().getName() + " está preparando seu " + pedido);

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("O atendente "+ Thread.currentThread().getName() + " preparou o seu " + pedido);
    }
}
