class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int num : nums)
            maxHeap.add(num);
        while(k-1> 0){
            maxHeap.poll();
            k--;
        }  
        return maxHeap.peek();
    }
}