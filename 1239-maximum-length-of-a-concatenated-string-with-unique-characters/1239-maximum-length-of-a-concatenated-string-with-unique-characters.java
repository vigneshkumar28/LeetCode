class Solution {
    public int maxLength(List<String> arr) {
        int[] maxLengths = {0};
        backtracking(arr, "",0, maxLengths);
        return maxLengths[0];
    }
    private void backtracking(List<String> arr, String str, int start, int[] length){
        if(length[0] < str.length())
            length[0] = str.length();
        for(int i=start;i<arr.size(); i++){
            if(!isValid(str, arr.get(i))){
                continue;
            }
            backtracking(arr, str+arr.get(i),i+1, length);
        }
    }
    private boolean isValid(String currStr, String arrStr){
        Set<Character> set = new HashSet<Character>();
        for(char c: arrStr.toCharArray()){
            if(set.contains(c))
                return false;
            set.add(c);
            if(currStr.contains(String.valueOf(c)))
                return false;
        }
        return true;
    }
}