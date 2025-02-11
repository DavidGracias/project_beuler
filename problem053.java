package project_beuler;

public class problem053 {
	
//	There are exactly ten ways of selecting three from five, 12345:
//	123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
//	
//	In combinatorics, we use the notation, (5 3) = 10
//	In general, (n r) = n!/ r!(n-r)! where r <= n
//	It is not until n=23, that a value exceeds one-million: (23 10) = 1144066
//	
//	How many, not necessarily distinct, values of (n r) where 1 <= n <= 100 are greater than one-million?
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 1000000;
		int hits = 0;
		for(int n = 1; n <= 100; n++) {
			for(int r = 2; r < n; r++) {
				double comb = 1;
				for(int i = 0; i < r; i++)
					comb = comb * (n-i)/(i+1.0);
				if(comb > target) {
					hits+= n-2*r+1;
					break;
				}
			}
		}
		System.out.println(hits);
	}
}
