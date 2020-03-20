package com.generation.entities;

import com.generation.base.Entity;

public class Risorsa extends Entity
{
	private String nome, descrizione;
	private int valore;
	@Override
	public String toString() {
		return "Risorsa [nome=" + nome + ", descrizione=" + descrizione + ", valore=" + valore + "]";
	}
	
	public Risorsa(int id, String nome, String descrizione, int valore) {
		super(id);
		this.nome = nome;
		this.descrizione = descrizione;
		this.valore = valore;
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
	public Risorsa ()
	{
		
	}
	
	
	
	
	
	
	
	
	
	
}
