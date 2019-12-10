package project_beuler;

import java.util.ArrayList;

public class problem060 {

//	The primes 3, 7, 109, and 673, are quite remarkable.
//	By taking any two primes and concatenating them in
//	any order the result will always be prime. For example,
//	taking 7 and 109, both 7109 and 1097 are prime. The sum
//	of these four primes, 792, represents the lowest sum for
//	a set of four primes with this property.
//
//	Find the lowest sum for a set of five primes for which
//	any two primes concatenate to produce another prime.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		
		
		while( true ) {
			int n = primes.get( primes.size()-1 );
			int digits = (n+"").length();
			for(n = n; n < Math.pow(10, digits); n = Interface.nextPrime(n) )
				primes.add(n);

			ArrayList<Integer> concat = new ArrayList<Integer>();
			
			
			//check here
		}
			
	}
	public static int concat(int a, int b) {
		return Integer.parseInt(a+""+b);
	}
	

}
