class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i: nums){
            minHeap.add(i);
        }
        int prevEle = minHeap.poll();
        int currentStrike=1;
        int longStrike=1;
        while(!minHeap.isEmpty()){
            int num = minHeap.poll();
            if(num == prevEle+1){
                currentStrike++;
            }else if(num != prevEle){
                longStrike= Math.max(longStrike, currentStrike);
                currentStrike=1;
            }
            prevEle = num;
        }
        return Math.max(currentStrike, longStrike);
    }
}