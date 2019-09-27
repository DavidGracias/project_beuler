package project_beuler;

public class problem003 {

//	The prime factors of 13195 are 5, 7, 13 and 29.
//
//	What is the largest prime factor of the number 600851475143 ?
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 600851475143L;
		
		for(double i = 2.0; i < n/2+1; i++) {
			if( (n/i)%1 == 0)
				if( isPrime( (long)(n/i) ) ) {
					System.out.println( (long)(n/i) );
					break;
				}
		}
		
		
		
		
	}
	public static boolean isPrime(long n) {
		if(n%2 == 0)
			return false;
		
		for(int i = 3; i < n/2 +1; i+=2)
			if(n % i == 0)
				return false;
		return true;
	}

}
