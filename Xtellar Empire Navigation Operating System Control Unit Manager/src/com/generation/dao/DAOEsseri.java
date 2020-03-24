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
	/**
	 * in ingresso parametro db per fare una sola connessione
	 * @param db
	 * @author Ivan Capra
	 */
	
	public DAOEsseri (IDatabase db) {
		this.db = db;
	}
	/**
	 * ritorno la lista di entity ricavate dalla query in ingresso
	 * @author Ivan Capra
	 */
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
	/**
	 * ritorno la lista completa di entity della tabella
	 * @author Ivan Capra
	 */
	@Override
	public List<Entity> list() {
		String query = read.replace("tabella", nometabella).replace("where id = ?;", "");
		return list(query);
	}	
	
/**
 * ritorno entity con l'id in ingresso
 * @author Ivan Capra
 */
	@Override
	public Entity load(BigInteger id) {
		try {
			Entity ris = new Essere();
			ris.fromMap(db.row(read.replace("tabella",nometabella).replace("?", id+"")));
			return ris;
		} catch(Exception exc) {
			return null;
		}
	}
/**
 * carico nel database l'entity presa in ingresso, modificandola o creando una nuova.
 * ritorno l'entity modificata se e' andato a buon fine
 * @author Ivan Capra
 */
	@Override
	public Entity load(Entity e) {
		try{
			Entity ris = null;
			BigInteger id = null;
			String query="";
			if(e.getId()!=null) // la mia entity esiste gia nel db
				query = update.replace("tabella", nometabella).replace("[id]", e.getId()+"");
			else
				query = insert.replace("tabella", nometabella);
			id = db.update(query, e.toMap());
			if(e.getId()==null)
				ris = load(id);
			else
				ris = load(e.getId());
			return ris;
		} catch(Exception exc) {
			return null;
		}
	}
/**
 * rimuovo dal database la riga con l'id in ingresso
 * @author Ivan Capra
 */
	@Override
	public boolean delete(BigInteger id) {
		return db.update(delete.replace("tabella", nometabella).replace("[id]", id+"")) == null;
	}
	
	/**
	 * trovo l'eta' media degli esseri
	 * @author Ivan Capra
	 */
	@Override
	public double etaMedia() {
		String query = "select avg(anni) media from ("
				+ "select (year(now()) - year(dob)) as anni from esseri) pippo;";
		Map<String,String> test = db.row(query);
		if(test!=null && test.get("media")!=null)
			return Integer.parseInt(test.get("media"));
		else
			return -1;
	}
/**
 * ritorno l'eta' massima degli esseri
 * @author Ivan Capra
 */
	@Override
	public int etaMassima() {
		String query = "select max(anni) massimo from ("
				+ "select (year(now()) - year(dob)) as anni from esseri) pippo;";
		Map<String,String> test = db.row(query);
		if(test!=null && test.get("massimo")!=null)
			return Integer.parseInt(test.get("massimo"));
		else
			return -1;
	}
/**
 * ritorno l'eta' minima degli esseri
 * @author Ivan Capra
 */
	@Override
	public int etaMinima() {
		String query = "select min(anni) minimo from ("
				+ "select (year(now()) - year(dob)) as anni from esseri) pippo;";
		Map<String,String> test = db.row(query);
		if(test!=null && test.get("minimo")!=null)
			return Integer.parseInt(test.get("minimo"));
		else
			return -1;
	}
/**
 * ritorno il numero di ripetizioni di un certo cognome preso in ingresso
 * @author Ivan Capra
 */
	@Override
	public int ripetizioneCognome(String cognome) {
		String query = "select count(*) conta from esseri where cognome = '" + cognome + "'";
		Map<String,String> test = db.row(query);
		if(test!=null && test.get("conta")!=null)
			return Integer.parseInt(db.row(query).get("conta"));
		else
			return 0;
	}

}
