package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//CLASSE MADRE
public class Employee
{
	int id;
	String nome;
	String cognome;
	double stipendioBase;

	public Employee(int id, String nome, String cognome, double stipendioBase)
	{
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.stipendioBase = stipendioBase;

	}

	public static void letturaDatiDipendenti(Credenziali credenziali)
	{
		String SELECT = "SELECT * FROM dipendenti";

		try (Connection conn = DriverManager.getConnection(credenziali.URL, credenziali.USER, credenziali.PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SELECT);)
		{
			while (rs.next())
			{
				int id = rs.getInt("id_dipendente");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				double stipendio = rs.getInt("stipendio");

				System.out.printf("id: %d | nome: %s | cognome: %s | stipendio: %.2f\n", id,
				 nome, cognome, stipendio);

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
