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
			System.out.println(series);
			String[] current = new String[series];
			for(int i = 0; i < current.length; i++)
				current[i] = series+"";
			summation[series-1] = multString(current);
		}
		String sum = Interface.addString(summation);
		System.out.println(sum.substring(sum.length()-10));
	}
	public static String multString(String[] rows) {
		if(rows.length == 1) return rows[0];
		String[] addRows = new String[rows.length-1]; // numbers with rows[0] distributed to each
//		for(int y = 1; y < rows.length; y++) { // for each remaining #, mult rows[0] to each
			String[] number = new String[rows[0].length()];
			for(int e = rows[0].length()-1; e >= 0; e--) { //cycle through each digit of multiplicator
				int carryover = 0;
				number[e] = "";
				for(int pow = e+1; pow < rows[0].length(); pow++ )
					number[e] += 0;
				for(int z = rows[1].length()-1; z >= 0; z--) { //cycle through each digit of multiplier
					int temp = Integer.parseInt(rows[0].charAt(e)+"") * Integer.parseInt(rows[1].charAt(z)+"")+carryover;
					number[e] = (temp%10)+""+number[e];
					carryover = temp/10;
				}
				if(carryover != 0)
					number[e] = carryover + number[e];
				if(number[e].length() > 10)
				number[e] = number[e].substring(number[e].length()-10);
			}
			addRows[0] = Interface.addString(number);
			for(int y = 2; y < rows.length; y++)
				addRows[y-1] = rows[y];
//		}
		return multString(addRows);
	}

}
