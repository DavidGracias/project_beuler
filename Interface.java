package project_beuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
	
	public Interface() { }
	
	public static ArrayList<Integer> divisors(int n, boolean proper){
		ArrayList<Integer> d = new ArrayList<Integer>();
		int max = 0;
		for(int i = 1; i <= Math.sqrt(n); i++) {
			if(i == Math.sqrt(n) && proper)
				break;
			if(n%i == 0) {
				d.add(i);
				d.add(n/i);
				if(n/i > d.get(max))
					max = d.size()-1;
			}
		}
		int temp = d.get(max);
		d.set(max, d.get(d.size()-1));
		d.set(d.size()-1, temp);
		return d;
	}
	
	//Sieve of Atkin
	public int[] primeGen(int upper) {
		
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
