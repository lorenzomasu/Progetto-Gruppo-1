package com.generation.entities;

import java.math.BigInteger;

import com.generation.base.Entity;

public class Rubrica extends Entity implements IRubrica{
	private int numero;//ho dovuto aggiungere questa variabile perchè il database o il mapper non riuscivano a gestirlo, e' sempre uguale all'id
	private String foto, citta, indirizzo; //l'id dell'entity e' il numero di telefono
	
	public Rubrica() {}; 

	public Rubrica(int id, String foto, String citta, String indirizzo) {
		super(id);
		this.numero = id;
		this.foto = foto;
		this.citta = citta;
		this.indirizzo = indirizzo;
	}

	@Override
	public BigInteger getId() {
		return super.getId();
	}
	
	@Override
	public void setId(int id) {
		super.setId(id);
		this.numero = id;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
		setId(numero);
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	@Override
	public boolean isValid(String... params) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "ID: " + getId() + "\nfoto: " + foto + ", \ncitta: " + citta + ", \nindirizzo: " + indirizzo ;
	}
	
	
	
}
