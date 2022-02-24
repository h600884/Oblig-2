package no.hvl.dat102.oppg4;

public class FiboIkkeRekursiv {
	
	public static int fibonacci(int n) {
		int sum1 = 1;
		int sum2 = 1;
		
		if(n < 2) {
			return n;
		} else 
		for(int i = 1; i < n; i++) {
			sum2 = sum1 + sum2;
			sum1 = sum2 - sum1;
		}
		return sum1;
	}

	
	public static void main(String[] args){
	System.out.println(fibonacci(2));
	System.out.println(fibonacci(3));
	System.out.println(fibonacci(4));
	System.out.println(fibonacci(5));
	System.out.println(fibonacci(10));
	}

}
