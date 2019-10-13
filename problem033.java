package project_beuler;

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
		String dup = duplicate(n, d);
		if( dup.length() == 0 ) return false;
		
		int newN = Integer.parseInt(remove(n, dup));
		int newD = Integer.parseInt(remove(d, dup));
		int[] frac = Interface.simplify(newN, newD);
		
		if( 
			Math.abs(
				Double.parseDouble(n)/Double.parseDouble(d) -
				(double) frac[0]/(double)frac[1]
			) < .0000001
		) {
			nSum*= frac[0]; dSum*= frac[1];
			System.out.print(n+"/"+d+"\t");
			System.out.println(Double.parseDouble(n)/Double.parseDouble(d));
			System.out.print(frac[0]+"/"+frac[1]+"\t");
			System.out.println(frac[0]/(double)frac[1]);
			System.out.println();
			return true;
		}
		return false;
	}
	
	public static String remove(String haystack, String needle) {
		return haystack.substring(0, haystack.indexOf(needle)) + haystack.substring(haystack.indexOf(needle)+1);
	}
	
	public static String duplicate(String a, String b) {
		for(int x = 0; x < a.length(); x++)
		for(int y = 0; y < b.length(); y++)
		if(a.charAt(x) == b.charAt(y))
			return ""+a.charAt(x);
		return "";
	}
}
