package project_beuler;

import java.util.ArrayList;

public class problem010 {

//	The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//
//	Find the sum of all the primes below two million.
	
	
	public static ArrayList<Integer> primes = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		int n = 2000000;
		
		primes.add(2);
		sum += 2;
		
		for(int i = 3; i < n; i+=2) {
			if( isPrime(i) ) {
				System.out.println(i);
				primes.add(i);
				sum += i;
			}
		}
		System.out.println("\n"+sum);
	}
	public static boolean isPrime(int n) {
		for(int i = 0; i < primes.size(); i++) {
			if(n % primes.get(i) == 0)
				return false;
		}
		return true;
	}

}
