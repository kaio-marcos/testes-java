package testes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String frase = "abc";
		String frase2 = new String("abc");
		
		if(frase == frase2) {
			System.out.println("sim");
		}
		
		LocalDate l = LocalDate.now();
		LocalDate l2 = LocalDate.now();
		if(l.equals(l2)) {
			System.out.println("ok");
		}
	}

}
