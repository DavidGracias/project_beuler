package project_beuler;

public class problem050 {
	
//	The prime 41, can be written as the sum of six consecutive primes:
//
//	41 = 2 + 3 + 5 + 7 + 11 + 13
//	This is the longest sum of consecutive primes that adds to a prime below one-hundred.
//
//	The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
//
//	Which prime, below one-million, can be written as the sum of the most consecutive primes?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int upper = 1000000;
		int max_length = 1;
		int max_prime = 2;

		int starting_prime = 1;
		while(starting_prime < upper) {
			starting_prime = Interface.nextPrime(starting_prime);
			int sum = 0;
			int length = 0;
			int cur_prime = starting_prime;
			while (sum + cur_prime < upper) {
				sum+=cur_prime;
				length++;
				
				if(length > max_length && Interface.isPrime(sum)) {
					max_length = length;
					max_prime = sum;
				}
				cur_prime = Interface.nextPrime(cur_prime);
			}
		}
		System.out.println(max_prime);
		
		
		
	}
	
}
