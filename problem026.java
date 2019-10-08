package project_beuler;

public class problem026 {
	
	//Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle.
//	It can be seen that 1/7 has a 6-digit recurring cycle.

//Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String longest = "";
		int D = 1;
		for(int d = 2; d < 1000; d++) {
			String decimal = Interface.divide(1, d, 2000);
			String newest = repeating(decimal);
			if( newest.length() > longest.length() ) {
				longest = newest;
				D = d;
			}
		}
		System.out.println(D);
		
	}
	public static String repeating(String haystack) {
		String needle = haystack.substring(haystack.length()-1);
		
		for(int i = haystack.length()-needle.length(); i >= needle.length(); i--) {
			//out of bounds
			if(needle.compareTo( haystack.substring(i-needle.length(), i) ) == 0)
				return needle;
			
			//continue pattern
			needle = haystack.charAt(i-1) + needle;
		}
		return "";
	}
	
}
