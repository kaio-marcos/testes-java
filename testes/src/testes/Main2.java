package testes;

import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int corPrincipal = 0;
		int linha, coluna;
		
		while (corPrincipal == 0 || corPrincipal > 2) {
			System.out.println("Qual cor do quadrado 1x1:");
			System.out.println("1 - Preto");
			System.out.println("2 - Branco");
			try {
				corPrincipal = sc.nextInt();
			} catch (Exception e) {System.out.println("Valor inv�lido:");}
		}
		
		System.out.println("Qual a linha do quadrado:");
		linha = sc.nextInt();
		System.out.println("Qual a coluna do quadrado:");
		coluna = sc.nextInt();
		
		if(corPrincipal == 1) {
			if((linha % 2 == 0 && coluna % 2 == 0) || (linha % 2 != 0 && coluna % 2 != 0))
				System.out.println("O quadrado " + linha + "x"+ coluna + " � preta");
			else
				System.out.println("O quadrado " + linha + "x"+ coluna + " � branco");

		}else if(corPrincipal == 2) {
			if((linha % 2 == 0 && coluna % 2 == 0) || (linha % 2 != 0 && coluna % 2 != 0))
				System.out.println("O quadrado " + linha + "x"+ coluna + " � branco");
			else
				System.out.println("O quadrado " + linha + "x"+ coluna + " � preto");
		}
	}
}
