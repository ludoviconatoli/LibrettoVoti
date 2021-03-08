package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.util.*;

public class TestLibretto {
	
	public static void main(String[] args) {
		
		Libretto libretto = new Libretto();
		
		Voto v1 = new Voto("Analisi I", 20, LocalDate.of(2019,2,15));
		Voto v2 = new Voto("Chimica", 24, LocalDate.of(2019, 7, 15));
		Voto v3 = new Voto("Informatica", 30, LocalDate.of(2020, 6, 18));
		libretto.add(v1);
		libretto.add(v2);
		libretto.add(v3);
		libretto.add(new Voto("Statistica", 25, LocalDate.of(2020, 2, 10)));
		libretto.add(new Voto("Fisica I", 23, LocalDate.of(2019, 7, 4)));
		
		System.err.println("LIBRETTO");
		System.out.println(libretto);
		
		List<Voto> venticinque = libretto.listaVotiUguali(25);
		System.out.println(venticinque);
		System.out.println();
		
		Libretto vc = libretto.votiUguali(25);
		System.out.println(vc);
	}
	
}
