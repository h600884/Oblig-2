package no.hvl.dat102.oppg4;

public class FinnSum {
	//Oppgave 4.a

	public static int sum(int n) {
		int resultat = 0;
		if(n == 1) {
			resultat = 1;
		} else {
			resultat = n + sum(n - 1);
		}
		return resultat;
	}
	
	public static void main(String[] args) {
		System.out.println(sum(100));
	}
}
