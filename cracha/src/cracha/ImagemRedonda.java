package cracha;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

public class ImagemRedonda {
	
	private static BufferedImage imagemRedonda(BufferedImage input) {
		int i = Math.min(input.getWidth(), input.getHeight());
		BufferedImage other = new BufferedImage(i, i, input.TYPE_INT_ARGB);

		Graphics2D g2d = other.createGraphics();	
		g2d.setClip(new Ellipse2D.Double(0, 0, i, i));
		g2d.drawImage(input, 0, 0, null);	
		g2d.dispose();
		
		return other;
	}
	public static void main(String[] args) {
		File imagem = new File("C:\\Users\\Kaio\\Documents\\cracha_vivo\\datena.jpg");
		File novaImagem = new File("C:\\Users\\Kaio\\Documents\\cracha_vivo\\datena_recortado.jpg");
		
		try {
			novaImagem.createNewFile();
			ImageOutputStream out = new FileImageOutputStream(novaImagem);
			BufferedImage bfi = imagemRedonda(ImageIO.read(imagem));
			ImageIO.write(bfi, "png", out);
			
			out.close();
		} catch (Exception e) {e.printStackTrace();}
	}
}
