class StockSpanner {
    static Stack<int[]> result;
    public StockSpanner() {
        result = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!result.isEmpty() && result.peek()[0] <= price){
            span = span + result.peek()[1];
            result.pop();
        }
        result.push(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */