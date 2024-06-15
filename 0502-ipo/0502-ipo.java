class Solution {
    class Pair{
        int profit;
        int capital;
        Pair(int profit, int capital){
            this.profit=profit;
            this.capital=capital;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> minHeap=new PriorityQueue<>((a,b)-> a.capital- b.capital);
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>((a,b)-> b.profit- a.profit);
        for(int i =0; i<profits.length; i++){
            minHeap.add(new Pair(profits[i],capital[i]));
        }

        while(k>0){
            while(!minHeap.isEmpty() && minHeap.peek().capital<=w){
                maxHeap.add(minHeap.remove());
            }
            if(maxHeap.isEmpty()) break;
            w+=maxHeap.remove().profit;
            k--;
        }
        return w;
    }
}