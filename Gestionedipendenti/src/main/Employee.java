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

		try (Connection conn = DriverManager.getConnection(credenziali.getURL(), credenziali.getUSER(),
				credenziali.getPASSWORD());
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

	public static void eliminaDipendente(Credenziali credenziali, Scanner scanner) {
		System.out.println("Ecco la lista completa dei dipendenti.");
		letturaDatiDipendenti(credenziali);
		// String sql = "SELECT * FROM dipendenti";
		// System.out.printf("id: %d | nome: %s | cognome: %s | stipendioBase: %.2f\n",
		// id, nome, cognome, stipendioBase);
		System.out.println("Chi desidera eliminare? Inserisci ID per continuare.");
		int id = scanner.nextInt();
		scanner.nextLine();
		try (Connection connect = credenziali.connessione();
			PreparedStatement psDel = connect.prepareStatement("DELETE FROM dipendenti WHERE id_dipendenti = ?");) {
			//ResultSet rs = psDel.executeQuery();
			psDel.setInt(1, id);
			int affectedrows = psDel.executeUpdate();
			if (affectedrows==0) {
                throw new SQLException("Modifica dipendente fallita, nessuna riga eliminata.");
            } else {
                System.out.println("Dipendente eliminato con successo");
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}