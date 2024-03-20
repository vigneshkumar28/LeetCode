class Solution {
    public int maxProduct(int[] nums) {
        int maxMul= nums[0];
        int minMul= nums[0];
        int result= maxMul;
        for(int i=1;i<nums.length;i++){
            int max = Math.max(nums[i], Math.max(nums[i]*maxMul, nums[i]*minMul));
            minMul = Math.min(nums[i], Math.min(nums[i]*maxMul, nums[i]*minMul));
            maxMul = max;
            result =Math.max(result, maxMul);
        }
        return result;
    }
}