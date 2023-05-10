package uniresteste.testes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import jdk.nashorn.internal.parser.JSONParser;

public class Main {

	private static JSONArray jsonRespostaListaConexao(String urlConexao ) throws Exception {
		
		URL url = new URL(urlConexao);
		HttpURLConnection conection = (HttpURLConnection) url.openConnection();
		conection.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
		    content.append(inputLine);
		}
		
		JSONArray lista = new JSONArray(content.toString());
		
		in.close();
		conection.disconnect();
		
		return lista;
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("nd");
		HttpResponse<JsonNode> response = Unirest.get("https://servicodados.ibge.gov.br/api/v1/localidades/microrregioes")
				.queryString("orderBy", "nome")
				.asJson();
		System.out.println(response.getBody());
		/*
		JSONArray conteudo = jsonRespostaListaConexao("https://servicodados.ibge.gov.br/api/v1/localidades/microrregioes");
		System.out.println(conteudo.length());
		
		HttpResponse<JsonNode> response = Unirest.get("https://servicodados.ibge.gov.br/api/v1/localidades/microrregioes")
				.queryString("orderBy", "nome")
				.asJson();
		JSONArray lista = response.getBody().getArray();
		
		List<Microregiao> microregioes = new ArrayList<Microregiao>();
		
		for(int i=0; i < lista.length(); i++) {
			JSONObject objt1 = lista.getJSONObject(i);
			
			Microregiao microregiao = new Microregiao();
			microregiao.setId(objt1.getLong("id"));
			microregiao.setNome(objt1.getString("nome"));
			
			JSONObject objt2 = objt1.getJSONObject("mesorregiao");
			
			Mesoregiao mesoregiao = new Mesoregiao();
			mesoregiao.setId(objt2.getLong("id"));
			mesoregiao.setNome(objt2.getString("nome"));
			
			JSONObject objt3 = objt2.getJSONObject("UF");
			
			Uf uf = new Uf();
			uf.setId(objt3.getLong("id"));
			uf.setNome(objt3.getString("nome"));
			uf.setSigla(objt3.getString("sigla"));
			
			JSONObject objt4 = objt3.getJSONObject("regiao");
			
			Regiao regiao = new Regiao();
			regiao.setId(objt4.getLong("id"));
			regiao.setNome(objt4.getString("nome"));
			regiao.setSigla(objt4.getString("sigla"));
			
			microregiao.setMesoregiao(mesoregiao);
			mesoregiao.setUf(uf);
			uf.setRegiao(regiao);
			
			microregioes.add(microregiao);
		}
		
		System.out.println(microregioes.size());
		*/
	}
}
