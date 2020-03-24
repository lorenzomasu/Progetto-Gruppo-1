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

	@Override
	public double valoreMedioRisorse() {
		String query = read.replace("*", "avg(valore) valMedio").replace("tabella", "risorse").replace("where id = [id]", ""); 
		Map<String,String> test = db.row(query);
		if(test!=null && test.get("media")!=null)
			return Double.parseDouble(db.row(query).get("valMedio"));
		else
			return 0;
	}

	@Override
	public int valoreRisorsa(String nomeRisorsa) {
		String query = read.replace("*", "valore").replace("tabella", "risorse").replace("id = [id]", "nome = '" + nomeRisorsa + "'");
		Entity e = new Risorsa();
		Map<String,String> test = db.row(query);
		if(test!=null && test.get("media")!=null)
			e.fromMap(db.row(query));
		else
			return -1;
		return ((Risorsa)e).getValore();
	}

	@Override
	public List<Entity> list() {
		String query = read.replace("tabella","risorse").replace("where id = ?", "");
		return list(query);
	}

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

	@Override
	public boolean delete(BigInteger id) {
		String query = delete.replace("tabella", "risorse").replace("[id]",id+"");
		BigInteger ris = db.update(query);
		return ris == null; 
	}

}
