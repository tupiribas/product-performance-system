package service;

import java.util.List;

public class CalculationService {
	
	public static <T extends Comparable<T>> T max(List<T> list) {
		if (list.isEmpty()) {
			throw new IllegalStateException("Error 1>>> List is empty");
		}
		T max = list.get(0);
		for (T itens : list) {
			if (itens.compareTo(max) > 0) {
				max = itens;
			}
		}
		return max;
	}
	
	

}
