package testes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Ordenar {
	
	// passar uma ordem 
	
	private static String invocarMetodo(Object arg) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m = arg.getClass().getDeclaredMethod("getStringParaOrdenar");
		if(!m.getReturnType().equals(String.class)) {
			throw new IllegalAccessException("Type of return is not String class");
		}
		Object retornoDoMetodo = m.invoke(arg);
		String texto = ((String) retornoDoMetodo).trim();
		return texto;
	}
	
	public static List<Object> ordemAlfabetica(List<Object> conteudo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		char[] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 
				'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
				'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
				'y', 'z'};
		
		if(conteudo == null || conteudo.size() <= 1) {
			throw new IllegalStateException("Parâmetro List vazia ou contendo apenas um elemento.");
		}
		List<Object> conteudoOrdenado = new ArrayList<Object>();
		
		for(int i=0; i < conteudo.size(); i++) {
			Object o = conteudo.get(i);
			String texto = invocarMetodo(o);
	        if(texto.length() > 0) {
	        	if(conteudoOrdenado.size() == 0) {
	        		conteudoOrdenado.add(o);
	        	}else {
	        		boolean ordenado = false;
	        		int count = 0;
	        		while (ordenado) {
	        			char charIndex = texto.charAt(count);
	        			int indexChar = -1;
	        			for(int j=0; j<letras.length; j++) {
	        				if(letras[j] == charIndex) {
	        					indexChar = j;
	        				}
	        			}
	        			if(indexChar != -1) {
	        				char proximoCharIndex = texto.charAt(count + 1);
	        				//char proximoCharIndex = texto.charAt(count + 1);
//	        				if(proximaLetraIndex != ' ') {
//	        					
//	        				}
	        			}
	        			count++;
	        		}
	        	}
	        	
	        }
		}
		
		return null;
	}
	
}
