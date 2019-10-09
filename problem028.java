package project_beuler;

public class problem028 {

	public static void main(String[] args) {
			
			int n_max = 0;
			int max_prod = 0;
			int[] primes = Interface.primeGen(1000);
			for (int a = -999; a < 1000; a++) {
				for (int b : primes) {
					System.out.println(a + " " + b);
					int n;
					for (n = 0; Interface.isPrime(n * n + a * n + b); n++) ;
					if (n_max < n) {
						n_max = n;
						max_prod = a * b;
					}
				}
			}
			
			System.out.println(max_prod);

		}
}
