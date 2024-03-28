class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans=0, start=-1;
        Map<Integer, Integer> freqMap= new HashMap<>();
        for(int end=0; end< nums.length;end++){
            freqMap.put(nums[end], freqMap.getOrDefault(nums[end], 0)+1);
            while(freqMap.getOrDefault(nums[end], 0) > k){
                start++;
                freqMap.put(nums[start], freqMap.getOrDefault(nums[start], 0)-1);   
            }
            ans = Math.max(ans, end-start);
        }
        return ans;
    }
}