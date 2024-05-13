class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        int result = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            else if (ch == '+'){
                result += num * sign;
                num = 0;
                sign = 1;
            }
            else if (ch == '-'){
                result += num * sign;
                num = 0;
                sign = -1;
            }
            else if (ch == '('){
                st.push(result);
                st.push(sign);
                result = 0;
                num = 0;
                sign = 1;
            }
            else if (ch == ')'){
                result += num * sign;
                num = 0;
                int stack_sign = st.peek();
                st.pop();
                result *= stack_sign;
                int stack_last_result = st.peek();
                st.pop();
                result += stack_last_result;
            }
        }
        result += sign * num;
        return result;

    }
}