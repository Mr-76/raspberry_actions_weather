package org.example;

import java.util.HashMap;
import java.util.Map;

import org.Scraping.ScrapingService;

//api fica no repository 

/*Repositorio de acoes, como é algo bem simples decidi
 * manter a api de busca de precos e volume aquie mesmo
 * sem precisar criar um service pois é algo simples,
 * o proposito da classe é manter a colecao de acoes sendo consultadas
 * por um momento e depois apagar,pois serao salvas no banco de dados
 */
public class AcoesRepository {
	private Map<String, Acao> list_acoes;
	private ScrapingService scrapService;

	public ScrapingService getScrapService() {
		return scrapService;
	}

	public AcoesRepository() {
		list_acoes = new HashMap<String, Acao>();
		scrapService = new ScrapingService();
	}

	public void removeAcao(String codigo) {
		list_acoes.remove(codigo);
	}

	private int updateAcao(Acao acao) {
		acao.setPrice(scrapService.getPrice(acao.getCodigo()));

		return 0;
	}

	public void addAcao(Acao acao) {
		String codigo = acao.getCodigo();

		float price = scrapService.getPrice(codigo);
		acao.setPrice(price);
		acao.setMaxprice(price);
		acao.setMinprice(price);
		acao.setVolume(scrapService.getVolume(codigo));
		list_acoes.put(codigo, acao);
	}

	public Acao getAcao(String codigo) {
		return list_acoes.get(codigo);
	}

	/**
	 * Funcao da update na acao setando o min,max e current price.
	 * 
	 * @param codigo codigo da acao para update
	 */
	public void updateAcao(String codigo) {
		Acao acao = list_acoes.get(codigo);
		float price = scrapService.getPrice(codigo);
		if (price >= acao.getMaxprice()) {
			acao.setMaxprice(price);
			acao.setMinprice(acao.getCurrentPrice());
		} else {
			acao.setMinprice(price);
			acao.setMaxprice(acao.getCurrentPrice());
		}
		acao.setVolume(scrapService.getVolume(codigo));
		acao.setCurrentPrice(price);
	}

	public boolean acaoExiste(String codigo) {
		return list_acoes.containsKey(codigo);
	}

	public void setScrapingService(ScrapingService scrapingService1) {
		this.scrapService = scrapingService1;
	}

	public void updateAllAcoes() {
	}
}
