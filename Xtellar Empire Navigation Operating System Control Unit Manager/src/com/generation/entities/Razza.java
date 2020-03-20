package com.generation.entities;

import com.generation.base.Entity;

public class Razza extends Entity implements IRazza
{
	private String nome, descrizione;

	@Override
	public String toString() 
	{
		return "Razza [nome=" + nome + ", descrizione=" + descrizione + "]";
	}

	public Razza() 
	{
		
		// TODO Auto-generated constructor stub
	}

	public Razza(int id,String nome,String descrizione) 
	{
		super(id);
		this.nome = nome;
		this.descrizione = descrizione;
		// TODO Auto-generated constructor stub
	}

	public String getNome() 
	{
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

	@Override
	public boolean isValid(String... params) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}


	 