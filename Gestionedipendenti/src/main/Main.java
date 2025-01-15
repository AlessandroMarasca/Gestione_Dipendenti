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
			System.out.println(
					"\nScegli un'operazione:\n" + "1. Aggiungi un dipendente\n" + "2. Visualizza tutti i dipendenti\n"
							+ "3. Aggiorna un dipendente\n" + "4. Elimina un dipendente\n" + "5. Esci");

			System.out.print("Inserisci la tua scelta: ");
			int scelta = scanner.nextInt();
			scanner.nextLine();

			switch (scelta)
			{
			case 1:
				System.out.print("Inserisci il nome del dipendente: ");
				String nome = scanner.nextLine();

				System.out.print("Inserisci il cognome del dipendente: ");
				String cognome = scanner.nextLine();

				System.out.print("Inserisci lo stipendio base: ");
				double stipendio = scanner.nextDouble();

				System.out.print("Inserisci l'ID del team: ");
				int idTeam = scanner.nextInt();

				int nuovoIdDipendente = Employee.inserisciNuovoDipendente(nome, cognome, stipendio, idTeam, credenziali);
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
				System.out.print("Inserisci l'ID del dipendente da eliminare: ");
				int rimuoviId = scanner.nextInt();

				// --> metodo per cancellare
				break;

			case 5:
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