package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;


public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	 
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();
		
		if(siste.equals(foerste)) {
			fjernSiste();
			return resultat;
		}
		
		LinearNode<T> node = foerste;
		
		for(int i = 0; i < antall - 2; i++) {
			node = node.getNeste();
		}
		
		siste = node;
		node.setNeste(null);
		antall--;
		
		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = foerste.getElement();
		foerste = foerste.getNeste();
		antall--;
		
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T svar = foerste.getElement();

		return svar;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T el) {
		
		LinearNode<T> ny = new LinearNode<>(el);
		
		if(erTom()) {
			foerste = ny;
			siste = ny;
		} else {
			if(foerste.getElement().compareTo(el) >= 0) {
				ny.setNeste(foerste);
				foerste = ny;
			} else {
				LinearNode<T> forrige = foerste;
				LinearNode<T> node = foerste.getNeste();
				
				while(node != null && node.getElement().compareTo(el) < 0) {
					forrige = node;
					node = node.getNeste();
				}
				forrige.setNeste(ny);
				if (node != null) {
					ny.setNeste(node);
				} else {
					siste = ny;
				}
			}
		}
		antall++;
		
	}

	@Override
	public T fjern(T element) {
		
		
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { 
			antall--;
			svar = denne.getElement();
			if (forrige == null) { 
				foerste = foerste.getNeste();
				if (foerste == null) { 
					siste = null;
				}
			} else { 
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { 
					siste = forrige;
				}
			}
		} 
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		
		
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		  if (denne != null) {
			  if (element.equals(denne.getElement())) {
				resultat = true;
			  }
		  } 
		return resultat;
	}
	
	public String toString() {
		String resultat = "";

		
		LinearNode current = foerste;
		while (current != null) {
			resultat += current.getElement();
			if (current.getNeste() != null) {
				resultat += "\n";
			}
			current = current.getNeste();
		}
		
		return resultat;
	}
}
