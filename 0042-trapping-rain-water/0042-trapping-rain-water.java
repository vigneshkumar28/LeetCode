class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n <= 2)
            return 0;
        int trappedWater = 0;
        int leftPtr = 0;
        int rightPtr = n-1;
        int leftMax = 0;
        int rightMax = 0;
        while(leftPtr < rightPtr){
            leftMax = Math.max(leftMax, height[leftPtr]);
            rightMax = Math.max(rightMax, height[rightPtr]);
            if(leftMax < rightMax){
                trappedWater += leftMax - height[leftPtr];
                leftPtr++;
            }else{
                trappedWater += rightMax - height[rightPtr];
                rightPtr--;
            }
        }
        return trappedWater;
    }
}