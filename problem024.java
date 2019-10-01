package project_beuler;

public class problem024 {
	
//	A permutation is an ordered arrangement of objects.
//	For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
//	If all of the permutations are listed numerically or alphabetically,
//	we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
//
//	012   021   102   120   201   210
//
//	What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
	public static int target = 1000000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p = 9;
		permutation(p, "");
	}
	
	public static void permutation(int n, String path) {
		if(path.length() == n+1) {
			target--;
			if(target == 0)
				System.out.println(path);
			return;
		}
		
		
		for(int i = 0; i<=n; i++)
			if( !hasDuplicates(path+i) )
				permutation(n, path+i);
				
	}
	
	public static int factorial(int n) {
		if(n == 1 || n == 0)
			return 1;
		return n * factorial(n-1);
	}
	
	public static boolean hasDuplicates(String s) {
		for(int x = 0; x < s.length(); x++)
			for(int y = 0; y < s.length(); y++) {
				if(y == x)
					continue;
				if(s.charAt(x) == s.charAt(y))
					return true;
			}
		return false;
	}
}
