package project_beuler;

public class problem027 {
	
//	Considering quadratics of the form:
//		n^2+an+b
//		where |a| < 1000 and |b| ≤ 1000
	
//	Find the product of the coefficients, a and b
//	for the quadratic expression that produces the maximum number of primes
//	for consecutive values of n starting with n=0
	
//	where |n| is the modulus/absolute value of
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] max = new int[3]; //maxC, maxA, maxB
		int[] b = Interface.primeGen(1000);
		for(int a = -999; a < 1000; a++) {
			for(int bi: b) {
				int n = 0;
				while(Interface.isPrime(n*n + a*n + bi)) n++;
				if(n > max[0]) {
					max[0] = n;
					max[1] = a;
					max[2] = bi;
				}
			}
		}
		System.out.println(max[1]*max[2]);
		
	}
}
