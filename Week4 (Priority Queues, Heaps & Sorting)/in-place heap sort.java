class Solution {
	
	/**
	 * swaps two elements in an array
	 * 
	 * @param a array
	 * @param i position of element to swap in a
	 * @param j position of element to swap in a
	 */
	public static void swap(int[] a, int i, int j) {
    int m = a[i];
    int n = a[j];
    a[i] = n;
    a[j] = m;
	}

	/**
	 * restores the heap property in a heap represented as an array
	 * 
	 * @param heap  array representation of a heap,
	 * 							which might be invalidated
	 * @param root  index of the root of the heap,
	 * 							which might be a subtree of the overall heap 
	 * @param range index of the last element in the heap, 
	 * 							array elements with an index > range are not part of the heap
	 *
	 * when the heap property is invalid at root, 
	 * the method fixes the heap first locally before fixing the affected subtree 
	 */
	public static void restoreHeap(int[] heap, int root, int range) {
	  for(int i=root; i<range; i++) {
	    if(i+1 <= range) {
	      if(heap[i] < heap[i+1])
	        swap(heap, i, i+1);
	    }
	    if(i+2 <= range) {
	      if(heap[i] < heap[i+2])
	        swap(heap, i, i+2);
	    }
	  }
	}
	
	/**
	 * turns an array of integers into a heap
	 * 
	 * this is an in-place algorithm, the heap is built in the array itself
	 * 
	 * @param array of integer numbers,
	 *              on return, this array represents a valid heap
	 */
	public static void buildHeap(int[] array) {
	  /*
	    This is roughly based on the "heapify" implementation for 
	    bottom-up heap construction given on page 382 of the book.
	  */
	  
	  // start at the parent of the last entry
	  int start = (int)Math.floor((array.length-1)/2);
	  
	  // loop until the root is reached
	  for(int j = start; j >= 0; j--)
	    restoreHeap(array, j, array.length-1);

	}

	/**
	 * sorts an array of integer numbers
	 * 
	 * this is an in-place algorithm, the heap is built in the array itself
	 * 
	 * @param array of elements, on return, this array represents a valid heap
	 */
	public static void inPlaceHeapSort(int[] array) {
    //  Build the heap
    buildHeap(array);
    
    //  Since the root is the max value of the heap, move it to the sequence to the right
    //  of the heap. Then, restore the heap property. Loop until the sequence makes up the
    //  entire array.
    for(int i = array.length-1; i > 0; i--) {
      swap(array,0,i);
      restoreHeap(array,0,i-1);
    }
    
	}
}//
