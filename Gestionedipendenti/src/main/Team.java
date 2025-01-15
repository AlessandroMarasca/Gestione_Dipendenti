package main;
import java.sql.Connection;
public class Team {
	int id_team;
	String nome;
	int id_progetto;
	int id_manager;
	
	public Team(int id_team,String nome,int id_progetto) {
		this.id_team=id_team;
		this.nome=nome;
		this.id_progetto=id_progetto;
		this.id_manager=id_manager;
	}


}
