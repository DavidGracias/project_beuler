package project_beuler;


public class A_Sorting_Alg {

	public static int x = 1000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] list = Interface.parseArr("problem022.txt");
		
		String[] merge = Interface.mergesort(list);
		String[] quick = list.clone(); quicksort(quick, 0, list.length-1);
		
		int sum = 0;
		for(int i = 0; i < quick.length; i++)
			sum += merge[i].compareTo(quick[i]);
		System.out.println(sum);
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
	
}
