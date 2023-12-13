class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] results = new int[n-k+1];
        int count = 0;
        // store indices in dequue instead of number
        for(int i=0; i<n;i++){
            while(!deque.isEmpty() && deque.peekFirst() <= i-k)
                deque.pollFirst();
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.pollLast();
            deque.add(i);
            if(i>=k-1)
                results[count++] = nums[deque.peekFirst()];
        }
        return results;
    }
}