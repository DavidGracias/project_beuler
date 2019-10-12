package project_beuler;

public class problem035 {

//	The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
//	
//	There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
//	
//	How many circular primes are there below one million?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000000;
		int counter = 0;
		for(int i = 0; i < n; i++)
			if(isCircular(i)) counter++;
		System.out.println();
		System.out.println(counter);
	}
	public static int rotate(int n) {
		if(n < 10)
			return n;
		return Integer.parseInt(n%10+""+n/10);
	}
	
	public static boolean isCircular(int n) {
		for(int i = 0; i < (n+"").length(); i++)
			if(!Interface.isPrime(n)) return false;
			else n = rotate(n);
		System.out.println(n);
		return true;
	}
}
