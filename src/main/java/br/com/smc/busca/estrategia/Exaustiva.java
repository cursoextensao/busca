package br.com.smc.busca.estrategia;

import java.util.List;

import br.com.smc.busca.Universo;
import br.com.smc.busca.blackbox.BlackBox;

/**
 * @author savio
 *
 */
public class Exaustiva implements Busca {
	private Universo universo;
	
	public Exaustiva(Universo universo) {
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
			
			for (String solucao : novasSolucoes) {
				valor = blackBox.testar(solucao);
				
				if (valor == universo.getNumeroBits()){
					return solucaoAtual;
				}
			}
		}
	}

}
