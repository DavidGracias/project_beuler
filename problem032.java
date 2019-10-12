package project_beuler;

import java.util.ArrayList;

public class problem032 {
	
//	We shall say that an n-digit number is pandigital
//	if it makes use of all the digits 1 to n exactly once;
//	for example, the 5-digit number, 15234, is 1 through 5 pandigital.
//
//	The product 7254 is unusual, as the identity, 39 × 186 = 7254,
//	containing multiplicand, multiplier, and product is 1 through 9 pandigital.
//
//	Find the sum of all products whose multiplicand/multiplier/product
//	identity can be written as a 1 through 9 pandigital.
//
//	HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
	public static int sum = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int a = 1; a < Math.pow(10, 4); a++) {
			if( !hasDups(a+"") )
				for(int b = 1; b < Math.pow(10, 5-(a+"").length()); b++) {
					int c = (a*b);
					if((a+""+b+""+c).length() == 9 && !hasDups(a+""+b+""+c))
						insert(list, c);
				}
		}
		System.out.println(sum);
	}
	public static boolean hasDups(String n) {
		int[] counter = new int[9];
		for(String a: n.split("")) {
			if(a.contentEquals("0") || counter[Integer.parseInt(a)-1] == 1)
				return true;
			counter[Integer.parseInt(a)-1]++;
		}
		return false;
		
	}
	public static void insert(ArrayList<Integer> haystack, int needle) {
		for(int i = 0; i < haystack.size(); i++)
			if(haystack.get(i) == needle)
					return;
		sum+=needle;
		haystack.add(needle);
		return;
	}

}
