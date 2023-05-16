package org.example;

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
	public void testa_web_scrape(){
		String searchQuery = "iphone 13";

// Instantiate the client
		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

// Set up the URL with the search term and send the request
		String searchUrl = null;
		try {
			searchUrl = "https://newyork.craigslist.org/search/moa?query=" + URLEncoder.encode(searchQuery, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		try {
			HtmlPage page = client.getPage(searchUrl);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
