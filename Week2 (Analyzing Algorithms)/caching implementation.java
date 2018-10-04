class Binomial {
  private static Table bin = new Table(10, 10, 0);
  public static int calls = 0;
  
  public Binomial() {
    calls = 0;
  }

  public static void clearCache() {
    calls = 0;
    bin = new Table(10, 10, 0);
  }
  
  public static int bin(int n, int k) {
    calls++;
    if(((n == k) && (k > 0)) || ((n > k) && (k == 0))) {
      bin.set(n,k,1);
      return 1;
    } else if ((n > 0) && (k > 0)) {
      int val = bin.get(n,k);
      if(val <= 0) {
        val = bin(n-1, k) + bin(n-1, k-1);
        bin.set(n,k,val);
      }
      return val;
      
    }
    
    return 0;
  }
}

//
