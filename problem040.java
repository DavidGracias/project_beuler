package project_beuler;

public class problem040 {
	
//	An irrational decimal fraction is created by concatenating the positive integers:
//
//	0.123456789101112131415161718192021...
//
//	It can be seen that the 12th digit of the fractional part is 1.
//
//	If dn represents the nth digit of the fractional part, find the value of the following expression.
//
//	d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mult = 1;
		for(int i = 1, lcount = 1, n = 0; n <= 6; i++) {
			if(lcount -(i+"").length() <= 0) {
				int charAt = Integer.parseInt( (i+"").charAt(lcount-1)+"" );
				System.out.println(charAt +" "+ i);
				mult*= charAt;
				n++;
				lcount += (int)( Math.pow(10, n) - Math.pow(10, n-1) );
			}
			lcount-=(""+i).length();
		}
		System.out.println();
		System.out.println(mult);
	}

}
