package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;

public class TestLibretto {
	
	public static void main(String[] args) {
		
		Libretto libretto = new Libretto();
		
		Voto v1 = new Voto("Analisi I", 20, LocalDate.of(2019,2,15));
		Voto v2 = new Voto("Chimica", 24, LocalDate.of(2019, 7, 15));
		Voto v3 = new Voto("Informatica", 30, LocalDate.of(2020, 6, 18));
		libretto.add(v1);
		libretto.add(v2);
		libretto.add(v3);
		
		System.err.println("LIBRETTO");
		System.out.println(libretto);
	}
	
}
