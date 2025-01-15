package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Team {
	int id_team;
	String nome;
	int id_progetto;
	int id_manager;
	
	public Team(int id_team,String nome,int id_progetto) {
		this.id_team=id_team;
		this.nome=nome;
		this.id_progetto=id_progetto;
		this.id_manager=id_manager;
	}
	public static int assegnaTeamProgetto(Scanner scanner, Credenziali credenziali) {
		System.out.println("Seleziona un progetto: ");
		int id_progetto=scanner.nextInt();
		System.out.println("A quale team vuoi assegnarlo?");
		int id_team=scanner.nextInt();
		String sql = "UPDATE progetti SET id_team=? WHERE id_progetto=?";
		try (Connection conn = credenziali.connessione();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
		{

			pstmt.setInt(1, id_team);
			pstmt.setInt(2, id_progetto);
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0)
			{
				System.out.println("Team  con ID " + id_team + " assegnato correttamente al progetto: " + id_progetto);
			} else
			{
				System.out.println("Nessun team assegnato. Verificare l'ID.");
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return -1; 
	}

}
