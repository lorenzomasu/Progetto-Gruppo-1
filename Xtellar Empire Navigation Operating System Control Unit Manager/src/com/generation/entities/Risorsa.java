package com.generation.entities;

import com.generation.base.Entity;

public class Risorsa extends Entity implements IRisorsa{
	private String nome, descrizione;
	private int valore;
	public Risorsa(String nome, String descrizione, int valore) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.valore = valore;
	}
	
	public Risorsa() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	@Override
	public boolean isValid(String... params) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "ID: " + getId() + "\nnome: " + nome + ", \ndescrizione: " + descrizione + ", \nvalore: " + valore;
	}
	
	
	
}
