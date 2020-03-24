package com.generation.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.generation.base.Entity;
import com.generation.base.SmartList;
import com.generation.db.IDatabase;
import com.generation.entities.Pianeta;

public class DAOPianeti implements IDAO, IDAOPianeti{
	private IDatabase db;
	private String nometabella = "pianeti";
	/**
	 * in ingresso parametro db per fare una sola connessione
	 * @param db
	 * @author Ivan Capra
	 */
	
	public DAOPianeti(IDatabase db) {
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
			Entity e = new Pianeta();
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
			Entity ris = new Pianeta();
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
			BigInteger id = null;
			Entity ris = null;
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
	 * ritorno la grandezza media dei pianeti dell'impero
	 * @author Ivan Capra
	 */
	
	@Override
	public double grandezzaMediaPianeti() {
		String query = "select avg(grandezza) average from pianeti";
		Map<String,String> test = db.row(query);
		if(test!=null && test.get("average")!=null)
			return Double.parseDouble(db.row(query).get("average"));
		else
			return 0;
	}
	/**
	 * ritorno la grandezza totale dei pianeti dell'impero
	 */
	@Override
	public int grandezzaTotalePianeti() {	
		String query = "select sum(grandezza) somma from pianeti";
		Map<String,String> test = db.row(query);
		if(test!=null && test.get("somma")!=null)
			return Integer.parseInt(db.row(query).get("somma"));
		else
			return 0;
	}
	/**
	 * ritorno la distanza tra le coordinate di due pianeti
	 * @author Ivan Capra
	 */
	@Override
	public String distanzaPianeti(String nomea, String nomeb) {
		try{
			String query = read.replace("tabella", nometabella).replace("id = ?;", "nome = '" + nomea + "'");
			Pianeta a = (Pianeta)list(query).get(0);
			if(a == null)
				return "Nome pianeta 1 errato.";
			if(a.getCoordinate() == null || a.getCoordinate().length()!=20)
				return "Cordinate pianeta 1 errate.";
			query = read.replace("tabella", nometabella).replace("id = ?;", "nome = '" + nomeb + "'");
			Pianeta b = (Pianeta)list(query).get(0);
			if(b == null)
				return "Nome pianeta 2 errato.";
			if(b.getCoordinate() == null || b.getCoordinate().length()!=20)
				return "Coordinate pianeta errate.";
			String ris = "";
			for(int i=0;i<10;i++) {//ciclo delle lettere
				if(a.getCoordinate().toCharArray()[i] - b.getCoordinate().toCharArray()[i]>='A')
					ris += a.getCoordinate().toCharArray()[i] - b.getCoordinate().toCharArray()[i];
				else
					ris += 'A' + (a.getCoordinate().toCharArray()[i] - b.getCoordinate().toCharArray()[i]);
			}
			for(int i=10;i<20;i++) {
				ris += String.valueOf(Math.abs(a.getCoordinate().toCharArray()[i] - b.getCoordinate().toCharArray()[i]));
			}
			return ris;
		} catch(Exception e) {
			return null;
		}
	}
	/**
	 * trovo se esiste gia un nome tra i pianeti
	 * true se esiste gia, false se non esiste
	 * @author Ivan Capra
	 */
	@Override
	public boolean doppione(String nome) {
		String query = read.replace("tabella", nometabella).replace("id = ?;", "nome = '" + nome + "';");
		return list(query).size()!=0 ? true : false;
	}
	/**
	 * trovo il o i pianeti piu grandi dell'impero
	 * @author Ivan Capra
	 */
	@Override
	public List<Entity> pianetaPiuGrande() {
		String query = "select max(grandezza) massimo from pianeti";
		Map<String,String> test = db.row(query);
		int maggiore = 0;
		if(test!=null && test.get("massimo")!=null)
			maggiore = Integer.parseInt(db.row(query).get("massimo"));
		else
			return null;
		query = read.replace("tabella", nometabella).replace("id = ?;", "grandezza = " + maggiore + ";");
		return list(query);
	}
	/**
	 *trovo i o il pianeta piu piccolo dell'impero
	 * @author Ivan Capra
	 */
	@Override
	public List<Entity> pianetaPiuPiccolo() {
		String query = "select min(grandezza) minimo from pianeti";
		Map<String,String> test = db.row(query);
		int minimo = 0;
		if(test!=null && test.get("massimo")!=null)
			minimo = Integer.parseInt(db.row(query).get("minimo"));
		else
			return null;
		query = read.replace("tabella", nometabella).replace("id = ?;", "grandezza = " + minimo + ";");
		return list(query);
	}

}
