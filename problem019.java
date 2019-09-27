package project_beuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem019 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String[] names = parseFile("problem019.txt");
		
		names = mergesort(names);
		
		System.out.println(names.length);
	}
	
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
	public static void swapString(String[] list, int left, int right) {
		String temp = list[left];
		list[left] = list[right];
		list[right] = temp;
	}
	
	
	public static String[] parseFile(String dir) throws FileNotFoundException {
		File file = new File(System.getProperty("user.dir")+"/src/project_beuler/"+dir);
		Scanner reader = new Scanner(file);
		reader.close();
		String contents = reader.nextLine();
		return contents.split("(\\\"(,\\\")?)");
	}

}
