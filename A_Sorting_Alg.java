package project_beuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A_Sorting_Alg {

	public static int x = 1000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] list = parseFile("problem022.txt");
		
		String[] merge = mergesort(list);
		String[] quick = list.clone(); quicksort(quick, 0, list.length-1);
		
		int sum = 0;
		for(int i = 0; i < quick.length; i++)
			sum += merge[i].compareTo(quick[i]);
		System.out.println(sum);
	}
	
//Merge Sort
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
	
	
//Quick Sort
	public static void quicksort(String[] list, int start, int end) {
//		System.out.println(start+" "+end);
		
		int index = start;
		int pivot = end;
		
		int inc = 1;
		while( index != pivot ) {
			if(
				(inc == 1 && list[index].compareTo(list[pivot]) > 0) ||
				(inc == -1 && list[pivot].compareTo(list[index]) > 0)
			) {
				//swap
				String temp = list[index];
				list[index] = list[pivot];
				list[pivot] = temp;
				
				int tempInt = index;
				index = pivot;
				pivot = tempInt;
				
				inc *= -1;
			}
			index+=inc;
		}
		if(end != pivot && start != pivot)
			quicksort(list, start, pivot);
		if(start != pivot && end != pivot)
		quicksort(list, pivot, end);
	}
	
	
//Parsing a file
	public static String[] parseFile(String dir){
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
