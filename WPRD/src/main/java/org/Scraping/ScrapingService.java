package org.Scraping;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class ScrapingService {
	private float max_price = 0;
	private float min_price = 0;

	public ScrapingService() {
		System.out.println("Started");
	}

	/**
	 * Metodo retorna Float com valor da acao.
	 *
	 * @param codigo Codigo de uma acao
	 *
	 * @return preco da acao buscada
	 */
	public Float getPrice(String codigo) {
		Document doc;
		float precoAcao = 0.0f;
		String nomeAcao = String.format("https://finance.yahoo.com/quote/%s.SA?p=%s.SA", codigo,codigo);
		try {
			// fetching the target website
			// http headers to be blocked by the website :>
			doc = Jsoup.connect(nomeAcao)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
					.header("Accept-Language", "*")
					.get();
			// System.out.println(doc);
			Elements products = doc.select("fin-streamer");
			System.out.println(products.get(18).text());
			String price_stock_string = products.get(18).text();
			precoAcao = Float.parseFloat(price_stock_string);
			System.out.printf("%f float", precoAcao);
			// System.out.println(products);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return precoAcao;

	}

	public Float getVolume(String codigo) {
		float volume = 0;
		return volume;
	}
}
