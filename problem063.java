package project_beuler;

public class problem063 {
	
//	The 5-digit number, 16807=7^5, is also a fifth power.
//	Similarly, the 9-digit number, 134217728=8^9, is a ninth power.
//
//	How many n-digit positive integers exist which are also an nth power?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = 0;
		
		for(int n = 0; n < 10; n++){
			if(n%10 == 0) continue;
			int power = 0;
			String mult = "1";
			do {
				power++;
				mult = Interface.multString(new String[] { mult, n+""});
				if( power == mult.length() )
					result++;
			} while( power <= mult.length() );
			System.out.println(result);
		}
	}
	
	//2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2
	//

}
