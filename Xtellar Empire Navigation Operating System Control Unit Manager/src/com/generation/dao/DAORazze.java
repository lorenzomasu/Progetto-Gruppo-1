package com.generation.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.generation.base.Entity;
import com.generation.base.SmartList;
import com.generation.db.IDatabase;
import com.generation.entities.Razza;

public class DAORazze implements IDAO, IDAORazze {
	
	private IDatabase db; 
	
	public DAORazze(IDatabase db) {
		this.db = db; 
	}
	
	/**
	 * ritorna una lista di Entity dove la descrizione è uguale alla caratteristica passata come paramentro
	 * @author Lorenzo
	 */
	@Override
	public List<Entity> esiste(String caratteristica) {
		String query = read.replace("tabella", "razze").replace("id = ?", "descrizione = '" + caratteristica + "'");
		if(list(query) != null)
			return list(query); 
		return null;
	}

	/**
	 * restituisce una lista di tutte le Entity
	 * @author Lorenzo
	 */
	@Override
	public List<Entity> list() {
		String query = read.replace("tabella","razze").replace("where id = ?", "");
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
			Entity e = new Razza();
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
		try{
			String query = read.replace("tabella","razze").replace("?",id+"");
		
			Entity e = new Razza();
			e.fromMap(db.row(query));
			return e;
		} catch(Exception e) {
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
				query = update.replace("tabella", "razze").replace("[id]",e.getId()+"");
			else
				query = insert.replace("tabella", "razze");
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
		String query = delete.replace("tabella", "razze").replace("[id]",id+"");
		BigInteger ris = db.update(query);
		return ris == null; 
	}

}
