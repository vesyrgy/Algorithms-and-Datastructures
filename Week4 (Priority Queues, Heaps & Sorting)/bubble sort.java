class Solution {
  
  /**
   * @param elements array of integers to be sorted
   */
  public static void bubbleSort(int[] elements) {
    for(int j=elements.length; j >1; j--)  {
      for(int i=1; i<j; i++) {
        int a = elements[i-1];
        int b = elements[i];
        if(a > b) {
          elements[i-1] = b;
          elements[i] = a;
        }
      }
    }
  }
}//
