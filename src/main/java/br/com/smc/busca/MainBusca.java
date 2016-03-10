package br.com.smc.busca;

import org.apache.log4j.Logger;

import br.com.smc.busca.blackbox.BlackBox;
import br.com.smc.busca.blackbox.OneMax;
import br.com.smc.busca.estrategia.Busca;
import br.com.smc.busca.estrategia.Exaustiva;
import br.com.smc.busca.estrategia.Gulosa;
import br.com.smc.busca.universo.Universo;
import br.com.smc.busca.universo.UniversoExaustivo;
import br.com.smc.busca.universo.UniversoGuloso;

/**
 * @author savio
 *
 */
public class MainBusca {
	private static final int NUM_REPETICOES = 1;
	private static final int NUM_BITS = 30;
	private static final boolean EXAUSTIVA = true;
	
	private static Logger LOG = Logger.getLogger("busca");
	
	public static void main(String[] args) {
		int[] numeroAcessos = new int[NUM_REPETICOES];
		double[] tempoExecucao = new double[NUM_REPETICOES];
		
		
		for (int i = 0; i < NUM_REPETICOES; i++) {
			long t1 = System.nanoTime();
			Universo universo = null;
			BlackBox blackBox = new OneMax();
			
			Busca busca = null;
			
			if (EXAUSTIVA){
				universo = new UniversoExaustivo(NUM_BITS);
				busca = new Exaustiva(universo);
			} else {
				universo = new UniversoGuloso(NUM_BITS);
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
			
			long t2 = System.nanoTime();
			
			numeroAcessos[i] = blackBox.getNumeroDeAcessos();
			tempoExecucao[i] = (t2-t1)/1000000;
			
		}
		
		
		int somaNumero = 0;
		double somaTempo = 0.0;
		for (int i = 0; i < tempoExecucao.length; i++) {
			somaNumero += numeroAcessos[i];
			somaTempo += tempoExecucao[i];
		}
		
		System.out.println("Número de acessos: " + somaNumero/NUM_REPETICOES);
		System.out.println("Tempo de execução: " + somaTempo/NUM_REPETICOES);
	}

}
