class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return maxK(nums, k)- maxK(nums,k-1);
    }
    private int maxK(int[] nums, int k){
        int windowSize=0, subArrays=0, start=0;
        for(int end=0;end<nums.length;end++){
            windowSize += nums[end]%2;
            while(windowSize > k){
                windowSize -= nums[start]%2;
                start++;
            }
            subArrays += end-start+1;
        }
        return subArrays;
    }
}