package br.com.smc.busca.util;

import org.apache.commons.lang3.StringUtils;

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
	
	public static String incrementa(String numero){
		int operador = 1;
		int resultado = 0;
		String novoNumero = numero;
		for (int i = numero.length() - 1; i  >= 0; i--) {
			if (operador == 1){
				if (novoNumero.charAt(i) == '0'){
					resultado = 1;
					operador = 0;
				} else {
					resultado = 0;
					operador = 1;
				}
			} else {
				if (novoNumero.charAt(i) == '0'){
					resultado = 0;
					operador = 0;
				} else {
					resultado = 1;
					operador = 0;
				}
			}
			
			novoNumero = StringUtils.overlay(novoNumero, Integer.toString(resultado), i, i + 1);	
		}
		
		return novoNumero;
	}
	public static void main(String[] args) {
		String numero = "00000";
		
		System.out.println(numero);
		for (int i = 0; i < Math.pow(2, 120) - 1; i++) {
			numero = incrementa(numero);
			System.out.println(numero);
		}
	}

}
