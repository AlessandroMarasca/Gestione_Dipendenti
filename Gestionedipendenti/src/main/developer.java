package main;

public class developer extends Employee{
	int IdLinguaggi;
    String linguaggiConosciuti;
    String progettiAssegnati;

	// INIZIALIZZIAMO IL COSTRUTTORE
	public developer(int id, String nome, String cognome, double stipendioBase, String linguaggiConosciuti, String progettiAssegnati) {
		super(id, nome, cognome, stipendioBase);
		this.linguaggiConosciuti = linguaggiConosciuti;
		this.progettiAssegnati = progettiAssegnati;
	}



}
