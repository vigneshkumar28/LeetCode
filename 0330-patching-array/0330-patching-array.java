class Solution {
    public int minPatches(int[] nums, int n) {
        long missingNum = 1;
        int patch = 0;
        int i=0;
        while(missingNum <= n){
            if(i< nums.length && nums[i] <= missingNum){
                missingNum += nums[i];
                i++;
            }else{
                missingNum += missingNum;
                patch++;
            }
        }
        return patch;
    }
}