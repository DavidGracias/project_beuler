package project_beuler;

public class problem038 {
	
//	Take the number 192 and multiply it by each of 1, 2, and 3:
//
//	192 × 1 = 192
//	192 × 2 = 384
//	192 × 3 = 576
//	By concatenating each product we get the 1 to 9 pandigital,
//	192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)
//
//	The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5,
//	giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
//
//	What is the largest 1 to 9 pandigital 9-digit number that can be formed as the
//	concatenated product of an integer with (1,2, ... , n) where n > 1?
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//n = 2; 9/2 digits long
		//1000, 99999
		//n = 3; 9/3 digits long
		//12, 34, 56, 78
		
		int max = -1;
		for(double n = 2; n <= 9; n++)
		for(int i = (int) Math.pow(10, Math.floor(9/n)-1); i <= Math.pow(10, Math.ceil(9/n)-1); i++) {
			String concat = returnConcat((int)n, i);
			if( Interface.isPandigital(concat) )
				max = Math.max(max, Integer.parseInt(concat));
		}
		
		System.out.println(max);
	}
	public static String returnConcat(int n, int i) {
		if(n == 0)
			return "";
		return returnConcat(n-1, i) +""+i*n;
	}
	

}
