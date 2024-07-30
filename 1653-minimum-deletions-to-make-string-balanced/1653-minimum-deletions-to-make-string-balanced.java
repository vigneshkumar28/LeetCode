class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int[] countA = new int[n];
        int aCount=0;
        for(int i=n-1; i>=0; i--){
            countA[i]=aCount;
            if(s.charAt(i)=='a')aCount++;
        }
        int minDeletions=n;
        int bCount=0;
        for(int i=0;i<n;i++){
            minDeletions = Math.min(minDeletions, bCount+countA[i]);
            if(s.charAt(i) == 'b') bCount++;
        }
        return minDeletions;
    }
}