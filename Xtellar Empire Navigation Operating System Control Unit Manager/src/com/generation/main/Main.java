package com.generation.main;

import java.util.*;

import com.generation.aggregator.*;
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
		
		do {
			System.out.println(menuprincipale);
			opzione = tastiera.nextLine();
			String risposta = "";
			
			switch(opzione) {
			case "1":
				
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			case "4":
				
				break;
			case "5":
				
				break;
			case "6":
				Aggregator a = Aggregator.getInstance();
				String rispostasotto = "";
				String sottomenu1 = "1)Quantita numeri di una citta\t\t"
								+ "2)Cerca caratteristica aliena\n"
								+ "3)Grandezza media pianeti\t\t"
								+ "4)Grandezza totale pianeti\n"
								+ "5)Controllo nome pianeta esistente\t\t"
								+ "6)Pianeta(i) piu' grande\n"
								+ "7)Pianeta(i) piu' piccolo\t\t"
								+ "8)Eta' media popolazione\n\t\t\t\t"
								+ "9)Pagina successiva";
				sottomenu1 += "\n0)Indietro";
				String sottomenu2 = "1)Eta massima popolazione\t\t"
								+ "2)Eta minima popolazione\n"
								+ "3)Numero ripetizioni cognome\t\t"
								+ "4)Valore medio delle risorse\n"
								+ "5)Valore di una risorsa\t\t"
								+ "6)Dettagli dato un numero\n"
								+ "7)Quantita' risorsa\t\t"
								+ "8)Popolazione totale impero\n"
								+ "9)Pagina precedente\t\t10)Pagina successiva";
				sottomenu2 += "\n0)Indietro";
				String sottomenu3 = "1)Risorsa piu' presente\t\t"
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
				String sottomenu[] = new String[3];
				sottomenu[0] = sottomenu1;
				sottomenu[1] = sottomenu2;
				sottomenu[2] = sottomenu3;
				String sottoopzione = "";
				String sottorisposta = "";
				String input = "";
				do {
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
							sottorisposta = "";
							break;
						}
						break;
					case 2://pagina 2 del sottomenu
						switch(sottoopzione) {
						/*
						 * \t\t"
								+ "2)Eta minima popolazione\n"
								+ "3)Numero ripetizioni cognome\t\t"
								+ "4)Valore medio delle risorse\n"
								+ "5)Valore di una risorsa\t\t"
								+ "6)Dettagli dato un numero\n"
								+ "7)Quantita' risorsa\t\t"
								+ "8)Popolazione totale impero\n"
								+ "9)Pagina precedente\t\t10)Pagina successiva";
						 */
						case "1"://1)Eta massima popolazione
							if(a.etaMassima() == 0)
								sottorisposta = "Popolazione non trovata.";
							else 
								sottorisposta = "L'eta' massima della popolazione equivale a: " + a.etaMassima();
							break;
						case "2":
							
							break;
						}
						break;
						
					case 3:
						
						break;
					}
					System.out.println(sottorisposta);
				}while(!rispostasotto.equalsIgnoreCase("0"));
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
