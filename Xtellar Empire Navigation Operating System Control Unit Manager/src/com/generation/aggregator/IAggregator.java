package com.generation.aggregator;

import java.util.List;
import java.util.Map;

import com.generation.entities.*;

public interface IAggregator {
	/**
	 * -1 se non trova la citta
	 * @param citta
	 * @return
	 */
	public int numeriCitta(String citta);
	
	/**
	 * lista vuota se non trova nulla
	 * @param caratteristica
	 * @return
	 */
	public List<Razza> esiste(String caratteristica);
	
	/**
	 * -1 se zero pianeti
	 * @return
	 */
	public int grandezzaMediaPianeti();
	
	/**
	 * -1 se zero pianeti
	 * @return
	 */
	public int grandezzaTotalePianeti();
	
	/**
	 * 
	 * @param nomea
	 * @param nomeb
	 * @return
	 */
	public String distanzaPianeti(String nomea, String nomeb);
	
	/**
	 * false se non trovato, true se trovato
	 * @param nome
	 * @return
	 */
	public boolean doppione(String nome); 
	
	/**
	 * null se non ci sono pianeti
	 * @return
	 */
	public Pianeta pianetaPiuGrande();
	
	/**
	 * null se non ci sono pianeti
	 * @return
	 */
	public Pianeta pianetaPiuPiccolo();
	
	/**
	 * -1 se 0 popolazione
	 * @return
	 */
	public double etaMedia();
	
	/**
	 * -1 se 0 pop
	 * @return
	 */
	public int etaMassima();
	
	/**
	 * -1 se 0 pop
	 * @return
	 */
	public int etaMinima();
	
	/**
	 * 0 se non c'e il cognome in db o se ci sono 0 ripetizioni
	 * @param cognome
	 * @return
	 */
	public int ripetizioneCognome(String cognome);
	
	/**
	 * -1 se non ci sono risorse
	 * @return
	 */
	public double valoreMedioRisorse();
	
	/**
	 * -1 se non c'e risorsa
	 * @param nomeRisorsa
	 * @return
	 */
	public int valoreRisorsa(String nomeRisorsa);
	
	/**
	 * null se non si trova numero
	 * @param numero
	 * @return
	 */
	public String cittaDelNumero(int numero);
	
	/**
	 * null se non si trova numero
	 * @param numero
	 * @return
	 */
	public String indirizzoDelNumero(int numero);
	
	/**
	 * null se non si trova razza
	 * @param nome
	 * @return
	 */
	public Razza razza(String nome);
	
	/**
	 * null se non si trova numero
	 * @param numero
	 * @return
	 */
	public String dettagliNumero(int numero);
	
	/**
	 * -1 se non ha quella risorsa
	 * @param nomeRisorsa
	 * @return
	 */
	public int quantitaRisorsaImpero(String nomeRisorsa);
	
	/**
	 * lista zero parametri se non ci sono razze su quel pianeta, null se non esiste quel pianeta
	 * @param p
	 * @return
	 */
	public List<Razza> razzeSuPianeta(String p);
	
	/**
	 * null se razza non esiste, lista vuota se razza non sta su pianeti
	 * @param r
	 * @return
	 */
	public List<Pianeta> pianetiConRazza(String r);
	
	/**
	 * numero normale
	 * @return
	 */
	public int popolazioneTotaleImpero();
	
	/**
	 * -1 se la razza non esiste
	 * @param r
	 * @return
	 */
	public int popolazioneRazza(String r);
	 
	/**
	 * -1 se pianeta non esiste
	 * @param p
	 * @return
	 */
	public int popolazionePianeta(String p);
	
	/**
	 * null se non ci sono risorse
	 * @return
	 */
	public Risorsa risorsaPiuPresente();
	
	/**
	 * lista vuota se non ci sono risorse
	 * @return
	 */
	public List<Map<Risorsa,Integer>> sortValore();
	
	/**
	 * null se pianeta non esiste, vuota se pianeta non ha risorse
	 * @param p
	 * @return
	 */
	public List<Risorsa> risorsePianeta(String p);
	
	/**
	 * null se risorsa non esiste, lista vuota se risorsa non e' su pianeti
	 * @param r
	 * @return
	 */
	public List<Pianeta> PianetiConRisorsa(String r);
	
	public boolean aggiungiRisorsaAPianeta(String nomepianeta, String nomerisorsa, int quantita);

	String cittaDelNumero(int numero, List<Razza> citta);
	
}
