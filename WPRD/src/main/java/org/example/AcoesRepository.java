package org.example;

import java.util.HashMap;
import java.util.Map;

//api fica no repository 

/*Repositorio de acoes, como é algo bem simples decidi
 * manter a api de busca de precos e volume aquie mesmo
 * sem precisar criar um service pois é algo simples,
 * o proposito da classe é manter a colecao de acoes sendo consultadas
 * por um momento e depois apagar,pois serao salvas no banco de dados
 */
public class AcoesRepository {
	private Map<String, Acao> list_acoes;

	public AcoesRepository() {
		list_acoes = new HashMap<String, Acao>();
	}

	public void removeAcao(String codigo) {
		list_acoes.remove(codigo);
	}

	public void addAcao(Acao acao) {
		String codigo = acao.getCodigo();
		list_acoes.put(codigo, acao);
	}

	public Acao getAcao(String codigo) {
		return list_acoes.get(codigo);
	}


	public void updateAcao(String codigo) {
		//chama api
	}

	public boolean acaoExiste(String codigo) {
		return list_acoes.containsKey(codigo);
	}

	public void updateAllAcoes() {
		// chama api para todas as acoes :) na lista do hash map
	}
}
