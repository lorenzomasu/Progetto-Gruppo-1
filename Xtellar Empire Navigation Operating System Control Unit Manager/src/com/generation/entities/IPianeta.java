package com.generation.entities;

public interface IPianeta {
	
	/**
	 * Restituisce la differenza tra le coordinata (10 letteri e 10 numeri) sempre in positivo
	 * @param coordinata
	 * @return
	 */
	String distanza(String coordinata);
	
	public String toString();
}
