package com.generation.aggregator;

import java.math.BigInteger;
import java.util.*;

import com.generation.base.Entity;
import com.generation.dao.*;
import com.generation.db.Database;
import com.generation.db.IDatabase;
import com.generation.entities.*;

public class Aggregator implements IAggregator{

	private static Aggregator instance;
	
	private Map<String,Object> dependencies = new HashMap<String,Object>();
	
	/**
	 * costruttore aggregator, crea tutti i dao necessari e li mette in dependencies
	 * @author Ivan Capra
	 */
	public Aggregator() {
		IDatabase db = Database.getInstance();
		db.setPercorso("jdbc:mysql://localhost:3306/impero");
		db.setUser("root");
		db.setPw("root");
		IDAO daoesseri = new DAOEsseri(db);
		dependencies.put("daoesseri", daoesseri);
		
		IDAO daopianeti = new DAOPianeti(db);
		dependencies.put("daopianeti", daopianeti);
		
		IDAO daorazze = new DAORazze(db);
		dependencies.put("daorazze", daorazze);
		
		IDAO daorisorse = new DAORisorse(db);
		dependencies.put("daorisorse", daorisorse);
		
		IDAO daorubrica = new DAORubrica(db);
		dependencies.put("daorubrica", daorubrica);

		IDAO daocontiene = new DAOContiene(db);
		dependencies.put("daocontiene", daocontiene);
		
	}
	
	/**
	 * metodo per prendere l'istanza dell'aggregator
	 */
	public static Aggregator getInstance() {
		if(instance == null)
			instance = new Aggregator();
		return instance;
	}
	
	public Object get(String chiave) {
		return dependencies.get(chiave);
	}
	
	/*
	 * RICORDARSI DI METTERE CERCA, MODIFICA, CARICA ED ELIMINA PER OGNI SINGOLA ENTITY
	 */
	
	public Entity cercaEssere(int id) {
		return  ((DAOEsseri) getInstance().get("daoesseri")).load(BigInteger.valueOf(id));
	}
	
	public Entity modificaCreaEssere(Entity e) {
		return ((DAOEsseri) getInstance().get("daoesseri")).load(e);
	}
	
	public boolean eliminaEssere(int id) {
		return ((DAOEsseri) getInstance().get("daoesseri")).delete(BigInteger.valueOf(id));
	}
	
	
	
	
	public Entity cercaPianeta(int id) {
		return  ((DAOPianeti) getInstance().get("daopianeti")).load(BigInteger.valueOf(id));
	}
	
	public Entity modificaCreaPianeta(Entity e) {
		return ((DAOPianeti) getInstance().get("daopianeti")).load(e);
	}
	
	public boolean eliminaPianeta(int id) {
		return ((DAOPianeti) getInstance().get("daopianeti")).delete(BigInteger.valueOf(id));
	}
	
	
	
	
	public Entity cercaRazza(int id) {
		return  ((DAORazze) getInstance().get("daorazze")).load(BigInteger.valueOf(id));
	}
	
	public Entity modificaCreaRazza(Entity e) {
		return ((DAORazze) getInstance().get("daorazze")).load(e);
	}
	
	public boolean eliminaRazza(int id) {
		return ((DAORazze) getInstance().get("daorazze")).delete(BigInteger.valueOf(id));
	}
	
	public Entity cercaRisorsa(int id) {
		return  ((DAORisorse) getInstance().get("daorisorse")).load(BigInteger.valueOf(id));
	}
	
	public Entity modificaCreaRisorsa(Entity e) {
		return ((DAORisorse) getInstance().get("daorisorse")).load(e);
	}
	
	public boolean eliminaRisorsa(int id) {
		return ((DAORisorse) getInstance().get("daorisorse")).delete(BigInteger.valueOf(id));
	}
	
	public Entity modificaRisorsaAPianeta(int idpianeta, int idrisorsadamodificare, int idrisorsanuova) {
		Map<String, String> e = new HashMap<String,String>();
		e.put("idpianeta", idpianeta+"");
		e.put("idrisorsa", idrisorsadamodificare+"");
		Map<String, String> modifica = new HashMap<String,String>();
		modifica.put("idpianeta", idpianeta+"");
		modifica.put("idrisorsa", idrisorsanuova+"");
		return ((DAOContiene)getInstance().get("daocontiene")).load(e, modifica);
	}
	
	public Entity aggiungiRisorsaAPianeta(int idpianeta, int idrisorsa, int quantita) {
		Map<String, String> e = new HashMap<String,String>();
		e.put("idpianeta", idpianeta+"");
		e.put("idrisorsa", idrisorsa+"");
		e.put("quantita", quantita+"");
		return ((DAOContiene)getInstance().get("daocontiene")).load(e, null);
	}
	
	public boolean eliminaRisorsaPianeta(int idpianeta, int idrisorsa) {
		return ((DAOContiene)getInstance().get("daocontiene")).deleteRisorsaDaPianeta(BigInteger.valueOf(idpianeta), BigInteger.valueOf(idrisorsa));
	}
	
	
	
	
	public Entity cercaRubrica(int id) {
		return  ((DAORubrica) getInstance().get("daorubrica")).load(BigInteger.valueOf(id));
	}
	
	public Entity modificaCreaRubrica(Entity e) {
		return ((DAORubrica) getInstance().get("daorubrica")).load(e);
	}
	
	public boolean eliminaRubrica(int id) {
		return ((DAORubrica) getInstance().get("daorubrica")).delete(BigInteger.valueOf(id));
	}
	
	
	
	
	/*
	 * CRUD
	 */
	@Override
	public int numeriCitta(String citta) {
		int ris = ((DAORubrica)getInstance().get("daorubrica")).elencoNumeri(citta).size();
	}

	@Override
	public List<Razza> esiste(String caratteristica) {
		return ((DAORazze)getInstance().get("daorazze")).esiste(caratteristica);
	}

	@Override
	public double grandezzaMediaPianeti() {
		return ((DAOPianeti) getInstance().get("daopianeti")).grandezzaMediaPianeti();
	}

	@Override
	public int grandezzaTotalePianeti() {
		return ((DAOPianeti) getInstance().get("daopianeti")).grandezzaTotalePianeti();
	}

	@Override
	public boolean doppione(String nome) {
		return ((DAOPianeti) getInstance().get("daopianeti")).doppione(nome);
	}

	@Override
	public List<Pianeta> pianetaPiuGrande() {
		List<Entity> pianeti = ((DAOPianeti) getInstance().get("daopianeti")).pianetaPiuGrande();
		List<Pianeta> p = new ArrayList<Pianeta>();
		for(Entity e : pianeti) {
			p.add((Pianeta)e);
		}
		return p;
	}

	@Override
	public List<Pianeta> pianetaPiuPiccolo() {
		List<Entity> pianeti = ((DAOPianeti) getInstance().get("daopianeti")).pianetaPiuPiccolo();
		List<Pianeta> p = new ArrayList<Pianeta>();
		for(Entity e : pianeti) {
			p.add((Pianeta)e);
		}
		return p;
	}

	@Override
	public double etaMedia() {
		return ((DAOEsseri) getInstance().get("daoesseri")).etaMedia();
	}

	@Override
	public int etaMassima() {
		return ((DAOEsseri) getInstance().get("daoesseri")).etaMassima();
	}

	@Override
	public int etaMinima() {
		return ((DAOEsseri) getInstance().get("daoesseri")).etaMinima();
	}

	@Override
	public int ripetizioneCognome(String cognome) {
		return  ((DAOEsseri) getInstance().get("daoesseri")).ripetizioneCognome(cognome); 
	}

	@Override
	public double valoreMedioRisorse() {
		return ((DAORisorse)getInstance().get("daorisorse")).valoreMedioRisorse();
	}

	@Override
	public int valoreRisorsa(String nomeRisorsa) {
		return ((DAORisorse)getInstance().get("daorisorse")).valoreRisorsa(nomeRisorsa);
	}

	@Override
	public String cittaDelNumero(int numero) {
		return null;
	}

	@Override
	public String indirizzoDelNumero(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String dettagliNumero(int numero) {
		List<Entity> esseri = ((DAOEsseri) getInstance().get("daoesseri")).list();
		Essere essere = null;
		for(Entity e : esseri) {
			if(((Essere)e).getIdnumero() == numero) {
				essere = (Essere)e;
			}
		}
		if(essere == null)
			return "Nessun numero trovato.";
		Pianeta p = (Pianeta) ((DAOPianeti) getInstance().get("daopianeti")).load(BigInteger.valueOf(essere.getIdpianeta()));
		Razza r = (Razza) ((DAORazze)getInstance().get("daorazze")).load(BigInteger.valueOf(essere.getIdrazza()));
		return p.toString() +", " + cittaDelNumero(numero) + ", " + indirizzoDelNumero(numero) + ", " + r.toString() + ", " + essere.toString(); 
	}

	@Override
	public int quantitaRisorsaImpero(String nomeRisorsa) {
		List<Entity> contiene = ((DAOContiene)getInstance().get("daocontiene")).list();
		List<Entity> risorse = ((DAORisorse)getInstance().get("daorisorse")).list();
		int id = -1;
		for(Entity risorsa : risorse) {
			if(((Risorsa)risorsa).getNome().equalsIgnoreCase(nomeRisorsa)) {
				id = risorsa.getId().intValue();
				break;
			}
		}
		if(id == -1)
			return -1;
		int tot = 0;
		for(Entity e : contiene) {
			if(((Contiene)e).getIdrisorsa() == id)
				tot += ((Contiene)e).getQuantita();
		}
		return tot;
	}

	
	@Override
	public int popolazioneTotaleImpero() {
		return ((DAORazze)getInstance().get("daorazze")).list().size();
	}

	@Override
	public String distanzaPianeti(String nomea, String nomeb) {
		return  ((DAOPianeti)getInstance().get("daopianeti")).distanzaPianeti(nomea, nomeb) ;
	}

	/**
	 * ritorna nullo se il pianeta non esiste
	 */
	@Override
	public List<Razza> razzeSuPianeta(String p) {
		List<Entity> pianeti = ((DAOPianeti)getInstance().get("daopianeti")).list();
		Pianeta pia = null;
		for(Entity e : pianeti) {
			if(((Pianeta)e).getNome().equalsIgnoreCase(p)) {
				pia = (Pianeta)e;
				break;
			}
		}
		if(pia == null)
			return null;
		List<Entity> esseri = ((DAOEsseri)getInstance().get("daoesseri")).list();
		List<Entity> razze = ((DAORazze)getInstance().get("daorazze")).list();
		List<Razza> risposta = new ArrayList<Razza>();
		
		for(Entity e : esseri) {
			if(((Essere)e).getIdpianeta() == pia.getId().intValue()) {
				for(Entity pi : razze) {
					if(risposta.contains(pi))
						break;
					else if(pi.getId().intValue() == ((Essere)e).getIdrazza()) {
						risposta.add((Razza)pi);
						break;
					}
				}
			}
		}
		return risposta;
	}

	/**
	 * ritorna null se la razza non esiste, lista size 0 se nessun pianeta ha quella razza
	 */
	@Override
	public List<Pianeta> pianetiConRazza(String r) {
		List<Entity> razze = ((DAORazze)getInstance().get("daorazze")).list();
		Razza raz = null;
		for(Entity e : razze) {
			if(((Razza)e).getNome().equalsIgnoreCase(p)) {
				raz = (Razza)e;
				break;
			}
		}
		if(raz == null)
			return null;
		List<Entity> esseri = ((DAOEsseri)getInstance().get("daoesseri")).list();
		List<Entity> pianeti = ((DAOPianeti)getInstance().get("daopianeti")).list();
		List<Pianeta> risposta = new ArrayList<Pianeta>();
		
		for(Entity e : esseri) {
			if(((Essere)e).getIdrazza() == raz.getId().intValue()) {
				for(Entity pi : pianeti) {
					if(risposta.contains(pi))
						break;
					else if(pi.getId().intValue() == ((Essere)e).getIdpianeta()) {
						risposta.add((Pianeta)pi);
						break;
					}
				}
			}
		}
		return risposta;
	}

	/**
	 * ritorna il numero di esseri per quella razza, -1 se razza non esiste
	 */
	@Override
	public int popolazioneRazza(String r) {
		List<Entity> razze = ((DAORazze)getInstance().get("daorazze")).list();
		Razza raz = null;
		for(Entity e : razze) {
			if(((Razza)e).getNome().equalsIgnoreCase(p)) {
				raz = (Razza)e;
				break;
			}
		}
		if(raz == null)
			return -1;
		List<Entity> esseri = ((DAOEsseri)getInstance().get("daoesseri")).list();
		int tot=0;
		for(Entity e : esseri) {
			if(((Essere)e).getIdrazza() == raz.getId().intValue())//if
				tot++;
		}
		return tot;
	}
	
	/**
	 * ritorna il numero di persone su un pianeta
	 * -1 se il pianeta non e' stato trovato
	 */
	@Override
	public int popolazionePianeta(String p) {
		List<Entity> pianeti = ((DAOPianeti)getInstance().get("daopianeti")).list();
		Pianeta pia = null;
		for(Entity e : pianeti) {
			if(((Pianeta)e).getNome().equalsIgnoreCase(p)) {
				pia = (Pianeta)e;
				break;
			}
		}
		if(pia == null)
			return -1;
		List<Entity> esseri = ((DAOEsseri)getInstance().get("daoesseri")).list();
		int tot=0;
		for(Entity e : esseri) {
			if(((Essere)e).getIdpianeta() == pia.getId().intValue())//if
				tot++;
		}
		return tot;
	}

	
	/**
	 * ritorno la lista di risorse su un pianeta
	 * ritorno null se il pianeta non esiste, vuoto se la risorsa non e' su nessun pianeta
	 */
	@Override
	public List<Risorsa> risorsePianeta(String p) {
		List<Entity> pianeti = ((DAOPianeti)getInstance().get("daopianeti")).list();
		Pianeta pia = null;
		for(Entity e : pianeti) {
			if(((Pianeta)e).getNome().equalsIgnoreCase(p)) {
				pia = (Pianeta)e;
				break;
			}
		}
		if(pia == null)
			return null;
		List<Entity> risorsa = ((DAOContiene)getInstance().get("daocontiene")).risorseSuPianeta(pia);
		List<Risorsa> risorse = new ArrayList<Risorsa>();
		for(Entity e : risorsa){
			risorse.add((Risorsa)e);
		}
		return risorse;
	}

	/**
	 * ritorno la lista di pianeti con una certa risorsa
	 * ritorno null se la risorsa non esiste, vuota se nessun pianeta ce l'ha
	 */
	
	@Override
	public List<Pianeta> PianetiConRisorsa(String r) {
		List<Entity> risorse = ((DAORisorse)getInstance().get("daorisorse")).list();
		Risorsa risorsa = null;
		for(Entity e : risorse) {
			if(((Risorsa)e).getNome().equalsIgnoreCase(r)) {
				risorsa = (Risorsa) e;
				break;
			}
		}
		if(risorsa == null)
			return null;
		List<Entity> pianeta = ((DAOContiene)getInstance().get("daocontiene")).pianetiConRisorsa(risorsa);
		List<Pianeta> pianeti = new ArrayList<Pianeta>();
		for(Entity e : pianeta) {
			pianeta.add((Pianeta)e);
		}
		return pianeti;
	}

	
}
