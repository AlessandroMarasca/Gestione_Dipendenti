package main;

public class Manager extends Employee {
	double bonus;
	String teamGestito;
	
	
	public Manager(int id, String nome, String cognome, double stipendio, int idTeam, double bonus, String teamGestito) {
		super(id, nome, cognome, stipendio, idTeam);
		this.bonus = bonus;
		this.teamGestito = teamGestito;
	}
}
