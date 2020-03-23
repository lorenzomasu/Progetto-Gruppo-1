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
	/**
	 * in ingresso parametro db per fare una sola connessione
	 * @param db
	 * @author Ivan Capra
	 */
	
	public DAOContiene(IDatabase db) {
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
			Entity e = new Contiene();
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

	@Override
	@Deprecated
	public Entity load(BigInteger idPianeta) {
		return null;
	}
	/**
	 * cerco nel database la risorsa con quell'id
	 * @param idRisorsa
	 * @return la lista dei contieni con id risorsa
	 * @author Ivan Capra
	 */
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
	/**
	 * cerco nel database il pianeta con quell'id
	 * @param idPianeta
	 * @return la lista dei contieni con id pianeta
	 * @author Ivan Capra
	 */
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
	@Deprecated
	public boolean delete(BigInteger id) {
		return false;
	}
	
	/**
	 * cancello la risorsa nella tabella contiene
	 * @param id
	 * @return vero se ha fatto, false se non ce l'ha fatta
	 * @author Ivan Capra
	 */
	public boolean deleteRisorsa(BigInteger id) {
		return db.update(delete.replace("tabella", nometabella).replace("id = [id]", "idrisorsa = " + id+"")) == null;
	}
	/**
	 * cancello il pianeta nella tabella contiene
	 * @param id
	 * @return vero se fatto, false se no
	 * @author Ivan Capra
	 */
	public boolean deletePianeta(BigInteger id) {
		return db.update(delete.replace("tabella", nometabella).replace("id = [id]", "idpianeta = " + id+"")) == null;
	}
	/**
	 * cancello la risorsa dai pianeti
	 * @param idpianeta
	 * @param idrisorsa
	 * @return vero se fatto, false se no
	 * @author Ivan Capra
	 */
	public boolean deleteRisorsaDaPianeta(BigInteger idpianeta, BigInteger idrisorsa) {
		return db.update(delete.replace("tabella", nometabella).replace("id = [id]", "idpianeta = " + idpianeta+"" + " and idrisorsa = " + idrisorsa+"")) == null;
	}
	
	/**
	 * data mappa in ingresso e le modifiche da fare le apporto al db
	 * @param e
	 * @param modifiche
	 * @return entity modificata
	 * @author Ivan Capra
	 */
	public Entity load(Map<String, String> e, Map<String,String> modifiche) {
		BigInteger id = null;
		String query="";
		if(e.get("idpianeta")!=null && e.get("idrisorse")!=null && modifiche!=null) { // la mia entity esiste gia nel db
			query = update.replace("tabella", nometabella).replace("id = [id];", "idpianeta = " + e.get("idpianeta") + " and idrisorsa = " + e.get("idrisorsa"));
			id = db.update(query, modifiche);
		}
		else if(e.get("idpianeta")!=null && e.get("idrisorse")!=null && modifiche==null){
			query = insert.replace("tabella", nometabella);
			id = db.update(query, e);
		}
		return searchRisorsa(id).get(0);
	}

	
	/**
	 * ritorno la lista di contiene con una risorsa r
	 * @author Ivan Capra
	 */
	@Override
	public List<Entity> pianetiConRisorsa(Risorsa r) {
		String query = read.replace("tabella", nometabella).replace("id = ?;", "idrisorsa = " + r.getId());
		return list(query);
	}

	/**
	 * ritorno la lista di contiene con un pianeta p
	 * @author Ivan Capra
	 */
	@Override
	public List<Entity> risorseSuPianeta(Pianeta p) {
		String query = read.replace("tabella", nometabella).replace("id = ?;", "idpianeta = " + p.getId());
		return list(query);
	}
}
