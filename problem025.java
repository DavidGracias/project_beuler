package project_beuler;

public class problem025 {
	
//	The 12th term, F12, is the first term to contain three digits.
//
//	What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String first = "1";
		String second = "1";
		int counter = 2;
		do {
			String third = Interface.addString(new String[] {first, second});
			first = second;
			second = third;
			counter++;
		} while( second.length() < 1000 );
		System.out.println(counter);
	}
	

}
