class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)
            return 0;
        int ans=0;
        int[] histogram = new int[matrix[0].length];
        for(char[] row: matrix){
            for(int i=0;i<row.length;i++){
                histogram[i]= row[i]=='0'? 0: histogram[i]+1;
            }
            ans = Math.max(ans, largeRectangle(histogram));
        }
        return ans;
    }
    public int largeRectangle(int[] his){
        int ans =0;
        Deque<Integer> stack= new ArrayDeque<>();
        for(int i=0;i<=his.length; i++){
            while(!stack.isEmpty() && (i==his.length || his[stack.peek()]> his[i])){
                int h=his[stack.pop()];
                int w=stack.isEmpty() ? i: i-1-stack.peek();
                ans = Math.max(ans, h*w);
            }
            stack.push(i);
        }
        return ans;
    }
}