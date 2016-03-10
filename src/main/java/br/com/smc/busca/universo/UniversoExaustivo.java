package br.com.smc.busca.universo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.smc.busca.util.Util;

/**
 * @author savio
 *
 */
public class UniversoExaustivo implements Universo{
	private Logger LOG = Logger.getLogger("busca");
	private int numeroBits;
	
	public UniversoExaustivo(int numeroBits) {
		this.numeroBits = numeroBits;
	}
	
	public List<String> gerarSolucoes(String solucaoAtual, Integer quantidade) {
		List<String> solucoes = new ArrayList<>(quantidade);
		String solucao = solucaoAtual;
		for (int i = 0; i < quantidade; i++) {
			solucao = Util.incrementa(solucao);
			solucoes.add(solucao);
		}
		return solucoes;
	}
	
	public String gerarSolucaoInicial() {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < numeroBits; i++) {
			sb.append("0");
		}
		
		return sb.toString();
	}
	
	public int getNumeroBits() {
		return numeroBits;
	}
}
