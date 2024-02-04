class Solution {
    public int countPrefixes(String[] words, String s) {
        int prefixCount=0;
        for(String i: words){
            if(s.startsWith(i)){
                prefixCount++;
            }
        }
        return prefixCount;
    }
}