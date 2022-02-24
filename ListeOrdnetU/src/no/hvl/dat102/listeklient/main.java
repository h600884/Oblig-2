package no.hvl.dat102.listeklient;

import java.util.Scanner;

import no.hvl.dat102.tabell.TabellOrdnetListe;

public class main {
	
	public static void main (String [] args) {
		TabellOrdnetListe<String> navneListe1 = new TabellOrdnetListe<String>();
		   TabellOrdnetListe<String> navneListe2 = new TabellOrdnetListe<String>();

		    Scanner tast = new Scanner(System.in);
		    String navn, svar;

		    do{
		          System.out.println("Oppgi navn: ");
		          navn   = tast.nextLine();
		          
		          navneListe1.leggTil(navn);
		          navneListe2.leggTil(navn);

		          System.out.print("Oppgi flere navn [J/N]?:");
		          svar = tast.nextLine();
		       tast.close();

		      } while(svar.equals("j")|| svar.equals("J"));


		       System.out.println("\n\nNavnelisten i stigende ordning:");

		        while(navneListe1.antall() > 0)
		              System.out.print(navneListe1.fjernFoerste() + " ");


		      
		       System.out.println("\n\nNavnelisten i fallende ordning:");

		        while(navneListe2.antall() > 0)
		           System.out.print(navneListe2.fjernSiste() + " ");
	}
}
