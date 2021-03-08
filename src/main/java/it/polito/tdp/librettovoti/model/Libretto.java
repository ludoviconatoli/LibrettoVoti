package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {

	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<>();
	}
	
	public void add(Voto v) {
		this.voti.add(v);
	}
	
	public List<Voto> listaVotiUguali(int punteggio){
		//restituisce solo i voti uguali il criterio
		LinkedList<Voto> v = new LinkedList<>();
		for(Voto vo: this.voti)
			if(vo.getVoto() == punteggio)
				v.add(vo);
		
		return v;
	}
	
    public Libretto votiUguali(int punteggio){
    	Libretto l = new Libretto();
    	for(Voto v: this.voti)
    		if(v.getVoto() == punteggio)
    			l.add(v);
    	
    	return l;
	}
	 
	
	public String toString() {
		String s = "";
		for(Voto v: this.voti)
			s = s + v.toString() + "\n";
		return s;
	}
}
