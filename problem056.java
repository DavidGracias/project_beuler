package project_beuler;

public class problem056 {
	
//	A googol (10^100) is a massive number: one followed by one-hundred zeros;
//	100^100 is almost unimaginably large: one followed by two-hundred zeros.
//	Despite their size, the sum of the digits in each number is only 1.
//
//	Considering natural numbers of the form, ab, where a,
//	b < 100, what is the maximum digital sum?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 0;
		for(int a = 100; a > 0; a--)
			if(a% 10 != 0)
			for(int b = 100; b > 0; b--) {
				String[] power = new String[b];
				for(int i = 0; i < power.length; i++)
					power[i] = a+"";
				String value = Interface.multString(power);
				if( value.length() < max/10 )
					break;
				max = Math.max( max, digitSum(value) );
			}
		System.out.println(max);
	}
	public static int digitSum(String number) {
		int i = 0;
		for(int x = 0; x < number.length(); x++)
			i += Integer.parseInt(number.charAt(x)+"");
		return i;
	}

}
