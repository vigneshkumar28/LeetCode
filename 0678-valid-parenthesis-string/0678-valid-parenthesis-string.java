class Solution {
    public boolean checkValidString(String s) {
        int openCount=0;
        int closeCount=0;
        for(int i=0;i <s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='*')
                openCount++;
            else
                openCount--;
            if(s.charAt(s.length()-1-i)==')' || s.charAt(s.length()-1-i)=='*')
                closeCount++;
            else
                closeCount--;
            if(openCount<0 || closeCount<0)
                return false;
        }
        return true;
    }
}