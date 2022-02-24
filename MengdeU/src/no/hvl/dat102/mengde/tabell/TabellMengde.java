package no.hvl.dat102.mengde.tabell;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;

public class TabellMengde<T> implements MengdeADT<T> {
	
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	@SuppressWarnings("unchecked")
	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}
	
	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	@SuppressWarnings("unchecked")
	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		T svar = null;
		int indeks = tilf.nextInt(antall);
		svar = tab[indeks];
		tab[indeks] = tab[antall - 1];
		tab[antall-1]= null;
		antall--;

		return svar;
	}

	@Override
	public T fjern(T element) {

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		T svar = null;
		for(int i = 0; (i < antall && !funnet);i++) {
			if(tab[i].equals(element)) {
				svar = tab[i];
				tab[i] = tab[antall-1];
				//tab[antall-1] = null;
				antall--;
				funnet = true;
				
			}
		}
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Objects.hash(antall);
		result = prime * result + Arrays.deepHashCode(tab);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
			boolean likeMengder = true;
			MengdeADT<T> m2 = (TabellMengde<T>) obj;
			
			if (this.antall != m2.antall()) {
				likeMengder = false;
			} else {
				Iterator<T> teller = m2.iterator();

				while (teller.hasNext() && likeMengder) {
					T element = teller.next();
					if (!this.inneholder(element)) {
						likeMengder = false;
					}
				}
			}
		return likeMengder;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new TabellMengde<T>();
		T element = null;
		
		Iterator<T> teller2 = this.iterator();
		while (teller2.hasNext()) {
			element = teller2.next();
			((TabellMengde<T>) begge).settInn(element);
		}
		
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext()) {
			element = teller.next();
			if (!this.inneholder(element)) {
				((TabellMengde<T>) begge).settInn(element);
			}
		}
		
		return begge;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<T>();
		T element = null;
		
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext()) {
			element = teller.next();
			if (this.inneholder(element)) {
				((TabellMengde<T>) snittM).settInn(element);
			}
		}
		
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<T>();
		T element;
		
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext()) {
			element = teller.next();
			if (!this.inneholder(element)) {
				((TabellMengde<T>) differensM).settInn(element);
			}
		}
		
		Iterator<T> teller2 = this.iterator();
		while (teller2.hasNext()) {
			element = teller2.next();
			if(!m2.inneholder(element)) {
			((TabellMengde<T>) differensM).settInn(element);
			}
		}

		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		
		for(T element : m2) {
			if(!this.inneholder(element)) {
				erUnderMengde = false;
			}
		}
		
		return erUnderMengde;
	}

	@Override
	public Iterator<T> iterator() {
		return new TabellIterator<T>(tab, antall);
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	public T[] getTab () {
		return tab;
	}

	public T getElement(int i) {
		return tab[i];
	}

	@Override
	public String toString(){

		String resultat = "<";

		for (int i = 0; i < antall; i++) {
			resultat += tab[i].toString();
			if (i < antall-1) {
				resultat += ", ";
			}
		}
		resultat += ">";
		return resultat;
	}

	

}
