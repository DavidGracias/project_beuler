package project_beuler;

import java.util.ArrayList;

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
		String[] array = new String[]{1487+"", 4817+"", 8147+""};
		int n = 1000;
		do {
			n = Interface.nextPrime(n);
			if(!Interface.in(n+"", array))
				exibitsProperty(n);
		} while(n < 10000);
		
	}
	
	public static boolean exibitsProperty(int n) {
		ArrayList<String> sequences = new ArrayList<String>();
		Interface.permutations(sequences, n+"", "");
		for(int i = sequences.size()-1; i > 0; i--)
			if( !Interface.isPrime(Integer.parseInt(sequences.get(i))) ||
				Integer.parseInt(sequences.get(0)) == Integer.parseInt(sequences.get(i)) ||
				sequences.get(i).charAt(0) == '0'
			)
				sequences.remove(i);
		
		for(int i = 1; i < sequences.size(); i++)
			for(int z = 1; z < sequences.size(); z++) {
				if(i == z ) continue;
				if(
					Integer.parseInt(sequences.get(0)) - Integer.parseInt(sequences.get(z) ) ==
					Integer.parseInt(sequences.get(i)) - Integer.parseInt(sequences.get(0) )
				) {
					System.out.println(sequences.get(i)+" "+sequences.get(0)+" "+sequences.get(z));
					return true;
				}
			}
		return false;
	}
	
	public static boolean isPandigital(String n, int length) {
		if(n.charAt(0) == '0') return false;
		int[] counter = new int[length];
		for( String a: n.split("") ) {
			int i = Integer.parseInt(a);
			if( i > length || counter[i] == 1) return false;
			counter[i]++;
		}
		return true;
	}
}
