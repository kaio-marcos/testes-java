package alura_stickers.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connect {
	
	private URL urlToConnect;
	private HttpURLConnection huc;
	
	public Connect(String url, String method) {
		try {
			this.urlToConnect = new URL(url);
			this.huc = (HttpURLConnection) urlToConnect.openConnection();
			huc.setRequestMethod(method);
			int status = huc.getResponseCode();
			System.out.println(status);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException("Verifique a url e o método ('GET', 'POST', 'PUT'...)");
		}
	}

	public String getResposta() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(huc.getInputStream()));
		String inputLine;
		StringBuilder content = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		
		return content.toString(); 
	}
	
	public void fechar() {
		huc.disconnect();
	}
}
