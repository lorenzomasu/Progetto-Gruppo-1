package com.generation.entities;

import com.generation.base.Entity;

public class Pianeta extends Entity implements IPianeta{
	private String nome;
	private int grandezza;
	private String coordinate;
	
	public Pianeta(String nome, int grandezza, String coordinate) {
		super();
		this.nome = nome;
		this.grandezza = grandezza;
		this.coordinate = coordinate;
	}
	
	public Pianeta() {}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getGrandezza() {
		return grandezza;
	}
	public void setGrandezza(int grandezza) {
		this.grandezza = grandezza;
	}
	public String getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}
	@Override
	public boolean isValid(String... params) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String distanza(String coordinata) {
		if(this.getCoordinate().length()!=20 || coordinata.length()!=20)
			return "Coordinate errate.";
		String ris = "";
		for(int i=0;i<10;i++) {//ciclo delle lettere
			if(this.getCoordinate().toCharArray()[i] - coordinata.toCharArray()[i]>='A')
				ris += this.getCoordinate().toCharArray()[i] - coordinata.toCharArray()[i];
			else
				ris += 'A' + (this.getCoordinate().toCharArray()[i] - coordinata.toCharArray()[i]);
		}
		for(int i=10;i<20;i++) {
			ris += String.valueOf(Math.abs(this.getCoordinate().toCharArray()[i] - coordinata.toCharArray()[i]));
		}
		return ris;
	}
}
