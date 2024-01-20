class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int n= arr.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                int top = stack.pop();
                sum += (long) arr[top] * (i-top)*(top-(!stack.isEmpty() ? stack.peek(): -1));
                sum = sum% 1000000007;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            sum += (long) arr[top] * (n-top)*(top-(!stack.isEmpty() ? stack.peek(): -1));
            sum = sum%1000000007;
        }

        return (int)sum;
    }
}