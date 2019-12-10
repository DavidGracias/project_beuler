package project_beuler;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

public class problem062 {
	
//	The cube, 41063625 (3453), can be permuted to produce two other cubes:
//	56623104 (3843) and 66430125 (4053).
//	
//	In fact, 41063625 is the smallest cube which has exactly three
//	permutations of its digits which are also cube.
//
//	Find the smallest cube for which exactly five permutations of its digits are cube.
	
//	SOLUTION IN PYTHON:
//def main():
//    perms = {}
//
//    last = 1
//    while True:
//        last+=1
//        key = order( str(last**3) )
//        if not key in perms:
//            perms[key] = []
//        perms[key]+= [last]
//        if len( perms[key] ) == 5:
//            break
//        
//
//    print( perms[key] )
//    print( perms[key][0]**3 )
//
//def order(n):
//    n =  [char for char in n]  
//    for x in range( len(n) ):
//        min = x
//        for y in range( x+1, len(n) ):
//            if n[y] < n[min]:
//                min = y
//        temp = n[x]
//        n[x] = n[min]
//        n[min] = temp
//    return "".join(n)
//
//main()

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dictionary perms = new Hashtable();
		int last = 1;
		while( perms.get((Integer) last ) != (Integer) 3 ) {
			last++;
			String key = Interface.multString(new String[]{last+"", last+"", last+""});
			key = order(key);
			if( perms.get(key) == null)
				perms.put(key, 0);
			perms.put( key, (Integer) perms.remove(key) + (Integer) 1 );
		}
		System.out.println(last);
	}
	public static String order(String mixed) {
		return Arrays.toString( Interface.mergesort(mixed.split("")) );
	}

}
