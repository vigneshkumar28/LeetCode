class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        //sliding window
        int N=s.length();
        int maxLen=0;
        int start=0;
        int currentCost=0;
        for(int i=0;i<N;i++){
            currentCost += Math.abs(s.charAt(i)-t.charAt(i));
            while(currentCost > maxCost){
                currentCost -= Math.abs(s.charAt(start)-t.charAt(start));
                start++;
            }
            maxLen = Math.max(maxLen, i-start+1);
        }
        return maxLen;
    }
}