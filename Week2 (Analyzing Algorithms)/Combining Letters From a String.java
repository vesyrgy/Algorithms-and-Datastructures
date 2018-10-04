import java.util.*;

class Solution {

  static Set<String> combineLetters(String s, int n) {
    
    Set<String> result = new TreeSet<String>();
    
    // call backtracking method here
    String t = "";
    backtrack(s, n, t, result);
    return result;
  }
  
  static void backtrack(String s, int n, String t, Set<String> r) {
    if(n == 0) {
      if(t != "")
        r.add(t);
    } else {
      for(int i = 0; i < s.length(); i++) {
         backtrack(s, n-1, t+s.charAt(i),r);
      }
    }
    //return r;
  }
  
}//
