package com.generation.aggregator;

import java.util.List;

import com.generation.entities.*;

public interface IAggregator {
	
	public int numeriCitta(String citta);
	
	public List<Razza> esiste(String caratteristica);

	public double grandezzaMediaPianeti();
	
	public int grandezzaTotalePianeti();

	public String distanzaPianeti(String nomea, String nomeb);
	
	public boolean doppione(String nome); 

	public List<Pianeta> pianetaPiuGrande();

	public List<Pianeta> pianetaPiuPiccolo();

	public double etaMedia();

	public int etaMassima();
	
	public int etaMinima();
	
	public int ripetizioneCognome(String cognome);

	public double valoreMedioRisorse();

	public int valoreRisorsa(String nomeRisorsa);
	
	public String cittaDelNumero(int numero);

	public String indirizzoDelNumero(int numero);

	public String dettagliNumero(int numero);
	
	public int quantitaRisorsaImpero(String nomeRisorsa);

	public List<Razza> razzeSuPianeta(String p);

	public List<Pianeta> pianetiConRazza(String r);

	public int popolazioneTotaleImpero();
	
	public int popolazioneRazza(String r);

	public int popolazionePianeta(String p);
	
	public List<Risorsa> risorsaPiuPresente();
	
	public List<Risorsa> risorsePianeta(String p);

	public List<Pianeta> PianetiConRisorsa(String r);
	
}
