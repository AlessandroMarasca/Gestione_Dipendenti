package main;
import java.sql.*;
import java.util.Scanner;
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
	private static final String URL = "jdbc:mysql://localhost:3306/db_azienda";
    private static final String USER = "root";
    private static final String PASSWORD = "Simox00512!0";
    static connessioni conn1=new connessioni("jdbc:mysql://localhost:3306/db_azienda","root","Simox00512!0");
    
    public static void main(String [] args) {
    	Scanner scanner=new Scanner(System.in);
    	int scelta=scanner.nextInt();
    	int newemployeeID;
    	
    	do {
    		System.out.println("Benvenuto nella gestione dei dipendenti, che cosa desideri fare? \n1) Aggiungi nuovo dipendente \n2) Leggi elenco completo dei dipendenti \n3) Aggiorna dati dipendenti  \n4) Assegna dipendente ad un team \n5) Assegna dipendente ad un progetto \n6) Gestisci team \n7)Elimina dipendente \n8) Calcola stipendi");
    		
    		switch (scelta) {
    		case 1:
    			 newemployeeID=Employee.insertEmployee("Mario","Rossi",2000.00,conn1);
    			System.out.println("Inserito nuovo dipendente con ID: " + newemployeeID);
    		case 2:
    		
    		case 3:
    			System.out.println("INserisci id da cercare:");
    			int employeeidfind=scanner.nextInt();
    			
    			if(employeeidfind.equals(newemployeeID)) {
    				Employee.updateEmployee(employeidfind,"Simone","verdi",1000,conn1);	
    			}
    		case 4:
    		
    		case 5:
    		
    		case 6:
    		
    		case 7:
    		
    		case 8:
    		
    		case 9:
    		}
    		 
    	} while (scelta > 9);

	}
}
	
 
    
    

