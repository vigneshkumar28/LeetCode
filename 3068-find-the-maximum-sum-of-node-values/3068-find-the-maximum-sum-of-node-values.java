class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> Integer.compare(b, a));

        long sum = 0;
        for(int num : nums){
            sum += (long) num;
            int xorNum = num ^ k;
            pq.offer(xorNum - num);
        }

        while(pq.size() > 1){
            int diff1 = pq.poll();
            int diff2 = pq.poll();
            
            if(diff1 + diff2 > 0) {
                sum += diff1 + diff2;
            } else {
                break;
            }
        }

        return sum;
    }
}