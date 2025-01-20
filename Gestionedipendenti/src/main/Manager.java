package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Manager extends Employee {

	public static void assegnaDipendenteManager(Connection conn, Scanner scanner) {
		System.out.print("Inserisci l'ID del dipendente manager: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		String QUERY = "INSERT INTO manager (id_dipendente) VALUES (?);";

		try ( PreparedStatement pstmt = conn.prepareStatement(QUERY)) {
			pstmt.setInt(1, id);

			int affectedRows = pstmt.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Inserimento fallito, nessuna riga aggiunta.");
			} else {
				System.out.println("Manager aggiunto con successo.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void visualizzaManager(Connection conn) {

		String QUERY = "SELECT dipendenti.id, dipendenti.nome, dipendenti.cognome," + "dipendenti.stipendio"
				+ "dipendenti.id_team" + " FROM manager "
				+ "INNER JOIN dipendenti ON manager.id_dipendente = dipendenti.id;";

		try (
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				double stipendio = rs.getInt("stipendio");
				int idTeam = rs.getInt("id_team");

				System.out.printf("id: %d | nome: %s | cognome: %s | stipendio: %.2f | team: %d\n", id, nome, cognome,stipendio, idTeam);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void calcolaBonus(Connection conn, Scanner scanner) {
		String query = "SELECT dipendenti.id, dipendenti.nome, dipendenti.cognome, dipendenti.stipendio, managers.bonus"
				+ " FROM dipendenti " + "INNER JOIN managers ON dipendenti.id = managers.id_dipendente";
		try (
				Statement stmt2 = conn.createStatement();
				ResultSet rs2 = stmt2.executeQuery(query);) {
			while (rs2.next()) {
				int id = rs2.getInt("id");
				String nome = rs2.getString("nome");
				String cognome = rs2.getString("conome");
				double stipendio = rs2.getDouble("stipendio");
				System.out.print("A quanto ammonta la percentuale del bonus? ");     
	            double percBonus = scanner.nextDouble();
	            double calcoloBonus = stipendio * (percBonus / 100);
	            System.out.printf("id: %d | nome: %s |cognome: %s | calcoloBonus: %.2f ", id, nome, cognome, calcoloBonus);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}