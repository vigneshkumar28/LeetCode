class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max=Arrays.stream(nums).max().getAsInt();
        long ans=0;
        int start=0,maxElementsInWindow=0;
        for(int end=0;end<nums.length;end++){
            if(nums[end]==max)
                maxElementsInWindow++;
            while(k==maxElementsInWindow){
                if(nums[start]==max){
                    maxElementsInWindow--;
                }
                start++;
            }
            ans += start;
        }
        return ans;
    }
}