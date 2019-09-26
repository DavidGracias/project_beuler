package project_beuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem022 {
	
//	five-thousand first names, begin by sorting it into alphabetical order.
//	Then working out the alphabetical value for each name,
//	multiply this value by its alphabetical position in the list to obtain a name score.
//  
//	For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
//
//	What is the total of all the name scores in the file?

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] list = parseFile("problem022.txt");
		
		String[] merge = mergesort(list);
		
		long namescore = 0;
		for(int i = 0; i < merge.length; i++) {
			int temp = 0;
			for(int c = 0; c < merge[i].length(); c++)
				temp+= ( (merge[i].toUpperCase()).charAt(c) -'A' +1);
			namescore += (i+1) * temp;
		}
		System.out.println(namescore);
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
	
	
//Parsing a file
	public static String[] parseFile(String dir){
		File file = new File(System.getProperty("user.dir")+"/src/project_beuler/"+dir);
		Scanner reader;
		try {
			reader = new Scanner(file);
		} catch (FileNotFoundException e) {
			reader = new Scanner(System.in);
		}
		String contents = reader.nextLine();
		reader.close();
		return contents.split("(\\\"(,\\\")?)");
	}

}
