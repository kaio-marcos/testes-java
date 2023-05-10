package br.com.kaio.apache.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import org.apache.poi.POIDocument;
import org.apache.poi.POITextExtractor;
import org.apache.poi.POIXMLPropertiesTextExtractor;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.model.XMLParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlCursor;

public class World {

	private static String teste() {
		return "TESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE"
				+ "TESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE"
				+ "TESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE";
	}
	
	private static void escreveParagrafo(String texto, Integer posicao, XWPFDocument documento) {
//		String textoParagrafo = documento.getParagraphArray(posicao).getText();
//		int novaPosicaoEncontrada = -1;
//		if(!texto.contains(textoParagrafo)) {
//			for(int i=0; i < documento.getParagraphs().size(); i++) {
//				String textoAux = documento.getParagraphArray(i).getText().toLowerCase();
//				if(textoAux.contains(texto)) {
//					novaPosicaoEncontrada = i;
//				}
//			}
//		}
//		if(novaPosicaoEncontrada > -1) {
//			posicao = novaPosicaoEncontrada;
//		}
		String textoParagrafo = documento.getParagraphArray(posicao).getText();

	}
	
	public static void main(String[] args) throws IOException {
		//XWPFDocument docx = new XWPFDocument(new FileInputStream("C:\\Users\\Kaio\\Documents\\world-apache-poi\\MarelliCasesquestionario.docx"));
		XWPFDocument newDocx = new XWPFDocument(new FileInputStream("C:\\Users\\Kaio\\Documents\\world-apache-poi\\MarelliCasesquestionario.docx"));
		
		HashMap<String, String> perguntasERespostas = new HashMap<String, String>();
		perguntasERespostas.put("qual o segmento da empresa", teste());
		perguntasERespostas.put("qual o momento que a empresa vive em sua trajetória", "numa boa trajetória");
		perguntasERespostas.put("quais as características do prédio da empresa", "uma ótima infraestrutura :) ");
		perguntasERespostas.put("quanto à sustentabilidade, quais as ações que podem ser destacadas no projeto", "Extremamente ecológicos");
		perguntasERespostas.put("quais aspectos positivos destaca nos produtos marelli", "A beleza");
		perguntasERespostas.put("Qual a necessidade de renovação do mobiliário da companhia", "Ambiente ruim");
		perguntasERespostas.put("Produtos utilizados:", "lustra móveis");
		perguntasERespostas.put("Loja responsável pela execução:", "caxias do sul");
		
				
		for(String pergunta : perguntasERespostas.keySet()) {
			int indice = -1;
			for(int i=0; i < newDocx.getParagraphs().size(); i++) {
				String texto = newDocx.getParagraphArray(i).getText().toLowerCase();
				if(texto.contains(pergunta.toLowerCase())) {
					indice = i;
					break;
				}
			}
			if(indice > -1) {
				XmlCursor cursor = newDocx.getParagraphArray(indice).getCTP().newCursor();
				cursor.toNextSibling();
				XWPFParagraph newParagraph = newDocx.insertNewParagraph(cursor);
				XWPFRun run = newParagraph.createRun();
				run.setBold(true);
				run.setText(perguntasERespostas.get(pergunta));
			}
		}

		
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Kaio\\Documents\\world-apache-poi\\questionario.docx"));
		newDocx.write(fos);
		fos.close();
	}

}
