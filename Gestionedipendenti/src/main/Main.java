package main;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		// Istanza oggetto connessione al DB

		Credenziali credenziali = new Credenziali();

		boolean avvio = true;

		// Avvio del programma

		System.out.println("Sistema di Gestione Dipendenti");
		while (avvio)
		{
			System.out.println("\nBenvenuto nella gestione dei dipendenti, che cosa desideri fare?\n"
					+ "1) Aggiungi nuovo dipendente\n" + "2) Leggi elenco completo dei dipendenti\n"
					+ "3) Leggi elenco completo dei developers\n" + "4) Assegna ruolo developer a un dipendente\n"
					+ "5) Assegna dipendente ad un team\n" + "6) Assegna team ad un progetto\n"
					+ "7) Assegna linguaggio dev\n" + "8) Elimina dipendente\n" + "9) Calcola stipendi\n"
					+ "10) Aggiungi nuovo progetto\n" + "11)Esci");
			// "4) Aggiorna dati dipendenti\n"
			// "7) Gestisci team\n"

			System.out.print("\nInserisci la tua scelta: ");
			int scelta = scanner.nextInt();
			scanner.nextLine();

			switch (scelta)
			{
			case 1:

				int nuovoIdDipendente = Employee.inserisciNuovoDipendente(credenziali, scanner);
				System.out.println("Inserito nuovo dipendente con ID: " + nuovoIdDipendente);
				break;

			case 2:

				System.out.println("Elenco dei dipendenti:");
				Employee.letturaDatiDipendenti(credenziali);
				break;

			case 3:

				System.out.println("Elenco dei developers:");
				Developer.visualizzaDevelopers(credenziali, scanner);
				break;

			case 4:

				Developer.assegnaDipendenteDev(credenziali, scanner);
				break;

			case 5:

				Employee.assegnaDipendenteTeam(scanner, credenziali);
				break;

			case 6:

				Team.assegnaTeamProgetto(scanner, credenziali);
				break;
				
			case 7:

				Linguaggi.assegnaLinguaggioDev(credenziali, scanner);
				break;

			case 8:

				Employee.eliminaDipendente(credenziali, scanner);
				break;

			case 10:

				Progetti.inserisciProgetto(credenziali, scanner);
				break;

			case 11:

				System.out.println("Uscita dal sistema. Arrivederci!");
				avvio = false;
				break;

			default:
				System.out.println("Scelta non valida. Riprova.");
			}
		}

		scanner.close();
	}
}