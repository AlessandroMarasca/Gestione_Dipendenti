package main;

import java.sql.*;
import java.util.Scanner;

//CLASSE MADRE
public class Employee {
	int id;
	String nome;
	String cognome;
	double stipendioBase;

	public Employee(int id, String nome, String cognome, double stipendioBase) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.stipendioBase = stipendioBase;
	}

	public static void letturaDatiDipendenti(Credenziali credenziali) {
		String SELECT = "SELECT * FROM dipendenti";

		try (Connection conn = DriverManager.getConnection(credenziali.URL, credenziali.USER, credenziali.PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SELECT);) {
			while (rs.next()) {
				int id = rs.getInt("id_dipendenti");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				double stipendio = rs.getInt("stipendio");

				System.out.printf("id: %d | nome: %s | cognome: %s | stipendio: %.2f\n", id, nome, cognome, stipendio);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public void eliminaDipendente (Credenziali credenziali, int id) {
		String SELECT = "SELECT * FROM dipendenti";

		try (Connection conn2 = DriverManager.getConnection(credenziali.URL, credenziali.USER, credenziali.PASSWORD);
				Statement stmt2 = conn2.createStatement(); 
		ResultSet rs2 = stmt2.executeQuery(SELECT);) {
			while (rs.next()) {
		int select;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Ecco la lista completa dei dipendenti.");
			String sql = "SELECT*FROM db_azienda.dipendenti";
			System.out.println("Chi desidera eliminare? Inserisci ID per continuare.");
			select = scanner.nextInt();
			switch (select) {
			case 1:
				String SQL = "DELETE FROM db_azienda.dipendenti WHERE id_dipendenti = elimina";
			
				}

			}
		while(select == 0);
			}
	}
}
}