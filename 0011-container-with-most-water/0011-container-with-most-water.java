class Solution {
    public int maxArea(int[] height) {
        int maxAreaWater = 0;
        for(int i = 0, j=height.length-1; i<j;){
            int width = j-i;
            int h = Math.min(height[j], height[i]);
            int tempMaxArea = width * h;
            maxAreaWater = Math.max(maxAreaWater, tempMaxArea);
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxAreaWater;
    }
}