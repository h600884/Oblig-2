package no.hvl.dat102.oppgave2;

import java.util.*;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {
	 private String navn;
	    private MengdeADT<Hobby> hobbyer;
	    private int statusIndeks; 

	    public Medlem (String navn, MengdeADT<Hobby> hobbyer) {
	        this.navn = navn;
	        this.hobbyer = hobbyer;
	        statusIndeks = -1;
	    }

	    public Medlem (String navn) {
	        this.navn = navn;
	        hobbyer = null;
	        statusIndeks = -1;
	    }

	    public String getNavn() {
	        return navn;
	    }

	    public void setNavn(String navn) {
	        this.navn = navn;
	    }

	    public void setStatusIndeks (int indeks) {
	        statusIndeks = indeks;
	    }

	    public int getStatusIndeks () {
	        return statusIndeks;
	    }

	    public void setHobbyer(MengdeADT<Hobby> hobbyer) {
	        this.hobbyer = hobbyer;
	    }

	    public MengdeADT<Hobby> getHobbyer() {
	        return hobbyer;
	    }

	    public boolean passerTil(Medlem medlem2) {
	    	
	    	if (hobbyer.antall() != medlem2.hobbyer.antall() ||
	    			(statusIndeks != -1 && medlem2.statusIndeks != -1)) {
	    		return false;
	    	}
	    	
	    	Iterator<Hobby> m1 = hobbyer.iterator(), m2 = medlem2.hobbyer.iterator();
	    	
	    	while (m1.hasNext()) {
	    		while (m2.hasNext()) {
	    			if (!m1.next().equals(m2.next()) ) {
	    				return false;
	    			}
	    		}
	    	}
	    	return true;
	    }
	    
	    @Override
	    public String toString () {
	        return "[Navn=" + navn + ", " + hobbyer + ", statusIndeks=" + statusIndeks + "]";
	    }
}
