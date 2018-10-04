class Binomial {
  public static int calls = 0;

  public static void clearCache() {
    calls = 0;
  }

  public static int bin(int n, int k) {
    Table t = new Table(n+1,k+1,0);
    
    // if n, k satisfy the base case, return 1:
    if(((n == k) && (k > 0)) || ((n > k) && (k == 0))) {
      calls++;
      return 1;
    }
    
    // otherwise build the table
    for(int i=0; i<n+1; i++) {
      for(int j=0; j<k+1; j++) {
        if(((i == j) && (j > 0)) || ((i > j) && (j == 0)) ) {
          t.set(i,j,1); //  fill in the first column and the diagonal of the table with 1.
        } else if ((i > 0) && (j > 0)) {
          calls = calls + 2;  // increment the calls by 2, since there are two recursive calls that are made.
          int val = t.get(i-1, j) + t.get(i-1, j-1); // calculate the new value recursively & add it to the table
          t.set(i,j,val); 
        }
      }
    }
    //System.out.print(t.toString());
    return t.get(n,k); 
  }
}

//
