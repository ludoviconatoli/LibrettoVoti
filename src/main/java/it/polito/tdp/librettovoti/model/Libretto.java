package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {

	private List<Voto> voti;
	private Map<String, Voto> votiMap; //identity map: nome esame -> oggetto voto
	
	public Libretto() {
		this.voti = new ArrayList<>();
		this.votiMap = new HashMap<String, Voto>();
	}
	
	public void add(Voto v) {
		this.voti.add(v);
		this.votiMap.put(v.getNome(), v);
	}
	/**
	 * Verifica che nel libretto c'è già un voto con lo stesso esame e lo stesso voto
	 * @param punteggio
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
		Voto trovato = this.votiMap.get(v.getNome());
		if(trovato == null)
			return false;
		
		if(trovato.getVoto() == v.getVoto())
			return true;
		
		return false;
	}
	
	/**
	 * Verifica che nel libretto c'è già un voto con stesso esame ma voto diverso
	 * @param punteggio
	 * @return
	 */
	public boolean esisteConflitto(Voto v) {
		Voto trovato = this.votiMap.get(v.getNome());
		if(trovato == null)
			return false;
		
		if(trovato.getVoto() != v.getVoto())
			return true;
		
		return false;
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
	 
    /**
     * Ricerca un Voto del corso di cui è specificato il nome
     * Se il corso non esiste, restituisce null
     * @param nomeCorso (String)
     * @return Voto v
     */
	public Voto ricercaCorso(String nomeCorso) {
		
		Voto v = this.votiMap.get(nomeCorso);
		return v;
	}
	
	public String toString() {
		String s = "";
		for(Voto v: this.voti)
			s = s + v.toString() + "\n";
		return s;
	}
}
