package main;

import java.sql.*;

public class Credenziali
{
	private String URL = "jdbc:mysql://localhost:3306/db_azienda";
	private String USER = "root";
	private String PASSWORD = "Marcoluca123!";

	//Costruttore vuoto per istanziare le credenziali
	
	public Credenziali()
	{
		
	}

	//Costruttore per istanziare nuove credenziali
	
	public Credenziali(String URL, String USER, String PASSWORD)
	{
		this.URL = URL;
		this.USER = USER;
		this.PASSWORD = PASSWORD;
	}
	
	//Metodo per l'apertura della connessione

	public Connection connessione() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
