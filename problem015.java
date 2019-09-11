package project_beuler;

public class problem015 {
	
//	Starting in the top left corner of a 2×2 grid,
//	and only being able to move to the right and down,
//	there are exactly 6 routes to the bottom right corner.
//
//	How many such routes are there through a 20×20 grid?
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(recursion(0, 0));
		long start = 2;
		double multiplyer = 3;
		int dimensions = 20;
		double denominator = 1;
		for(int i = 1; i < dimensions; i++) {
			start *= multiplyer;
			denominator += (i+1);
			multiplyer += 1/denominator;
		}
		System.out.println(start);
	}
	//dim: 		1, 2, 3, 4, 5, 6, 7, 8, 9, 10
	//answer: 	2, 6, 20, 70, 252, 924, 3432, 12870, 48620, 184756
	//growth: 		3, 3.33, 3.5, 3.6, 3.66, 3.714, 3.75, 3.77, 3.8
	//den:		1, 1/3, 1/6, 1/10, 1/15, 1/21, 1/28, 1/37,
	
	
	
	
//	public static int recursion(int r, int c) {
//		System.out.println(r+" "+c);
//		if(r == height && c == width)
//			return 1;
//		else if(r > height || c > width)
//			return 0;
//		return recursion(r, c+1) + recursion(r+1, c);
//	}
	

}