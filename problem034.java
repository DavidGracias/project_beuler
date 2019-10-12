package project_beuler;

public class problem034 {
	
//	145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
//
//	Find the sum of all numbers which are equal to the sum of the factorial of their digits.
//
//	Note: as 1! = 1 and 2! = 2 are not sums they are not included.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int n = Integer.MAX_VALUE;
		for(int i = 10; i < n; i++) {
			if(isCurious(i)) {
				sum+=i;
				System.out.println(sum+" "+i);
			}
		}
	}
	public static boolean isCurious(int n) {
		String[] digits = (n+"").split("");
		int acc = 0;
		for(String digit: digits)
			acc+= fact(Integer.parseInt(digit));
		return acc == n;
	}
	public static int fact(int n) {
		int accumulator = 1;
		for(int i = 2; i <= n; i++)
			accumulator*= i;
		return accumulator;
	}

}
