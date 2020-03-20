package com.generation.aggregator;

import java.util.List;
import java.util.Map;

import com.generation.entities.*;

public interface IAggregator {

	public int numeriCitta(String citta);
	public List<Razza> esiste(String caratteristica);
	public int grandezzaMediaPianeti();
	public int grandezzaTotalePianeti();
	public String distanzaPianeti(Pianeta a, Pianeta b);
	public boolean doppione(String nome); 
	public Pianeta pianetaPiuGrande();
	public Pianeta pianetaPiuPiccolo();
	public double etaMedia();
	public int etaMassima();
	public int etaMinima();
	public int ripetizioneCognome(String cognome); 
	public double valoreMedioRisorse();
	public int valoreRisorsa(String nomeRisorsa);
	public String cittaDelNumero(int numero);
	public String indirizzoDelNumero(int numero);
	public Razza razza(String nome);
	public String dettagliNumero(int numero); 
	public int quantitaRisorsaImpero(String nomeRisorsa);
	public List<Razza> razzeSuPianeta(Pianeta p);
	public List<Pianeta> pianetiConRazza(Razza r);
	public int popolazioneTotaleImpero();
	public int popolazioneRazza(Razza r);
	public int popolazionePianeta(Pianeta p);
	public Risorsa risorsaPiuPresente();
	public List<Map<Risorsa,Integer>> sortValore();
	public List<Risorsa> risorsePianeta(Pianeta p);
	public List<Pianeta> PianetiConRisorsa(Risorsa r);
	
	
}
