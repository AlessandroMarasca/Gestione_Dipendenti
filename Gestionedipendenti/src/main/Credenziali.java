package main;

public class Credenziali
{
	String URL = "jdbc:mysql://localhost:3306/db_azienda";
	String USER = "root";
	String PASSWORD = "Edoardo#";

	public Credenziali()
	{
	}

	public Credenziali(String URL, String USER, String PASSWORD)
	{
		this.URL = URL;
		this.USER = USER;
		this.PASSWORD = PASSWORD;
	}

	public String getURL()
	{
		return URL;
	}

	public String getUSER()
	{
		return USER;
	}

	public String getPASSWORD()
	{
		return PASSWORD;
	}
}
