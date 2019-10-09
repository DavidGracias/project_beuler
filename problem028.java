package project_beuler;

public class problem028 {
	
//	Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
//
//		21 22 23 24 25
//		20  7  8  9 10
//		19  6  1  2 11
//		18  5  4  3 12
//		17 16 15 14 13
//
//		It can be verified that the sum of the numbers on the diagonals is 101.
//
//		What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1001;
		int sum = 1;
		for(int i = 1; 2*i+1 <= a; i+=1) {
			int n = (int) Math.pow(2*i+1, 2);
			for(int z = 0; z < 4; z++)
				sum+= n-z*(2*i);
		}
		System.out.println(sum);
	}
	
}
