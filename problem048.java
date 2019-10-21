package project_beuler;

public class problem048 {
	
//	The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
//
//	Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000;
		String[] summation = new String[n];
		for(int series = 1; series <= n; series++) {
			String[] current = new String[series];
			for(int i = 0; i < current.length; i++)
				current[i] = series+"";
			summation[series-1] = Interface.multString(current);
		}
		String sum = Interface.addString(summation);
		System.out.println(sum.substring(sum.length()-10));
	}

}
