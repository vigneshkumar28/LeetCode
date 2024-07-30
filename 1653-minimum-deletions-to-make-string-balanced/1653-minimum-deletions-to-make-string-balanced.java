class Solution {
    public int minimumDeletions(String s) {
        //space optimized dp
        int n=s.length();
        int minDeletions=0;
        int bCount=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == 'b'){
                bCount++;
            }else{
                minDeletions=Math.min(minDeletions+1, bCount);
            }
        }
        return minDeletions;
    }
}