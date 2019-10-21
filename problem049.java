package project_beuler;

public class problem049 {
	
//	The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330,
//	is unusual in two ways:
//		(i) each of the three terms are prime, and,
//		(ii) each of the 4-digit numbers are permutations of one another.
//
//	There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
//	exhibiting this property, but there is one other 4-digit increasing sequence.
//
//	What 12-digit number do you form by concatenating the three terms in this sequence?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000;
		do {
			n = nextPrime(n);
			if(exibitsProperty(n))
				break;
		}while(n < 10000);
		System.out.println(n);
	}
	public static int nextPrime(int n) {
		do {
			n++;
		} while(Interface.isPrime(n));
		return n;
	}
	public static boolean exibitsProperty(int n) {
		
		return true;
	}
	public static void recursive() {
		
	}

}
