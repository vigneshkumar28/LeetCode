class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        for(int i=1;i<=9;i++)
            q.add(i);
        checkDigit(low, high,q, result);
        return result;
    }
    private static void checkDigit(int low, int high, Queue<Integer> q, List<Integer> result){
        while(q.size() > 0){
            int first = q.remove();
            if(first >= low && first <= high)
                result.add(first);
            int lastDigit = first%10;
            if(lastDigit < 9) q.add(first*10 + lastDigit+1);
        }
    }
}