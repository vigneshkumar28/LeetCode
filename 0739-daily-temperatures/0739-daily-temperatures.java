class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stackObj = new Stack<Integer>();
        int[] result = new int[temperatures.length];
        for(int i=0;i<temperatures.length; i++){
            while(!stackObj.empty() && temperatures[i] > temperatures[stackObj.peek()]){
                int index = stackObj.pop();
                result[index] = i - index;
            }
            stackObj.push(i);
        }
        return result;
    }
}