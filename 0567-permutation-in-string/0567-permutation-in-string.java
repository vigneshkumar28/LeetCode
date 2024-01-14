class Solution {
    private String newStr(String s){
      char[] c = s.toCharArray();
      Arrays.sort(c);
      return new String(c);
    }
    public boolean checkInclusion(String s1, String s2) {
        s1 = newStr(s1);
        for(int i=0; i<=s2.length()-s1.length(); i++){
          if(s1.equals(newStr(s2.substring(i, i+s1.length()))))
            return true;
        }
      return false;
    }
}