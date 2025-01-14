package main;

public class Credenziali {
	String URL;
	String USER;
	String PASSWORD;

	public Credenziali (String URL, String USER, String PASSWORD) {
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
