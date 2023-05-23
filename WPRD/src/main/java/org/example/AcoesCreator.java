package org.example;

import org.Scraping.ScrapingService;

public class AcoesCreator {

	private AcoesRepository repositorioAcoes;
	private ScrapingService scrapingService1;

	public AcoesCreator() {
		repositorioAcoes = new AcoesRepository();
		scrapingService1 = new ScrapingService();
	}

	private void setRepositoryService() {
		this.repositorioAcoes.setScrapingService(scrapingService1);
	}

	public void RemoveAcao(String codigo) {
		repositorioAcoes.removeAcao(codigo);
	}

	public void createAcao(String codigo) {
		Acao acao = new Acao(codigo);
		repositorioAcoes.addAcao(acao);
	}

	public Acao getAcao(String codigo) {
		return this.repositorioAcoes.getAcao(codigo);
	}

	public boolean updateAcao(String codigo) {
		if (this.repositorioAcoes.acaoExiste(codigo) != false) {
			this.repositorioAcoes.updateAcao(codigo);
			return true;
		} else {
			System.out.println("Sem acao com esse nome");
			return false;
		}
	}

	public void updateAllAcoes(String codigo) {
		this.repositorioAcoes.updateAllAcoes();

	}

	public boolean acaoExiste(String codigo) {
		return this.repositorioAcoes.acaoExiste(codigo);
	}

	public ScrapingService getScrapService() {
		return this.repositorioAcoes.getScrapService();
	}
}
