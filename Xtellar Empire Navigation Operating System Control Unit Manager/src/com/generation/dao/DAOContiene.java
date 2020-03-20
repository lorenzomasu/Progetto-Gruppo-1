package com.generation.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.generation.base.Entity;

public class DAOContiene implements IDAO{

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
	@Deprecated
	public Entity load(Entity e) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean load(Map<String, Integer> e) {
		return false;
	}
	
	@Override
	public boolean delete(BigInteger id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
