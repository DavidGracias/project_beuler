package project_beuler;

public class problem052 {
	
//	It can be seen that the number, 125874, and its double, 251748,
//	contain exactly the same digits, but in a different order.
//
//	Find the smallest positive integer, x,
//	such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		while( !(
			sameDigits(i+"", 6*i+"") &&
			sameDigits(i+"", 5*i+"") &&
			sameDigits(i+"", 4*i+"") &&
			sameDigits(i+"", 3*i+"") &&
			sameDigits(i+"", 2*i+"")
		) )
			i = updateI(i);
		System.out.println(i);
		System.out.println(i*2);
		System.out.println(i*3);
		System.out.println(i*4);
		System.out.println(i*5);
		System.out.println(i*6);
			
	}
	public static boolean sameDigits(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		while(s1.length() > 0) {
			if(s2.indexOf(s1.charAt(0)) == -1)
				return false;
			s2 = s2.substring(0, s2.indexOf(s1.charAt(0))) + s2.substring(s2.indexOf(s1.charAt(0)), s2.length());
			s1 = s1.substring(1);
		}
		return true;
	}
	public static int updateI(int i) {
		i++;
		if( (6*i+"").length() != (i+"").length() ) {
			int n = 0;
			while(i/(int)Math.pow(10, n) != 0 )
				n++;
			i = (int) Math.pow(10, n);
		}
		return i;
	}

}
