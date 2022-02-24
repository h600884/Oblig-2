package no.hvl.dat102.adt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.exceptions.EmptyCollectionException;

public abstract class OrdnetListeADTTest {

	

	private OrdnetListeADT<Integer> liste;

	
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;

	

	protected abstract OrdnetListeADT<Integer> reset();

	@BeforeEach
	public final void setup() {
		liste = reset();
	}

	
	@Test
	public final void nyListeErTom() {
		assertTrue(liste.erTom());
	}

	
	public final void leggTilOgFjern() {
		liste.leggTil(e0);
		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e3);
		liste.leggTil(e4);
		liste.leggTil(e5);
		assertEquals(e5, liste.fjern(e5));
		assertEquals(e4, liste.fjern(e4));
		assertEquals(e3, liste.fjern(e3));
		assertEquals(e2, liste.fjern(e2));
		assertEquals(e1, liste.fjern(e1));
		assertEquals(e0, liste.fjern(e0));
	}

	
	@Test
	public final void viseOrdnetIkkeAvtagende() {
		
		liste.leggTil(e0);
		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e3);
		liste.leggTil(e4);
		liste.leggTil(e5);
			assertEquals(e5, liste.fjernFoerste());
			assertEquals(e4, liste.fjernFoerste());
			assertEquals(e3, liste.fjernFoerste());
			assertEquals(e2, liste.fjernFoerste());
			assertEquals(e1, liste.fjernFoerste());
			assertEquals(e0, liste.fjernFoerste());
	}

	@Test
	public final void viseOrdnetIkkeStigende() { 
		liste.leggTil(e0);
		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e3);
		liste.leggTil(e4);
		liste.leggTil(e5);
		assertEquals(e0, liste.fjernSiste());
		assertEquals(e1, liste.fjernSiste());
		assertEquals(e2, liste.fjernSiste());
		assertEquals(e3, liste.fjernSiste());
		assertEquals(e4, liste.fjernSiste());
		assertEquals(e5, liste.fjernSiste());
	}


	 
	@Test
	public final void leggTilOgfjernMedDuplikater() {
	
		  liste.leggTil(e0);
		  liste.leggTil(e0);
		  liste.leggTil(e1);
		  liste.leggTil(e2);
		  liste.leggTil(e2);
		  liste.leggTil(e2);
		  liste.leggTil(e3);
		  liste.leggTil(e4);
		  liste.leggTil(e5);

		assertEquals(e0, liste.fjern(e0));
		assertEquals(e1, liste.fjern(e1));
		assertEquals(e4, liste.fjern(e4));
		assertEquals(e5, liste.fjern(e5));
		assertEquals(e2, liste.fjern(e2));
		assertEquals(e3, liste.fjern(e3));

	}

	
	@Test
	public final void leggTilOgInnholder() {
		liste.leggTil(e2);
		liste.leggTil(e1);
		liste.leggTil(e4);
		liste.leggTil(e0);
		liste.leggTil(e3);

		assertTrue(liste.inneholder(e2));
		assertTrue(liste.inneholder(e1));
		assertTrue(liste.inneholder(e4));
		assertTrue(liste.inneholder(e0));
		assertTrue(liste.inneholder(e3));
		assertFalse(liste.inneholder(e5));

	}

	/**
	 * Tester om listen med verdier ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		liste.leggTil(e0);
		liste.leggTil(e1);
		liste.leggTil(e3);
		liste.leggTil(e2);
		liste.leggTil(e4);
		liste.leggTil(e5);
		assertFalse(liste.erTom());
	}

	
	@Test
	public final void leggTilFjernErTom() {
		
		liste.leggTil(e0);
		liste.leggTil(e4);
		liste.leggTil(e2);
		liste.leggTil(e3);
		liste.leggTil(e5);
		liste.leggTil(e1);
		assertEquals(e0, liste.fjernSiste());
		assertEquals(e1, liste.fjernSiste());
		assertEquals(e2, liste.fjernSiste());
		assertEquals(e3, liste.fjernSiste());
		assertEquals(e4, liste.fjernSiste());
		assertEquals(e5, liste.fjernSiste());
		
		assertTrue(liste.erTom());
	}

	
	@Test
	
	public void fjernFraTomListe() {	
		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			liste.fjernFoerste();
		});
	}

	

}
