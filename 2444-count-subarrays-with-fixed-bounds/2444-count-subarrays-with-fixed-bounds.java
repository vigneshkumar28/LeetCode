class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int leftId=-1, rightId=-1, wrongId=-1;
        long ans=0;
        for(int i=0;i<nums.length;i++){
            if(!(minK<=nums[i] && nums[i]<=maxK))
                wrongId=i;
            if(nums[i] == minK)
                leftId=i;
            if(nums[i]==maxK)
                rightId=i;
            ans += Math.max(0, Math.min(leftId, rightId)-wrongId);
        }
        return ans;
    }
}