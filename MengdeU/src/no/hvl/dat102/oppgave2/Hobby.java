package no.hvl.dat102.oppgave2;

import java.util.*;

public class Hobby {
private String hobbyNavn;  
	
	public Hobby(String hobby) { 
		hobbyNavn = hobby; 
	} 
	
	@Override
	public String toString() {
		return "Hobbyer = <" + hobbyNavn + ">";
	}
	
	public String getHobbyNavn() {
		return hobbyNavn;
	}
	
	public void setHobbyNavn(String hobby) {
		this.hobbyNavn = hobby;
	}

	@Override
	public boolean equals(Object hobby2) {
		if (this == hobby2)
			return true;
		
		if (hobby2 == null)
			return false;
		
		if (getClass() != hobby2.getClass())
			return false;
		
		Hobby hobbyDenAndre = (Hobby)hobby2; 
		return(hobbyNavn.equals(hobbyDenAndre.getHobbyNavn())); 
	}
}
