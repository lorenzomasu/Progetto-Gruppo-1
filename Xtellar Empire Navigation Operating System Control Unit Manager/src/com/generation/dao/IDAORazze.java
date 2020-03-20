package com.generation.dao;

import java.util.List;

import com.generation.entities.Razza;

public interface IDAORazze {
	public List<Razza> esiste(String caratteristica);
}
