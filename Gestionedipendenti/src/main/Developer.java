package main;

public class Developer extends Employee {
	int IdLinguaggi;


	// INIZIALIZZIAMO IL COSTRUTTORE
	public Developer(int id, String nome, String cognome, double stipendioBase, String linguaggiConosciuti, String progettiAssegnati) {
		super(id, nome, cognome, stipendioBase);
		this.linguaggiConosciuti = linguaggiConosciuti;
		this.progettiAssegnati = progettiAssegnati;

	}

}
