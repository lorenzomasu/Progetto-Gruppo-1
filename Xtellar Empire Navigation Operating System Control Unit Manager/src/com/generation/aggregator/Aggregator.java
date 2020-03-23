package com.generation.aggregator;

import java.util.List;
import java.util.Map;

import com.generation.base.Entity;
import com.generation.dao.IDAO;
import com.generation.entities.Pianeta;
import com.generation.entities.Razza;
import com.generation.entities.Risorsa;
import com.generation.entities.Rubrica;

public class Aggregator implements IAggregator{

	IDAO daoesseri;
	IDAO daopianeti; 
	IDAO daorazze;
	IDAO daorisorse;
	IDAO daorubrica;
	
	/*
	 * RICORDARSI DI METTERE CERCA, MODIFICA, AGGIORNA ED ELIMINA PER OGNI SINGOLA ENTITY
	 */
	
	@Override
	public int numeriCitta(String citta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Razza> esiste(String caratteristica) {
		// TODO Auto-generated method stub
		return null;
	}

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
	public double etaMedia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int etaMassima() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int etaMinima() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ripetizioneCognome(String cognome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double valoreMedioRisorse() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int valoreRisorsa(String nomeRisorsa) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override // da
	public String cittaDelNumero(int numero) 
	{
		
		
		return ((DAORubrica) getInstance().get("daorubrica")).cittaDelNumero(numero);
		
	}

	@Override
	public String indirizzoDelNumero(int numero) 
	{
		
		 return ((DAORubrica) getInstance().get("daorubrica")).indirizzoDelNumero(indirizzo);;
	}

	
 
	@Override
	public String dettagliNumero(int numero) 
	{
		
		return null;
	} 

	@Override
	public int quantitaRisorsaImpero(String nomeRisorsa) 
	{
		
		return 0;
	}

	
	@Override
	public int popolazioneTotaleImpero() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override  // a
	public Risorsa risorsaPiuPresente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<Risorsa, Integer>> sortValore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String distanzaPianeti(String nomea, String nomeb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Razza> razzeSuPianeta(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pianeta> pianetiConRazza(String r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int popolazioneRazza(String r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int popolazionePianeta(String p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Risorsa> risorsePianeta(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pianeta> PianetiConRisorsa(String r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean aggiungiRisorsaAPianeta(String nomepianeta, String nomerisorsa, int quantita) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
