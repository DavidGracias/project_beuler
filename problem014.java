package project_beuler;

public class problem014 {
	
//	The following iterative sequence is defined for the set of positive integers:
//
//		n → n/2 (n is even)
//		n → 3n + 1 (n is odd)
//
//		Using the rule above and starting with 13, we generate the following sequence:
//
//		13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
//		It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
//
//		Which starting number, under one million, produces the longest chain?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int highest = 0;
		int num = 1;
		int n = 1000000;
		for(int i = n-1; i > 1; i--) {
			int temp = sequence(i);
			if(temp > highest)
				num = i;
			highest = Math.max(highest, temp);
		}
		System.out.println(num);
	}
	
	public static int sequence(long n) {
		int i;
		for(i = 0; n != 1; i++) {
			if(n%2 == 0)
				n = n/2;
			else
				n = 3*n+1;
			System.out.println(n);
		}
		return i;
	}

}
