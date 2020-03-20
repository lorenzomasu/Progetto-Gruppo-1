package com.generation.dao;

import java.util.List;

import com.generation.base.Entity;
import com.generation.entities.*;

public interface IDAOContiene {
	List<Entity> pianetiConRisorsa(Risorsa r);
	List<Entity> risorseSuPianeta(Pianeta p);
}
