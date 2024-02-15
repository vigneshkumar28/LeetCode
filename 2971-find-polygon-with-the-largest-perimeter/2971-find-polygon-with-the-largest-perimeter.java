class Solution {
    public long largestPerimeter(int[] nums) {
       Arrays.sort(nums);
        long larger=-1;
        long prevSum=0;
        for(int num: nums){
            if(num < prevSum)
                larger = num+prevSum;
            prevSum += num;
        }
        return larger;
    }
}