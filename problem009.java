package project_beuler;

public class problem009 {
	
//	A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//
//	a2 + b2 = c2
//	For example, 32 + 42 = 9 + 16 = 25 = 52.
//
//	There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//	Find the product abc.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//a max = 1/3
		//b max = 1/2
		//c max = 1
		int n = 1000;
		for(int a = 1; a < n/3+1; a++) {
			for(int b = a+1; b < (n-a)/2+1; b++) {
				int c = 1000-b-a;
				if(a*a + b*b == c*c) {
					System.out.println(a*b*c);
					break;
				}
				
			}
		}
	}

}
