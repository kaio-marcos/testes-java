package testes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invoke {
	
	private String nome;
	
	public String getName() {
		System.out.println("opa");
		return "a";
	}
	
	public void setName(String nome) {
		this.nome = nome;
	}
	
	public static void invocar(Object objt) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Method m = objt.getClass().getDeclaredMethod("getName");
		if(!m.getReturnType().equals(String.class)) {
			throw new IllegalAccessException("Type of return is not String class");
		}
        Object rv = m.invoke(objt);
        
        System.out.println(rv);  
	}
	
	public static void main(String[] args) {
		try {
			Invoke i = new Invoke(); 
			i.setName("Teste");
			invocar(i);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
