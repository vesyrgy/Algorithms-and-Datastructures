recursion

class Power {
  
  static int power(int x, int n) {
    if(n == 0)
      return 1;
    if (n%2==1) {
      int y = power(x,(n-1)/2);
      return x*y*y;
    } else {
      int y = power(x, n/2);
      return y*y;
    }
  }
}//

