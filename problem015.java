package project_beuler;

public class problem015 {
	
//	Starting in the top left corner of a 2�2 grid,
//	and only being able to move to the right and down,
//	there are exactly 6 routes to the bottom right corner.
//
//	How many such routes are there through a 20�20 grid?
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		System.out.println(lattice(n, n));
		
	}
	
	
	
	
	public static long lattice(int r, int c) {
		if(r == 0 || c == 0)
			return 1;
		if(r == 1)
			return c+1;
		if(c == 1)
			return r+1;
		
		return 2*lattice(r-1, c-1) + lattice(r-2, c) + lattice(r, c-2);
	}
	

}