class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if(ch == -1)
            return word;
        String firstHalf = word.substring(0, index+1);
        String lastHalf = word.substring(index+1);
        StringBuilder sb= new StringBuilder(firstHalf);
        sb.reverse();
        return sb+lastHalf;
    }
}