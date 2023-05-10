package cracha;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;

public class GeraCracha {

	private static BufferedImage imagemCircular(BufferedImage input) {
		int i = Math.min(input.getWidth(), input.getHeight());
		BufferedImage other = new BufferedImage(i, i, input.TYPE_INT_ARGB);

		Graphics2D g2d = other.createGraphics();
		g2d.setClip(new Ellipse2D.Double(0, 0, i, i));
		g2d.drawImage(input, 0, 0, null);
		g2d.dispose();

		return other;
	}

	private static File geraCracha(String nome, String cargo, String rg) throws IOException, DocumentException {
		File fonteBold = new File("C:\\Users\\Kaio\\Documents\\cracha_vivo\\Roboto-Bold.ttf");
		// File fonteRegular = new
		// File("C:\\Users\\Kaio\\Documents\\cracha_vivo\\Roboto-Regular.ttf");

		File original = new File("C:\\Users\\Kaio\\Documents\\cracha_vivo\\pdforiginal.pdf");

		byte[] bytes = new byte[(int) fonteBold.length()];
		FileInputStream fis = null;

		fis = new FileInputStream(fonteBold);
		fis.read(bytes);
		fis.close();
		BaseFont bfBold = BaseFont.createFont("Roboto-Bold.ttf", BaseFont.WINANSI, BaseFont.EMBEDDED, true, bytes,
				null);

		Font f = new Font(bfBold);
		f.setColor(BaseColor.WHITE);

		File fModificado = new File("C:\\Users\\Kaio\\Documents\\cracha_vivo\\arquivos_finais\\cracha_teste.pdf");

		PdfReader reader = new PdfReader(new FileInputStream(original));
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(fModificado));
		PdfContentByte canvas = stamper.getOverContent(1);

		Phrase phrase = new Phrase();
		f.setSize(13.5f);

		Chunk ch = new Chunk(nome, f);
		phrase.add(ch);

		ColumnText ct = new ColumnText(canvas);
		ct.setSimpleColumn(phrase, 10, 12, 170, 180, 30, Element.ALIGN_CENTER);
		ct.go();

		File imagem = new File("C:\\Users\\Kaio\\Documents\\cracha_vivo\\datena.jpg");
		File novaImagem = new File("C:\\Users\\Kaio\\Documents\\cracha_vivo\\datena_recortado.jpg");
		BufferedImage bfi = null;

		try {
			novaImagem.createNewFile();
			ImageOutputStream out = new FileImageOutputStream(novaImagem);
			bfi = imagemCircular(ImageIO.read(imagem));
			ImageIO.write(bfi, "png", out);

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		byte[] bytesImg = new byte[(int) novaImagem.length()];
		FileInputStream fiStream = null;

		fiStream = new FileInputStream(novaImagem);
		fiStream.read(bytesImg);
		fiStream.close();

		Image perfil = Image.getInstance(bytesImg);
		perfil.setAlignment(Image.MIDDLE);
		perfil.scaleToFit(bfi.getWidth(), bfi.getHeight());

		phrase = new Phrase();
		ch = new Chunk(perfil, 0, 0, true);
		phrase.add(ch);

		ct = new ColumnText(canvas);
		ct.setSimpleColumn(phrase, 75, 3, 130, 116, 30, Element.ALIGN_CENTER);
		ct.go();

		canvas = stamper.getOverContent(2);
		phrase = new Phrase();
		f.setSize(7f);

		ch = new Chunk(nome, f);
		phrase.add(ch);

		ct = new ColumnText(canvas);
		ct.setSimpleColumn(phrase, 10, 209, 170, 239, 30, Element.ALIGN_CENTER);
		ct.go();

		phrase = new Phrase();
		ch = new Chunk(cargo, f);
		phrase.add(ch);

		ct = new ColumnText(canvas);
		ct.setSimpleColumn(phrase, 10, 201, 170, 231, 30, Element.ALIGN_CENTER);
		ct.go();

		phrase = new Phrase();
		ch = new Chunk(rg, f);
		phrase.add(ch);

		ct = new ColumnText(canvas);
		ct.setSimpleColumn(phrase, 10, 192, 170, 223, 30, Element.ALIGN_CENTER);
		ct.go();

		phrase = new Phrase();
		String vCard = "BEGIN:VCARD\n" + "VERSION:3.0\n" + "N:;" + nome + ";;VIVO - ;\n" + "ORG: Canal VIVO PAP;\n"
				+ "TEL:1199999999\n" + "TEL:11999999999\n" + "EMAIL:teste@teste.com\n" + "END:VCARD";

		BarcodeQRCode qr = new BarcodeQRCode(vCard, 1000, 1000, null);
		Image imgQr = qr.getImage();
		imgQr.scaleAbsolute(100, 100);

		ch = new Chunk(imgQr, 0, 0, true);
		phrase.add(ch);

		ct = new ColumnText(canvas);
		ct.setSimpleColumn(phrase, 40, 10, 130, 150, 0, Element.ALIGN_CENTER);
		ct.go();

		stamper.close();
		reader.close();

		return fModificado;
	}

	private static byte[] geraImagemVerso(File file) throws IOException {
		PDDocument document = PDDocument.load(file);
		PDFRenderer pdfRenderer = new PDFRenderer(document);

		BufferedImage bImage = pdfRenderer.renderImageWithDPI(1, 300, ImageType.RGB);
		int w = bImage.getWidth();
		int h = bImage.getHeight();
		BufferedImage cImage = bImage;
		cImage = bImage.getSubimage(0, 0, w, h);

//		File novaImagem = new File("C:\\Users\\Kaio\\Documents\\cracha_vivo\\verso_cracha.png"); 
//		ImageOutputStream out = new FileImageOutputStream(novaImagem);
//
//		ImageIO.write(cImage, "png", out);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(cImage, "png", baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();

		document.close();
		
		return imageInByte;
	}

	private static byte[] geraImagemFrente(File file) throws IOException {
		PDDocument document = PDDocument.load(file);
		PDFRenderer pdfRenderer = new PDFRenderer(document);

		BufferedImage bImage = pdfRenderer.renderImageWithDPI(0, 300, ImageType.RGB);
		int w = bImage.getWidth();
		int h = bImage.getHeight();
		BufferedImage cImage = bImage;
		cImage = bImage.getSubimage(0, 0, w, h);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(cImage, "png", baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		
		document.close();
		
		return imageInByte;
	}

	private static void geraCrachaEmMassa(int quantidade) throws FileNotFoundException, IOException, DocumentException {
		float x = 66.5f, y = 46, width = 178f, height = 272;

		File backGround = new File("C:\\Users\\Kaio\\Documents\\cracha_vivo\\originalmassa.pdf");
		File fModificado = new File("C:\\Users\\Kaio\\Documents\\cracha_vivo\\arquivos_finais\\pdfmassa.pdf");

		PdfReader reader = new PdfReader(new FileInputStream(backGround));
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(fModificado));

		PdfContentByte canvas = stamper.getOverContent(1);

		quantidade = quantidade * 2;
		for (int i = 1; i < quantidade + 1; i++) {
			File cracha = geraCracha("José assumssão" + i, "Gerente de TI" + i, i + "99999999x");

			Image imagemGerada;
			if (i % 2 != 0) {
				imagemGerada = Image.getInstance(geraImagemFrente(cracha));
			} else {
				imagemGerada = Image.getInstance(geraImagemVerso(cracha));
			}

			Phrase phrase = new Phrase();
			imagemGerada.setAlignment(Image.MIDDLE);
			Chunk chunk = new Chunk(imagemGerada, 0, 0);
			phrase.add(chunk);
			ColumnText ct = new ColumnText(canvas);

			ct.setSimpleColumn(phrase, x, y - height, x + width, y, 0, Element.ALIGN_CENTER);
			ct.go();

			x += 234.5f;
		}

		stamper.close();
		reader.close();
	}

	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {

		geraCrachaEmMassa(6);
	}

}
