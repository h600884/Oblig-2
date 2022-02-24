package no.hvl.dat102.oppg4;

public class FiboRekursiv {

	public static int Fibonacci(int n) {
		
		if(n < 2) {
			return n;
		} else {
			return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Fibonacci(2));
		System.out.println(Fibonacci(3));
		System.out.println(Fibonacci(4));
		System.out.println(Fibonacci(5));
		
	}
}
