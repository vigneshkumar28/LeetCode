class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n=heights.length;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0;i<n-1;i++){
            int climb=heights[i+1]-heights[i];
            if(climb>0){
                if(ladders>0){
                    minHeap.offer(climb);
                    ladders--;
                }else if(!minHeap.isEmpty() && minHeap.peek() <climb){
                    bricks -= minHeap.poll();
                    minHeap.offer(climb);
                }else{
                    bricks -= climb;
                }
                if(bricks<0)
                    return i;
            }
        }
        return n-1;
    }
}