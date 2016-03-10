package br.com.smc.busca.estrategia;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.smc.busca.blackbox.BlackBox;
import br.com.smc.busca.universo.Universo;
import br.com.smc.busca.util.QuantidadeDeUnsComparator;
import br.com.smc.busca.util.Util;

/**
 * @author savio
 *
 */
public class Gulosa implements Busca {
	private static final Comparator<String> COMPARATOR = new QuantidadeDeUnsComparator();
	private static final Logger LOG = Logger.getLogger("busca");
	
	private Universo universo;
	
	public Gulosa(Universo universo) {
		this.universo = universo;
		
	}
	@Override
	public String resolver(BlackBox blackBox) {
		String solucaoAtual = universo.gerarSolucaoInicial();

		List<String> novasSolucoes = null;

		int valor = blackBox.testar(solucaoAtual);
		
		if (valor == universo.getNumeroBits()){
			return solucaoAtual;
		}
		
		while(true){
			novasSolucoes = universo.gerarSolucoes(solucaoAtual, universo.getNumeroBits());
			Collections.sort(novasSolucoes, COMPARATOR);
			
			if (Util.contaUm(novasSolucoes.get(0)) > Util.contaUm(solucaoAtual)){
				solucaoAtual = novasSolucoes.get(0);
				LOG.info("Solução melhor encontrada: " + solucaoAtual + " [numeroDeUm="+ Util.contaUm(solucaoAtual) +"]");
				
				valor = blackBox.testar(solucaoAtual);
				
				if (valor == universo.getNumeroBits()){
					return solucaoAtual;
				}
			}
		}
	}

}
