package br.com.smc.busca.util;

import java.util.Comparator;

/**
 * @author savio
 *
 */
public class QuantidadeDeUnsComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		Integer c1 = Util.contaUm(o2);
		return c1.compareTo(Util.contaUm(o1));
	}

}
