class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i =0; i < nums.length;i++){
            double temp = nums[i] * nums[i];
            nums[i] = (int)temp;
        }
        Arrays.sort(nums);
        return nums;
    }
}