package no.hvl.dat102.oppgave2;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Main {

	public static void main(String[] args) {
		
			Datakontakt ny = new Datakontakt(4);
	        Medlem Eivind = new Medlem("Eivind");
	        Medlem Marte = new Medlem("Marte");
	        Medlem Kim = new Medlem("Kim");
	        Medlem Tuva = new Medlem("Tuva");
	        Hobby Fotball = new Hobby("Fotball");
	        Hobby Tennis = new Hobby("Tennis");
	        MengdeADT<Hobby> hobbyer = new TabellMengde<>();
	        MengdeADT<Hobby> hobbyer1 = new TabellMengde<>();
	        
	        hobbyer.leggTil(Tennis);
	        hobbyer1.leggTil(Fotball);
	        
	        ny.leggTilMedlem(Eivind);
	        ny.leggTilMedlem(Marte);
	        ny.leggTilMedlem(Kim);
	        ny.leggTilMedlem(Tuva);
	        
	        Eivind.setHobbyer(hobbyer);
	        Marte.setHobbyer(hobbyer);
	        Kim.setHobbyer(hobbyer1);
	        Tuva.setHobbyer(hobbyer1);


	        System.out.println(ny.finnPartnerFor(Eivind));
	        System.out.println();
	        System.out.println(ny.finnPartnerFor(Kim));
	        
	        System.out.println(ny);
	        
	        Tekstgrensesnitt.skrivParListe(ny);
	        //ny.tilbakestillStatusIndeks("Eivind");
	        System.out.println(ny);
	        
	}

}
