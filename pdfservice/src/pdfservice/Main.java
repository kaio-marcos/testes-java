package pdfservice;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.portable.ApplicationException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class Main {
	
	public static void main(String[] args) {
		try {
		

//		File original = new File("C:\\Users\\Kaio\\Documents\\cartas_tempest\\Carta_cliente_A5.pdf");
//		File fModificado = new File("C:\\Users\\Kaio\\Documents\\cartas_tempest\\carta_replace_teste.pdf");
//		
//
//		PdfReader reader = new PdfReader(original.toString()); 
//		PdfDictionary dict = reader.getPageN(1);
//	    PdfArray refs = null;
//	    
//	    if (dict.get(PdfName.CONTENTS).isArray()) {
//	        refs = dict.getAsArray(PdfName.CONTENTS);
//	    //If we have just a reference, wrap it in a single item array for convenience
//	    } else if (dict.get(PdfName.CONTENTS).isIndirect()) {
//	        refs = new PdfArray(dict.get(PdfName.CONTENTS));
//	    //Sanity check, should never happen for conforming PDFs
//	    } else {
//	    	System.out.println("erro");
//	    }
//	    for(PdfObject reference : refs) {
//	    	reference = (PRIndirectReference) reference;
//	    	PRStream stream = (PRStream)PdfReader.getPdfObject(reference);
//	    	byte[] data = PdfReader.getStreamBytes(stream);
//		    String dd = new String(data);
//		    dd = dd.replace("<nome do cliente>,", "");
//		    System.out.print(dd);
//		    stream.setData(dd.getBytes());
//	    }
//	    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(fModificado));
//	    
//	    stamper.close();
//	    reader.close();

	    
		File fonte = new File("C:\\Users\\Kaio\\Documents\\\\cartas_tempest\\engrez\\Engrez-Bold.otf");
		File original = new File("C:\\Users\\Kaio\\Documents\\cartas_tempest\\carta_replace.pdf");
		
		byte[] bytes = new byte[(int) fonte.length()];
		FileInputStream fis = null;
		
		try{
            fis = new FileInputStream(fonte);
            fis.read(bytes);
            fis.close();        
            
        }catch(IOException ioExp){
            ioExp.printStackTrace();
        }
		
		BaseFont bf = BaseFont.createFont("Engrez-Bold.otf", BaseFont.WINANSI, BaseFont.EMBEDDED, true, bytes, null);
		
		Font f = new Font(bf);
		f.setColor(BaseColor.WHITE);
		
		for(String nome : readNames()) {
			File fModificado = new File("C:\\Users\\Kaio\\Documents\\cartas_tempest\\arquivos_finais\\carta_"+nome+".pdf");
			PdfReader reader = new PdfReader(new FileInputStream(original));
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(fModificado));
			PdfContentByte canvas = stamper.getOverContent(1);
			
			Phrase phrase = new Phrase();
			f.setSize(18);
			
			Chunk ch = new Chunk(nome.trim() + ",", f);
			phrase.add(ch);
			
			ColumnText ct = new ColumnText(canvas);
			ct.setSimpleColumn(phrase, 220,467,450,100, 30, Element.ALIGN_LEFT);
			ct.go();
			
			stamper.close();
			reader.close();
		}

		} catch (Exception e) {
			e.printStackTrace();
		
		}

	}
	

	
	private static List<String> readNames(){
		
		Path arquivo = Paths.get("C:\\Users\\Kaio\\Documents\\cartas_tempest\\nomes.txt");
		try {
			return Files.readAllLines(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
