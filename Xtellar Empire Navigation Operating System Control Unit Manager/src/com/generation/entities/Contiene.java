package com.generation.entities;

import java.math.BigInteger;

import com.generation.base.Entity;

public class Contiene extends Entity {
	private int idrisorsa, quantita;

	public Contiene(int idrisorsa, int quantita) {
		super();
		this.idrisorsa = idrisorsa;
		this.quantita = quantita;
	}

	public Contiene() {}
	
	
	public int getIdrisorsa() {
		return idrisorsa;
	}

	public void setIdrisorsa(int idrisorsa) {
		this.idrisorsa = idrisorsa;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public BigInteger getIdPianeta() {
		return id;
	}
	
	public void setIdPianeta(BigInteger idpianeta) {
		this.id = idpianeta;
	}

	@Override
	public boolean isValid(String... params) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
