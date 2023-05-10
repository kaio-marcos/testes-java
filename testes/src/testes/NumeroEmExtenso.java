package testes;

public class NumeroEmExtenso {

	public static void main(String[] args) {
		String numero = "10000";
		if(numero.length() > 22){
			System.out.println("Só podemos ir até o sextilhão");
			return;
		}
		
		String[][] classes = {  {"mil", "mil"}, 
								{"milhão", "milhões"},
								{"bilhão", "bilhões"},
								{"trilhão", "trilhões"},
								{"quatrilhão", "quatrilhões"},
								{"quintilhão", "quintilhões"},
								{"sextilhão", "sextilhões"}
							}; // com plural
		
		String[][] ordens = new String[3][]; // tres ordens (unidade, dezena, centena)
		
		// cada ordem recebe 10 elementos
		ordens[0] = new String[]{"Um", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Onze", "Doze", "Treze", "Quatorze", "Quinze", "Dezesseis", "Dezesete", "Dezoito", "Dezenove"};
		ordens[1] = new String[]{"Vinte", "Trinta", "Quarenta", "Cinquenta", "Sessenta", "Setenta", "Oitenta", "Noventa"};
		ordens[2] = new String[]{"Cem", "Cento", "Duzentos", "Trezentos", "Quatrocentos", "Quinhentos", "Seiscentos", "Setecentos", "Oitocentos", "Novecentos"};
		
		int linha = 8;
		int coluna = 3;
		Character[][] numerosSeparados = new Character[linha][coluna];
		linha--;
		coluna--;
		
		int classe = -1;
		int count = 0;
		for(int i=numero.length()-1; i>=0; i--) {
			count++;

			if(count > 3) {
				linha--;
				coluna=2;
				count=1;
				if(classe == -1) {
					classe = 0;
				}else {
					classe++;
				}
			}
			
			numerosSeparados[linha][coluna] = numero.charAt(i);
			coluna--;
		}
		
		String[] classesExtensas = new String[7];
		count=0;
		for(int l=0; l<8; l++) {
			String numeroExtenso = "";
			String numeroFormado = "";
			String classeAtual = "";
			
			for(int c=0; c<3; c++) {
				Character caracter = numerosSeparados[l][c];
				if(caracter != null) {
					numeroFormado+=caracter;
				}
			}
			if(numeroFormado != "") {
				// não pode ser a ultima linha e somente a primeira coluna da esquerda pra direita
				// maior que 1 é plural
				if(l < 7 && classe != -1) {
					if(Integer.valueOf(numeroFormado) > 1) {
						classeAtual = classes[classe][1];
					}else if(Integer.valueOf(numeroFormado) > 0) {
						classeAtual = classes[classe][0];
					}						
					classe--;
				}
				
				Integer terceiraOrdem, segundaOrdem, primeiraOrdem, numeroFormadoAux;
				numeroFormado = String.valueOf(Integer.valueOf(numeroFormado));
				
				if(numeroFormado.length() == 3) {
					terceiraOrdem = Integer.valueOf(numeroFormado.substring(0, 1));
					segundaOrdem = Integer.valueOf(numeroFormado.substring(1, 2));
					numeroFormadoAux = Integer.valueOf(numeroFormado);
					if(numeroFormadoAux == 100) {
						numeroExtenso += ordens[2][terceiraOrdem - 1];
					}else if(numeroFormadoAux > 100 && numeroFormadoAux < 200) {
						numeroExtenso += ordens[2][terceiraOrdem ];
					}else if(numeroFormadoAux > 200) {
						numeroExtenso += ordens[2][terceiraOrdem];
					}
					
					numeroFormado = numeroFormado.substring(1, numeroFormado.length());
				}
				if(numeroFormado.length() == 2) {
					segundaOrdem = Integer.valueOf(numeroFormado.substring(0, 1));
					if(segundaOrdem > 0) {
						if(numeroExtenso != "") {
							numeroExtenso += " e ";							
						}
						numeroFormadoAux = Integer.valueOf(numeroFormado);
						if(numeroFormadoAux < 20 && numeroFormadoAux > 9) {
							numeroExtenso += ordens[0][numeroFormadoAux - 1];
							numeroFormado = "";
						}else if(numeroFormadoAux > 0) {
							numeroExtenso += ordens[1][segundaOrdem - 2];
						}
					}
					if(numeroFormado != "") {
						numeroFormado = numeroFormado.substring(1, numeroFormado.length());						
					}
				}
				if(numeroFormado.length() == 1) {
					primeiraOrdem = Integer.valueOf(numeroFormado.substring(0, numeroFormado.length()));
					if(primeiraOrdem > 0) {
						if(numeroExtenso != "") {
							numeroExtenso += " e ";							
						}
						numeroExtenso += ordens[0][primeiraOrdem - 1];
					}
				}
				
				if(classeAtual != "") {
					numeroExtenso += " " + classeAtual + " ";
				}
				if(numeroExtenso != "") {
					classesExtensas[count] = numeroExtenso;					
					count++;
				}
			}
		}
		String fraseFinal = "";
		if(classesExtensas != null && classesExtensas.length > 0) {
			for(int j=0; j<classesExtensas.length; j++) {
				if(classesExtensas[j] != null) {
					fraseFinal += classesExtensas[j].trim();
					if(fraseFinal != "") {
						fraseFinal += " e ";						
					}
				}
			}
			fraseFinal = fraseFinal.substring(0, fraseFinal.length()-2).trim();
		}
		System.out.println(numero + " é igual a:");
		System.out.println(fraseFinal);
	}

}
