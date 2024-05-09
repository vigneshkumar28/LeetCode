class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i: happiness){
            maxHeap.add(i);
        }
        long totalHappines=0;
        int turns=0;
        for(int i=0;i<k;i++){
            totalHappines += Math.max(maxHeap.poll()-turns, 0);
            turns++;
        }
        return totalHappines;
    }
}