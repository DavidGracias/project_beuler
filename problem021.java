package project_beuler;

import java.util.ArrayList;

public class problem021 {
	
//	Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
//	If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
//
//	For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
//
//	Evaluate the sum of all the amicable numbers under 10000.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sum = 0;
		int n = 10000;
		for(int x = 0; x < n; x++)
			for(int y = x+1; y < n; y++)
				if(sumDivisors(x) == y && x == sumDivisors(y))
					sum += x+y;
		System.out.println(sum);
		
	}
	public static ArrayList<Integer> divisors(int n){
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> amicableD = new ArrayList<Integer>();
		d.add(1); d.add(n);
		amicableD.add(1);
		for(int i = 2; i <= Math.sqrt(n); i++)
			if(n%i == 0) {
				d.add(i); d.add(n/i);
				if(i != n/i) {
					amicableD.add(i); amicableD.add(n/i);
				}
			}
		
		return amicableD;
	}
	public static int sumDivisors(int n) {
		ArrayList<Integer> d = divisors(n);
		int sum = 0;
		for(int i = 0; i < d.size(); i++)
			sum+= d.get(i);
		return sum;
	}

}
