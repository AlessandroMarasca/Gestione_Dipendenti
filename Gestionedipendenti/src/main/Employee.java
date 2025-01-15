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
	int idTeam;
	


	public Employee(int id, String nome, String cognome, double stipendioBase, int idTeam)
	{
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.stipendioBase = stipendioBase;
		this.idTeam = idTeam;
		


	}

	
	/**
     * Mostra la lista di tutti i records della tabella dipendenti.
     *
     * @param credenziali Apertura della connessione al DB
     */

	public static void letturaDatiDipendenti(Credenziali credenziali)
	{
		String QUERY = "SELECT * FROM dipendenti";

		try (Connection conn = credenziali.connessione();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);)
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
	
	/**
     * Inserisce un nuovo dipendente nella tabella dipendenti.
     *
     * @param nome  Nome del dipendente
     * @param cognome Cognome del dipendente
     * @param stipendioBase Stipendio del dipendente
     * @param idTeam Team a cui appartiene
     * @param credenziali Apertura della connessione al DB
     * @return L'ID generato per il nuovo dipendente
     */
	
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
	

}

