class Solution {
    public String reversePrefix(String word, char ch) {
        int first= word.indexOf(ch);
        if(first==-1)
            return word;
        StringBuffer sb= new StringBuffer(word.substring(0, first+1));  
        return sb.reverse().toString() + word.substring(first+1);
    }
}