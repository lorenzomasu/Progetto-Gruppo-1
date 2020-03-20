package com.generation.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.generation.base.Entity;
import com.generation.base.SmartList;
import com.generation.db.IDatabase;
import com.generation.entities.Essere;

public class DAOEsseri implements IDAO, IDAOEsseri{
	private IDatabase db;
	private String nometabella = "esseri";
	
	
	public DAOEsseri (IDatabase db) {
		this.db = db;
	}
	
	public List<Entity> list(String filtro)
	{
		List<Entity> ris = new SmartList<Entity>();
		for(Map<String,String> riga : db.rows(filtro)) {
			Entity e = new Essere();
			if(e!=null) {
				e.fromMap(riga);
				ris.add(e);
			}
		}
		return ris;
	}
	
	@Override
	public List<Entity> list() {
		String query = read.replace("tabella", nometabella).replace("where id = ?;", "");
		return list(query);
	}

	@Override
	public Entity load(BigInteger id) {
		Entity ris = new Essere();
		ris.fromMap(db.row(read.replace("tabella",nometabella).replace("?", id+"")));
		return ris;
	}

	@Override
	public Entity load(Entity e) {
		BigInteger id = null;
		String query="";
		if(e.getId()!=null) // la mia entity esiste gia nel db
			query = update.replace("tabella", nometabella).replace("[id]", e.getId()+"");
		else
			query = insert.replace("tabella", nometabella);
		id = db.update(query, e.toMap());
		return load(id);
	}

	@Override
	public boolean delete(BigInteger id) {
		return db.update(delete.replace("tabella", nometabella).replace("[id]", id+"")) == null;
	}
	
	
	@Override
	public double etaMedia() {
		String query = "select avg(anni) media from ("
				+ "select (year(now()) - year(dob)) as anni from esseri) pippo;";
		return Integer.parseInt(db.row(query).get("media"));
	}

	@Override
	public int etaMassima() {
		String query = "select max(anni) massimo from ("
				+ "select (year(now()) - year(dob)) as anni from esseri) pippo;";
		return Integer.parseInt(db.row(query).get("massimo"));
	}

	@Override
	public int etaMinima() {
		String query = "select min(anni) minimo from ("
				+ "select (year(now()) - year(dob)) as anni from esseri) pippo;";
		return Integer.parseInt(db.row(query).get("minimo"));
	}

	@Override
	public int ripetizioneCognome(String cognome) {
		String query = "select count(*) conta from essere where cognome = '" + cognome + "'";
		return Integer.parseInt(db.row(query).get("conta"));
	}

}
