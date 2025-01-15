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
			System.out.println("Benvenuto nella gestione dei dipendenti, che cosa desideri fare? \n1) Aggiungi nuovo dipendente \n2) Leggi elenco completo dei dipendenti \n3) Aggiorna dati dipendenti  \n4) Assegna dipendente ad un team \n5) Assegna dipendente ad un progetto \n6) Gestisci team \n7)Elimina dipendente \n8) Calcola stipendi \n9Esci");

			System.out.print("Inserisci la tua scelta: ");
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
				System.out.print("Inserisci l'ID del dipendente da aggiornare: ");
				int nuovoId = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Inserisci il nuovo nome: ");
				String nuovoNome = scanner.nextLine();

				System.out.print("Inserisci il nuovo cognome: ");
				String nuovoCognome = scanner.nextLine();

				System.out.print("Inserisci stipendio base: ");
				double nuovoStipendio = scanner.nextDouble();

				System.out.print("Inserisci il nuovo ID del team: ");
				int nuovoIdTeam = scanner.nextInt();

				// --> metodo per aggiornare
				break;

			case 4:
				Employee.assegnaDipendenteTeam(scanner, credenziali);
				
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				System.out.print("Inserisci l'ID del dipendente da eliminare: ");
				int rimuoviId = scanner.nextInt();

				// --> metodo per cancellare
				break;
			case 8:
				break;

			case 9:

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