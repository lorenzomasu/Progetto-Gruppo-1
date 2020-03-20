package com.generation.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generation.base.Entity;
import com.generation.base.SmartList;
import com.generation.db.IDatabase;
import com.generation.entities.Contiene;
import com.generation.entities.Pianeta;
import com.generation.entities.Risorsa;

public class DAOContiene implements IDAO, IDAOContiene{

	private IDatabase db;
	private String nometabella = "contiene";
	
	public DAOContiene(IDatabase db) {
		this.db = db;
	}
	
	public List<Entity> list(String filtro)
	{
		List<Entity> ris = new SmartList<Entity>();
		for(Map<String,String> riga : db.rows(filtro)) {
			Entity e = new Contiene();
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
		return null;
	}
	
	public List<Entity> searchRisorsa(BigInteger idRisorsa) {
		List<Entity> valori = new ArrayList<Entity>();
		List<Map<String,String>> f = db.rows(read.replace("tabella",nometabella).replace("id = ?;", "idrisorsa = " + idRisorsa));
		for(Map<String, String> map : f) {
			Entity e = new Contiene();
			e.fromMap(map);
			valori.add(e);
		}
		return valori;
	}
	
	public List<Entity> searchPianeta(BigInteger idPianeta) {
		List<Entity> valori = new ArrayList<Entity>();
		List<Map<String,String>> f = db.rows(read.replace("tabella",nometabella).replace("id = ?;", "idpianeta = " + idPianeta));
		for(Map<String, String> map : f) {
			Entity e = new Contiene();
			e.fromMap(map);
			valori.add(e);
		}
		return valori;
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
		return searchRisorsa(id).get(0);
	}

	@Override
	public List<Entity> pianetiConRisorsa(Risorsa r) {
		String query = read.replace("tabella", nometabella).replace("id = ?;", "idrisorsa = " + r.getId());
		return list(query);
	}

	@Override
	public List<Entity> risorseSuPianeta(Pianeta p) {
		String query = read.replace("tabella", nometabella).replace("id = ?;", "idpianeta = " + p.getId());
		return list(query);
	}
}
