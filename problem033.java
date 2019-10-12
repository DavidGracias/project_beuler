package project_beuler;

import java.util.ArrayList;

public class problem033 {
	
//	The fraction 49/98 is a curious fraction, as an inexperienced mathematician
//	in attempting to simplify it may incorrectly believe that 49/98 = 4/8,
//	which is correct, is obtained by cancelling the 9s.
//
//	We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
//
//	There are exactly four non-trivial examples of this type of fraction,
//	less than one in value, and containing two digits in the numerator and denominator.
//
//	If the product of these four fractions is given in its lowest common terms,
//	find the value of the denominator.

	public static int nSum = 1;
	public static int dSum = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int num = 10; num < 100; num++)
			for(int den = num+1; den < 100; den++)
				if( num %10 != 0 && den % 10 != 0 )
					isCurious(num+"", den+"");
		
		int[] frac = Interface.simplify(nSum, dSum);
		System.out.println(nSum+"/"+dSum);
		System.out.println(frac[0]+"/"+frac[1]);
	}
	public static boolean isCurious(String n, String d) {
		if( !Interface.hasDuplicates(n, d) ) return false;
		
		Integer[] one = Interface.divisors(Integer.parseInt(n));
		Integer[] two = Interface.divisors(Integer.parseInt(d));
		//find duplicates
		int min = Math.min(n.length(), d.length());
		for(int z = 0; z < min; z++)
		if( d.indexOf( n.charAt(z) ) != -1) //for each duplicate found
			for(Integer cOne : one)
			for(Integer cTwo : two) {
				String dup = n.charAt(z)+"";
				if(cOne == Integer.parseInt(dup) && cTwo == Integer.parseInt(dup) ) {
					//not n or d, its n-dup && d-dup
					int newN = Integer.parseInt(String.join("", n.split(dup)));
					int newD = Integer.parseInt(String.join("", d.split(dup)));
					int[] frac = Interface.simplify(newN, newD);

					if( //Integer.parseInt(n) != frac[0] && Integer.parseInt(d) != frac[1] &&
						Math.abs(
							Double.parseDouble(n)/Double.parseDouble(d) -
							(double) frac[0]/(double)frac[1]
						) < .0000001
					) {
						
						System.out.print(n+"/"+d+"\t");
						System.out.println(Double.parseDouble(n)/Double.parseDouble(d));
						System.out.print(frac[0]+"/"+frac[1]+"\t");
						System.out.println(frac[0]/(double)frac[1]);
						System.out.println();
						return true;
					}
				}
			}
		return false;
	}
	
	//rounding errors...?

}
