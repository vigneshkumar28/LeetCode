class Solution {
    public String firstPalindrome(String[] words) {
        for(String s: words){
            if(checkPailindrome(s)){
                return s;
            }
        }
        return "";
    }
    private boolean checkPailindrome(String s){
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i) != s.charAt(n-i-1))
                return false;
        }
        return true;
    }
}