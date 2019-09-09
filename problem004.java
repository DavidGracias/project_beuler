package project_beuler;

public class problem004 {

//	A palindromic number reads the same both ways.
//	The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
//
//	Find the largest palindrome made from the product of two 3-digit numbers.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long highest = -1;
		for(int x = 999; x > 99; x--)
			for(int y = 999; y > 99; y--)
				if( x*y > highest && isPalindrome(x*y) ) {
					highest = x*y;
					break;
				}
		System.out.println(highest);
				
	}
	
	public static boolean isPalindrome(long n) {
		String word = n+"";
		for(int i = 0; i < word.length(); i++)
			if(word.charAt(i) != word.charAt(word.length()-1 -i))
				return false;
		return true;
	}

}
