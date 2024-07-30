class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int aCount=0;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i)=='a')aCount++;
        }
        int minDeletions=n;
        int bCount=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == 'a') aCount--;
            minDeletions = Math.min(minDeletions, aCount+bCount);
            if(s.charAt(i) == 'b') bCount++;
        }
        return minDeletions;
    }
}