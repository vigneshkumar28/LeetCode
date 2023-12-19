class Solution {
    public int jump(int[] nums) {
        int max = 0;
        int n = nums.length;
        int jump =0;
        int lastJump = 0;
        for(int i=0; i<n-1; i++){
            max= Math.max(max, nums[i]+i);
            if(i ==lastJump){
                lastJump = max;
                jump++;
            }
        }
        return jump;
    }
}