package project_beuler;

public class problem058 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int primes = 0;
		int total = 0;
		int i = 0;
		do{
			i++;
			int n = (int) Math.pow(2*i+1, 2);
			for(int z = 0; z < 4; z++) {
				if( Interface.isPrime(n-z*(2*i)) )
					primes++;
				total++;
			}
		}while(primes/(double)total > .1);
		System.out.println(2*i+1);
	}

}
