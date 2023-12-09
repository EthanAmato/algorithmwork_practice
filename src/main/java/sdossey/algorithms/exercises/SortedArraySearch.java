package sdossey.algorithms.exercises;

import sdossey.algorithms.datasets.Words;

public class SortedArraySearch {

	// Recursive implementation
	public static boolean binarySearch(String[] data, int start, int end, String searchString) {
		if (start > end) {
			return false;
		}
		int midpoint = (start + end) / 2; // fixed--(put start+end in parenthesis)
		String compareString = data[midpoint];
		int compareResult = searchString.compareTo(compareString);
		if (compareResult < 0) {
			return binarySearch(data, start, midpoint - 1, searchString);
		} else if (compareResult > 0) {
			return binarySearch(data, midpoint + 1, end, searchString);
		} else /* equal */ {
			return true;
		}
	}

	public static boolean contains(String[] data, String searchString) {
		// Reimplement this method to be faster.
		// It is okay to create other methods that are called,
		// and it is okay to use methods of String (such as equals)

		// Thought process:
		// We have a sorted array and need to search it
		// Whenever I see sorted array, I immediately think of binary search
		// Let's make 2 variables that will allow us to keep track of which section of
		// the array we are considering for where searchString could be located:
		int left = 0; // beginning of array
		int right = data.length - 1; // end of array

		// If right is ever equal to left or less than it, we know we didn't find the
		// word
		while (left <= right) {

			// Calculate the middle that will decide the value we are looking at currently
			// subtract right from left.
			int middle = (left + right) / 2;

			// Compare the values of the word we're looking for and the data at the middle
			// index
			int compareResult = searchString.compareTo(data[middle]);

			// if compareTo returns 0, they are equal and therefore searchString exists in
			// data
			if (compareResult == 0)
				return true;

			if (compareResult > 0) {
				// Search string bigger than (further along in alphabet than) current data in
				// the middle
				// meaning that we should move our left forward
				// increment because we already checked it
				left = middle + 1;
			} else {
				// If search string smaller than (earlier in alphabet than) current data in
				// middle
				// we need to bring our right backwards because there's no chance of it being
				// later in alphabet than middle
				// decrement because we already checked it
				right = middle - 1;
			}
		}

		// Return false after search because we couldn't find the searchString
		return false;
//		return binarySearch(data, 0, data.length - 1, searchString);
	}
	

	public static final void main(String[] args) {
		String[] data = Words.ENGLISH;
		String[] checkData = Words.SPANISH;

		int counter = 0;

		long start = System.currentTimeMillis();
		for (String value : checkData) {
			if (contains(data, value)) {
				counter += 1;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("There are " + counter + " words shared between our Spanish and English dictionary.");
		System.out.println("It took " + (end - start) + " milliseconds to do this calculation.");
	}
}
