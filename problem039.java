package project_beuler;

public class problem039 {
	
//	If p is the perimeter of a right angle triangle with integral length sides,
//	{a,b,c}, there are exactly three solutions for p = 120.
//
//	{20,48,52}, {24,45,51}, {30,40,50}
//
//	For which value of p ≤ 1000, is the number of solutions maximized?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = -1;
		int length = 0;
		for(int p = 1+1+1; p <= 1000; p++) {
			int current = 0;
			for(int a = 1; a <= (double) 2/3*p; a++) {
				for(int b = 1; b <= a; b++)
					if(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) == (p-b-a))
						current++;
			}
			if(current > length) {
				max = p;
				length = current;
			}
		}
		System.out.println(max+" "+length);
	}

}
