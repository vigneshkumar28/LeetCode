class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        Map<Long, List<Integer>> result = new HashMap<>();
        for(int i=0;i<n;i++){
            result.putIfAbsent((long)nums[i], new ArrayList<>());
            result.get((long)nums[i]).add(i);
        }
        int count = 0;
        int[][] dp=new int[n][n];
        for(int j=n-2;j>=1;j--){
            for(int i=j-1;i>=0;i--){
                long diff = 2*(long)nums[j]-nums[i];
                if(!result.containsKey(diff)){
                    continue;
                }
                for(Integer k:result.get(diff)){
                    if(k>j){
                        dp[i][j] += dp[j][k]+1;
                    }
                }
                count += dp[i][j];
            }
        }
        return count;
    }
}