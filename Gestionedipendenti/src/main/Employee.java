package main;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.*;
import java.util.Scanner;

//CLASSE MADRE
public class Employee {
	int id;
	String nome;
	String cognome;
	double stipendioBase;
<<<<<<< HEAD
	int id_team2;
	
	
	
=======
>>>>>>> refs/remotes/origin/master

	public Employee(int id, String nome, String cognome, double stipendioBase,int id_team2) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.stipendioBase = stipendioBase;
<<<<<<< HEAD
		this.id_team2=id_team2;
		
		
=======
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
>>>>>>> refs/remotes/origin/master
	}
	
	public static int assegnaDipendenteTeam(Scanner scanner,Credenziali credenziali) {
		System.out.println("Inserisci id dipendente a cui vuoi assegnare un team:");
		int id=scanner.nextInt();
		System.out.println("Inserisci id del team");
		int id_team2=scanner.nextInt();
		String sql="UPDATE dipendenti SET id_team2=? WHERE id_dipendenti=?";
		try (Connection conn = DriverManager.getConnection(credenziali.URL,credenziali.USER,credenziali.PASSWORD);
			      PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			     pstmt.setInt(1, id_team2);
			     pstmt.setInt(2,id);
			     int affectedRows = pstmt.executeUpdate();
		          if (affectedRows > 0) {
		              System.out.println("Dipendente con ID " + id+ " assegnato correttamente al team: "+id_team2);
		          } else {
		              System.out.println("Nessun dipendente assegnato. Verificare l'ID.");
		          }
		
			    

			   

			   
			 } catch (SQLException e) {
			     e.printStackTrace();
			 }
			 return -1; // In caso di errore
			
	}
	
	
}
}