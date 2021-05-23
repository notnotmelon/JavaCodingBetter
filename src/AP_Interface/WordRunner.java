package AP_Interface;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("words.dat"));

		int size = file.nextInt();
//		file.nextLine();
		//PriorityQueue<AP_Interface.Word> bruh = new PriorityQueue<>();
		ArrayList<VowelWord> bruh = new ArrayList<>();

		while(size --> 0){
			bruh.add(new VowelWord(file.next() ) );
		}

		mergeSort(bruh, 0, bruh.size());

		for(VowelWord j : bruh){
			System.out.println(j);
		}

	}

	public static void mergeSort(ArrayList<VowelWord> a, int f, int b){
		//f = front (0), b = back
		int mid = (f + b)/2;
		if(mid == f){return;}

		mergeSort(a, f, mid);
		mergeSort(a, mid, b);
		merge(a, f, b);
	}

	public static void merge(ArrayList<VowelWord> a, int f, int b){
		//difference in size of the temp array and the actual array, spot for merging later,
		//beginning of sort, middle of array, second middle
		int dif = b-f, spot = 0, beg = f, mid = (f+b)/2, s = mid;

		//temporary array to store stuff
		ArrayList<VowelWord> temp = new ArrayList<>();

		//while not past the middle, and not past the back
		while(beg < s && mid < b){

			//if the element at the beginning is less than that at the middle
			if(a.get(beg).compareTo(a.get(mid)) < 0){
				//add the beginning element to the end, and then increment indexes
				temp.add(spot++, a.get(beg++));
			}else{
				//add the middle element to the end
				temp.add(spot++, a.get(mid++));
			}
		}

		//while the indexes are less than their ends, add the rest of the elements
		while(beg < s){
			temp.add(spot++, a.get(beg++));
		} while(mid < b){
			temp.add(spot++, a.get(mid++));
		}
		//for every element in temp
		for(int i = 0; i<dif; i++){
			//set the relative front of the base to the next element
			a.set(f+i, temp.get(i));
		}
	}

}

//MalwareBytes = virus scanner