package main;

import java.sql.*;

public class Credenziali
{
	private String URL = "jdbc:mysql://localhost:3306/db_azienda";
	private String USER = "root";
	private String PASSWORD = "Edoardo#";

	//Costruttore vuoto per istanziare le credenziali
	
	public Credenziali()
	{
	}

	//Costruttore per istanziare nuove credenziali
	
	public Credenziali(String URL, String USER, String PASSWORD)
	{
		this.setURL(URL);
		this.setUSER(USER);
		this.setPASSWORD(PASSWORD);
	}
	
	//Metodo per l'apertura della connessione

	public Connection connessione() throws SQLException {
		return DriverManager.getConnection(getURL(), getUSER(), getPASSWORD());
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getUSER() {
		return USER;
	}

	public void setUSER(String uSER) {
		USER = uSER;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
}
