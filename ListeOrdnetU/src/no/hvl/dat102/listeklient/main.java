package no.hvl.dat102.listeklient;

import java.util.Scanner;

import javax.swing.JOptionPane;

import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class main {
	
public static Person lesInnPerson() {
		
		String fornavn = JOptionPane.showInputDialog("Fornavn:");
		String etternavn = JOptionPane.showInputDialog("Etternavn:");
		int fodselsaar = 0;
		
		boolean works;
		do {
			works = true;
		
			try {
				fodselsaar = Integer.parseInt(JOptionPane.showInputDialog("Fodselsaar:"));
			}
			catch (NumberFormatException e) {
				works = false;
			}
		}
			while (!works);
				return new Person(fornavn, etternavn, fodselsaar);
	}
	
	public static void main(String[] args) {
		
		TabellOrdnetListe<Person> navneListe1 = new TabellOrdnetListe<Person>();
		KjedetOrdnetListe<Person> navneListe2 = new KjedetOrdnetListe<Person>();

		
		
		navneListe1.leggTil(lesInnPerson());
		navneListe1.leggTil(lesInnPerson());
		navneListe1.leggTil(lesInnPerson());
//		navneListe1.leggTil(lesInnPerson());
//		
//		navneListe2.leggTil(lesInnPerson());
//		navneListe2.leggTil(lesInnPerson());
//		navneListe2.leggTil(lesInnPerson());
//		navneListe2.leggTil(lesInnPerson());
		
		System.out.println(navneListe1.toString());
		System.out.println(navneListe2.toString());

	}
}

	
