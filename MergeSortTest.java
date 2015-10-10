// Test driving the merge sort class.
public class MergeSortTest {
	
	public static void main( String[] args ) {
		
		// create object to perform merge sort
		MergeSort sortArray = new MergeSort( 10 );
		
		// print unsorted array
		System.out.println( "Unsorted:" + sortArray + "\n" );
		
		sortArray.sort(); // sort arary
		
		// print sorted arary
		System.out.println( "Sorted: " + sortArray );
	}	// end main

}	// end class MergeSortTest
