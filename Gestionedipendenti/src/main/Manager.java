package main;

public class Manager extends Employee {
	double bonus;
	String teamGestito;
	
	
	public Manager(int id, String nome, String cognome, double bonus, String teamGestito,double stipendioBase) {
		super(id, nome, cognome, stipendioBase);
		this.bonus = bonus;
		this.teamGestito = teamGestito;
	}
}
