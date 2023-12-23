class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int count = 0;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
          maxHeap.offer(num);
        }else{
          minHeap.offer(num);
        }
        while(maxHeap.size() > minHeap.size()+1){
          minHeap.offer(maxHeap.poll());
        }
        while(minHeap.size() > maxHeap.size()){
          maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
             return (double)(maxHeap.peek() + minHeap.peek())/2;
        }
        return maxHeap.peek();
      }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */