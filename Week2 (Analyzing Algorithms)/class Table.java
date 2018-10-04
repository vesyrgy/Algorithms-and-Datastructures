class Table {
  
  // -elements : int[][]
  // a table consists of n rows, and m columns
  private int[][] elements;
  private int _n;
  private int _m;
  private int padding;  // keeps track of how much space is needed in the string representation of columns
    
  // pre: n > 0, m > 0
  // post: has created a Table object with n rows and m columns, the value of all elements = val
  // +Table(int n, int m, int val)
  public Table(int n, int m, int val) {
    if((n > 0) && (m > 0)) {
      elements = new int[n][m];
      _n = n;
      _m = m;
      //padding = (int)Math.log10(Math.abs(val));
      padding = String.valueOf(val).length();
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
          elements[i][j] = val;
        }
      }
      
    }
  }
  
  // pre: 0 <= row < n, 0 <= col < m
  // post: if pre elements[row][col] = val
  // +set(int row, int col, int val)
  public void set(int row, int col, int val) {
    if((0 <= row) && (row < _n) && (0 <= col) && (col < _m)) {
      elements[row][col] = val;
      if(padding < String.valueOf(val).length())
        padding = String.valueOf(val).length();
      /*
      if(padding < (int)Math.log10(Math.abs(val)))
        padding = (int)Math.log10(Math.abs(val));
      */
    }
  }
  
  // pre: 0 <= row < n, 0 <= col < m
  // post: if pre returns elements[row][col], returns -1 otherwise
  // +get(int row, int col) : int
  public int get(int row, int col) {
    int res = -1;
    if((0 <= row) && (row < _n) && (0 <= col) && (col < _m)) {
        res = elements[row][col];
    }
    return res;
  }
  
  // post: has returned the number of rows 
  // +numRows() : int
  public int numRows() {
    return _n;
  }
  
  // post: has returned the number of columns
  // +numCols() : int
  public int numCols() {
    return _m;
  }
  
  // post: has returned a String representation of the Table object
  // +toString()
  public String toString() {
    String s = "";
    String dashes = "";
    //  figure out how many dashes there need to be in a row
    for(int j = 0; j < _m; j++) {
      dashes+="--";
      for(int k = 0; k < padding; k++) {
        dashes+="-";
      }
      if(j < _m-1)
        dashes+="-";
    }
    
    for(int i = 0; i < _n; i++) {
      for(int j = 0; j < _m; j++) {
        s+=" ";
        int val = elements[i][j];
        System.out.println("padding: " + padding);
        int spaces = padding-String.valueOf(val).length();
        //int spaces = padding-(int)Math.log10(Math.abs(val));
        
        for(int k = 0; k<spaces; k++) {
          s+=" ";
        }
        s+=val + " ";
        if(j < _m-1)
          s+="|";
      }
      s+="\n";
      // add a row of dashes
      if(i < _n-1)
        s+=dashes+"\n";
    }
    return s;
  }
  
}//
