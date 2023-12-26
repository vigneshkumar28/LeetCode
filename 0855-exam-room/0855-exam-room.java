class ExamRoom {
    int start = 0;
    int total=0;
    TreeSet<Integer> result;
    public ExamRoom(int n) {
        result = new TreeSet<>();
        total = n;
    }
    
    public int seat() {
        int seat = 0;
        if(!result.isEmpty()){
            int firstSeat = result.first();
            Integer prev = null;
            for(int s: result){
                if(prev != null){
                    int curr = (s-prev)/ 2;
                    if(curr > firstSeat){
                        firstSeat = curr;
                        seat = prev + curr;
                    }
                }
                prev = s;
            }
            if(total-1-result.last() > firstSeat)
                seat = total-1;
        }
        result.add(seat);
        return seat;
    }
    
    public void leave(int p) {
        result.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */