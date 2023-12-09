package sdossey.algorithms.exercises;

import javax.swing.JFrame;

import sdossey.algorithms.datasets.RandomData;
import sdossey.algorithms.util.InstrumentedList;
import sdossey.algorithms.util.IntArrayVisualizer;

public class MakeASort {
	public static final void main(String[] args) {
		double delay = .1; // Second delay between visualization step.
		IntArrayVisualizer visualizer = new IntArrayVisualizer(RandomData.randomIntList(1, 51, 30), delay);

		JFrame frame = new JFrame("Sorting Visualization App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(visualizer);
		frame.setResizable(true);
		frame.setSize(800, 600);
		frame.setVisible(true);

//		sort(visualizer.getInstrumentedList());
		insertionSort(visualizer.getInstrumentedList());
	}
/*
 * To sort an array of size N in ascending order iterate over the array and compare 
 * the current element (key) to its predecessor, if the key element is smaller than 
 * its predecessor, compare it to the elements before. Move the greater elements one 
 * position up to make space for the swapped element.
 * */
	private static void insertionSort(InstrumentedList<Integer> list) {

		for(int i = 0; i < list.size(); i++) {
			if(i == 0) {
				
			}
			
			list.get(i).compareTo(null);
		}
		
	}

	static final void sort(InstrumentedList<Integer> list) {

		// We are only allowed to use the following methods:
		//
		// Integer list.get(index) -- returns what is at an index.
		//
		// int list.compare(indexA, indexB);
		// returns negative number is a<b, 0 if a.equals(b), and
		// positive number if a>b
		//
		// int list.exchange(indexA, indexB);
		// exchange the element at indexA with the element at indexB
		
		// Can't do things like merge sort because we aren't allowed to set indices in subarrays using a setter

		// Bubble sort comes to mind when it comes to the exchange method so I'll just
		// do that

		/*
		// Loop through entire list:
		for(int i = 0; i < list.size() - 1; i++) {
			
			// Each pass will be met with passes to the end of the list - the amount of passes we've made
			// so far (since we know that by the end of the first pass the last element will be sorted, there's no need
			// to revisit and recompare)
			for(int j = 0; j < list.size() - i - 1; j++) {
				
				// If 'left' element turns out to be greater than
				// 'right' element, we swap
				if(list.get(j).compareTo(list.get(j + 1)) > 0) {
					list.exchange(j, j+1);
				}
			}
		}
		
		// Avg of O(n^2) time complexity, O(1) Space complexity
		// Worst Case + Best Case = n^2
		// Typically, selection sort behaves very badly - ends up being slower than 
		// bubble sort... Certainly slower than insertion sort despite all of them being O(n^2) time complexity 
		
		*/
		
		// Alternative approach could be selection sort:
		int currMinIndex;
		
		// Need to pass through array
		for(int i = 0; i < list.size(); i++) {
			// Keep track of the most recent 'unsorted' index (we'll check the val later)
			currMinIndex = i;
			
			// Pass through the rest of the unsorted part of the array
			for(int j = i; j < list.size(); j++) {
				
				// If current num in pass is smaller than the min we're tracking,
				// replace min. By end of pass we will have smallest num in list
				if(list.get(j) < list.get(currMinIndex)) {
					currMinIndex = j;
				} 
			}
			// Lastly, we will swap the index of the leftmost 'unsorted' index (i) with the index
			// of the min of the array
			list.exchange(currMinIndex, i);
		}
		// Should also be Time complexity O(n^2) with Space complexity O(1)
		
		
		
		
	}
	
	

	
	
	
	
}
