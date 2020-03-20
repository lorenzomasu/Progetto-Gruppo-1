package com.generation.dao;

import java.util.List;

import com.generation.base.Entity;

public interface IDAOPianeti {
	
	public double grandezzaMediaPianeti();
	public int grandezzaTotalePianeti();
	public String distanzaPianeti(String nomea, String nomeb);
	public boolean doppione(String nome); //se un pianeta ha stesso nome di un altro
	public List<Entity> pianetaPiuGrande();
	public List<Entity> pianetaPiuPiccolo();

}
