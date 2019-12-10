package project_beuler;

public class problem061 {
	
//	P0 = n(n+1)/2
//	P1 = n^2
//	P2 = n(3n−1)/2
//	P3 = n(2n−1)
//	P4 = n(5n−3)/2
//	P5 = n(3n−2)
	
//	1) The set is cyclic, in that the last two digits of each number is the
//	first two digits of the next number (including the last number with the first).
//	
//	2) Each polygonal type: triangle (P3,127=8128), square (P4,91=8281),
//	and pentagonal (P5,44=2882), is represented by a different number in the set.
//	
//	3) This is the only set of 4-digit numbers with this property.
//	
//	Find the sum of the only ordered set of six cyclic 4-digit
//	numbers for which each polygonal type: triangle, square, pentagonal,
//	hexagonal, heptagonal, and octagonal, is represented by a different number in the set.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = new int[] { 0, 0, 0, 0, 0, 0 };
		
		
		
	}
	public static double p0(int n) {
		return n*(n+1)/2;
	}
	public static double p1(int n) {
		return n*n;
	}
	public static double p2(int n) {
		return n*(3*n-1)/2;
	}
	public static double p3(int n) {
		return n*(2*n-1);
	}
	public static double p4(int n) {
		return n*(5*n-3)/2;
	}
	public static double p5(int n) {
		return n*(3*n-2);
	}

}
