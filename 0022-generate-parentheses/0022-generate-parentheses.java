class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateHelper(result, new StringBuilder(), n, n);
        return result;
    }
    private void generateHelper(List<String> result, StringBuilder s, int open, int close){
        if(open == 0 && close == 0){
            result.add(s+"");
            return;
        }
        if(open >0){
            s.append("(");
            generateHelper(result, s, open-1, close);
            s.deleteCharAt(s.length()-1);
        }
        if(close > open){
            s.append(")");
            generateHelper(result, s, open, close-1);
            s.deleteCharAt(s.length()-1);
        }
    }
}