package project_beuler;

public class problem037 {
	
//	The number 3797 has an interesting property.
//	Being prime itself, it is possible to continuously
//	remove digits from left to right, and remain prime at each stage:
//		3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
//
//	Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
//
//	NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counter = 11;
		int sum = 0;
		for(int i = 8; counter > 0; i++) {
			if(isInteresting(i)) {
				System.out.println(i);
				sum+=i;
				counter--;
			}
		}
		System.out.println();
		System.out.println(sum);
	}
	public static boolean isInteresting(int i) {
		String l = "0"+i;
		String r = i+"0";
		while(l.length() > 1 || r.length() > 1) {
			l = l.substring(1);
			r = r.substring(0, r.length()-1);
			if( !Interface.isPrime(Integer.parseInt(l)) || !Interface.isPrime(Integer.parseInt(r)))
				return false;
		}
		return true;
		
	}

}
