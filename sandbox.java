package project_beuler;
import java.math.BigInteger; 

public class sandbox {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int counter = 0;
		int i = 100;
		BigInteger[] frac = addFrac( new BigInteger[]{BigInteger.valueOf(1), BigInteger.valueOf(1)}, inverse(root2(i)) );
		if( (frac[0]+"").length() > (frac[1]+"").length() ) {
			counter++;
		}
		

		System.out.println(frac[0] +" / "+ frac[1]);
		System.out.println( (frac[0]+"").length() );
	}
	
	public static BigInteger[] root2(int n) {
		if( n == 0 )
			return new BigInteger[]{BigInteger.valueOf(2), BigInteger.valueOf(1)};
		return addFrac( new BigInteger[]{BigInteger.valueOf(2), BigInteger.valueOf(1)}, inverse(root2(n-1)) );
	}
	
	public static BigInteger[] addFrac(BigInteger[] first, BigInteger[] second) {
		return new BigInteger[] {first[0].multiply(second[1]).add(first[1].multiply(second[0])), first[1].multiply(second[1])};
	}
	
	public static BigInteger[] inverse(BigInteger[] frac) {
		return new BigInteger[] { frac[1], frac[0] };
	}

}
