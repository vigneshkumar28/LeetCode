class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length();
        if(s==null || n == 0)
            return 0;
        int sumOfParentheses = 0;
        Stack<Integer> result = new Stack<>();
        result.push(-1);
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '(')
                result.push(i);
            else{
                result.pop();
                if(result.isEmpty())
                    result.push(i);
                else
                    sumOfParentheses = Math.max(sumOfParentheses, i-result.peek());
            }
        }
        return sumOfParentheses;
    }
}