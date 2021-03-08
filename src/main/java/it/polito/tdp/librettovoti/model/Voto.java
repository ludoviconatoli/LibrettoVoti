package it.polito.tdp.librettovoti.model;
import java.time.LocalDate;

//POJO - Plain Old Java Object
//Java Bean 
//classe con solo elementi e costruttore - non ha logica, solo dati
/**
 * Memorizza risultato di un esame singolo
 * @author ludov
 *
 */
public class Voto {
	
	private String nome;
	private int voto;
	private LocalDate data;
	
	/**
	 * 
	 * @param nome Nome corso superato
	 * @param voto Voto ottenuto
	 * @param data Data di superamento
	 */
	public Voto(String nome, int voto, LocalDate data) {
		
		this.nome = nome;
		this.voto = voto;
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String toString() {
		return "Esame " +this.nome + " voto: " + this.voto + " passato il " + this.data;
	}
}
