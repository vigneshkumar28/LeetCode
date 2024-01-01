class Solution {
    public int longestValidParentheses(String s) {
        int sumOfParentheses = 0;
        Stack<Integer> result = new Stack<>();
        result.push(-1);
        for(int i=0;i<s.length();i++){
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