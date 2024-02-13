class Solution {
    public boolean isPalindrome(String s) {
        String str="";
        s = s.toLowerCase();
        int n=s.length();
        for(int i=0;i<n; i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c))
                str += c;
        }
        return checkPailindrome(str);
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