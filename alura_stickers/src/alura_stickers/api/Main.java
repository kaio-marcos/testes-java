package alura_stickers.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;


public class Main {
	
	private static String IMDB_TOP_MOVIES = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
	private static String IMDB_TOP_SERIES = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
	private static String NASA = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
	public static void main(String[] args) throws Exception {
		// conexão http buscando os dados
		Connect con = new Connect(IMDB_TOP_MOVIES, "GET");
		String body = con.getResposta();
		
		// filtrar dados que interessam
		
		// extrair só os dados que interessam (titulo, poster, classificação)
		JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados 
        
        for (Map<String,String> filme : listaDeFilmes) {
        	String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            GeradoraDeFigurinhas.cria(inputStream, nomeArquivo);

            System.out.println(titulo);
            System.out.println();
        }
        
	}
}
