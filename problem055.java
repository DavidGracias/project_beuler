package project_beuler;

public class problem055 {
	
//	If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
//
//	Not all numbers produce palindromes so quickly. For example,
//
//	349 + 943 = 1292,
//	1292 + 2921 = 4213
//	4213 + 3124 = 7337
//
//	That is, 349 took three iterations to arrive at a palindrome.
//
//	Although no one has proved it yet, it is thought that some numbers,
//	like 196, never produce a palindrome. A number that never forms a palindrome
//	through the reverse and add process is called a Lychrel number. Due to the
//	theoretical nature of these numbers, and for the purpose of this problem,
//	we shall assume that a number is Lychrel until proven otherwise. In addition
//	you are given that for every number below ten-thousand, it will either
//		(i) become a palindrome in less than fifty iterations, or,
//		(ii) no one, with all the computing power that exists, has managed so far to map it to a palindrome.
//	
//	In fact, 10677 is the first number to be shown to require over fifty iterations
//	before producing a palindrome: 4668731596684224866951378664 (53 iterations, 28-digits).
//
//	Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.
//
//	How many Lychrel numbers are there below ten-thousand?
//
//	NOTE: Wording was modified slightly on 24 April 2007 to emphasise the theoretical nature of Lychrel numbers.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counter = 0;
		for(int i = 0; i < 10000; i++) {
			if(isLichrel(i+"")) {
				System.out.println(i);
				counter++;
			}
		}
		System.out.println(counter);
	}
	public static String reverse(String n) {
		String next = "";
		while( n.length() > 0) {
			next = n.charAt(0) + next;
			n = n.substring(1);
		}
		return next;
	}
	public static boolean isLichrel(String n) {
		for(int z = 0; z < 50; z++) {
			n = Interface.addString(new String[] {n, reverse(n)});
			if(Interface.isPalindrome(n))
				return false;
//			int spacing = n.length();
//			System.out.println("Iteration: "+ z);
//			System.out.println("  "+n);
//			System.out.println("+ "+reverse(n));
//			for(int i = -2; i < n.length(); i++)
//				System.out.print("-");
//			System.out.println();
//			if(spacing == n.length())
//				System.out.print("  ");
//			System.out.println(n+"\n");
		}
		return true;
	}
	

}
