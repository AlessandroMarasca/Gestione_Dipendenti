package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;

import java.sql.Connection;

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
	public static int insertEmployee(String name, String cognome, double stipendioBase,connessioni conn1) {
	    String sql = "INSERT INTO Dipendenti (nome, cognome,stipendio) VALUES (?, ?, ?)";
	    try (Connection conn = DriverManager.getConnection(conn1.URL,conn1.USER,conn1.PASSWORD);
	         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

	        pstmt.setString(1, name);
	        pstmt.setString(2, cognome);
	        pstmt.setDouble(3, stipendioBase);

	        int affectedRows = pstmt.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLException("Creazione cliente fallita, nessuna riga aggiunta.");
	        }

	        // Recupero la chiave generata (ID auto-increment)
	        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                return generatedKeys.getInt(1);
	            } else {
	                throw new SQLException("Creazione cliente fallita, ID non recuperato.");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1; // In caso di errore
	}
	public static void updateEmployee(int EmployeeID, String newnome,String newcognome,double newstipendio,connessioni conn1) {
	    String sql = "UPDATE Dipendenti SET (nome = ?,cognome=?,stipendio=?) WHERE id_dipendenti = ?";
	    try (Connection conn = DriverManager.getConnection(conn1.URL, conn1.USER, conn1.PASSWORD);
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setInt(1, EmployeeID);
	        pstmt.setString(2, newnome);
	        pstmt.setString(3, newcognome);
	        pstmt.setDouble(3, newstipendio);

	        int affectedRows = pstmt.executeUpdate();
	        if (affectedRows > 0) {
	            System.out.println("Dati aggiornati correttamente per il dipendente con ID " + EmployeeID);
	        } else {
	            System.out.println("Nessun dipendente aggiornato. Verificare l'ID.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
