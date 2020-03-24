package com.generation.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.generation.base.Entity;
import com.generation.base.SmartList;
import com.generation.db.IDatabase;
import com.generation.entities.Risorsa;


public class DAORisorse implements IDAO, IDAORisorse{
	
	private IDatabase db; 


	public DAORisorse(IDatabase db) {
		this.db = db;
	}

	/**
	 * ritorna la media del valore di tutte le risorse
	 * @author Lorenzo
	 */
	@Override
	public double valoreMedioRisorse() {
		String query = read.replace("*", "avg(valore) valMedio").replace("tabella", "risorse").replace("where id = [id]", ""); 
		return Double.parseDouble(db.row(query).get("valMedio"));
	}
	
	/**
	 * ritorna la media del valore della risorsa passata come parametro
	 * @author Lorenzo
	 */
	@Override
	public int valoreRisorsa(String nomeRisorsa) {
		String query = read.replace("*", "valore").replace("tabella", "risorse").replace("id = [id]", "nome = '" + nomeRisorsa + "'");
		Entity e = new Risorsa();
		e.fromMap(db.row(query));
		return ((Risorsa)e).getValore(); 
	}

	/**
	 * restituisce una lista di tutte le Entity
	 * @author Lorenzo
	 */
	@Override
	public List<Entity> list() {
		String query = read.replace("tabella","risorse").replace("where id = [id]", "");
		return list(query);
	}

	/**
	 * restituisce una lista di tutte le Entity filtrate col parametro filtro (query)
	 * @author Lorenzo
	 */
	@Override
	public List<Entity> list(String filtro) {
		List<Entity> ris = new SmartList<Entity>();
		List<Map<String,String>> righe = db.rows(filtro);
		for(Map<String,String> riga : righe)
		{
			Entity e = new Risorsa();
			e.fromMap(riga);
			ris.add(e);
		}
		return ris;
	}

	/**
	 * ritorno entity con l'id in ingresso
	 * @author Lorenzo
	 */
	@Override
	public Entity load(BigInteger id) {
		try {
			String query = read.replace("tabella","risorse").replace("[id]",id+"");
			Entity e = new Risorsa();
			e.fromMap(db.row(query));
			return e;
		}catch(Exception exc) {
			return null;
		}
	}

	/**
	 * carico nel database l'entity presa in ingresso, modificandola o creando una nuova.
	 * ritorno l'entity modificata se e' andato a buon fine	 
	 * @author Lorenzo
	 */
	@Override
	public Entity load(Entity e) {
		try{
			Entity ris = null;
			
			String query = "";
			
			if(e.getId() != null)
				query = update.replace("tabella", "risorse").replace("[id]",e.getId()+"");
			else
				query = insert.replace("tabella", "risorse");
			
			Map<String, String> mappa = e.toMap();
			BigInteger id = db.update(query,mappa);
			if(e.getId()==null)
				ris = load(id);
			else
				ris = load(e.getId());
			return ris;
		}catch(Exception exc) {
			return null;
		}
	}

	/**
	 * cancella una Entity in base all'id passato come parametro
	 * @author Lorenzo
	 */
	@Override
	public boolean delete(BigInteger id) {
		String query = delete.replace("tabella", "risorse").replace("[id]",id+"");
		BigInteger ris = db.update(query);
		return ris == null; 
	}

}
