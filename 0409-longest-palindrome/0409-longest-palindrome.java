class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int res=0;
        for(char c: s.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
                res +=2;
            }else{
                set.add(c);
            }
        }
        if(!set.isEmpty()) res++;
        return res;
    }
}