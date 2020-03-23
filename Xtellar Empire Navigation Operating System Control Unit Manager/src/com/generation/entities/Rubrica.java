package com.generation.entities;

import com.generation.base.Entity;

public class Rubrica extends Entity
{
	private String foto, citta, indirizzo; //l'id dell'entity e' il numero di telefono

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



}
