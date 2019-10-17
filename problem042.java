package project_beuler;

public class problem042 {
	
//	The nth term of the sequence of triangle numbers is given by,
//	t_n = ½n(n+1); so the first ten triangle numbers are:
//
//	1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
//
//	By converting each letter in a word to a number corresponding
//	
//	to its alphabetical position and adding these values we form a
//	word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10.
//	If the word value is a triangle number then we shall call the word a triangle word.
//
//	Using words.txt (right click and 'Save Link/Target As...'),
//	a 16K text file containing nearly two-thousand common English words,
//	how many are triangle words?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = Interface.parseArr("problem042.txt");
		int i = 0;
		for(String word : words)
			if(word.length() != 0 && isTriangle(word))
				i++;
		System.out.println(i);
	}
	
	public static boolean isTriangle(String i) {
		double sum = 0;
		for(String value : (i).toLowerCase().split("")) {
			sum+= (value.charAt(0)-'a'+1);
		}
//		n^2 + n = 2*sum
//		-b +/- Math.sqrt(b^2 - 4ac)  /2a
//		-1 +/- Math.sqrt( 1 - 4(1)(-2sum) );
		double n = ( -1 + Math.sqrt(1 + 8*sum) )/2;
		System.out.println(n);
		return n == (int) n;
	}

}
