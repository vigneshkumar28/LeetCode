class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        int[] arr = new int[n];
        int j = 0;
        for(int i=0; i<n; i = i+2){
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }
        return nums;
    }
}