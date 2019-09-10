package project_beuler;

public class problem016 {
	
//	2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
//
//	What is the sum of the digits of the number 2^1000?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000;
		String start = "1";
		for(int i = 0; i < n; i++) {
			start = Double(start);
		}
		int sum = 0;
		for(int x = 0; x < start.length(); x++)
			sum+= Integer.parseInt(""+start.charAt(x));
		System.out.println(sum);
	}
	public static String Double(String n) {
		String number = "";
		int carryover = 0;
		for(int y = n.length()-1; y >= 0; y--) { //columns
			int temp = 2* Integer.parseInt(n.charAt(y)+"") +carryover;
			number = (temp%10)+""+number;
			carryover = temp/10;
		}
		return (carryover != 0)? carryover + number : number;
	}
	

}
