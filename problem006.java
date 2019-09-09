package project_beuler;

public class problem006 {
	
//	The sum of the squares of the first ten natural numbers is,
//
//	1^2 + 2^2 + ... + 10^2 = 385
//	The square of the sum of the first ten natural numbers is,
//
//	(1 + 2 + ... + 10)^2 = 552 = 3025
//	Hence the difference between the sum of the squares of the first ten natural numbers
//	and the square of the sum is 3025 − 385 = 2640.
//
//	Find the difference between the sum of the squares of the first one hundred natural
//	numbers and the square of the sum.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 100;
		int a = 0;
		int b = 0;
		for(int i = 1; i <= n; i++) {
			a+= i*i;
			b+= i;
		}
		b*=b;
		System.out.println(Math.abs(a-b));
	}

}
