class Solution {
    public int minimumLengthEncoding(String[] w) {
        HashSet<String> set = new HashSet<>(Arrays.asList(w));
        for(String i: w){
          for(int j=1;j<i.length();j++){
            set.remove(i.substring(j));
          }
        }
        int sum=0;
        for(String i:set){
           sum += i.length()+1;
         }
         return sum;
    }
}