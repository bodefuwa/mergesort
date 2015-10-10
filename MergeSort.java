// Sample merge sort file
// Class creates an array filled with random integers.
// Provides a method to sort the array with merge sort.
// from the Deitel Java book How to Program
import java.util.Random;

public class MergeSort {
	
	private int[] data;
	private static final Random generator = new Random();
	
	// create array of given size and fill with random integers
	public MergeSort( int size ) {
		
		data = new int[ size ];	// create a space for array
		
		// fill array with random ints in range 10-99
		for ( int i = 0; i < size; i++ ) 
			data [ i ] = 10 + generator.nextInt( 90 );
		}
		
		// calls recursive split method to begin merge sorting
		public void sort() {
			sortArray( 0, data.length - 1 ); // split entire array
		}	// end method sort
		
		private void sortArray( int low, int high ) {
			
			// test base case; size of array equals 1
			if ( ( high - low ) >= 1 ) {
				
				int middle1 = ( low + high ) / 2 ; // calculate middle f array
				int middle2 = middle1 + 1;	// calculate next element over
				
				// output split step
				System.out.println( "split: " + subarray( low, high ) );
				System.out.println( "		" + subarray( low, middle1 ) );
				System.out.println( "		" + subarray( middle2, high ) );
				System.out.println();
				
				// split array in half; sort each half (recursive calls)
				sortArray( low, middle1 );
				sortArray( middle2, high );
				
				// merge two sorted arrays after split calls return
				merge( low, middle1, middle2, high );
			}	// end if
		}	// end method sortArray
		
		// merge two sorted subarrays into one sorted subarray
		private void merge( int left, int middle1, int middle2, int right ) {
			
			int leftIndex = left;
			int rightIndex = middle2;
			int combinedIndex = left;
			int[] combined = new int[ data.length ];
			
			// output two subarrays before merging
			System.out.println();
			System.out.println();
			
			// merge arrays until reaching end of either
			while ( leftIndex <= middle1 && rightIndex <= right ) {
				
				// place smaller of two current elements into result
				// and move to the next space in arrays
				if ( data[ leftIndex ] <= data[ rightIndex ] )
					combined[ combinedIndex++ ] = data[ leftIndex++ ];
				else 
					combined[ combinedIndex++ ] = data[ rightIndex++ ];
			}	// while
			
			// if left array is empty
			if ( leftIndex == middle2 )
				// copy in rest of right array
				while ( rightIndex <= right )
					combined[ combinedIndex++ ] = data[ rightIndex++ ];
			else // right array is empty
				// copy in rest of left array
				while ( leftIndex <= middle1 )
					combined[ combinedIndex++ ] = data[ leftIndex++ ];
			
			// copy values back into original array
			for ( int i = left; i <= right; i++ )
				data [ i ] = combined[ i ];
			
			// output merged array
			System.out.println();
			System.out.println();
		}	// end method merge
		
		// method to output certain values in array
		public String subarray( int low, int high ) {
			
			StringBuilder temporary = new StringBuilder();
			
			// output spaces for alignment
			for ( int i = 0; i < low; i++ )
				temporary.append( " " );
			
			// output elements left in array
			for ( int i = 0; i < low; i++ )
				temporary.append( " " + data[ i ]);
			
			return temporary.toString();
		}	// end method subarray
		
		// method to output values in array
		public String toString() {
			
			return subarray( 0, data.length - 1 );
		}	// end method toString
			
	}	// end class MergeSort
	

