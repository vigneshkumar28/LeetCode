class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int maxElement = 1; // because 1 palindrome and even/odd return sub string l to r
        int count = 0;
        for(int i=1;i<n;i++){
            //if even palindromic then current and previous
            int l = i-1;
            int r = i;
            while(l >= 0 && r<n && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > maxElement){
                    maxElement = r-l+1;
                    start = l;
                }
                l--;
                r++;
            }
            //if odd palindromic, then previous i-1, center i and next i+1
            l = i-1;
            r= i+1;
            while(l >=0 && r<n && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > maxElement){
                    maxElement = r-l+1;
                    start = l;
                }
                l--;
                r++;
            }
        }
        return s.substring(start, start+maxElement);
    }
}