class Solution {
    public String removeKdigits(String num, int k) {
      StringBuilder str = new StringBuilder();
      int n= num.length();
      Stack<Character> res = new Stack<>();
      for(char i: num.toCharArray()){
        while(k >0 && !res.isEmpty() && res.peek() > i){
          res.pop();
          k--;
        }
        res.push(i);
      }
      while(k >0){
          res.pop();
          k--;
      }
      for(char i: res)
        str.append(i);
      int ind = 0;
      while(ind < str.length() && str.charAt(ind) == '0')
        ind++;
      return ind == str.length() ? "0" : str.substring(ind);
    }
}