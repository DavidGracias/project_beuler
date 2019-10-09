package project_beuler;

public class problem030 {
	
//	Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
//
//	1634 = 14 + 64 + 34 + 44
//	8208 = 84 + 24 + 04 + 84
//	9474 = 94 + 44 + 74 + 44
//	As 1 = 14 is not a sum it is not included.
//
//	The sum of these numbers is 1634 + 8208 + 9474 = 19316.
//
//	Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.MAX_VALUE; //arbitrarily large
		int total = 0;
		for(int i = 2; i < n; i++) {
			String[] digits = (i+"").split("");
			int sum = 0;
			for(int z = 0; z < digits.length; z++)
				sum+= Math.pow(Integer.parseInt(digits[z]), 5);
			if(sum == i) {
				total+=i;
				System.out.println(total);
			}
			
		}
		System.out.println(total);
	}

}
