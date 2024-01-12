class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n= heights.length;
        int[] leftBoundary = new int[n];
        int[] rightBoundary = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            leftBoundary[i] = stack.isEmpty() ? 0:stack.peek()+1;
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            rightBoundary[i] = stack.isEmpty()? n-1 : stack.peek()-1;
            stack.push(i);
        }
        int maxHistogramRectangle = 0;
        for(int i=0; i<n;i++){
            int width = rightBoundary[i]-leftBoundary[i]+1;
            int area = width * heights[i];
            maxHistogramRectangle = Math.max(maxHistogramRectangle, area);
        }
        return maxHistogramRectangle;
    }
}