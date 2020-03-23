package com.generation.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import java.sql.Date;
import com.generation.aggregator.*;
import com.generation.base.Entity;
import com.generation.entities.*;

public class Main {

	public static void main(String[] args) {
		
		String menuprincipale = "1)Gestione esseri\n"
				+ "2)Gestione razze\n"
				+ "3)Gestione pianeta\n"
				+ "4)Gestione risorse\n"
				+ "5)Gestione rubrica\n"
				+ "6)Gestione Impero";
		menuprincipale += "\n0)Esci";
		Scanner tastiera = new Scanner(System.in);
		String opzione = "";
		String rispostasotto = "";
		String sottomenu1 ="", sottomenu2 ="", sottomenu3="";
		String sottoopzione = "";
		String sottorisposta = "";
		String input = "";
		Aggregator a = Aggregator.getInstance();
		
		do {
			System.out.println(menuprincipale);
			opzione = tastiera.nextLine();
			String risposta = "";
			
			switch(opzione) {
			case "1"://gestione esseri
				sottomenu1 = "1)Cerca essere.\n"
						+ "2)Modifica essere.\n"
						+ "3)Aggiungi essere.\n"
						+ "4)Elimina essere.\n";
				sottomenu1 += "0)Esci";
				sottoopzione = "";
				
				do {//do while gestito da sottoopzione
					
					System.out.println(sottomenu1);
					sottoopzione = tastiera.nextLine();
					Entity essere = null;
					switch(sottoopzione) {
					case "1"://1)Cerca essere.
						System.out.println("Inserisci id dell'essere:");
						try {
							essere = a.cercaEssere(Integer.parseInt(tastiera.nextLine()));
							if(essere.getId() == null)
								sottorisposta = "Essere non trovato.";
							else
								sottorisposta = essere.toString();
						}catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dell'id.";
						}
						break;
						
					case "2"://2)Modifica essere.
					case "3"://aggiungi essere
						try{
							System.out.println("Inserisci id essere:");
							essere = new Essere();
							essere.setId(Integer.parseInt(tastiera.nextLine()));
							System.out.println("Inserisci nome essere:");
							((Essere)essere).setNome(tastiera.nextLine());
							System.out.println("Inserisci cognome essere:");
							((Essere)essere).setCognome(tastiera.nextLine());
							System.out.println("Inserisci data di nascita yyyy-mm-dd");
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
							java.util.Date date = sdf.parse(tastiera.nextLine());
							java.sql.Date sqldate = new Date(date.getTime());
							((Essere)essere).setDob(sqldate);
							System.out.println("Inserisci id della sua razza:");
							((Essere)essere).setIdrazza(Integer.parseInt(tastiera.nextLine()));
							System.out.println("Inserisci numero di telefono:");
							((Essere)essere).setIdnumero(Integer.parseInt(tastiera.nextLine()));
							System.out.println("Inserisci id pianeta:");
							((Essere)essere).setIdpianeta(Integer.parseInt(tastiera.nextLine()));
							essere = a.modificaCreaEssere(essere);
							if(sottoopzione == "2")
								sottorisposta = "Essere modificato: " + essere.toString();
							else
								sottorisposta = "Essere aggiunto: " + essere.toString();
						} catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dati.";
						}
						break;
					case "4"://elimina pianeta
						try {
							System.out.println("Inserisci id essere:");
							sottorisposta = a.eliminaEssere(Integer.parseInt(tastiera.nextLine())) ? "Essere eliminato con successo." : "Errore nella cancellazione";
						} catch(Exception e) {
							sottorisposta = "Errore nella cancellazione.";
						}
						break;
					}
					
					System.out.println(sottorisposta);
				} while(!sottoopzione.equalsIgnoreCase("0"));//fine gestione esseri
				sottoopzione = "";
				sottorisposta = "";
				break;
				
			case "2"://gestione razze
				sottomenu1 = "1)Cerca razza.\n"
						+ "2)Modifica razza.\n"
						+ "3)Aggiungi razza.\n"
						+ "4)Elimina razza.\n";
				sottomenu1 += "0)Esci";
				sottoopzione = "";
				
				do {//do while gestito da sottoopzione
					
					System.out.println(sottomenu1);
					sottoopzione = tastiera.nextLine();
					Entity razza = null;
					switch(sottoopzione) {
					case "1"://1)Cerca razza.
						System.out.println("Inserisci id della razza:");
						try {
							razza = a.cercaRazza(Integer.parseInt(tastiera.nextLine()));
							if(razza.getId() == null)
								sottorisposta = "Razza non trovato.";
							else
								sottorisposta = razza.toString();
						}catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dell'id.";
						}
						break;
						
					case "2"://2)Modifica razza.
					case "3"://aggiungi razza
						try{
							System.out.println("Inserisci id razza:");
							razza = new Razza();
							razza.setId(Integer.parseInt(tastiera.nextLine()));
							System.out.println("Inserisci nome razza:");
							((Razza)razza).setNome(tastiera.nextLine());
							System.out.println("Inserisci descrizione razza:");
							((Razza)razza).setDescrizione(tastiera.nextLine());
							razza = a.modificaCreaRazza(razza);
							if(sottoopzione == "2")
								sottorisposta = "Razza modificata: " + razza.toString();
							else
								sottorisposta = "Razza aggiunta: " + razza.toString();
						} catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dati.";
						}
						break;
					case "4"://elimina pianeta
						try {
							System.out.println("Inserisci id razza:");
							sottorisposta = a.eliminaRazza(Integer.parseInt(tastiera.nextLine())) ? "Razza eliminata con successo." : "Errore nella cancellazione";
						} catch(Exception e) {
							sottorisposta = "Errore nella cancellazione.";
						}
						break;
					}
					
					System.out.println(sottorisposta);
				} while(!sottoopzione.equalsIgnoreCase("0"));//fine gestione esseri
				sottoopzione = "";
				sottorisposta = "";
				break;
				
			case "3"://gestione pianeta
				sottomenu1 = "1)Cerca pianeta.\n"
						+ "2)Modifica pianeta.\n"
						+ "3)Aggiungi pianeta.\n"
						+ "4)Elimina pianeta.\n"
						+ "5)Aggiungi risorsa a pianeta.\n"
						+ "6)Modifica risorsa di un pianeta.\n"
						+ "7)Elimina risorsa da un pianeta.\n";
				sottomenu1 += "0)Esci";
				sottoopzione = "";
				
				do {//do while gestito da sottoopzione
					
					System.out.println(sottomenu1);
					sottoopzione = tastiera.nextLine();
					Entity pianeta = null;
					switch(sottoopzione) {
					case "1"://1)Cerca pianeta.
						System.out.println("Inserisci id del pianeta:");
						try {
							pianeta = a.cercaPianeta(Integer.parseInt(tastiera.nextLine()));
							if(pianeta.getId() == null)
								sottorisposta = "Pianeta non trovato.";
							else
								sottorisposta = pianeta.toString();
						}catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dell'id.";
						}
						break;
						
					case "2"://2)Modifica pianeta.
					case "3"://aggiungi pianeta
						try{
							System.out.println("Inserisci id pianeta:");
							pianeta = new Pianeta();
							pianeta.setId(Integer.parseInt(tastiera.nextLine()));
							System.out.println("Inserisci nome pianeta:");
							((Pianeta)pianeta).setNome(tastiera.nextLine());
							System.out.println("Inserisci grandezza pianeta:");
							((Pianeta)pianeta).setGrandezza(Integer.parseInt(tastiera.nextLine()));
							System.out.println("Inserisci coordinate pianeta:");
							((Pianeta)pianeta).setCoordinate(tastiera.nextLine());
							pianeta = a.modificaCreaPianeta(pianeta);
							if(sottoopzione == "2")
								sottorisposta = "Pianeta modificato: " + pianeta.toString();
							else
								sottorisposta = "Pianeta aggiunto: " + pianeta.toString();
						} catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dati.";
						}
						break;
					case "4"://elimina pianeta
						try {
							System.out.println("Inserisci id pianeta:");
							sottorisposta = a.eliminaPianeta(Integer.parseInt(tastiera.nextLine())) ? "Pianeta eliminato con successo." : "Errore nella cancellazione";
						} catch(Exception e) {
							sottorisposta = "Errore nella cancellazione.";
						}
						break;
					case "5"://5)Aggiungi risorsa a pianeta.
						try{
							System.out.println("Inserisci id pianeta:");
							int idpianeta = Integer.parseInt(tastiera.nextLine());
							System.out.println("Inserisci id risorsa:");
							int idrisorsa = Integer.parseInt(tastiera.nextLine());
							System.out.println("Inserisci quantita' risorsa:");
							Contiene c = (Contiene) a.aggiungiRisorsaAPianeta(idpianeta, idrisorsa, Integer.parseInt(tastiera.nextLine()));
							if(c!=null)
								sottorisposta = "Aggiunta effettuata con successo.";
							else
								sottorisposta = "Errore nell'aggiunta.";
						} catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dati.";
						}
						break;
					case "6"://6)Modifica risorsa di un pianeta.
						try {
							System.out.println("Inserisci id pianeta da modificare:");
							int idpianeta = Integer.parseInt(tastiera.nextLine());
							System.out.println("Inserisci id risorsa da modificare:");
							int idrisorsa = Integer.parseInt(tastiera.nextLine());
							System.out.println("Inserisci nuovo id risorsa:");
							Contiene c = (Contiene)a.modificaRisorsaAPianeta(idpianeta, idrisorsa, Integer.parseInt(tastiera.nextLine()));
							if(c!=null)
								sottorisposta = "Modifica effettuata con successo.";
							else
								sottorisposta = "Errore nella modifica.";
						} catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dati.";
						}
						
						break;
					case "7":
						try {
							System.out.println("Inserisci id pianeta da eliminare:");
							int idpianeta = Integer.parseInt(tastiera.nextLine());
							System.out.println("Inserisci id risorsa da eliminare:");
							sottorisposta = a.eliminaRisorsaPianeta(idpianeta, Integer.parseInt(tastiera.nextLine())) ? "Eliminazione effettuata con successo." : "Errore nell'eliminazione."; 
						} catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dati.";
						}
						
						break;
					}
					
					System.out.println(sottorisposta);
				} while(!sottoopzione.equalsIgnoreCase("0"));//fine gestione esseri
				sottoopzione = "";
				sottorisposta = "";
				break;
				
			case "4"://==========gestione risorse===============
				sottomenu1 = "1)Cerca risorsa.\n"
						+ "2)Modifica risorsa.\n"
						+ "3)Aggiungi risorsa.\n"
						+ "4)Elimina risorsa.\n"
						+ "5)Aggiungi risorsa a pianeta.\n"
						+ "6)Modifica risorsa di un pianeta.\n"
						+ "7)Elimina risorsa da un pianeta.\n";;
				sottomenu1 += "0)Esci";
				sottoopzione = "";
				
				do {//do while gestito da sottoopzione
					
					System.out.println(sottomenu1);
					sottoopzione = tastiera.nextLine();
					Entity risorsa = null;
					switch(sottoopzione) {
					case "1"://1)Cerca risorsa.
						System.out.println("Inserisci id della risorsa:");
						try {
							risorsa = a.cercaRisorsa(Integer.parseInt(tastiera.nextLine()));
							if(risorsa.getId() == null)
								sottorisposta = "Risorsa non trovato.";
							else
								sottorisposta = risorsa.toString();
						}catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dell'id.";
						}
						break;
						
					case "2"://2)Modifica risorsa.
					case "3": //aggiungi risorsa
						try{
							System.out.println("Inserisci id pianeta:");
							risorsa = new Risorsa();
							risorsa.setId(Integer.parseInt(tastiera.nextLine()));
							System.out.println("Inserisci nome risorsa:");
							((Risorsa)risorsa).setNome(tastiera.nextLine());
							System.out.println("Inserisci descrizione risorsa:");
							((Risorsa)risorsa).setValore(Integer.parseInt(tastiera.nextLine()));
							risorsa = a.modificaCreaRisorsa(risorsa);
							if(sottoopzione == "2")
								sottorisposta = "Pianeta modificato: " + risorsa.toString();
							else 
								sottorisposta = "Pianeta aggiunto: " + risorsa.toString();
						} catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dati.";
						}
						break;
						
					case "4"://elimina risorsa
						try {
							System.out.println("Inserisci id risorsa:");
							sottorisposta = a.eliminaRisorsa(Integer.parseInt(tastiera.nextLine())) ? "Risorsa eliminata con successo." : "Errore nella cancellazione";
						} catch(Exception e) {
							sottorisposta = "Errore nella cancellazione.";
						}
						break;
					case "5"://5)Aggiungi risorsa a pianeta.
						try{
							System.out.println("Inserisci id pianeta:");
							int idpianeta = Integer.parseInt(tastiera.nextLine());
							System.out.println("Inserisci id risorsa:");
							int idrisorsa = Integer.parseInt(tastiera.nextLine());
							System.out.println("Inserisci quantita' risorsa:");
							Contiene c = (Contiene) a.aggiungiRisorsaAPianeta(idpianeta, idrisorsa, Integer.parseInt(tastiera.nextLine()));
							if(c!=null)
								sottorisposta = "Aggiunta effettuata con successo.";
							else
								sottorisposta = "Errore nell'aggiunta.";
						} catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dati.";
						}
						break;
					case "6"://6)Modifica risorsa di un pianeta.
						try {
							System.out.println("Inserisci id pianeta da modificare:");
							int idpianeta = Integer.parseInt(tastiera.nextLine());
							System.out.println("Inserisci id risorsa da modificare:");
							int idrisorsa = Integer.parseInt(tastiera.nextLine());
							System.out.println("Inserisci nuovo id risorsa:");
							Contiene c = (Contiene)a.modificaRisorsaAPianeta(idpianeta, idrisorsa, Integer.parseInt(tastiera.nextLine()));
							if(c!=null)
								sottorisposta = "Modifica effettuata con successo.";
							else
								sottorisposta = "Errore nella modifica.";
						} catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dati.";
						}
						
						break;
					case "7":
						try {
							System.out.println("Inserisci id pianeta da eliminare:");
							int idpianeta = Integer.parseInt(tastiera.nextLine());
							System.out.println("Inserisci id risorsa da eliminare:");
							sottorisposta = a.eliminaRisorsaPianeta(idpianeta, Integer.parseInt(tastiera.nextLine())) ? "Eliminazione effettuata con successo." : "Errore nell'eliminazione."; 
						} catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dati.";
						}
						
						break;
					}
					
					System.out.println(sottorisposta);
				} while(!sottoopzione.equalsIgnoreCase("0"));//fine gestione esseri
				sottoopzione = "";
				sottorisposta = "";
				break;
				
			case "5"://Gestione rubrica
				sottomenu1 = "1)Cerca numero.\n"
						+ "2)Modifica numero.\n"
						+ "3)Aggiungi numero.\n"
						+ "4)Elimina numero.\n";
				sottomenu1 += "0)Esci";
				sottoopzione = "";
				
				do {//do while gestito da sottoopzione
					
					System.out.println(sottomenu1);
					sottoopzione = tastiera.nextLine();
					Entity numero = null;
					switch(sottoopzione) {
					case "1"://1)Cerca risorsa.
						System.out.println("Inserisci numero:");
						try {
							numero = a.cercaRubrica(Integer.parseInt(tastiera.nextLine()));
							if(numero.getId() == null)
								sottorisposta = "Numero non trovato.";
							else
								sottorisposta = numero.toString();
						}catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dell'id.";
						}
						break;
						
					case "2"://2)Modifica numero.
					case "3": //aggiungi numero
						try{
							numero = new Rubrica();
							System.out.println("Inserisci numero:");
							numero.setId(Integer.parseInt(tastiera.nextLine()));
							System.out.println("Inserisci percorso foto:");
							((Rubrica)numero).setFoto(tastiera.nextLine());
							System.out.println("Inserisci citta numero:");
							((Rubrica)numero).setCitta(tastiera.nextLine());
							System.out.println("Inserisci indirizzo numero:");
							((Rubrica)numero).setIndirizzo(tastiera.nextLine());
							numero = a.modificaCreaRubrica(numero);
							if(sottoopzione == "2")
								sottorisposta = "Numero modificato: " + numero.toString();
							else
								sottorisposta = "Numero aggiunto: " + numero.toString();
						} catch(Exception e) {
							sottorisposta = "Errore nell'inserimento dati.";
						}
						break;
						
					case "4"://elimina numero
						try {
							System.out.println("Inserisci numero:");
							sottorisposta = a.eliminaRubrica(Integer.parseInt(tastiera.nextLine())) ? "Numero eliminato con successo." : "Errore nella cancellazione";
						} catch(Exception e) {
							sottorisposta = "Errore nella cancellazione.";
						}
						break;
					}
					
					System.out.println(sottorisposta);
				} while(!sottoopzione.equalsIgnoreCase("0"));//fine gestione esseri
				sottoopzione = "";
				sottorisposta = "";
				break;
				
			case "6":
				sottomenu1 = "1)Quantita numeri di una citta\t\t"
								+ "2)Cerca caratteristica aliena\n"
								+ "3)Grandezza media pianeti\t\t"
								+ "4)Grandezza totale pianeti\n"
								+ "5)Controllo nome pianeta esistente\t\t"
								+ "6)Pianeta(i) piu' grande\n"
								+ "7)Pianeta(i) piu' piccolo\t\t"
								+ "8)Eta' media popolazione\n\t\t\t\t"
								+ "9)Pagina successiva";
				sottomenu1 += "\n0)Indietro";
				sottomenu2 = "1)Eta massima popolazione\t\t"
								+ "2)Eta minima popolazione\n"
								+ "3)Numero ripetizioni cognome\t\t"
								+ "4)Valore medio delle risorse\n"
								+ "5)Valore di una risorsa\t\t"
								+ "6)Dettagli dato un numero\n"
								+ "7)Quantita' risorsa\t\t"
								+ "8)Popolazione totale impero\n"
								+ "9)Pagina precedente\t\t10)Pagina successiva";
				sottomenu2 += "\n0)Indietro";
				sottomenu3 = "1)Risorsa piu' presente\t\t"
								+ "2)Distanza tra due pianeti\n"
								+ "3)Razze su un certo pianeta\t\t"
								+ "4)Pianeti con una certa razza\n"
								+ "5)Popolazione totale razza\t\t"
								+ "6)Popolazione totale pianeta\n"
								+ "7)Risorse su un pianeta\t\t"
								+ "8)Pianeti con una certa risorsa\n"
								+ "9)Pagine precedente";
				sottomenu3 += "\n0)Indietro";
				int index = 0;
				String sottomenu[] = {sottomenu1, sottomenu2, sottomenu3};
				sottoopzione = "";
				
				
				do {//rispostasotto gestisce questo do while
					
					System.out.println(sottomenu[index]);
					sottoopzione = tastiera.nextLine();
					switch(index) {
					case 1://pagina 1 del sottomenu
						switch(sottoopzione) {
						case "1":// 1)Quantita numeri di una citta\t\t"
							System.out.println("Inserisci il nome della citta:");
							input = tastiera.nextLine();
							int test = a.numeriCitta(input);
							if(test == 0)
								sottorisposta = "Citta non trovata o vuota.";
							else
								sottorisposta = "La quantita di numeri presenti in questa citta' e': " + test;
							break;
							
						case "2": // 2)Cerca caratteristica aliena
							System.out.println("Inserisci la caratteristica aliena da ricercare:");
							input = tastiera.nextLine();
							List<Razza> razze = a.esiste(input);
							if(razze.size()==0 || razze == null)
								sottorisposta = "Nessuna razza trovata";
							else {
								if(razze.size() == 1)
									sottorisposta = "1 razza trovata: ";
								else
									sottorisposta = razze.size() + " razze trovate: ";
								for(Razza r : razze)
									sottorisposta += r.toString();
							}
							break;
							
						case "3"://3)Grandezza media pianeti
							sottorisposta = "La grandezza media di tutti i pianeti e': " + a.grandezzaMediaPianeti();
							break;
							
						case "4"://4)Grandezza totale pianeti\n
							sottorisposta = "La grandezza totale di tutti i pianeti e': " + a.grandezzaTotalePianeti();
							break;
							
						case "5"://5)Controllo nome pianeta esistente
							System.out.println("Inserire il nome da controllare:");
							input = tastiera.nextLine();
							sottorisposta = a.doppione(input) ? "Nome gia' esistente." : "Nome libero";
							break;
							
						case "6"://6)Pianeta(i) piu' grande
							List<Pianeta> pianeti = a.pianetaPiuGrande();
							if(pianeti.size() == 0 || pianeti == null)
								sottorisposta = "Nessun pianeta nell'impero.";
							else{
								if(pianeti.size() == 1)
									sottorisposta = "Il pianeta piu' grande e': ";
								else
									sottorisposta = "I pianeti piu' grandi sono: ";
								for(Pianeta p : pianeti)
									sottorisposta += p.toString();								
							}
							break;
							
						case "7"://7)Pianeta(i) piu' piccolo
							pianeti = a.pianetaPiuPiccolo();
							if(pianeti.size() == 0 || pianeti == null)
								sottorisposta = "Nessun pianeta nell'impero.";
							else{
								if(pianeti.size() == 1)
									sottorisposta = "Il pianeta piu' piccolo e': ";
								else
									sottorisposta = "I pianeti piu' piccoli sono: ";
								for(Pianeta p : pianeti)
									sottorisposta += p.toString();								
							}
							break;
						
						case "8"://8)Eta' media popolazione
							if(a.etaMedia() == 0)
								sottorisposta = "Popolazione non trovata.";
							else 
								sottorisposta = "L'eta' media della popolazione equivale a: " + a.etaMedia();
							break;
							
						case "9"://9)Pagina successiva
							index++;
							sottorisposta = "---------------------------";
							break;
						default:
							sottorisposta = "Errore nella selezione, riprovare.";
							break;
						}
						break;
					case 2://pagina 2 del sottomenu
						switch(sottoopzione) {
						case "1"://1)Eta massima popolazione
							if(a.etaMassima() == 0)
								sottorisposta = "Popolazione non trovata.";
							else 
								sottorisposta = "L'eta' massima della popolazione equivale a: " + a.etaMassima();
							break;
						case "2"://2)Eta minima popolazione
							if(a.etaMinima() == 0)
								sottorisposta = "Popolazione non trovata.";
							else 
								sottorisposta = "L'eta' massima della popolazione equivale a: " + a.etaMinima();
							break;
						case "3"://3)Numero ripetizioni cognome
							System.out.println("Inserire il cognome da cercare:");
							int r = a.ripetizioneCognome(tastiera.nextLine());
							if(r == 0)
								sottorisposta = "Cognome non trovato.";
							else
								sottorisposta = r + " ripetizioni trovate.";
							break;
						case "4"://4)Valore medio delle risorse
							if(a.valoreMedioRisorse() == 0)
								sottorisposta = "Risorse non trovate.";
							else
								sottorisposta = "Valore medio risorse dell'impero: " + a.valoreMedioRisorse();
							break;
						case "5"://5)Valore di una risorsa
							System.out.println("Scrivere il nome della risorsa:");
							r = a.valoreRisorsa(tastiera.nextLine());
							if(r == 0)
								sottorisposta = "Risorsa non trovata.";
							else
								sottorisposta = "Il valore della risorsa cercata e': " + r;
							break;
						case "6"://6)Dettagli dato un numero
							System.out.println("Inserisci il numero da cercare:");
							String s = tastiera.nextLine();
							try {
								r = Integer.parseInt(s);
							} catch(Exception e) {
								sottorisposta = "Inserimento numero errato.";
								break;
							}
							sottorisposta = a.dettagliNumero(r);
							break;
						case "7"://7)Quantita' risorsa
							System.out.println("Inserisci nome della risorsa:");
							r = a.quantitaRisorsaImpero(tastiera.nextLine());
							if(r == 0)
								sottorisposta = "Risorsa non trovata.";
							else
								sottorisposta = "Valore della risorsa: " + r;
							break;
						case "8"://8)Popolazione totale impero
							r = a.popolazioneTotaleImpero();
							if(r == 0)
								sottorisposta = "Impero senza popolazione.";
							else
								sottorisposta = "Popolazione totale e': " + r;
							break;
						case "9"://9)Pagina precedente
							index--;
							sottorisposta = "---------------------------";
							break;
						case "10"://10)Pagina successiva
							index++;
							sottorisposta = "---------------------------";
							break;
						default:
							sottorisposta = "Errore nella seleziona, riprovare.";
							break;
						}
						break;
						
					case 3://pagina 3 del sottomenu
						/*
							+ "";
						 */
						switch(sottoopzione) {
						case "1"://1)Risorsa piu' presente
							Risorsa ri = a.risorsaPiuPresente();
							if(ri.getId().intValue() == 0)
								sottorisposta = "Nessuna risorsa trovata.";
							else
								sottorisposta = ri.toString();
							break;
							
						case "2"://2)Distanza tra due pianeti
							System.out.println("Inserisci il nome del primo pianeta:");
							String pi = tastiera.nextLine();
							System.out.println("Inserisci il nome del secondo pianeta:");
							pi = a.distanzaPianeti(pi, tastiera.nextLine());
							if(pi.isEmpty())
								sottorisposta = "Pianeta non trovato.";
							else
								sottorisposta = "La distanza tra i due pianeti e' " + pi;
							break;
							
						case "3"://3)Razze su un certo pianeta
							System.out.println("Inserisci il nome del pianeta:");
							List<Razza> r = a.razzeSuPianeta(tastiera.nextLine());
							if(r == null)
								sottorisposta = "Pianeta non esistente.";
							else if(r.isEmpty())
								sottorisposta = "Pianeta vuoto.";
							else if(r.size() == 1)
								sottorisposta = "La razza sul pianeta cercato e':" + r.get(0).toString();
							else {
								sottorisposta = "Le razze sul pianeta cercato sono: ";
								for(Razza ra : r)
									sottorisposta += ra.toString();
							}
							break;
							
						case "4"://4)Pianeti con una certa razza
							System.out.println("Inserisci il nome della razza:");
							List<Pianeta> pia = null;
							pia = a.pianetiConRazza(tastiera.nextLine());
							if(pia == null)
								sottorisposta = "Razza non esistente.";
							else if(pia.isEmpty())
								sottorisposta = "Razza con 0 esemplari.";
							else if(pia.size() == 1)
								sottorisposta = "La razza vive sul pianeta: " + pia.get(0).toString();
							else {
								sottorisposta = "La razza vive sui pianeti: ";
								for(Pianeta ra : pia)
									sottorisposta += ra.toString();
							}
							break;
							
						case "5"://5)Popolazione totale razza
							System.out.println("Inserisci il nome della razza:");
							int test = a.popolazioneRazza(tastiera.nextLine());
							if(test == 0)
								sottorisposta = "Razza con 0 popolazione.";
							else
								sottorisposta = "La razza ha una popolazione pari a: " + test;
							break;
						case "6"://6)Popolazione totale pianeta
							System.out.println("Inserire nome del pianeta:");
							test = a.popolazionePianeta(tastiera.nextLine());
							if(test == 0)
								sottorisposta = "Pianeta vuoto o non esistente.";
							else
								sottorisposta = "Il pianeta ha popolazione uguale a: " + test;
							break;
							
						case "7"://7)Risorse su un pianeta
							System.out.println("Inserisci nome del pianeta:");
							List<Risorsa> ris = a.risorsePianeta(tastiera.nextLine()); 
							if(ris == null)
								sottorisposta = "Pianeta non esistente.";
							else if(ris.isEmpty())
								sottorisposta = "Il pianeta e' senza risorse.";
							else if(ris.size() == 1)
								sottorisposta = "Risorsa su pianeta: " + ris.get(0).toString();
							else{
								sottorisposta = "Risorse su pianeta: ";
								for(Risorsa risorsa : ris)
									sottorisposta += risorsa.toString();
							}
							break;
							
						case "8"://8)Pianeti con una certa risorsa
							System.out.println("Inserisci nome della risorsa da cercare:");
							pia = null;
							pia = a.PianetiConRisorsa(tastiera.nextLine());
							if(pia == null)
								sottorisposta = "Risorsa non esistente.";
							else if(pia.isEmpty())
								sottorisposta = "Risorsa su nessun pianeta.";
							else if(pia.size() == 1)
								sottorisposta = "Il pianeta con la risorsa e': " + pia.get(0).toString();
							else {
								sottorisposta = "Pianeti con la risorsa: ";
								for(Pianeta ra : pia)
									sottorisposta += ra.toString();
							}
							break;
							
						case "9"://9)Pagine precedente
							index--;
							sottorisposta = "---------------------------";
							break;
						default:
							sottorisposta = "Errore nella seleziona, riprovare.";
							break;
						}
					break;//fine del sottomenu
					}
					System.out.println(sottorisposta);
				}while(!rispostasotto.equalsIgnoreCase("0"));//uscita dal sottomenu
				//non c'e il break perche in questo modo la risposta verra annullata tramite lo 0
				
			case "0":
				risposta = "";
				break;
			default:
				risposta = "Opzione errata";
				break;
			}
			System.out.println(risposta);
		}while(!opzione.equalsIgnoreCase("0"));
		
		tastiera.close();
	}

}
