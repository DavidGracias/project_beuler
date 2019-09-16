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
		int sum = 0;
		int[][] places = new int[][] {
			{
				"thousand".length(),
				3
			},
			{
				"hundred".length(),
				2
			},
			{
				"".length(),
				0
			},
		};
		for(int i = places.length-1; i >=0; i++) {
			switch( (int) (n/Math.pow(10, places[i][1]))%10 ) {
				case 0: break;
			//5 letters
				case 8: case 7: case 3: sum+=5-(8);
					
			//4 letters
				case 9: case 5: case 4: sum+=4-(4);
					
			//3 letters
				case 6: case 2: case 1: sum+=4;
				
				default: sum+=places[i][0];
			}
		}
		int tens = Integer.parseInt( (n+"").substring((n+"").length()-2, (n+"").length()) );
		if(tens/10 == 9 || tens/10 == 7 || tens/10 == 6)
			sum+= 2;
		else if(tens/10 == 8 || tens/10 == 5 || tens/10 == 4 || tens/10 == 3)
			sum+=1;
		else if(tens/10 == 2)
			sum+=3;
		else if(tens/10 == 1) {
			switch(tens) {
			case 19:
			case 18:
			case 17:
			case 16:
			case 15:
			case 14:
			case 13:
			case 12:
			case 11:
			case 10:
			}
		}
		
		
		
		return sum;
	}

}
