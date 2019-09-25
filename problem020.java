package project_beuler;

public class problem020 {
	
//	n! means n × (n − 1) × ... × 3 × 2 × 1

//	For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
//	and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
//	
//	Find the sum of the digits in the number 100!

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		String start = "1";
		for(int i = 1; i <= n; i++) {
			start = times(start, i);
		}
		int sum = 0;
		for(int x = 0; x < start.length(); x++)
			sum+= Integer.parseInt(""+start.charAt(x));
		System.out.println(sum);
	}
	public static String times(String n, int multiplicator) {
		String number = "";
		int carryover = 0;
		for(int y = n.length()-1; y >= 0; y--) { //columns
			int temp = multiplicator* Integer.parseInt(n.charAt(y)+"") +carryover;
			number = (temp%10)+""+number;
			carryover = temp/10;
		}
		return (carryover != 0)? carryover + number : number;
	}
	

}
