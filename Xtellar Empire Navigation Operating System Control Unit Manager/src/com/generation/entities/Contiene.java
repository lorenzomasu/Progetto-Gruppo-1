package com.generation.entities;

import java.math.BigInteger;

import com.generation.base.Entity;

public class Contiene extends Entity {
	private int idrisorse, quantita;

	public Contiene(int idrisorsa, int quantita) {
		super();
		this.idrisorse = idrisorsa;
		this.quantita = quantita;
	}

	public Contiene() {}
	
	
	public int getIdrisorse() {
		return idrisorse;
	}

	public void setIdrisorse(int idrisorsa) {
		this.idrisorse = idrisorsa;
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

	@Override
	public String toString() {
		return "idpianeta: " + getId() + "\nidrisorsa: " + idrisorse + ", \nquantita: " + quantita;
	}
	
	
}
