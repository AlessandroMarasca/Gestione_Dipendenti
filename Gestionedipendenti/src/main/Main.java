package main;
import java.sql.*;
<<<<<<< HEAD
import java.util.Scanner;


=======
import java.util.*;
>>>>>>> refs/remotes/origin/master
public class Main {
	/*
	 * Sistema di Gestione dei Dipendenti Obiettivo del progetto: Creare un sistema
	 * per gestire i dipendenti di un'azienda, sfruttando JDBC per interagire con un
	 * database. Il sistema consente di eseguire operazioni CRUD sui dipendenti,
	 * assegnarli a progetti, gestire team e calcolare gli stipendi con eventuali
	 * bonus.
	 * 
	 * Crea un'applicazione per gestire i dipendenti di un'azienda utilizzando JDBC
	 * per connettersi a un database. Utilizza l'ereditarietà per rappresentare
	 * diversi tipi di dipendenti:
	 * 
	 * Employee (classe base): rappresenta un dipendente generico, con attributi
	 * come id, nome, cognome, e stipendioBase. Manager (classe derivata):
	 * rappresenta un manager, con attributi aggiuntivi come bonus e teamGestito.
	 * Developer (classe derivata): rappresenta uno sviluppatore, con attributi come
	 * linguaggiConosciuti e progettiAssegnati. Il database deve contenere una
	 * tabella per i dipendenti e tabelle correlate per i progetti e i team. Deve
	 * essere possibile aggiungere, modificare, eliminare dipendenti, assegnarli a
	 * progetti e calcolare gli stipendi (considerando eventuali bonus).
	 * 
	 * Le risposte a questa e-mail saranno pubblicate come risposta all’annuncio,
	 * che sarà visto da tutte le persone del corso.
	 */
	//ACCESSO MYSQL
<<<<<<< HEAD
	static Credenziali credenziali=new Credenziali("jdbc:mysql://localhost:3306/db_azienda","root","Marcoluca123!");

=======
	private static final String URL = "jdbc:mysql://localhost:3306/db_azienda";
    private static final String USER = "root";
    private static final String PASSWORD = "Linkmarasca1994!";
>>>>>>> refs/remotes/origin/master
    
    public static void main(String [] args) {
<<<<<<< HEAD
    	/*do {
    		System.out.println("Benvenuto nella gestione dei dipendenti, che cosa desid");
    		switch() {
=======
    Credenziali credenziali = new Credenziali("jdbc:mysql://localhost:3306/db_azienda","root", "Linkmarasca1994!");
    	int scelta;
    	Scanner scanner = new Scanner(System.in);
    	do {
    		System.out.println("Benvenuto nella gestione dei dipendenti, che cosa desideri fare? \n1) Aggiungi nuovo dipendente \n2) Leggi elenco completo dei dipendenti \n3) Aggiorna dati dipendenti  \n4) Assegna dipendente ad un team \n5) Assegna dipendente ad un progetto \n6) Gestisci team \n7)Elimina dipendente \n8) Calcola stipendi");
    		scelta = scanner.nextInt();
    		switch (scelta) {
>>>>>>> refs/remotes/origin/master
    		case 1:
<<<<<<< HEAD
    			
    		}
    	}*/
    	
    	Scanner scanner=new Scanner(System.in);
    Employee.assegnaDipendenteTeam(scanner,credenziali);
=======
>>>>>>> refs/remotes/origin/master

    		case 2:
    		Employee.letturaDatiDipendenti(credenziali);
    		case 3:
    		
    		case 4:
    		
    		case 5:
    		
    		case 6:
    		
    		case 7:

    		case 8:
    			
    		
    		case 9:
    		}
    	} while (scelta > 9);
    	
    	System.exit(scelta);
	}
}