package project_beuler;

public class problem036 {
	
//	The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
//
//	Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
//
//	(Please note that the palindromic number, in either base, may not include leading zeros.)

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int n = 1000000;
		for(int i = 0; i < n; i++)
			if(isPalindrome(i+"") && isPalindrome(Interface.base(2, i))) {
				sum+=i;
			}
		System.out.println(sum);
	}
	
	
	public static boolean isPalindrome(String n) {
		for(int i = 0; i < n.length()/2; i++)
			if( n.charAt(i) != n.charAt((n.length()-1)-i) )
				return false;
		return true;
			
	}

}
