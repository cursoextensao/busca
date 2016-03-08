package br.com.smc.busca;

import org.apache.log4j.Logger;

import br.com.smc.busca.blackbox.BlackBox;
import br.com.smc.busca.blackbox.OneMax;
import br.com.smc.busca.estrategia.Busca;
import br.com.smc.busca.estrategia.Exaustiva;
import br.com.smc.busca.estrategia.Gulosa;

/**
 * @author savio
 *
 */
public class Main {
	private static final int NUM_BITS = 120;
	private static final boolean EXAUSTIVA = false;
	
	private static Logger LOG = Logger.getLogger("br.com.smc.busca.util");
	
	public static void main(String[] args) {
		Universo universo = new Universo(NUM_BITS);
		BlackBox blackBox = new OneMax();
		
		Busca busca = null;
		
		if (EXAUSTIVA){
			busca = new Exaustiva(universo);
		} else {
			busca = new Gulosa(universo);
		}
		
		String solucao = busca.resolver(blackBox);
		
		if (solucao != null){
			LOG.info("Solução encontrada: " + solucao);
			System.out.println("Solução encontrada: " + solucao);
		} else {
			LOG.info("Não foi possível encontrar a solução do problema");
			System.out.println("Não foi possível encontrar a solução do problema");
		}
		
		LOG.info("Número de acessos: " + blackBox.getNumeroDeAcessos());
		System.out.println("Número de acessos: " + blackBox.getNumeroDeAcessos());
	}

}
