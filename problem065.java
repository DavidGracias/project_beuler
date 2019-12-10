package project_beuler;

import java.math.BigInteger;

public class problem065 {
	
//	The square root of 2 can be written as an infinite continued fraction.
//
//	The infinite continued fraction can be written, [1;(2)]. (2) indicates that 2 repeats ad infinitum.
//	In a similar way, root(23) = [4;(1,3,1,8)]
//
//	It turns out that the sequence of partial values of continued fractions
//	for square roots provide the best rational approximations.
//	
//	What is most surprising is that the important mathematical constant,
//	e=[2;1,2,1,1,4,1,1,6,1,...,1,2k,1,...]
//
//	The first ten terms in the sequence of convergents for e are:
//
//	Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e
//	e
	
	
	public static int convergents = -2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		convergents+= 100;
		BigInteger[] starting = new BigInteger[]{BigInteger.valueOf(2), BigInteger.valueOf(1)};
		BigInteger[] frac = addFrac( starting, inverse(root(convergents)) );
		
		System.out.println(frac[0] +" / "+ frac[1]);
		int sum = 0;
		String numerator =  (frac[0]+"");
		for(int i = 0; i < numerator.length(); i++)
			sum += Integer.parseInt( numerator.charAt(i)+"" );
		System.out.println( sum );
	}
	
	public static BigInteger[] root(int n) {
		BigInteger[] next = new BigInteger[]{BigInteger.valueOf( getDen(convergents-n) ), BigInteger.valueOf(1)};
		if( n == 0 )
			return next;
		return addFrac( next, inverse(root(n-1)) );
	}
	
	public static BigInteger[] addFrac(BigInteger[] first, BigInteger[] second) {
		return new BigInteger[] {first[0].multiply(second[1]).add(first[1].multiply(second[0])), first[1].multiply(second[1])};
	}
	
	public static BigInteger[] inverse(BigInteger[] frac) {
		return new BigInteger[] { frac[1], frac[0] };
	}

	public static int getDen(int n) {
		if( n % 3 == 1)
			return 2*(n+2)/3;
		return 1;
	}
}
