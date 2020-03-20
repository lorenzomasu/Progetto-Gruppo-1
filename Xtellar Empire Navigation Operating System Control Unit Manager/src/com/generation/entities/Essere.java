package com.generation.entities;

import java.sql.Date;

import com.generation.base.*;

public class Essere extends Entity implements IEssere{
	private String nome, cognome;
	private Date dob;
	private int idrazza, idnumero, idpianeta;
}
