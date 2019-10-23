package project_beuler;

public class problem051 {
	
//	By replacing the 1st digit of the 2-digit number *3,
//	it turns out that six of the nine possible values:
//		13, 23, 43, 53, 73, and 83, are all prime.
//
//	By replacing the 3rd and 4th digits of 56**3 with the same digit,
//	this 5-digit number is the first example having seven primes among 
//	the ten generated numbers, yielding the family:
//		56003, 56113, 56333, 56443, 56663, 56773, and 56993.
//		Consequently 56003, being the first member of this family,
//		is the smallest prime with this property.
//
//	Find the smallest prime which, by replacing part of the number
//	(not necessarily adjacent digits) with the same digit, is part of an eight prime value family.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] alphabet = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "*"};
		for(int n = 2; true; n++) {
			System.out.println(n);
			for(int z = 1; z < alphabet.length; z++)
				perms(alphabet, alphabet[z], n);
		}
		
	}
	public static void perms(String[] alphabet, String path, int length) {
		if(path.length() == length) {
			int counter = 0;
			if(path.indexOf("*") != -1)
			for(int i = 0; i <= 9; i++) {
				if(i == 0 && path.charAt(0) == '*') continue;
				String next = path.replaceAll("\\*", i+"");
				if(Interface.isPrime(Integer.parseInt(next)))
					counter++;
			}
			if(counter == 8) {
				System.out.println(path);
				for(int z = 0; z <= 9; z++)
					if(Interface.isPrime(Integer.parseInt(path.replaceAll("\\*", z+""))))
						System.out.println(path.replaceAll("\\*", z+""));
				System.out.println();
			}
			return;
		}
		for(int z = 0; z < alphabet.length; z++)
			perms(alphabet, path+alphabet[z], length);
	}

}
