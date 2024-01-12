class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> countStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        for(char c: s.toCharArray()){
            if(!charStack.isEmpty() && charStack.peek() == c){
                countStack.push(countStack.pop()+1);
            }else{
                countStack.push(1);
            }
            charStack.push(c);
            if(countStack.peek() == k){
                int count = countStack.pop();
                while(count-- > 0){
                    charStack.pop();   
                }
            }
        }
        StringBuilder output = new StringBuilder();
        while(!charStack.isEmpty()){
            output.append(charStack.pop());
        }
        return output.reverse().toString();
    }
}