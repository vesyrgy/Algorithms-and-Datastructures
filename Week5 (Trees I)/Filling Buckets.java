import java.util.Queue;
//import java.util.Arrays;
import java.util.LinkedList;

class Solution {
  
  /**
	 * Returns an array of buckets (represented by Queues). Each bucket contains
	 * exactly one value of elements.
	 * 
	 * @param array
	 *            to fill the buckets with.
	 * @return an array of buckets
	 */
	@SuppressWarnings("unchecked")
	public static Queue<Integer>[] fillBuckets(int[] array) {
	  if((array == null) || (array.length == 0)) { 
	    	  Queue<Integer>[] buckets = new Queue[0];
	    	  return buckets;
	  } 
	  
	  int vmin = Integer.MAX_VALUE;
	  int vmax = Integer.MIN_VALUE;
	  // vmin should be the smallest key in the array and vmax should be the largest
	  for(int i = 0; i < array.length; i++) {
	    if(array[i] < vmin)
	      vmin = array[i];
	    if(array[i] > vmax)
	      vmax = array[i];
	  }
	  
	  //System.out.println("array: "+ Arrays.toString(array) + ", vmax: " + vmax + ", vmin: " + vmin);
	  Queue<Integer>[] buckets = new Queue[Math.abs(vmax-vmin)+1];
    //System.out.println(buckets.length);
    
    
    for(int i=0; i<buckets.length; i++) {
      //int key = vmin+i;
      Queue<Integer> q = new LinkedList<Integer>(); // initialize each bucket
      buckets[i] = q;
      //System.out.println("key is: " + key + ", buckets["+key+"] is " + buckets[i].toString());
    }
    
    for(int j=0; j < array.length; j++) {
      //System.out.println("j: " + j + ", array length: " + array.length + ", array[j]: " + array[j]);
      int key = array[j]-vmin;
      //System.out.println("key is: " + key);
      buckets[key].add(array[j]);
      //System.out.println("buckets["+key+"] is " + buckets[key].peek().toString());
    }

    
    
    return buckets;
	}
}


