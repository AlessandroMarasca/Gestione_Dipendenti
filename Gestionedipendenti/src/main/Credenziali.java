package main;

public class Credenziali {
<<<<<<< HEAD
	String URL="jdbc:mysql://localhost:3306/db_azienda";
	String USER="root";
	String PASSWORD="Marcoluca123!";
=======
	String URL ;
	String USER;
	String PASSWORD;
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
	public  Credenziali (String URL, String USER, String PASSWORD) {
=======
	public Credenziali (String URL, String USER, String PASSWORD) {
>>>>>>> refs/remotes/origin/master
	this.URL = URL;
	this.USER = USER;
	this.PASSWORD = PASSWORD;
	}
	public String getURL() {
		return URL;
	}
	public String getUSER() {
		return USER;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
}
