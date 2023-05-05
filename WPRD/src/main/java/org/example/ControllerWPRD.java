package org.example;

public class ControllerWPRD {
	private AcoesCreator AcoesCreator;
	private WeatherCreator WeatherCreator;

	public ControllerWPRD() {
		this.AcoesCreator = new AcoesCreator();
		this.WeatherCreator = new WeatherCreator();
	}

	public boolean acaoExiste(String codigo) {
		return AcoesCreator.acaoExiste(codigo);
	}

	public int createAcao(String codigo) {
		this.AcoesCreator.createAcao(codigo);
		return 0;
	}

	public int RemoveAcao(String codigo) {
		this.AcoesCreator.RemoveAcao(codigo);
		return 0;
	}

	public int UpdateAcao(String codigo) {
		this.AcoesCreator.updateAcao(codigo);
		return 0;
	}

	public int UpdateAllAcoes(String codigo) {
		this.AcoesCreator.updateAllAcoes(codigo);

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
}
