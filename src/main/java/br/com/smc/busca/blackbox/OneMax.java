package br.com.smc.busca.blackbox;

import org.apache.log4j.Logger;

import br.com.smc.busca.util.Util;

/**
 * @author savio
 *
 */
public class OneMax implements BlackBox {
	private Logger LOG = Logger.getLogger("busca");
	private int NUMERO_ACESSOS = 0;
	
	@Override
	public int testar(String solucao) {
		NUMERO_ACESSOS ++;
		LOG.info("Acessando a black box... Número de acessos: " + NUMERO_ACESSOS);
		return Util.contaUm(solucao);
	}
	
	public int getNumeroDeAcessos(){
		return NUMERO_ACESSOS;
	}

}
