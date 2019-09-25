package project_beuler;

public class problem019 {

//	You are given the following information, but you may prefer to do some research for yourself.
//
//	1 Jan 1900 was a Monday.
//	
//	All the rest have thirty-one,
//	Saving February alone,
//	Which has twenty-eight, rain or shine.
//	And on leap years, twenty-nine.
	
//	A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
//	How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] weekdays = new int[7]; //count # of weekdays total (possible other problem)
		int weekdayCounter = 1;
		int firstSundays = 0;
		for(int year = 1900; year < 1901; year++)
			for(int month = 1; month <= 12; month++)
				for(int day = 1; day <= monthLength(month, year); day++)
					weekdayCounter= (weekdayCounter+1)%7;
		
		for(int year = 1901; year <= 2000; year++)
			for(int month = 1; month <= 12; month++)
				for(int day = 1; day <= monthLength(month, year); day++) {
//					System.out.println(year+"/"+month+"/"+day+" - "+weekdayCounter);
//					weekdays[weekdayCounter%7]++;
					if(day == 1 && weekdayCounter%7 == 0)
						firstSundays++;
					weekdayCounter++;
				}
		System.out.println(firstSundays);
	}
	public static int monthLength(int m, int y) {
//		Thirty days has September (9), April(4), June(6) and November(11).
		switch(m) {
			case 11: case 9: case 6: case 4:
				return 30;

			case 2:
				if(m%4 != 0)
					return 28;
				else if(m%100 == 0 && m%400 != 0)
					return 28;
				else
					return 29;
					
			case 12: case 10: case 8: case 7: case 5: case 3: case 1:
			default: return 31;
		}
	}

}
