class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helperKDis(nums, k) - helperKDis(nums, k-1);
    }
    private static int helperKDis(int[] nums, int k){
        int left = 0;
        int count =0;
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for(int right=0;right<nums.length; right++){
            frequency.put(nums[right], frequency.getOrDefault(nums[right], 0)+1);
            while(frequency.size() >k){
                frequency.put(nums[left], frequency.get(nums[left])-1);
                if(frequency.get(nums[left]) == 0){
                    frequency.remove(nums[left]);
                }
                left++;
            }
            count += right - left+1;
        }
        return count;
    }
}