class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        if(n==1)
            return nums[0];
        int robbed =0;
        int notRobbed =0;
        for(int i=0;i<nums.length-1;i++){
            if(i%2==0){
                robbed += nums[i];
                robbed = Math.max(robbed, notRobbed);
            }else{
                notRobbed += nums[i];
                notRobbed = Math.max(notRobbed, robbed);
            }
        }
        int firstPossible = Math.max(robbed, notRobbed);
        robbed=0; notRobbed=0;
        for(int i=1;i<nums.length;i++){
            if(i%2==0){
                robbed += nums[i];
                robbed = Math.max(robbed, notRobbed);
            }else{
                notRobbed += nums[i];
                notRobbed = Math.max(notRobbed, robbed);
            }
        }
        int lastPossible = Math.max(robbed, notRobbed);
        int circularPossible = Math.max(firstPossible, lastPossible);
        return circularPossible;
    }
}