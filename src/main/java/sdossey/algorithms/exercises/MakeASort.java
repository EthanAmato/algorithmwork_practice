package sdossey.algorithms.exercises;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import sdossey.algorithms.datasets.RandomData;
import sdossey.algorithms.util.InstrumentedList;
import sdossey.algorithms.util.IntArrayVisualizer;

public class MakeASort {
	public static final void main(String[] args) {
		double delay = .05; // Second delay between visualization step.

//		ArrayList<Integer> test = new ArrayList<>();
//		test.add(4);
//		test.add(2);
//		test.add(1);
//		test.add(3);

		IntArrayVisualizer visualizer = new IntArrayVisualizer(RandomData.randomIntList(1, 30, 20), delay);
//		IntArrayVisualizer visualizer = new IntArrayVisualizer(test, delay);

		JFrame frame = new JFrame("Sorting Visualization App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(visualizer);
		frame.setResizable(true);
		frame.setSize(800, 600);
		frame.setVisible(true);

//		sort(visualizer.getInstrumentedList());
//		insertionSort(visualizer.getInstrumentedList());
		cocktailSort(visualizer.getInstrumentedList());
	}

	private static void cocktailSortAttemptOne(InstrumentedList<Integer> list) {
		// Start with bubble sort:
		int sortedIndex = 0;
		for (int i = 0; i < list.size(); i++) {
			int j;
			for (j = 0; j < list.size() - i - 1; j++) {
				// If pass's value is bigger than sub-pass's we swap because bigger should be
				// towards end
				if (list.get(j).compareTo(list.get(j + 1)) >= 0) {
					list.exchange(j, j + 1);
				}
			}
			sortedIndex++;
			for (int k = j; k > sortedIndex+i; k--) {
				if(list.get(k).compareTo(list.get(k-1)) < 0) {
					list.exchange(k, k-1);
				}
			}

		}

	}
	private static void cocktailSort(InstrumentedList<Integer> list) {
	    boolean swapped = true;
	    int start = 0;
	    int end = list.size();

	    while (swapped) {
	        // reset the swapped flag on entering the loop,
	        // because it might be true from a previous iteration.
	        swapped = false;

	        // loop from bottom to top same as the bubble sort
	        for (int i = start; i < end - 1; ++i) {
	            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
	                list.exchange(i, i + 1);
	                swapped = true;
	            }
	        }

	        // if nothing moved, then the array is sorted.
	        if (!swapped)
	            break;

	        // otherwise, reset the swapped flag so that it
	        // can be used in the next stage
	        swapped = false;

	        // move the end point back by one, because
	        // the item at the end is in its rightful spot
	        end--;

	        // from top to bottom, doing the same
	        // comparison as in the previous stage
	        for (int i = end - 1; i >= start; i--) {
	            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
	                list.exchange(i, i + 1);
	                // Still set swapped to true since the while loop runs on the condition that we swapped
	                swapped = true;
	            }
	        }

	        // increase the starting point, because
	        // the last stage would have moved the next
	        // smallest number to its rightful spot.
	        start++;
	    }
	}

	/*
	 * To sort an array of size N in ascending order iterate over the array and
	 * compare the current element (key) to its predecessor, if the key element is
	 * smaller than its predecessor, compare it to the elements before. Move the
	 * greater elements one position up to make space for the swapped element.
	 */
	private static void insertionSort(InstrumentedList<Integer> list) {

		// Placeholder elements:
		Integer currValue;
		Integer j;

		// Do a pass for each element in the list
		for (int i = 1; i < list.size(); i++) {
			// Get the value at the current index we are evaluating
			currValue = list.get(i);
			j = i - 1; // compare to prev in line in list

			// So long as the previous element index is within the bounds of the array (0 or
			// bigger)
			// and is bigger than the current value of the element we are working with,
			// we will continue swapping backwards
			while (j >= 0 && list.get(j) > currValue) {
				list.exchange(i, j);
				j--;
				i--;
			}
		}

//		for (int i = 0; i < list.size(); i++) {
//			// Get current item
//			currValue = list.get(i);
//			j = i - 1;
//			// Compare next two:
//
//			// If curr bigger than next, we are not in ascending order
//			while (j >= 0 && list.get(j) > currValue) {
//				// Move each element over by one to make room for next smallest item
//				list.set(j+1, list.get(j));
//				j--;
//			}
//
//			list.set(j+1, currValue);
//
//		}

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

		// Can't do things like merge sort because we aren't allowed to set indices in
		// subarrays using a setter

		// Bubble sort comes to mind when it comes to the exchange method so I'll just
		// do that

		/*
		 * // Loop through entire list: for(int i = 0; i < list.size() - 1; i++) {
		 * 
		 * // Each pass will be met with passes to the end of the list - the amount of
		 * passes we've made // so far (since we know that by the end of the first pass
		 * the last element will be sorted, there's no need // to revisit and recompare)
		 * for(int j = 0; j < list.size() - i - 1; j++) {
		 * 
		 * // If 'left' element turns out to be greater than // 'right' element, we swap
		 * if(list.get(j).compareTo(list.get(j + 1)) > 0) { list.exchange(j, j+1); } } }
		 * 
		 * // Avg of O(n^2) time complexity, O(1) Space complexity // Worst Case + Best
		 * Case = n^2 // Typically, selection sort behaves very badly - ends up being
		 * slower than // bubble sort... Certainly slower than insertion sort despite
		 * all of them being O(n^2) time complexity
		 * 
		 */

		// Alternative approach could be selection sort:
		int currMinIndex;

		// Need to pass through array
		for (int i = 0; i < list.size(); i++) {
			// Keep track of the most recent 'unsorted' index (we'll check the val later)
			currMinIndex = i;

			// Pass through the rest of the unsorted part of the array
			for (int j = i; j < list.size(); j++) {

				// If current num in pass is smaller than the min we're tracking,
				// replace min. By end of pass we will have smallest num in list
				if (list.get(j) < list.get(currMinIndex)) {
					currMinIndex = j;
				}
			}
			// Lastly, we will swap the index of the leftmost 'unsorted' index (i) with the
			// index
			// of the min of the array
			list.exchange(currMinIndex, i);
		}
		// Should also be Time complexity O(n^2) with Space complexity O(1)

	}

}
