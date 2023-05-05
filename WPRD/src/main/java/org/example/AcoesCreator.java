package org.example;

public class AcoesCreator {

	private AcoesRepository repositorioAcoes;

	public AcoesCreator() {

		repositorioAcoes = new AcoesRepository();
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

	public void updateAcao(String codigo) {
		if (this.repositorioAcoes.acaoExiste(codigo) != false) {
			this.repositorioAcoes.updateAcao(codigo);
		} else {
			System.out.println("Sem acao com esse nome");
		}
	}

	public void updateAllAcoes(String codigo) {
		this.repositorioAcoes.updateAllAcoes();

	}

	public boolean acaoExiste(String codigo) {
		return this.repositorioAcoes.acaoExiste(codigo);
	}
}
