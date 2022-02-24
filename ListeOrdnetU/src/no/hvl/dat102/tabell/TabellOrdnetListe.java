package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int ant;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		ant = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste();
		ant--;
		liste[ant] = null;
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = foerste();
		
		for(int i = 0; i < ant; i++) {
			liste[i] = liste[i+1];
		}
		liste[ant] = null;
		ant--;
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
	
		return liste[ant - 1];
	}

	@Override
	public boolean erTom() {
		return (ant == 0);
	}

	@Override
	public int antall() {
		return ant;
	}

	@Override
	public void leggTil(T element) {
		if(ant == liste.length) {
			utvid();
		}
		if(erTom()) {
			liste[0] = element;
		} else {
			boolean funnet = false;
			for(int i = 0; i < ant && !funnet; i++) {
				if(element.compareTo(liste[i]) >= 0) {
					for(int j = ant-1; j >= i; j--) {
						liste[j + 1] = liste[j];
					}
					liste[i] = element;
					funnet = true;
				}
			}
			if(!funnet) {
				liste[ant] = element;
			}
		}
		ant++;
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		int i = finn(element);

		if (i != -1) {
			for (int j = i; j < ant - 1; j++) {
				liste[j] = liste[j + 1];
			}
			ant--;
			liste[ant] = null;
			return element;
		}
		return null;

	}

	private int finn(T el) {
		if (erTom()) {
			throw new EmptyCollectionException("Ordnet liste");
		}
		for (int i = 0; i < ant; i++) {
			if (liste[i].equals(el)) {
				return i;
			}
		}
		return IKKE_FUNNET;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < ant; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class






	
	

