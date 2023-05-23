package org.example;

import org.Scraping.ScrapingService;

public class ControllerWPRD {
	private AcoesCreator acoesCreator;
	private WeatherCreator WeatherCreator;

	public ControllerWPRD() {
		this.acoesCreator = new AcoesCreator();
		this.WeatherCreator = new WeatherCreator();
	}

	public Acao getAcao(String codigo) {
		return this.acoesCreator.getAcao(codigo);
	}

	public boolean acaoExiste(String codigo) {
		return acoesCreator.acaoExiste(codigo);
	}

	public int createAcao(String codigo) {
		this.acoesCreator.createAcao(codigo);
		return 0;
	}

	public int RemoveAcao(String codigo) {
		this.acoesCreator.RemoveAcao(codigo);
		return 0;
	}

	public boolean UpdateAcao(String codigo) {
		return this.acoesCreator.updateAcao(codigo);
	}

	public int UpdateAllAcoes(String codigo) {
		this.acoesCreator.updateAllAcoes(codigo);

		return 0;
	}

	public int createWeather(String codigo) {
		this.WeatherCreator.createWeather(codigo);
		return 0;
	}

	public int RemoveWeather(String codigo) {
		this.WeatherCreator.removeWeather(codigo);
		return 0;
	}

	public int UpdateWeather(String codigo) {
		this.WeatherCreator.UpdateWeather(codigo);
		return 0;
	}

	public ScrapingService getScrapService() {
		return this.acoesCreator.getScrapService();
	}
}
