package alura_stickers.api;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;


public class GeradoraDeFigurinhas {

	public static void cria(InputStream inputStream, String nomeArquivo) throws Exception {
		// leitura da imagem
		// InputStream inputStream =
		// new FileInputStream(new File("entrada/filme-maior.jpg"));
		//InputStream inputStream = new URL(
		//		"https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
		//				.openStream();
		BufferedImage imagemOriginal = ImageIO.read(inputStream);

		// cria nova imagem em memória com transparência e com tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

		// copiar a imagem original pra novo imagem (em memória)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		// configurar a fonte
		Font fonte = Font.createFont(Font.PLAIN, new File("C:\\Users\\Kaio\\Documents\\cartas_intuit\\impact.ttf"))
				.deriveFont(Font.BOLD, 64);
		//Font fonte = new Font (Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
      
        //define inicio da string a partir da largura das bordas
        String texto = "TOPZERA";        
        FontMetrics fm = graphics.getFontMetrics();
		int larguraTexto = fm.stringWidth(texto);
        float inicio = (largura - larguraTexto) / 2;
               
        // escrever uma frase na nova imagem
        graphics.drawString(texto, inicio, novaAltura - 100);
        
        // contorno do texto
        GlyphVector gpv = fonte.createGlyphVector(graphics.getFontRenderContext(), texto);
        Shape textoContornado = gpv.getOutline();
        graphics.setColor(Color.BLACK);

        graphics.translate(inicio, novaAltura - 100);
        graphics.draw(textoContornado);
        
        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
        

	}
	
	public static void main(String[] args) throws Exception {
		InputStream inputStream = new URL(
						"https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
								.openStream();
		GeradoraDeFigurinhas.cria(inputStream, "C:\\Users\\Kaio\\Documents\\cartas_intuit\\sticker.png");
	}
	
}
