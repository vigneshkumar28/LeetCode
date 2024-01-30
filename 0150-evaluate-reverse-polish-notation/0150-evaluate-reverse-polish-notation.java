class Solution {
    private int performOperation(int var1, int var2, String str){
        switch(str){
            case "+": return var1+var2;
            case "-": return var1-var2;
            case "*": return var1*var2;
            case "/": return var1/var2;
            default: return 0;
        }
    }
    private boolean isStrOperator(String str){
        return str.equals("+") || str.equals("-") || str.equals("*")|| str.equals("/");
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> result = new Stack<>();
        for(String str: tokens){
            if(isStrOperator(str)){
                int var2 = result.pop();
                int var1 = result.pop();
                result.push(performOperation(var1, var2, str));
            }else{
                result.push(Integer.parseInt(str));
            }
        }
        return result.pop();
    }
}