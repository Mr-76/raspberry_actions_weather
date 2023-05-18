package org.Scraping;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class ScrapingService {
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
		try {
			// fetching the target website
			// http headers to be blocked by the website :>
			doc = Jsoup.connect("https://finance.yahoo.com/quote/ENBR3.SA?p=ENBR3.SA")
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
					.header("Accept-Language", "*")
					.get();
			// System.out.println(doc);
			Elements products = doc.select("div.value");
			for (Element element : products) {
				String elementString = element.selectFirst("P").text();
				System.out.println(element.selectFirst("P").text());
				// replacing sstring
				String modfiedString = elementString.replace(",", ".");
				Float price_stock = Float.parseFloat(modfiedString);
				System.out.printf("%f float", price_stock);
			}
			// System.out.println(products);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return precoAcao;
	}

}
