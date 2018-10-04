class StringIterator {
  private int i;
  private char[] array;
  
  public StringIterator(String s) {
    if(s != null)
      array = s.toCharArray();
  }
  
  public void reset() {
    i = 0;
  }
  
  public char next() {
    char res = 0;
    if (hasNext()) {
      if(array[i] != 0 && array != null) 
        res = array[i];
    }
    i++;
    return res;
    
  }
  
  public boolean hasNext() {
    if (array != null)
      return ((i < array.length) && (array[i] != 0));
    else
      return false;
  }
  
}//
