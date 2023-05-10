package testes;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Math;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Main {

	public static void main(String[] args) throws ParseException, IOException {
		List<Float> duracoes = new ArrayList<Float>();
		duracoes.add(2.02f);
		duracoes.add(2.95f);
		duracoes.add(1.14f);
		duracoes.add(2.13f);
		duracoes.add(1.86f);
		duracoes.add(1.45f);
		duracoes.add(1.5f);
		duracoes.add(2.77f);
		duracoes.add(1.55f);
		duracoes.add(1.49f);
		duracoes.add(1.2f);
		duracoes.add(2.89f);
		duracoes.add(2f);
		duracoes.add(1.75f);
		duracoes.add(2.56f);
		duracoes.add(2.05f);
		duracoes.add(2.19f);
		duracoes.add(1.11f);
		duracoes.add(1.81f);
		duracoes.add(2.45f);
		duracoes.add(1.37f);
		duracoes.add(2.67f);
		duracoes.add(1.63f);
		duracoes.add(1.89f);
		duracoes.add(1.76f);
		duracoes.add(2.05f);
		duracoes.add(2.98f);
		duracoes.add(2.53f);
		duracoes.add(2.15f);
		duracoes.add(1.21f);
		duracoes.add(2.43f);
		duracoes.add(2.21f);
		duracoes.add(2.15f);
		duracoes.add(2.85f);
		duracoes.add(1.28f);
		duracoes.add(2.17f);
		duracoes.add(1.52f);
		duracoes.add(1.33f);
		duracoes.add(2.14f);
		duracoes.add(2.93f);
		duracoes.add(1.39f);
		duracoes.add(2.83f);
		duracoes.add(1.19f);
		duracoes.add(1.21f);
		duracoes.add(1.09f);
		duracoes.add(1.77f);
		duracoes.add(2.93f);
		duracoes.add(2.53f);
		duracoes.add(1.4f);
		duracoes.add(2.49f);
		duracoes.add(2.81f);
		duracoes.add(2.05f);
		duracoes.add(2.48f);
		duracoes.add(2.47f);
		duracoes.add(1.95f);
		duracoes.add(1.41f);
		duracoes.add(2.12f);
		duracoes.add(2.45f);
		duracoes.add(1.68f);
		duracoes.add(1.57f);
		duracoes.add(1.66f);
		duracoes.add(1.69f);
		duracoes.add(1.68f);
		duracoes.add(2.93f);
		duracoes.add(1.27f);
		duracoes.add(1.77f);
		duracoes.add(2.97f);
		duracoes.add(1.89f);
		duracoes.add(2.15f);
		duracoes.add(1.37f);
		duracoes.add(1.35f);
		duracoes.add(2.05f);
		duracoes.add(1.12f);
		duracoes.add(1.37f);
		duracoes.add(2.89f);
		duracoes.add(2.05f);
		duracoes.add(1.11f);
		duracoes.add(2.23f);
		duracoes.add(2.6f);
		duracoes.add(1.33f);
		duracoes.add(1.42f);
		duracoes.add(1.31f);
		duracoes.add(1.89f);
		duracoes.add(2.33f);
		duracoes.add(1.94f);
		duracoes.add(1.47f);
		duracoes.add(2.29f);
		duracoes.add(2.61f);
		duracoes.add(2.92f);
		duracoes.add(2.45f);
		duracoes.add(1.89f);
		duracoes.add(1.49f);
		duracoes.add(2.34f);
		duracoes.add(2.63f);
		duracoes.add(1.82f);
		duracoes.add(2.53f);
		duracoes.add(1.59f);
		duracoes.add(2.03f);
		duracoes.add(1.92f);
		duracoes.add(1.65f);
		duracoes.add(2.17f);
		duracoes.add(2.67f);
		duracoes.add(1.43f);
		duracoes.add(1.17f);
		duracoes.add(1.61f);
		duracoes.add(2.51f);
		duracoes.add(2.48f);
		duracoes.add(2.25f);
		duracoes.add(1.56f);
		duracoes.add(2.39f);
		duracoes.add(2.12f);
		duracoes.add(2.61f);
		duracoes.add(2.76f);
		duracoes.add(1.93f);
		duracoes.add(1.71f);
		duracoes.add(2.57f);
		duracoes.add(2.77f);
		duracoes.add(2.47f);
		duracoes.add(2.36f);
		duracoes.add(2.05f);
		duracoes.add(1.5f);
		duracoes.add(1.25f);
		duracoes.add(1.98f);
		duracoes.add(1.41f);
		duracoes.add(1.46f);
		duracoes.add(1.63f);
		duracoes.add(2.67f);
		duracoes.add(1.57f);
		duracoes.add(2.25f);
		duracoes.add(1.31f);
		duracoes.add(1.41f);
		duracoes.add(2.45f);
		duracoes.add(1.47f);
		duracoes.add(2.93f);
		duracoes.add(1.46f);
		duracoes.add(1.73f);
		duracoes.add(1.82f);
		duracoes.add(2.07f);
		duracoes.add(1.86f);
		duracoes.add(1.05f);
		duracoes.add(2.29f);
		duracoes.add(1.35f);
		duracoes.add(1.98f);
		duracoes.add(1.97f);
		duracoes.add(2.4f);
		duracoes.add(1.53f);
		duracoes.add(2.65f);
		duracoes.add(2.29f);
		duracoes.add(1.12f);
		duracoes.add(1.35f);
		duracoes.add(1.45f);
		duracoes.add(2.77f);
		duracoes.add(2.61f);
		duracoes.add(2.63f);
		duracoes.add(1.96f);
		duracoes.add(2.25f);
		duracoes.add(2.14f);
		duracoes.add(1.87f);
		duracoes.add(1.94f);
		duracoes.add(2.93f);
		duracoes.add(2.88f);
		duracoes.add(2.19f);
		duracoes.add(2.02f);
		duracoes.add(2.53f);
		duracoes.add(1.38f);
		duracoes.add(1.27f);
		duracoes.add(2.11f);
		duracoes.add(1.49f);
		duracoes.add(2.2f);
		duracoes.add(1.83f);
		duracoes.add(1.32f);
		duracoes.add(2.25f);
		duracoes.add(1.65f);
		duracoes.add(2.37f);
		duracoes.add(2.57f);
		duracoes.add(2.29f);
		duracoes.add(2.29f);
		duracoes.add(1.09f);
		duracoes.add(2.99f);
		duracoes.add(1.01f);
		duracoes.add(1.73f);
		duracoes.add(1.89f);
		duracoes.add(2.47f);
		duracoes.add(1.09f);
		duracoes.add(2.69f);
		duracoes.add(2.71f);
		duracoes.add(2.73f);
		duracoes.add(1.69f);
		duracoes.add(1.31f);
		duracoes.add(1.23f);
		duracoes.add(2.36f);
		duracoes.add(2.29f);
		duracoes.add(1.1f);
		duracoes.add(1.99f);
		duracoes.add(1.44f);
		duracoes.add(2.89f);
		duracoes.add(1.32f);
		duracoes.add(1.93f);
		duracoes.add(1.72f);
		duracoes.add(1.17f);
		
        int dias = 0;
        if(duracoes != null && duracoes.size() > 1 && duracoes.size() < 1000){
            
            while(duracoes.size() > 0){
            	
                int posicao = posicaoMaiorValor(duracoes);
                float duracao = duracoes.get(posicao);
                float totalDuracaoDia = duracao;
                if(duracao >= 1.01f && duracao < 3.0f){
                	duracoes.remove(posicao);
                	
                	while(duracoes.size() > 0) {
                		Integer posicaoMenor = haValorMenorIgual(duracoes, totalDuracaoDia);
                		if(posicaoMenor != null) {
                			float totalDuracaoDiaAux = totalDuracaoDia + duracoes.get(posicaoMenor);
                			if(totalDuracaoDiaAux <= 3.0f) {
                				totalDuracaoDia = totalDuracaoDiaAux;
                			}else {
                				break;
                			}
                			
                			duracoes.remove((int)posicaoMenor);
                		}else {
                			break;
                		}
                    }
                }
                
				totalDuracaoDia = 0f;
				dias += 1;
            }

        }

        System.out.println(dias);
		
//		double x = Math.floor(15 / 3);
//		DecimalFormat df = new DecimalFormat("#.00");
//		System.out.println(df.format(17/3));
//		double x2 = Math.floor(50 / 3);
//		double y = Math.nextUp(x2);
		
//		String sourceFile = "C:\\Users\\Kaio\\Documents\\copy_bytes\\arquivo_entrada.txt";
//		File arquivoCompresso = new File("C:\\Users\\Kaio\\Documents\\copy_bytes\\compressed.zip");
//		
//		FileOutputStream fos = new FileOutputStream(arquivoCompresso);
//        ZipOutputStream zipOut = new ZipOutputStream(fos);
//        
//        File fileToZip = new File(sourceFile);
//        FileInputStream fis = new FileInputStream(fileToZip);
//        ZipEntry zipEntry = new ZipEntry("tabloide teste/" + "arquivoteste.txt");
//        
//        zipOut.putNextEntry(zipEntry);
//        int b;
//        while((b = fis.read()) != -1) {
//        	zipOut.write(b);
//        }

//        byte[] bytes = new byte[1024];
//        int length;
//        while((length = fis.read(bytes)) >= 0) {
//            zipOut.write(bytes, 0, length);
//        }
        
//        zipOut.close();
//        fis.close();
//        fos.close();
	}
	private static Integer haValorMenorIgual(List<Float> valores, Float totalDia){
		List<Float> valoresAux = valores;
		Integer posicaoMenor = null;
        Collections.sort(valoresAux);
        for(int i = valoresAux.size() - 1; i >= 0; i--){
        	if(valoresAux.get(i) >= 1.01f && valoresAux.get(i) < 3.0f){
        		if(totalDia + valoresAux.get(i) <= 3.0f) {
        			posicaoMenor = i;
        			break;
        		}
        	}
        }
        
        return posicaoMenor;
    }
	
    private static int posicaoMaiorValor(List<Float> valores){
        Integer posicaoMaior = null;
        for(int i = 0; i < valores.size(); i++){
        	if(posicaoMaior == null || valores.get(posicaoMaior) < valores.get(i)){
        		posicaoMaior = i;
        	}
        }
        return posicaoMaior;
    }
}
