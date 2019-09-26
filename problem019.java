package project_beuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem019 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String[] names = parseFile("problem019.txt");
		System.out.println(names);
		
		quicksort(names, 0, names.length-1);
		
		
	}
	
	public static void quicksort(String[] list, int left, int right) {
		if(right == 1 || left == list.length-2)
			return;
		int pivot = (left+right)/2;
		
		while(list[left].compareTo(list[pivot]) <= 0) left++;
		while(list[right].compareTo(list[pivot]) >= 0) right--;
		if(left < right)
			swapString(list, left, right);
//		quicksort();
		
	}
	public static void swapString(String[] list, int left, int right) {
		String temp = list[left];
		list[left] = list[right];
		list[right] = temp;
	}
	
	
	public static String[] parseFile(String dir) throws FileNotFoundException {
		File file = new File(System.getProperty("user.dir")+"/src/project_beuler/"+dir);
		Scanner reader = new Scanner(file);
		String contents = reader.nextLine();
		return contents.split("(\\\"(,\\\")?)");
	}

}
