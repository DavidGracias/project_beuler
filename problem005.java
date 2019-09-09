package project_beuler;

import java.util.ArrayList;

public class problem005 {
	
//	2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//
//	What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
//		2^2, 2*3, 2^3, 3^2, 5*2, 3*2^2, 7*2, 5*3, 2^4, 9*2, 5*2^2
		//could do this better but i dont want to rn
		int start = 1;
		int end = 20;
		int answer = 1;
		for(int n = start; n <= end; n++) {
//			System.out.println(n);
			if( isPrime(n) ) {
				System.out.println(n);
				answer *= n;
			}
			
		}
		
		System.out.println(answer*2*2*2*3);
	
	}
	public static boolean isPrime(int n) {
		for(int i = 2; i < n; i++)
			if(n % i == 0)
				return false;
		return true;
	}

}
