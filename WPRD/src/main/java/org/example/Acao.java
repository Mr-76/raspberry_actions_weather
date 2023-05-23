package org.example;

import java.util.Objects;

/*
 * Classe Acao mantem uma acao , com precos minimos e maximos, assim como volumes e o preço atual
 * o objeto é atualizado mantido pelo banco de dados que o programa ao começar deve dar o load
 * dos dados e manter,em memoria para ser atualizado depois, lembrando que o objeto é apagado da colecao
 * pois nao necessita gastar memoria com os dados em ram, pois so preciso no momento das consultas algo para manter
 * e fazer operacoes etc , apos isso armazenar no banco de dados para compartilhar com a outra parte em python display.
 */
public class Acao {
	private String codigo_acao;
	private float currentPrice = 0;
	private int minprice = 0;
	private int maxprice = 0;
	private int minvolume = 0;
	private int maxvolume = 0;

	// Construtor
	public Acao(String codigo) {
		this.codigo_acao = codigo;
	}
	public String getCodigo() {
		return this.codigo_acao;
	}

	public String getCodigo_acao() {
		return codigo_acao;
	}

	public float getCurrentPrice() {
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

	// Seleciona codigo da acao
	public void setCodigo_acao(String codigo_acao) {
		this.codigo_acao = codigo_acao;
	}

	// Seleciona preco minimo
	public void setMinprice(int minprice) {
		this.minprice = minprice;
	}

	// seleciona preco maximo
	public void setMaxprice(int maxprice) {
		this.maxprice = maxprice;
	}

	// seleciona volume minimo
	public void setMinvolume(int minvolume) {
		this.minvolume = minvolume;
	}

	// seleciona volume maximo
	public void setMaxvolume(int maxvolume) {
		this.maxvolume = maxvolume;
	}
	// Seleciona preco da acao
	public void setPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}


}
