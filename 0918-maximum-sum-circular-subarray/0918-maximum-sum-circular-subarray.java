class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int max= Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //find max sum
        for(int i: nums){
            sum+= i;
            if(sum > max){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        sum = 0; 
        // find min sum
        for(int i:nums){
            sum += i;
            if(sum < min){
                min =  sum;
            }
            if(sum > 0){
                sum = 0;
            }
            
        }
        sum = 0;
        for(int i: nums){
            sum += i;
        }
        // min += sum;
        int circularMax = sum - min;
        if(min == sum){
            return max;
        }
        return Math.max(circularMax, max);
    }
}