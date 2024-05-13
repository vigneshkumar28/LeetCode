class Solution {
    public boolean xorGame(int[] nums) {
        int res=0;
        for(int num: nums)
            res ^= num;
        return res == 0 || nums.length%2==0;
    }
}