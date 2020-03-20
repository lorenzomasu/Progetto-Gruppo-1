package com.generation.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.generation.base.Entity;
import com.generation.base.SmartList;
import com.generation.db.IDatabase;
import com.generation.entities.Pianeta;

public class DAOContiene implements IDAO{

	private IDatabase db;
	private String nometabella = "contiene";
	
	
	public DAOContiene(IDatabase db) {
		this.db = db;
	}
	
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
	
	@Override
	public List<Entity> list() {
		String query = read.replace("tabella", nometabella).replace("where id = ?;", "");
		return list(query);
	}

	@Override
	@Deprecated
	public Entity load(BigInteger idPianeta) {
		Entity ris = new Pianeta();
		ris.fromMap(db.row(read.replace("tabella",nometabella).replace("id = ?;", "idpianeta = " + idPianeta)));
		return ris;
	}
	
	public Entity searchRisorsa(BigInteger idRisorsa) {
		Entity ris = new Pianeta();
		ris.fromMap(db.row(read.replace("tabella",nometabella).replace("id = ?;", "idrisorsa = " + idRisorsa)));
		return ris;
	}
	
	public Entity searchPianeta(BigInteger idPianeta) {
		Entity ris = new Pianeta();
		ris.fromMap(db.row(read.replace("tabella",nometabella).replace("id = ?;", "idpianeta = " + idPianeta)));
		return ris;
	}
	
	
	@Override
	@Deprecated
	public Entity load(Entity e) {
		return null;
	}

	@Override
	public boolean delete(BigInteger id) {
		return db.update(delete.replace("tabella", nometabella).replace("[id]", id+"")) == null;
	}
	
	
	public Entity load(Map<String, String> e) {
		BigInteger id = null;
		String query="";
		if(e.get("idpianeta")!=null && e.get("idrisorse")!=null) // la mia entity esiste gia nel db
			query = update.replace("tabella", nometabella).replace("where idpianeta = [id];", e.get("idpianeta"));
		else
			query = insert.replace("tabella", nometabella);
		id = db.update(query, e);
		return searchRisorsa(id);
	}
}
