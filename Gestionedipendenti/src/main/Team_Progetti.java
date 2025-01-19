package main;

import java.sql.*;

public class Team_Progetti
{
	
	/**
	 * Metodo che mostra tutti i team con i relativi progetti assegnati
	 *
	 * @param conn   Apertura della connessione al DB
	 */

	public static void letturaTeamProgetto(Connection conn)
	{
		String sql = "SELECT team.nome, progetti.nome, progetti.scadenza "
				+ "FROM team_progetti "
				+ "INNER JOIN team ON team.id = team_progetti.id_team "
				+ "INNER JOIN progetti ON progetti.id = team_progetti.id_progetto";
		try (
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
