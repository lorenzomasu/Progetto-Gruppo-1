package com.generation.entities;

import java.sql.Date;
import java.util.Calendar;

import com.generation.base.*;

public class Essere extends Entity implements IEssere{
	private String nome, cognome;
	private Date dob;
	private int idrazza, idnumero, idpianeta;
	public Essere(String nome, String cognome, Date dob, int idrazza, int idnumero, int idpianeta) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.idrazza = idrazza;
		this.idnumero = idnumero;
		this.idpianeta = idpianeta;
	}
	
	public Essere() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getIdrazza() {
		return idrazza;
	}

	public void setIdrazza(int idrazza) {
		this.idrazza = idrazza;
	}

	public int getIdnumero() {
		return idnumero;
	}

	public void setIdnumero(int idnumero) {
		this.idnumero = idnumero;
	}

	public int getIdpianeta() {
		return idpianeta;
	}

	public void setIdpianeta(int idpianeta) {
		this.idpianeta = idpianeta;
	}

	@Override
	public boolean isValid(String... params) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int eta() {
		return Calendar.YEAR - Integer.parseInt(String.valueOf(dob).split("-")[0]);
	}

	@Override
	public String toString() {
		return "ID: " + getId() + "\nnome: " + nome + ", \ncognome: " + cognome + ", \ndob: " + dob + ", \nidrazza: " + idrazza
				+ ", \nidnumero: " + idnumero + ", \nidpianeta: " + idpianeta;
	}
	
	
}
