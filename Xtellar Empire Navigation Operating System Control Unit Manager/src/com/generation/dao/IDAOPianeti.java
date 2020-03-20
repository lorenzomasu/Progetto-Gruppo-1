package com.generation.dao;

import com.generation.entities.*;

public interface IDAOPianeti {
	
	public int grandezzaMediaPianeti();
	public int grandezzaTotalePianeti();
	public String distanzaPianeti(Pianeta a, Pianeta b);
	public boolean doppione(String nome); //se un pianeta ha stesso nome di un altro
	public Pianeta pianetaPiuGrande();
	public Pianeta pianetaPiuPiccolo();

}
