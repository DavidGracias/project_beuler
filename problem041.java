package project_beuler;

public class problem041 {
	
//	We shall say that an n-digit number is pandigital if it
//	makes use of all the digits 1 to n exactly once.
//	For example, 2143 is a 4-digit pandigital and is also prime.

//	What is the largest n-digit pandigital prime that exists?
	
	public static int pandigital = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int n = 9; n > 0; n--)
			pandigital("", n);
		System.out.println(pandigital);
	}
	public static void pandigital(String path, int n) {
		if(pandigital > 0)
			return;
		if(path.length() == n) {
			if(Interface.isPrime(Integer.parseInt(path)))
				pandigital = Integer.parseInt(path);
			return;
		}
		for(int dig = n; dig > 0; dig--)
			if(path.indexOf(dig+"") == -1)
				pandigital(path+dig, n);
	}

}
