import java.util.Arrays;
class SortedList 
{
  // -elements : Integer[]
  // -size     : int
  private Integer[] elements;
  private int size;
  
  // invariant : the elements are sorted in ascending order
  

  // pre : cap > 0
  // post: an empty SortedList has been constructed, 
  //       if pre is true, capacity = cap, otherwise capacity = 10
  // +SortedList(cap : int)
  public SortedList(int cap) {
    if (cap > 0) {
      elements = new Integer[cap];
    }
    elements = new Integer[10];
  }

  // post: returns true iff the list is empty
  // +isEmpty() : boolean
  public boolean isEmpty() {
    return size == 0;
  }
  

  // post: returns the number of elements in the list
  // +size() : int
  public int size() {
    return size;
  }

  // post: the size of elements and the value of capacity has been doubled, 
  //       the contents of the list is not changed
  // This method is called by add() when there are no empty positions 
  // +doubleCapacity()
  public void doubleCapacity() {
    Integer[] dc = Arrays.copyOf(elements, 2*elements.length);  // create new array of double size 
    elements = dc;  //  replace the original array with the new array
  }

  // post: if size was equal to capacity, doubleCapacity() has been called,
  // e has been added to the list
  // +add(e : Integer)
  public void add(int e) {
    int temp;
    int temp2;
    if(size == elements.length)
      doubleCapacity();
    elements[size] = e; //  append e to the end of the list
    for(int i=size; i>0;i--) {
      temp = elements[i];
      temp2 = elements[i-1];
      if(temp < temp2) {    //  go through the list and swap elements if they are not in order
        elements[i-1] = temp;
        elements[i] = temp2;
      }
    }
    size++; //increment the size
  }

  // post: returns the first position (from left to right) where e is found, 
  //       returns -1 otherwise
  // +indexOf(e : Integer) : int
  public int indexOf(Integer e) {
    for(int i = 0; i<size; i++) {
      if(elements[i] == e) {
        return i;
      }
    }
    return -1;
  }

  // post: an instance of e was removed and returned, 
  //       iff the list contained an instance of e, otherwise null is returned
  // +remove(e : Integer) : Integer
  public Integer remove(Integer e) {
    int i = indexOf(e);
    int returnval;
    if(i == -1)
      return null;
    else {
      returnval = elements[i];
      for(; i<size-1; i++)
        elements[i] = elements[i+1]; 
      if(size == elements.length)
        elements[size-1] = null;
    }
    size--;
    return returnval;
  }

  // post: returns a String representation of the list
  //       String format: <SortedList[el,e,e]> for a list with 3 elements!
  // +toString() : String
  public String toString() {
    String res = "SortedList[";
    if(size > 0) {
      for(int i=0;i<size-1;i++) {
        res += elements[i].toString() + ",";
      }
    res += elements[size-1];
    }
    res += "]";
    return res;
  }

}//
