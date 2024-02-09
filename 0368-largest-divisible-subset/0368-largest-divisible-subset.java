class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n=nums.length;
        if(n==0)
            return result;
        Arrays.sort(nums);
        int[] dp= new int[n];
        int[] lastDivisible = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(lastDivisible, -1);
        int maxSize=1;
        int maxIndex=0;
        for(int i=0;i<n;i++){
            for(int j=i-1; j>=0;j--){
                if(nums[i]%nums[j] == 0 && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    lastDivisible[i]=j;
                    if(dp[i]>maxSize){
                        maxSize=dp[i];
                        maxIndex=i;
                    }
                }
            }
        }
        while(maxIndex>=0){
            result.add(nums[maxIndex]);
            maxIndex = lastDivisible[maxIndex];
        }
        return result;
    }
}