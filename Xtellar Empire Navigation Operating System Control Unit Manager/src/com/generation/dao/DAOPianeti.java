package com.generation.dao;

import java.math.BigInteger;
import java.util.List;

import com.generation.base.Entity;
import com.generation.entities.Pianeta;

public class DAOPianeti implements IDAO, IDAOPianeti{

	@Override
	public int grandezzaMediaPianeti() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int grandezzaTotalePianeti() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String distanzaPianeti(Pianeta a, Pianeta b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doppione(String nome) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pianeta pianetaPiuGrande() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pianeta pianetaPiuPiccolo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entity> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entity> list(String filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity load(BigInteger id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity load(Entity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(BigInteger id) {
		// TODO Auto-generated method stub
		return false;
	}

}
