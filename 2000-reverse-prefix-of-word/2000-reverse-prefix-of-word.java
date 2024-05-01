class Solution {
    public String reversePrefix(String word, char ch) {
        int firstOccur= word.indexOf(ch);
        if(firstOccur==-1)
            return word;
        StringBuffer result= new StringBuffer(word.substring(0, firstOccur+1));
        result.reverse();
        return result + word.substring(firstOccur+1);
    }
}