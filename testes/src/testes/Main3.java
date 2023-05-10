package testes;

public class Main3 {

	public static void main(String[] args) {
		
		int[][] list = new int[10][];
		for(int i = 0; i <= 10; i++)
			list[i] = new int[i+1];
		
    	int[] primos = { 2,3,5,7,11,13,17,19,23,29,31 };
        int[] somas = new int[11];
        for(int i = 0; i < 11; i++){
            somas[i] = 0;
            for(int j = 0; j <= i; j++){      
                somas[i] += primos[j];
            }
        }
        
        for(int i = 0; i < 11; i++)
            System.out.print(" "+somas[i]);
        
        int[][] tab = new int[10][10];
        for(int i = 0; i < 10; i++)
        	for(int j = 0; j < 10; j++)
        		tab[i][j] = i*(j+1);
        
        int[][] p = new int[10][];
        for(int i = 0; i < 10; i++) {
        	p[i] = new int[i+1];        	
        }
        for(int i = 0; i < 10; i++){
        	p[i][0] = 1;
        	p[i][i] = 1;
        	for(int j = 1; j < i; j++)
        		p[i][j] = p[i-1][j-1]+p[i-1][j];
        }
	}

}
