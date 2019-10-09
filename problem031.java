package project_beuler;

public class problem031 {
	
//	In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
//
//	1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
//	It is possible to make £2 in the following way:
//
//	1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
//	How many different ways can £2 be made using any number of coins?

	public static int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( useitloseit(0, 0) );
		
	}
	public static int useitloseit(int total, int i) {
		if(total == 200)
			return 1;
		if(total > 200 || i >= coins.length)
			return 0;
		return useitloseit(total+coins[i], i) + useitloseit(total, i+1);
	}

}
