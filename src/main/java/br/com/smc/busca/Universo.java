package br.com.smc.busca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import br.com.smc.busca.util.Util;

/**
 * @author savio
 *
 */
public class Universo {
	private int numeroBits;
	private Set<String> solucoes = new HashSet<>();
	
	private Logger LOG = Logger.getLogger("br.com.smc.busca.util");
	private Random rand = new Random();

	public Universo(int numeroBits) {
		this.numeroBits = numeroBits;
	}
	
	public List<String> gerarSolucoes(String solucaoAtual, int quantidade) {
		List<String> solucoes = new ArrayList<>();
		
		for (int i = 0; i < quantidade; i++) {
			solucoes.add(proximaSolucao(solucaoAtual));
		}
		
		return solucoes;
	}
	
	private String proximaSolucao(String solucaoAtual) {
		LOG.info("Solicitando nova solução");
		if (solucoes.size() == Math.pow(2, numeroBits)){
			LOG.fatal("Todas as soluções do solucoes já foram geradas");
			throw new RuntimeException("Todas as soluções do solucoes já foram geradas");
		}
		
		String solucao = gerarSolucao(solucaoAtual);
		
		while(solucoes.contains(solucao)){
			solucao = gerarSolucao(solucao);
		}
		
		LOG.info("Solução gerada: " + solucao + " [numeroDeUm="+ Util.contaUm(solucao) +"]");
		solucoes.add(solucao);
		
		return solucao;
	}
	public String gerarSolucaoInicial() {
		//LOG.info("Solicitando nova solução");
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < numeroBits; i++) {
			sb.append(rand .nextBoolean() ? "0" : "1");
		}
		
		String solucao = sb.toString();
		//LOG.info("Solução gerada: " + solucao + " [numeroDeUm="+ Util.contaUm(solucao) +"]");
		
		return solucao;
	}
	
	private String gerarSolucao(String solucaoBase) {
		int posicao = rand.nextInt(numeroBits);
		String solucao = solucaoBase;
		
		solucao = StringUtils.overlay(solucaoBase, rand.nextBoolean() ? "0" : "1", posicao, posicao + 1);
		
		return solucao;
	}

	public int getNumeroBits() {
		return numeroBits;
	}
}
