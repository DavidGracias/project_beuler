package project_beuler;

public class problem066 {
	
//	Consider quadratic Diophantine equations of the form:
//
//	x^2 – Dy^2 = 1
//  Dy^2 = x^2 - 1
//  y^2 = (x^2 - 1)/D
//
//	For example, when D=13, the minimal solution in x is 649^2 – 13×180^2 = 1.
//
//	It can be assumed that there are no solutions in positive integers when D is square.
//
//	By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:
//
//	3^2 – 2×2^2 = 1
//	2^2 – 3×1^2 = 1
//	9^2 – 5×4^2 = 1
//	5^2 – 6×2^2 = 1
//	8^2 – 7×3^2 = 1
//
//	Hence, by considering minimal solutions in x for D ≤ 7, the largest x is obtained when D=5.
//
//	Find the value of D ≤ 1000 in minimal solutions of x for which the largest value of x is obtained.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxD = -1;
		int maxX = -1;
		for(int D = 2; D <= 7; D++) {
			if( Math.sqrt(D) == (int) Math.sqrt(D) ) continue;
			for(int x = 2; x < 1000; x++)
				if( Interface.isInteger( Math.sqrt( (Math.pow(x, 2) - 1)/D ) ) ) {
					if(x > maxX ) {
						maxX = x;
						maxD = D;
					}
					break;
				}
		}
		System.out.println(maxD);
	}

}
