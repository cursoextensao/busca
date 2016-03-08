package br.com.smc.busca.util;

/**
 * @author savio
 *
 */
public class Util {
	public static int contaUm(String solucao) {
		int count = 0;
		
		for (int i = 0; i < solucao.length(); i++) {
			if (solucao.charAt(i) == '1'){
				count++;
			}
		}
		
		return count;
	}
}
