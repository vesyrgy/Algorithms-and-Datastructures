import java.util.*;

class Solution {
  
  static Set<String> permuteString(String s) {
    
    Set<String> result = new TreeSet<String>();
    
    // call backtracking method here
    String t = "";
    backtrack(s, t, result);

    return result;
  }
  static void backtrack(String s, String t, Set<String> r) {
    if(s.length() < 2) {
        String u = s+t;
        if((u != "") && s != "")
          r.add(u);
        return;
    } else {
      for(int i = 0; i < s.length(); i++) {
         String head = s.substring(0,i);
         String tail = s.substring(i+1);
         backtrack(head + tail, t+s.charAt(i),r);
      }
    }
  }
  
  
}//
