package main;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//CLASSE MADRE
public class Employee {
	int id;
	String nome;
	String cognome;
	double stipendioBase;
	int id_team2;
	
	
	

	public Employee(int id, String nome, String cognome, double stipendioBase,int id_team2) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.stipendioBase = stipendioBase;
		this.id_team2=id_team2;
		
		
	}
	
	public static int assegnaDipendenteTeam(Scanner scanner,Credenziali credenziali) {
		System.out.println("Inserisci id dipendente a cui vuoi assegnare un team");
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
