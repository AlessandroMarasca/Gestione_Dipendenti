package main;

public class Developer extends Employee {
	int IdLinguaggi;
	int progettoAssegnato;


	// INIZIALIZZIAMO IL COSTRUTTORE

	public Developer(int id, String nome, String cognome, double stipendio, int idTeam, int IdLinguaggi, int progettoAssegnato) {
		super(id, nome, cognome, stipendio, idTeam);
        

	}

}
