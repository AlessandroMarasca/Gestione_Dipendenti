package main;

public class Manager extends Employee {
	double bonus;
	String teamGestito;
	
	
	public Manager(int id, String nome, String cognome, double bonus, String teamGestito,double stipendioBase,int id_team2) {
		super(id, nome, cognome, stipendioBase,id_team2);
		this.bonus = bonus;
		this.teamGestito = teamGestito;
	}
}
