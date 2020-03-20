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

	@Override
	public List<Razza> esiste(String caratteristica) {
		String query = read.replace("tabella", "razze").replace("id = [id]", "descrizione = '" + caratteristica + "'"); 
		return null;
	}

	@Override
	public List<Entity> list() {
		String query = read.replace("tabella","razze").replace("where id = [id]", "");
		return list(query);
	}

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

	@Override
	public Entity load(BigInteger id) {
		String query = read.replace("tabella","razze").replace("[id]",id+"");
		Entity e = new Razza();
		e.fromMap(db.row(query));
		return e;
	}

	@Override
	public Entity load(Entity e) {
		Entity ris = null;
		String query = "";
		
		if(e.getId() != null)
			query = update.replace("tabella", "razze").replace("[id]",e.getId()+"");
		else
			query = insert.replace("tabella", "razze");
		
		Map<String, String> mappa = e.toMap();
		BigInteger id = db.update(query,mappa);
		ris = load(id);
		return ris;
	}

	@Override
	public boolean delete(BigInteger id) {
		String query = delete.replace("tabella", "razze").replace("[id]",id+"");
		BigInteger ris = db.update(query);
		return ris == null; 
	}

}
