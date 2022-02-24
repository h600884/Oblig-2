package no.hvl.dat102.mengde.adt;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public abstract class ADTTest {

	private MengdeADT<String> Mengde1;
	private MengdeADT<String> Mengde2;

	// Testdata
	private String e0 = "BMW";
	private String e1 = "Mercedes";
	private String e2 = "Volvo";
	private String e3 = "Porsche";

	public void fellesElement() {
		Mengde1.leggTil(e0);
		Mengde1.leggTil(e1);
		Mengde2.leggTil(e1);
		Mengde2.leggTil(e2);
	}
	
	public void ulikeElement() {
		Mengde1.leggTil(e0);
		Mengde1.leggTil(e1);
		Mengde2.leggTil(e2);
		Mengde2.leggTil(e3);
	}
	
	
	protected abstract MengdeADT<String> reset();
	
	@BeforeEach
	public void setup() {
		Mengde1 = reset();
		Mengde2 = reset();
	}
	
	@Test
	public void unionDuplikat() {
		fellesElement();
		MengdeADT<String> union = Mengde1.union(Mengde2);
		
		assertEquals(e0, union.fjern(e0));
		assertEquals(e1, union.fjern(e1));
		assertEquals(e2, union.fjern(e2));
		
		assertTrue(union.erTom());
	}
	
	@Test
	public void unionUlike() {
		ulikeElement();
		MengdeADT<String> union = Mengde1.union(Mengde2);
		
		assertEquals(e0, union.fjern(e0));
		assertEquals(e1, union.fjern(e1));
		assertEquals(e2, union.fjern(e2));
		assertEquals(e3, union.fjern(e3));
		
		assertTrue(union.erTom());
	}
	
	@Test
	public void snittDuplikat() {
		fellesElement();
		MengdeADT<String> snitt = Mengde1.snitt(Mengde2);
		
		assertEquals(e1, snitt.fjern(e1));
		
		assertTrue(snitt.erTom());
	}
	
	@Test
	public void snittUlike() {
		ulikeElement();
		MengdeADT<String> snitt = Mengde1.snitt(Mengde2);
		
		assertTrue(snitt.erTom());
	}
	
	@Test
	public void differensDuplikat() {
		fellesElement();
		MengdeADT<String> differens = Mengde1.differens(Mengde2);
		
		assertEquals(e0, differens.fjern(e0));
		assertEquals(e2, differens.fjern(e2));
		
		assertTrue(differens.erTom());
	}
	
	@Test
	public void differensUlike() {
		ulikeElement();
		MengdeADT<String> differens = Mengde1.differens(Mengde2);
		
		assertEquals(e0, differens.fjern(e0));
		assertEquals(e1, differens.fjern(e1));
		assertEquals(e2, differens.fjern(e2));
		assertEquals(e3, differens.fjern(e3));
		
		assertTrue(differens.erTom());
	}

}
