package br.com.smc.busca.universo;

import java.util.List;

/**
 * @author savio
 *
 */
public interface Universo {
	public List<String> gerarSolucoes(String solucaoAtual, Integer quantidade);
	public String gerarSolucaoInicial();
	public int getNumeroBits();
}
