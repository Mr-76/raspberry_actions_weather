package org.example;

import java.util.Objects;

public class Acao {
	private String codigo_acao;
	private int currentPrice = 0;
	private int minprice = 0;
	private int maxprice = 0;
	private int minvolume = 0;
	private int maxvolume = 0;

	public Acao(String codigo) {
		this.codigo_acao = codigo;
		//apit chamada akie ja
	}

	public void setPrice() {
		// this.currentPrice = //api_de_acoes_get_preco_(from_this.codigo)
	}

	public String getCodigo() {
		return this.codigo_acao;
	}

	public String getCodigo_acao() {
		return codigo_acao;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public int getMinprice() {
		return minprice;
	}

	public int getMaxprice() {
		return maxprice;
	}

	public int getMinvolume() {
		return minvolume;
	}

	public int getMaxvolume() {
		return maxvolume;
	}

	@Override
	public String toString() {
		return "Acao{" +
				"codigo_acao='" + codigo_acao + '\'' +
				", currentPrice=" + currentPrice +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Acao acao = (Acao) o;
		return Objects.equals(codigo_acao, acao.codigo_acao);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo_acao);
	}
}
