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
	
	
	public DAOPianeti(IDatabase db) {
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
	public Entity load(BigInteger id) {
		Entity ris = new Pianeta();
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
	public double grandezzaMediaPianeti() {
		String query = "select avg(grandezza) average from pianeti";
		return Double.parseDouble(db.row(query).get("average"));
	}
	
	@Override
	public int grandezzaTotalePianeti() {	
		String query = "select sum(grandezza) somma from pianeti";
		return Integer.parseInt(db.row(query).get("somma"));
	}
	
	@Override
	public String distanzaPianeti(String nomea, String nomeb) {
		String query = read.replace("tabella", nometabella).replace("id = ?;", "nome = '" + nomea + "'");
		Pianeta a = (Pianeta)list(query).get(0);
		query = read.replace("tabella", nometabella).replace("id = ?;", "nome = '" + nomeb + "'");
		Pianeta b = (Pianeta)list(query).get(0);
		if(a.getCoordinate().length()!=20 || b.getCoordinate().length()!=20)
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
	}
	/**
	 * true se esiste gia, false se non esiste
	 */
	@Override
	public boolean doppione(String nome) {
		String query = read.replace("tabella", nometabella).replace("id = ?;", "nome = '" + nome + "';");
		return list(query).size()!=0 ? true : false;
	}
	
	@Override
	public List<Entity> pianetaPiuGrande() {
		String query = "select max(grandezza) massimo from pianeti";
		int maggiore = Integer.parseInt(db.row(query).get("massimo"));
		query = read.replace("tabella", nometabella).replace("id = ?;", "grandezza = " + maggiore + ";");
		return list(query);
	}
	
	@Override
	public List<Entity> pianetaPiuPiccolo() {
		String query = "select min(grandezza) minimo from pianeti";
		int minimo = Integer.parseInt(db.row(query).get("minimo"));
		query = read.replace("tabella", nometabella).replace("id = ?;", "grandezza = " + minimo + ";");
		return list(query);
	}

}
