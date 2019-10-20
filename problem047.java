package project_beuler;

import java.util.ArrayList;

public class problem047 {
	
//	The first two consecutive numbers to have two distinct prime factors are:
//	14 = 2 × 7
//	15 = 3 × 5
//
//	The first three consecutive numbers to have three distinct prime factors are:
//	644 = 2² × 7 × 23
//	645 = 3 × 5 × 43
//	646 = 2 × 17 × 19.
//
//	Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int z = 1;
		do {
			z++;
			if( !nthConsec(z, n) ) continue;
			System.out.println(z);
			break;
		}while(true);
	}
	public static boolean nDistinct(ArrayList<Integer> arr, int n) {
		int prev = -1;
		for(int i = 0; i < arr.size(); i++)
			if(arr.get(i) != prev) {
				prev = arr.get(i);
				n--;
			}
		return n == 0;
	}
	public static boolean nthConsec(int start, int end) {
		for(int i = 0; i < end; i++) {
			if(!nDistinct(Interface.primeDivisors(start+i), end)) return false;
		}
		return true;
	}

}
