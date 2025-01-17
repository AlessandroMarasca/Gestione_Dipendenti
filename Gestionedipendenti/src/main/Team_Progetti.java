package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Team_Progetti
{

	public static void letturaTeamProgetto(Credenziali credenziali, Scanner scanner)
	{
		String sql = "SELECT team.nome, progetti.nome, progetti.scadenza  "
				+ "FROM team_progetti "
				+ "INNER JOIN team ON team.id_team = team_progetti.id_team "
				+ "INNER JOIN progetti ON progetti.id_progetto = team_progetti.id_progetti";
		try (Connection conn = credenziali.connessione();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);)
		{
			while (rs.next())
			{
				
				String nometeam  = rs.getString("nome");
				String nomeprogetto = rs.getString("progetti.nome");
				String scadenza = rs.getString("scadenza");

				System.out.printf("nome_team: %s | nome_progetto: %s | scadenza: %s\n",  nometeam, nomeprogetto, scadenza);

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
