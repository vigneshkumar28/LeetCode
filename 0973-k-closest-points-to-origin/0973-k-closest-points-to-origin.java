class Solution {
    private int distance(int[] points){
        return points[0]*points[0] + points[1]*points[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->{
           return distance(b)-distance(a); 
        });
        for(int[] i: points){
            minHeap.offer(i);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[][] result = new int[k][2];
        int id=0;
        while(!minHeap.isEmpty()){
            result[id++] = minHeap.poll();
        }
        return result;
    }
}