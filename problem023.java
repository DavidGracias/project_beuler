package project_beuler;

import java.util.ArrayList;

public class problem023 {
	
//	A perfect number is a number for which the sum of its
//	proper divisors is exactly equal to the number. For example,
//	the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28,
//	which means that 28 is a perfect number.
//
//	A number n is called deficient if the sum of its proper
//	divisors is less than n and it is called abundant if this
//	sum exceeds n.
//
//	As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16,
//	the smallest number that can be written as the sum of two abundant
//	numbers is 24. By mathematical analysis, it can be shown that all
//	integers greater than 28123 can be written as the sum of two abundant
//	numbers. However, this upper limit cannot be reduced any further by
//	analysis even though it is known that the greatest number that cannot
//	be expressed as the sum of two abundant numbers is less than this limit.
//
//	Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 28123;
		long sum = 1;
		ArrayList<Integer> abundant = new ArrayList<Integer>();
		for(int i = 2; i <= n; i++) {
			//GET ABUNDANT NUMBERS
			Integer[] d = Interface.divisors(i);
			int curSum = 0;
			for(int x = 0; x < d.length; x++)
				curSum+= d[x];
			if(curSum > i)
				abundant.add(i);
			
			//CHECK TO SEE IF CUR NUMBER IS SUM OF 2 ABUNDANT
			if(!sumoftwo(abundant, i))
				sum+=i;
			
		}
		System.out.println(sum);
	}
	public static boolean sumoftwo(ArrayList<Integer> abundant, int n) {
		for(int y = abundant.size()-1; y >= 0; y--)
			for(int z = 0; z < abundant.size(); z++)
				if(n - abundant.get(y) == abundant.get(z))
					return true;
				else if(n - abundant.get(y) < abundant.get(z)) break;
		return false;
	}

}
