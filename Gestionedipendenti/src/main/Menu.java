package main;

import java.util.Scanner;
import java.sql.*;

public class Menu
{

	public static void accesso()
	{
		System.out.print("Benvenuto");
	}

	public static void menu(Connection conn, Scanner scanner)
	{
		String RESET = "\u001B[0m";
		String ROSSO = "\u001B[31m";
		String VERDE = "\u001B[32m";

		boolean avvio = true;

		// Avvio del programma

		System.out.println("\nSistema di Gestione Dipendenti");
		while (avvio)
		{
			System.out.println("\nBenvenuto nella gestione dei dipendenti, che cosa desideri fare?\n"
					+ "1) Aggiungi nuovo dipendente\n" + "2) Leggi elenco completo dei dipendenti\n"
					+ "3) Leggi elenco completo dei developers\n" + "4) Assegna ruolo developer a un dipendente\n"
					+ "5) Inserisci un nuovo team\n" + "6) Assegna dipendente ad un team\n"
					+ "7) Assegna team ad un progetto\n" + "8) Assegna linguaggio dev\n" + "9) Elimina dipendente\n"
					+ "10) Visualizza team e relativi progetti assegnati\n" + "11) Aggiungi nuovo progetto\n"
					+ "12) Assegna ruolo manager\n" + "13) Visualizza elenco managers\n"
					+ "14) Calcola stipendi managers\n" + "15) Modifica stipendio di un dipendente\n" + VERDE
					+ "16) Creazione tabelle\n" + RESET + ROSSO + "17) Elimina tutte le tabelle\n" + RESET
					+ "50) Esci");

			System.out.print("\nInserisci la tua scelta: ");
			int scelta = scanner.nextInt();
			scanner.nextLine();

			switch (scelta)
			{
			case 1:

				int nuovoIdDipendente = Employee.inserisciNuovoDipendente(conn, scanner);
				System.out.println("Inserito nuovo dipendente con ID: " + nuovoIdDipendente);
				break;

			case 2:

				System.out.println("Elenco dei dipendenti:");
				Employee.letturaDatiDipendenti(conn);
				break;

			case 3:

				System.out.println("Elenco dei developers:");
				Developer.visualizzaDevelopers(conn, scanner);
				break;

			case 4:

				Developer.assegnaDipendenteDev(conn, scanner);
				break;

			case 5:

				Team.inserisciNuovoTeam(conn, scanner);
				break;

			case 6:

				Employee.assegnaDipendenteTeam(conn, scanner);
				break;

			case 7:

				Team.assegnaTeamProgetto(conn, scanner);
				break;

			case 8:

				Linguaggi.assegnaLinguaggioDev(conn, scanner);
				break;

			case 9:

				Employee.eliminaDipendente(conn, scanner);
				break;

			case 10:

				Team_Progetti.letturaTeamProgetto(conn);
				break;

			case 11:

				Progetti.inserisciProgetto(conn, scanner);
				break;

			case 12:

				Manager.assegnaDipendenteManager(conn, scanner);
				break;

			case 13:
				System.out.println("Elenco dei managers:");
				Manager.visualizzaManager(conn);
				break;

			case 14:

				Manager.calcolaBonus(conn, scanner);
				break;

			case 15:

				Employee.modificaStipendi(conn, scanner);
				break;

			case 20:

				GestioneDB.createTabelle(conn);
				break;

			case 30:

				System.out.print("Le tabelle verrano eliminate definitivamente. Per continuare premi 1: ");
				int conferma = scanner.nextInt();
				scanner.nextLine();

				if (conferma == 1)
				{
					GestioneDB.dropTabelle(conn);
				} else
					continue;

				break;

			case 50:

				System.out.println("Uscita dal sistema. Arrivederci!");
				avvio = false;

			default:
				System.out.println("Scelta non valida. Riprova.");
			}
		}
	}
}
