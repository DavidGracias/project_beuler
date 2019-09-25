package project_beuler;

public class problem017 {
	
//	If the numbers 1 to 5 are written out in words: one, two, three, four, five,
//	then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
//
//	If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
//	how many letters would be used?
//
//
//	NOTE: Do not count spaces or hyphens.
//	For example, 342 (three hundred and forty-two) contains 23 letters
//	and 115 (one hundred and fifteen) contains 20 letters.
//	The use of "and" when writing out numbers is in compliance with British usage.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sum = 0;
		int n = 1000;
		for(int i = 1; i <= n; i++)
			sum+= numLetters(i);
		
		System.out.println(sum);

	}
	public static int numLetters(int n) {
		String length = thousands(n) + hundreds(n);

		if(n > 100 && n%100 > 0)
			length += "and";
		
		length+= tens(n) + ones(n);
		System.out.println(length);
		return length.length();
	}
	public static String thousands(int n) {
		int digit = 1000;
		String append = "thousand";
		if(n < digit)
			return "";
		return ones( (n/digit) % digit)+append;
	}
	public static String hundreds(int n) {
		int digit = 100;
		String append = "hundred";
		if(n < digit || n == 1000)
			return "";
		return ones( (n/digit) % digit)+append;
	}
	public static String tens(int n) {
		switch( (n/10)%10 ) {
			case 9: return "ninety";
			case 8: return "eighty";
			case 7: return "seventy";
			case 6: return "sixty";
			case 5: return "fifty";
			case 4: return "forty";
			case 3: return "thirty";
			case 2: return "twenty";
			case 1: return teens(n%100);
			default: return "";
		}
	}
	public static String teens(int n) {
		switch(n) {
			case 19: return "teen";
			case 18: return "een";
			case 17: return "teen";
			case 16: return "teen";
			case 15: return "een";
			case 14: return "teen";
			case 13: return "een";
			case 12: return "lve";
			case 11: return "ven";
			default: return "ten";
		}
	}
	public static String ones(int n) {
		switch(n%10) {
			case 9: return "nine";
			case 8: return "eight";
			case 7: return "seven";
			case 6: return "six";
			case 5: return "five";
			case 4: return "four";
			case 3: return "three";
			case 2: return "two";
			case 1: return "one";
			default: return "";
		}
	}

}
