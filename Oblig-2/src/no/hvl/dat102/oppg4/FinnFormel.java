package no.hvl.dat102.oppg4;

public class FinnFormel {
	//Oppgave 4.b
	
	public static int formel(int n) {
		int funnet = 0;
		
		if(n == 0) {
			funnet = 2;
		} else if(n == 1){
			funnet = 5;
		} else if (n > 1){
			funnet = 5*formel(n - 1) - 6*formel(n - 2) + 2;			
		}
		return funnet;
	}

	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++) {
		System.out.println(formel(i));
		}
	}
}
