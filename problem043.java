package project_beuler;

public class problem043 {
	
//	The number, 1406357289, is a 0 to 9 pandigital number because it is
//	made up of each of the digits 0 to 9 in some order, but it also has
//	a rather interesting sub-string divisibility property.
//
//	Let d1 be the 1st digit, d2 be the 2nd digit, and so on.
//	In this way, we note the following:
//
//	d2d3d4=406 is divisible by 2
//	d3d4d5=063 is divisible by 3
//	d4d5d6=635 is divisible by 5
//	d5d6d7=357 is divisible by 7
//	d6d7d8=572 is divisible by 11
//	d7d8d9=728 is divisible by 13
//	d8d9d10=289 is divisible by 17
//	Find the sum of all 0 to 9 pandigital numbers with this property.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pandigital(""));
	}
	public static Long pandigital(String path) {
		if(path.length() == 10) {
			if(isDiv(path))
				return Long.parseLong(path);
			else return 0L;
		}
		long sum = 0;
		for(int i = 0; i <= 9; i++)
			if(path.indexOf(i+"") == -1)
				sum+= pandigital(path+i);
			
		return sum;
	}
	public static boolean isDiv(String path) {
		int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17};
		for(int d = 1; d < 8; d++) {
			if(Integer.parseInt(path.substring(d, d+3)) % primes[d-1] != 0)
				return false;
		}
		return true;
	}

}
