package no.hvl.dat102.mengde.kjedet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.adt.ADTTest;
import no.hvl.dat102.mengde.adt.MengdeADT;

class KjedetMengdeTest extends ADTTest{

	@Override
	protected MengdeADT<String> reset() {
		return new KjedetMengde<String>();
	}

}
