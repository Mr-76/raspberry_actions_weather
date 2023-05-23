package org.example;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainTest {
	ControllerWPRD controlador = new ControllerWPRD();

	@BeforeEach

	public void setup() {
		System.out.printf("TESTANDO");
	}

	@Test
	public void testaCriar() {
		String codigo = "BBAS3";
		controlador.createAcao(codigo);
		Assertions.assertEquals(true, controlador.acaoExiste(codigo));
	}

	@Test
	public void testaDeletar() {
		String codigo = "BBAS3";
		controlador.RemoveAcao(codigo);
		Assertions.assertEquals(false, controlador.acaoExiste(codigo));
	}

	@Test
	public void testaUpdate() {
		String codigo = "BBAS3";
		Assertions.assertEquals(false, controlador.UpdateAcao(codigo));
		controlador.createAcao(codigo);
		Assertions.assertEquals(true, controlador.UpdateAcao(codigo));
	}

	@Test
	public void testAddAcao() {
		String codigo = "BBAS3";
		controlador.createAcao(codigo);
		Assertions.assertEquals(true, controlador.UpdateAcao(codigo));
		Acao acao = controlador.getAcao(codigo);
		System.out.printf("%f", acao.getCurrentPrice());

		codigo = "ENBR3";
		controlador.createAcao(codigo);
		Assertions.assertEquals(true, controlador.UpdateAcao(codigo));
		acao = controlador.getAcao(codigo);
		System.out.printf("%f", acao.getCurrentPrice());

		codigo = "ABCB4";
		controlador.createAcao(codigo);
		Assertions.assertEquals(true, controlador.UpdateAcao(codigo));
		acao = controlador.getAcao(codigo);
		System.out.printf("%f", acao.getCurrentPrice());

		codigo = "PETR4";
		controlador.createAcao(codigo);
		Assertions.assertEquals(true, controlador.UpdateAcao(codigo));
		acao = controlador.getAcao(codigo);
		System.out.printf("%f", acao.getCurrentPrice());

		codigo = "GMAT3";
		controlador.createAcao(codigo);
		Assertions.assertEquals(true, controlador.UpdateAcao(codigo));
		acao = controlador.getAcao(codigo);
		System.out.printf("%f", acao.getCurrentPrice());
	}

	@Test
	public void testa_web_scrape_get_preco() {
		Document doc;
		try {
			// fetching the target website
			// http headers to be blocked by the website :>
			doc = Jsoup.connect("https://finance.yahoo.com/quote/ENBR3.SA?p=ENBR3.SA")
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
					.header("Accept-Language", "*")
					.get();
			// System.out.println(doc);
			Elements products = doc.select("fin-streamer");
			System.out.println(products.get(18).text());
			String price_stock_string = products.get(18).text();
			Float price_stock = Float.parseFloat(price_stock_string);
			System.out.printf("%f float", price_stock);
			// System.out.println(products);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@Test
	public void testa_web_scrape_get_volume() {
		Document doc;
		try {
			// fetching the target website
			// http headers to be blocked by the website :>
			doc = Jsoup.connect("https://finance.yahoo.com/quote/ENBR3.SA?p=ENBR3.SA")
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
					.header("Accept-Language", "*")
					.get();
			// System.out.println(doc);
			Elements products = doc.select("fin-streamer");
			int i = 0;
			for (Element elemento : products) {
				System.out.printf("%d", i);
				System.out.println(elemento.text());

				i++;
			}
			// System.out.println(products);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
