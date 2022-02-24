package no.hvl.dat102.oppgave2;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Datakontakt {


private TabellMengde<Medlem> medlemmer;

	    public Datakontakt(int antall) {
	        medlemmer = new TabellMengde<>(antall);
	    }


	    public void leggTilMedlem(Medlem person) {
	        medlemmer.leggTil(person);
	    }

	    public int finnMedlemsIndeks(String medlemsnavn) {
	        int i = 0;
	        for (Medlem m : medlemmer) {
	            if (m.getNavn().contains(medlemsnavn)) {
	                return i;
	            }
	            i++;
	        }
	        return -1;
	    }

	    public int finnPartnerFor(Medlem medlem) {

	        int medlemIndeks = -1;

	        for (Medlem m : medlemmer) {
	            if (m.passerTil(medlem)) {
	                int indeksM = (finnMedlemsIndeks(m.getNavn()));
	                medlemIndeks = (finnMedlemsIndeks(medlem.getNavn()));

	                m.setStatusIndeks(medlemIndeks);
	                medlem.setStatusIndeks(indeksM);
	            }
	        }
	        return medlemIndeks;
	    }

	    public void tilbakestillStatusIndeks(String medlemsnavn) {
	        int m1 = finnMedlemsIndeks(medlemsnavn);
	        if (m1 != -1) {
	            int m2 = medlemmer.getElement(m1).getStatusIndeks();
	            medlemmer.getElement(m1).setStatusIndeks(-1);
	            medlemmer.getElement(m2).setStatusIndeks(-1);
	        }
	    }

	    public TabellMengde<Medlem> getMedlemmer() {
	        return medlemmer;
	    }

	    @Override
	    public String toString() {
	        return medlemmer.toString();
	    }
	}
