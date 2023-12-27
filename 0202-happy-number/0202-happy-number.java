class Solution {
    public boolean isHappy(int n) {
        Map<Integer, Boolean> result = new HashMap<>();
        return isHappyHelper(n, result);
    }
    private boolean isHappyHelper(int n, Map<Integer, Boolean> result){
        if(n == 1)
            return true;
        if(result.containsKey(n))
            return false;
        result.put(n, true);
        int sumOfSquare = 0;
        while(n > 0){
            int last = n%10;
            sumOfSquare += last * last;
            n/=10;
        }
        return isHappyHelper(sumOfSquare, result);
    }
}