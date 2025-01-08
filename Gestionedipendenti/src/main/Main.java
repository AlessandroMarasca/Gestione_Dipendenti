package main;
import java.sql.*;
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
    private static final String PASSWORD = "Alessandromarasca1994!";
    
    public static void Main(String [] args) {
	

	}
}