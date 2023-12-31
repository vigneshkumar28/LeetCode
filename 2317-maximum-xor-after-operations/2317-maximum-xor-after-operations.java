class Solution {
    public int maximumXOR(int[] nums) {
        int maxXor = 0;
        for(int i: nums){
            maxXor |= i;
        }
        return maxXor;
    }
}