package main;

import java.sql.*;
import java.util.Scanner;

//CLASSE MADRE
public class Employee
{
	int id;
	String nome;
	String cognome;
	double stipendioBase;

	int id_team2;

	public Employee(int id, String nome, String cognome, double stipendioBase, int id_team2)
	{
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.stipendioBase = stipendioBase;

		this.id_team2 = id_team2;

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
				int id = rs.getInt("id_dipendenti");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				double stipendio = rs.getInt("stipendio");

				System.out.printf("id: %d | nome: %s | cognome: %s | stipendio: %.2f\n", id, nome, cognome, stipendio);

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void eliminaDipendente(Credenziali credenziali, int id)
	{
		String SELECT = "SELECT * FROM dipendenti";

		try (Connection conn2 = DriverManager.getConnection(credenziali.URL, credenziali.USER, credenziali.PASSWORD);
				Statement stmt2 = conn2.createStatement();
				ResultSet rs2 = stmt2.executeQuery(SELECT);)
		{
			while (rs2.next())
			{
				int select;
				Scanner scanner = new Scanner(System.in);

				do
				{
					System.out.println("Ecco la lista completa dei dipendenti.");
					String sql = "SELECT*FROM db_azienda.dipendenti";
					System.out.println("Chi desidera eliminare? Inserisci ID per continuare.");
					select = scanner.nextInt();
					switch (select)
					{
					case 1:
						String SQL = "DELETE FROM db_azienda.dipendenti WHERE id_dipendenti = elimina";

					}

				} while (select == 0);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static int assegnaDipendenteTeam(Scanner scanner, Credenziali credenziali)
	{
		System.out.println("Inserisci id dipendente a cui vuoi assegnare un team:");
		int id = scanner.nextInt();
		System.out.println("Inserisci id del team");
		int id_team2 = scanner.nextInt();
		String sql = "UPDATE dipendenti SET id_team2=? WHERE id_dipendenti=?";
		try (Connection conn = DriverManager.getConnection(credenziali.URL, credenziali.USER, credenziali.PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
		{

			pstmt.setInt(1, id_team2);
			pstmt.setInt(2, id);
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0)
			{
				System.out.println("Dipendente con ID " + id + " assegnato correttamente al team: " + id_team2);
			} else
			{
				System.out.println("Nessun dipendente assegnato. Verificare l'ID.");
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return -1; // In caso di errore

	}
	
public static int inserisciNuovoDipendente(Credenziali credenziali, Scanner scanner) {
		
		System.out.print("Inserisci il nome del dipendente: ");
		String nome = scanner.nextLine();

		System.out.print("Inserisci il cognome del dipendente: ");
		String cognome = scanner.nextLine();

		System.out.print("Inserisci lo stipendio base: ");
		double stipendio = scanner.nextDouble();

		System.out.print("Inserisci l'ID del team: ");
		int idTeam = scanner.nextInt();
        String QUERY = "INSERT INTO dipendenti (nome, cognome, stipendio, id_team) VALUES (?, ?, ?, ?)";
        try (Connection conn = credenziali.connessione();
             PreparedStatement pstmt = conn.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, nome);
            pstmt.setString(2, cognome);
            pstmt.setDouble(3, stipendio);
            pstmt.setInt(4, idTeam);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creazione dipendente fallita, nessuna riga aggiunta.");
            }

            // Recupero la chiave generata (ID auto-increment)
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creazione dipendente fallita, ID non recuperato.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // In caso di errore
    }
}