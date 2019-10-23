package project_beuler;

public class problem041 {
	
//	We shall say that an n-digit number is pandigital if it
//	makes use of all the digits 1 to n exactly once.
//	For example, 2143 is a 4-digit pandigital and is also prime.

//	What is the largest n-digit pandigital prime that exists?
	private int panprime = 0; 
	
	public problem041() {
		
	}
	
	public int betterPandigital() { 
		String currNum = "987654321";
		while (!currNum.equals("123456789")) {
			int num = Integer.parseInt(currNum); 
			if (Interface.isPrime(num))
				return num;
			
			currNum = updateNum(currNum);
		}
		
		return 0; 
	}
	
//	4321
//	4312
	
//	4231
//	4213
	
//	4132
//	4123
	
	private String updateNum(String currNum) {
//		int index = 0;
		boolean des = true, asc = false;
		for(int i = 0; i < currNum.length()-1; i++) {
			if(!asc)
				des = currNum.charAt(i) > currNum.charAt(i+1);
			if(!des)
				asc = currNum.charAt(i) < currNum.charAt(i+1);
			if(asc == des)
				break;//this is bad
			
		}//this means swap from original
		
		
			
		return currNum; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		problem041 solver = new problem041();
		System.out.println(solver.betterPandigital());
//		for(int n = 9; n > 0; n--)
//			solver.pandigital("", n);
//		System.out.println(solver.panprime);
	}

	public void pandigital(String path, int n) {
		if(panprime > 0)
			return;
		if(path.length() == n) {
			if(Interface.isPrime(Integer.parseInt(path)))
				panprime = Integer.parseInt(path);
			return;
		}
		for(int dig = n; dig > 0; dig--)
			if(path.indexOf(dig+"") == -1)
				pandigital(path+dig, n);
	}
}
