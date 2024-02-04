class Solution {
    public boolean isPrefixString(String s, String[] words) {
        if(!s.startsWith(words[0]))
            return false;
        String str = "";
        for(String i: words){
            str += i;
            if(str.equals(s))
                return true;
        }
        return false;
    }
}