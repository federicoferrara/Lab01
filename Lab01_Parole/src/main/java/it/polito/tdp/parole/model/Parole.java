package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	private List<String> parole;
		
	public Parole() {
		parole= new LinkedList<>();
	}
	
	public void addParola(String p) {
		String daAggiungere;
		if(p==null) {
			return;
		}
		daAggiungere=p;
		parole.add(daAggiungere);
	}
	
	public class ComparatoreParole implements Comparator<String>{

		@Override
		public int compare(String s1, String s2) {
			// TODO Auto-generated method stub
			return s1.compareTo(s2);
		}
		
	}
	
	public List<String> getElenco() {
		List<String> risultato= new LinkedList<>(this.parole);
		Collections.sort(risultato, new ComparatoreParole());
		return risultato;
	}
	
	public void reset() {
		this.parole.clear();
	}
	
	public void cancella(String parola) {
		for(String s: this.parole) {
			if(s.equals(parola))
				this.parole.remove(s);
		}
	}

}