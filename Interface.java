package project_beuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Interface {
	
	public Interface() { }
	
	public static int lcm(int f, int l) {
		ArrayList<Integer> dF = Interface.primeDivisors(f);
		ArrayList<Integer> dL = Interface.primeDivisors(l);
		int mult = 1;
		Collections.sort(dF);
		Collections.sort(dL);
		for(int x = 0, y=0; x < dF.size() || y < dL.size();) {
			if(x >= dF.size())
				mult *= dL.get(y++);
			
			else if(y >= dL.size() || dF.get(x) < dL.get(y))
				mult *= dF.get(x++);
			
			else if(dF.get(x) > dL.get(y))
				mult *= dL.get(y++);
			
			else if(dF.get(x) == dL.get(y)) {
				mult*=dF.get(x);
				x++; y++;
			}
		}
		return mult;
	}
	
	public static ArrayList<Integer> primeDivisors(int n){
		ArrayList<Integer> d = new ArrayList<Integer>();
		int i = 2;
		while(n%i != 0) i++;
		//if i is prime
		if(Interface.isPrime(i))
			d.add(i);
		else
			d = mergeLists(d, primeDivisors(i));
		if(Interface.isPrime(n))
			return d;
		//if n/i is prime
		if(Interface.isPrime(n/i))
			d.add(n/i);
		else
			d = mergeLists(d, primeDivisors(n/i));
		return d;
		
	}
	public static <E>ArrayList<E> mergeLists(ArrayList<E> list1, ArrayList<E> list2){
		for(int i = 0; i < list2.size(); i++)
			list1.add(list2.get(i));
		return list1;
	}
	
	public static <T>String Stringify(T[] array) {
		String output = "[";
		for(int i = 0; i < array.length; i++) {
			output+=array[i];
			if(i != array.length-1)
				output+=", ";
		}
		return output+"]";
	}
	public static <E>String Stringify(ArrayList<E> array) {
		return Stringify(array.toArray(new Integer[array.size()]));
	}
	
	public static boolean isPrime(int n) {
		//Primes are 2, 3, 5, 7, etc.
		if(n < 2 || (n != 2 && n%2 == 0) )
			return false;
		for(int i = 3; i < n; i+=2)
			if(n%i == 0)
				return false;
		return true;
	}
	
	public static String addString(String[] rows) {
		String number = "";
		int carryover = 0;
		int index = 0; //index++ in while loop condition
		int max = 0;
		for(int z = 0; z < rows.length; z++)
			max = Math.max(rows[z].length(), max);
		while(index < max) {
			int sum = carryover;
			for(int i = 0; i < rows.length; i++) //rows
				if(rows[i].length()-1 >= index)
					sum+= Integer.parseInt(rows[i].charAt(rows[i].length()-1 -index)+"");
			
			carryover = sum/10;
			number = (sum%10)+""+number;
			index++;
		}
		if(carryover != 0)
			number = (carryover+""+number);
		return number;
	}
	
	public static Integer[] divisors(int n, boolean proper){
		ArrayList<Integer> d = new ArrayList<Integer>();
		d.add(1);
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i == 0) {
				d.add(i);
				if(i != n/i)
				d.add(n/i);
			}
		}
		
		return d.toArray(new Integer[d.size()]);
	}
	
	
	//Sieve of Atkin
	public static int[] primeGen(int upper) {
		
		boolean[] is_prime = new boolean[upper];
		for (int i = 0; i < upper; i++) is_prime[i] = false;
		
		for (int i = 1; i * i < upper; i++) {
			for (int j = 1; j * j < upper; j++) {
				
				int n = 4 * i * i + j * j;
				if (n <= upper && (n % 12 == 1 || n % 12 == 5)) 
					is_prime[n] ^= true;
				
				n = 3 * i * i + j * j;
				if (n <= upper && n % 12 == 7)
					is_prime[n] ^= true;
				
				n = 3 * i * i - j * j;
				if (i > j && n <= upper && n % 12 == 11)
					is_prime[n] ^= true;
				
			}
		
		}
		
		for (int a = 5; a * a < upper; a++) {
			if (is_prime[a]) {
				for (int b = a * a; b < upper; b += a * a)
					is_prime[b] = false;
			}
		}
		
		int num_primes = 2;
		for (int i = 0; i < is_prime.length; i++) {
			if (is_prime[i]) num_primes++;
		}
		
		int[] primes = new int[num_primes];
		primes[0] = 2;
		primes[1] = 3;
		
		int ind = 2;
		for (int i = 5; i < upper; i++) {
			if (is_prime[i]) {
				primes[ind] = i;
				ind++;
			}
		}
		return primes;
	}

	//MergeSort
	public static String[] mergesort(String[] list) {
		if(list.length == 1)
			return list;
		String[] first = new String[list.length/2];
		String[] second = new String[list.length-list.length/2];
		for(int i = 0; i < list.length; i++)
			if(i < list.length/2)
				first[i] = list[i];
			else
				second[i-list.length/2] = list[i];
				
		return merge(mergesort(first), mergesort(second));
	}
	public static String[] merge(String[] list1, String[] list2) {
		String[] full = new String[list1.length+list2.length];
		
		int x = 0; int y = 0;
		for(int i = 0; i < full.length; i++)
			if(
				(y >= list2.length) ||
				(x < list1.length && list1[x].compareTo(list2[y]) <= 0)
			)
				full[i] = list1[x++];
			else
				full[i] = list2[y++];
		
		return full;
		
	}
	public static int[] mergesort(int[] list) {
		if(list.length == 1)
			return list;
		int[] first = new int[list.length/2];
		int[] second = new int[list.length-list.length/2];
		for(int i = 0; i < list.length; i++)
			if(i < list.length/2)
				first[i] = list[i];
			else
				second[i-list.length/2] = list[i];
				
		return merge(mergesort(first), mergesort(second));
	}
	public static int[] merge(int[] list1, int[] list2) {
		int[] full = new int[list1.length+list2.length];
		
		int x = 0; int y = 0;
		for(int i = 0; i < full.length; i++)
			if(
				(y >= list2.length) ||
				(x < list1.length && list1[x] <= list2[y])
			)
				full[i] = list1[x++];
			else
				full[i] = list2[y++];
		
		return full;
		
	}
	
	//Binary Search
	public static int binarysearch(int[] haystack, int needle) {
		int low = 0;
		int high = haystack.length-1;
		while(low <= high) {
			int index = (low + high)/2;
			if(haystack[index] == needle)
				return index;
			if(haystack[index] - needle < 0)
				low = index+1;
			else
				high = index-1;

		}
		return -1;
	}
	
	//Long Division (string)
	public static String divide(int n, int d, int precision) {
		String number = "";
		while(number.length() < precision && n != 0) {
			n*=10;
			while(n/d == 0) {
				number+="0";
				n*=10;
			}
			number+=(n/d);
			n%=d;
		}
		return number;
	}
	
	//Parse Arr File
	public static String[] parseArr(String dir){
		File file = new File(System.getProperty("user.dir")+"/src/project_beuler/"+dir);
		Scanner reader;
		try {
			reader = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Error reading file, enter input here:");
			reader = new Scanner(System.in);
		}
		String contents = reader.nextLine();
		reader.close();
		return contents.split("(\\\"(,\\\")?)");
	}
}
