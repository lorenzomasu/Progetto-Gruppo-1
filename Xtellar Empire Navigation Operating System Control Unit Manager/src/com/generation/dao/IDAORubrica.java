package com.generation.dao;

import java.util.List;

import com.generation.base.Entity;

public interface IDAORubrica {
	public String cittaDelNumero(int numero);
	public String indirizzoDelNumero(int numero);

	public List<Entity> elencoNumeri(String citta); 

}
