package project_beuler;

public class primeGen {
	
	public primeGen() {}
	
	public int[] gen(int upper) {//sieve of atkin
		
		boolean[] is_prime = new boolean[upper];
		for (int i = 0; i < upper; i++) is_prime[i] = false;
		
		for (int i = 1; i * i < upper; i++) {
			for (int j = 1; j * j < upper; j++) {
				
				int n = 4 * i * i + j * j;
				if (n <= upper && (n % 12 == 1 || n % 12 == 5)) 
					is_prime[n] ^= true;
				
				n = 3 * i * i + j * j;
				if (n <= upper && n % 12 == 7)
					is_prime[n] ^= true;
				
				n = 3 * i * i - j * j;
				if (i > j && n <= upper && n % 12 == 11)
					is_prime[n] ^= true;
				
			}
		
		}
		
		for (int a = 5; a * a < upper; a++) {
			if (is_prime[a]) {
				for (int b = a * a; b < upper; b += a * a)
					is_prime[b] = false;
			}
		}
		
		int num_primes = 2;
		for (int i = 0; i < is_prime.length; i++) {
			if (is_prime[i]) num_primes++;
		}
		
		int[] primes = new int[num_primes];
		primes[0] = 2;
		primes[1] = 3;
		
		int ind = 2;
		for (int i = 5; i < upper; i++) {
			if (is_prime[i]) {
				primes[ind] = i;
				ind++;
			}
		}
		return primes;
	}

}