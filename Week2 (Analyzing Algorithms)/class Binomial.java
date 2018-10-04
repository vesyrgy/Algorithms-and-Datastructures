class Binomial {
  public static int calls;
  
  public Binomial() {
    calls = 0;
  }
  
  public static void reset() {
    calls = 0;
  }

  public static int bin(int n, int k) {
    calls++;
    if(((n == k) && (k > 0)) || ((n > k) && (k == 0)))
      return 1;
    if((n > k) && (k > 0))
      return bin(n-1, k) + bin(n-1, k-1);
    return 0;
  }
}

//
