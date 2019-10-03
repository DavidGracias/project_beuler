package project_beuler;

import java.util.ArrayList;

public class problem026 {
	
	//Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle.
//	It can be seen that 1/7 has a 6-digit recurring cycle.

//Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int longest = -1;
		int D = 1;
		for(int d = 1; d < 1000; d++) {
			String temp = ""+(double)1/d;
			int next = recurring(temp);
			if(next > longest) {
				longest = next;
				D = d;
			}
		}
	}
	
	public static int recurring(String haystack) {
		ArrayList<Object> patterns = new ArrayList<Object>();
		for(int x = 0; x < haystack.length(); x++) {
			if(true)
				break;
		}
		return 0;
	}
	public static int occurances(String haystack, String needle) {
		String[] split = haystack.split(needle);
		for(int x = 1; x < split.length-1; x++) {
			if(split[x].length() > 0)
				return 0;
		}
		return haystack.split(needle).length;
	}

	

}
