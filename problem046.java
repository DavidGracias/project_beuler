package project_beuler;

public class problem046 {
	
//	It was proposed by Christian Goldbach that every odd
//	composite number can be written as the sum of a prime and twice a square.
//
//	9 = 7 + 2×1^2
//	15 = 7 + 2×2^2
//	21 = 3 + 2×3^2
//	25 = 7 + 2×3^2
//	27 = 19 + 2×2^2
//	33 = 31 + 2×1^2
//
//	It turns out that the conjecture was false.
//
//	What is the smallest odd composite that cannot be written
//	as the sum of a prime and twice a square?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String output = "";
		for(int n = 9; output.length() == 0; n+=2) {
			if(Interface.isPrime(n)) continue;
			int prime = 2; double squared = 1;
			while(prime + 2*1 <= n){
				squared = Math.sqrt((n - prime)/2.0);
				if( isInteger( squared ) )
					break;
				prime = nextPrime(prime);
			}
			if( !isInteger(squared) )
				output = n+"";
		}
		System.out.println(output);
	}
	public static int nextPrime(int n) {
		do {
			n++;
		}while(!Interface.isPrime(n));
		return n;
	}
	public static boolean isInteger(double n) {
		return n == (int) n;
	}

}
