package main;

import java.util.Scanner;
import java.sql.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		boolean connesso = false;

		while (!connesso)
		{
			System.out.print("Inserisci il nome dello schema: ");
			String SCHEMA = scanner.nextLine();

			// Aggiorna l'URL con il nuovo schema
			String URL = "jdbc:mysql://localhost:3306/" + SCHEMA;

			System.out.print("Inserisci il nome utente: ");
			String USER = scanner.nextLine();

			System.out.print("Inserisci la password: ");
			String PASSWORD = scanner.nextLine();

			System.out.println("\nConfigurazione completata:");
			System.out.println("URL: " + URL);
			System.out.println("Utente: " + USER);

			try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD))
			{
				Menu.menu(conn, scanner);
				connesso = true;
			} catch (SQLException e)
			{
				System.err.println("SQL Exception: " + e.getMessage());
				continue;
			}
		}

		scanner.close();
	}
}