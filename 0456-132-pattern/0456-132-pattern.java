class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n<3)
            return false;
        int[] minArray = new int[n];
        minArray[0] = nums[0];
        for(int i=1;i<n;i++){
            minArray[i] = Math.min(minArray[i-1], nums[i]);
        }
        Stack<Integer> result = new Stack<>();
        for(int i= n-1; i>=0; i--){
            while(!result.isEmpty() && result.peek() <= minArray[i]){
                result.pop();
            }
            if(!result.isEmpty() && result.peek() < nums[i])
                return true;
            result.push(nums[i]);
        }
        return false;
    }
}