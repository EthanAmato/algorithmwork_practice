package sdossey.algorithms.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sdossey.algorithms.util.InstrumentedList;

public class MergeSortPractice {
	public static final String[] merge(String[] firstList, String[] secondList) {
		int leftPointer = 0, rightPointer = 0;

		int compare;
		int currIndex = 0;
		String[] mergedArray = new String[firstList.length + secondList.length];

		// Know this is linear time
		while (currIndex < firstList.length + secondList.length) {
			// Check if we are out of items in either list
			if (leftPointer >= firstList.length) {
				// Add remaining items from the right list
				while (rightPointer < secondList.length) {
					mergedArray[currIndex] = secondList[rightPointer];
					currIndex++;
					rightPointer++;
				}
				break;
			}
			if (rightPointer >= secondList.length) {
				// Add remaining items from the left list
				while (leftPointer < firstList.length) {
					mergedArray[currIndex] = firstList[leftPointer];
					currIndex++;
					leftPointer++;
				}
				break;
			}

			// Comparison and merging
			compare = firstList[leftPointer].compareTo(secondList[rightPointer]);
			if (compare <= 0) {
				mergedArray[currIndex] = firstList[leftPointer];
				currIndex++;
				leftPointer++;
			} else {
				mergedArray[currIndex] = secondList[rightPointer];
				currIndex++;
				rightPointer++;
			}
		}
		return mergedArray;
	}

	public static final String[] mergeSort(String[] list, int size) {

		// Merge Sort:
		// O(n log(n)) Time Complexity
		// O(n) Space Complexity

		// Much cheaper to sort a list that is half the size than going through a full
		// list and
		// sorting it in its entirety
		// Sorting 2 half lists takes 1/2 the time
		// Also, merging 2 sorted lists is not that difficult... Probably O(n) - all you
		// have to do is
		// maintain a current index in each of them, compare data at each running index
		// and put together a list

		if (size <= 1) {
			return list;
		}

		int midpoint = (size) / 2;
		String[] left = Arrays.copyOfRange(list, 0, midpoint);
		String[] right = Arrays.copyOfRange(list, midpoint, size);

		mergeSort(left, midpoint);
		mergeSort(right, list.length - midpoint);

		return merge(left, right);
	}

	public static void main(String[] args) {
//		String[] words1 = new String[] { "Apple", "Banana", "Dragonfruit" };
//		String[] words2 = new String[] { "Cucumber", "Deaconfruit", "Fruit", "Pear", "Z-Fruit" };
//
//		String[] res = merge(words1, words2);
//		for (String val : res) {
//			System.out.println(val);
//		}
		String[] words3 = new String[] { "Cucumber", "Deaconfruit", "Apple", "Banana", "Dragonfruit", "Fruit", "Pear",
				"Z-Fruit" };

		String[] res2 = mergeSort(words3, words3.length);
		for (String val : res2) {
			System.out.println(val);
		}
	}

}
