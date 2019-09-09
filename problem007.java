package project_beuler;

public class problem007 {
	
//	By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//
//	What is the 10,001st prime number?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int end = 10001;
		long prime = 2;
		for(int x = 1; x <= end; x++) {
			for(long y = prime+1; true; y++) {
				
				if(isPrime(y)) {
					prime = y;
					break;
				}
				
			}
			
		}
		System.out.println(prime);
		
	}
	public static boolean isPrime(long n) {
		for(int i = 2; i < n/2; i++)
			if(n % i == 0)
				return false;
		return true;
	}

}